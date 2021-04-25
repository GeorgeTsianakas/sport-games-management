package com.example.sportgamesmanagement.mapper;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.model.Match;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchMapperTest {

    public static final String TEAM_A = "OSFP";
    public static final String TEAM_B = "PAO";

    MatchMapper matchMapper = MatchMapper.INSTANCE;

    @Test
    void toDto() {
        Match match = new Match();
        match.setTeam_a(TEAM_A);
        match.setTeam_b(TEAM_B);
        MatchDTO matchDTO = matchMapper.toDto(match);
        assertEquals(String.valueOf(TEAM_A), matchDTO.getTeam_a());
        assertEquals(TEAM_B, matchDTO.getTeam_b());
    }

}
