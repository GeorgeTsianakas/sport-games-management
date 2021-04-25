package com.example.sportgamesmanagement.mapper;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.model.Match;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MatchMapper { // extends AppMapper<Match, MatchDTO> {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    MatchDTO toDto(Match match);

    List<MatchDTO> toDto(Collection<Match> match);

    Match toEntity(MatchDTO matchDTO);

    List<Match> toEntity(Collection<MatchDTO> matchDTO);

}
