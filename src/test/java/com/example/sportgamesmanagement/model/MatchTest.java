package com.example.sportgamesmanagement.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    Match match;

    @Before("")
    public void setUp() {
        match = new Match();
    }

    @Test
    void getId() throws Exception {
        String idValue = "4L";
        match.setId(idValue);
        assertEquals(idValue, match.getId());
    }

}
