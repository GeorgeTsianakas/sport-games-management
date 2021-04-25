package com.example.sportgamesmanagement.mapper;

import com.example.sportgamesmanagement.dto.MatchOddsDTO;
import com.example.sportgamesmanagement.model.MatchOdds;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MatchOddsMapper  { // extends AppMapper<MatchOdds, MatchOddsDTO> {

    MatchOddsMapper INSTANCE = Mappers.getMapper(MatchOddsMapper.class);

    MatchOddsDTO toDto(MatchOdds matchOdds);

    List<MatchOddsDTO> toDto(Collection<MatchOdds> matchOdds);

    MatchOdds toEntity(MatchOddsDTO matchOddsDTO);

    List<MatchOdds> toEntity(Collection<MatchOddsDTO> matchOddsDTO);

}
