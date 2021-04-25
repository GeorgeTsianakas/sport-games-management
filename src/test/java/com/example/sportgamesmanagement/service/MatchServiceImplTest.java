package com.example.sportgamesmanagement.service;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.mapper.MatchMapper;
import com.example.sportgamesmanagement.model.Match;
import com.example.sportgamesmanagement.repository.MatchRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static com.example.sportgamesmanagement.model.Sport.Basketball;
import static com.example.sportgamesmanagement.model.Sport.Football;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MatchServiceImplTest {

    @Mock
    MatchRepository matchRepository;

    MatchMapper matchMapper = MatchMapper.INSTANCE;

    MatchService matchService;

    @Before("")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        matchService = new MatchServiceImpl(matchRepository, matchMapper);
        matchService = new MatchServiceImpl(matchRepository, MatchMapper.INSTANCE);
    }

    @Test
    void getAll() {

        //given
        Match match1 = new Match();
        match1.setId("1");
        match1.setDescription("OSFP - PAO");
        match1.setTeam_a("OSFP");
        match1.setTeam_b("PAO");
        match1.setSport(Basketball);

        Match match2 = new Match();
        match2.setId("2");
        match2.setDescription("AEK - PAOK");
        match2.setTeam_a("AEK");
        match2.setTeam_b("PAOK");
        match2.setSport(Football);

        when(matchRepository.findAll()).thenReturn(Arrays.asList(match1, match2));
        //when
        List<MatchDTO> matchDTOS = matchService.getAll();
        //then
        assertEquals(2, matchDTOS.size());
    }

}
