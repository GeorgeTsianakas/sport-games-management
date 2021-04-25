package com.example.sportgamesmanagement.controller;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.service.MatchService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static com.example.sportgamesmanagement.model.Sport.Basketball;
import static com.example.sportgamesmanagement.model.Sport.Football;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MatchControllerTest extends AbstractRestControllerTest {

    @Mock
    MatchService matchService;

    MatchController controller;

    MockMvc mockMvc;

    @Before("")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new MatchController(matchService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    void getAllMatches() throws Exception {
        //given
        MatchDTO match1 = new MatchDTO();
        match1.setId("1");
        match1.setDescription("OSFP - PAO");
        match1.setTeam_a("OSFP");
        match1.setTeam_b("PAO");
        match1.setSport(Basketball);

        MatchDTO match2 = new MatchDTO();
        match2.setId("2");
        match2.setDescription("AEK - PAOK");
        match2.setTeam_a("AEK");
        match2.setTeam_b("PAOK");
        match2.setSport(Football);

        when(matchService.getAll()).thenReturn(Arrays.asList(match1, match2));

        mockMvc.perform(get(MatchController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.matches", hasSize(2)));
    }

}
