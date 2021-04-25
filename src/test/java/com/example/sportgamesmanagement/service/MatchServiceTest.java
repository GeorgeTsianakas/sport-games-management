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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MatchServiceTest {

    MatchService matchService;

    @Mock
    MatchRepository matchRepository;

    @Before("")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        matchService = new MatchServiceImpl(matchRepository, MatchMapper.INSTANCE);
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
        //given
        List<Match> categories = Arrays.asList(new Match(), new Match(), new Match());
        when(matchRepository.findAll()).thenReturn(categories);
        //when
        List<MatchDTO> matchDTOS = matchService.getAll();
        //then
        assertEquals(3, matchDTOS.size());
    }

}
