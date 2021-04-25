package com.example.sportgamesmanagement.service;

import com.example.sportgamesmanagement.dto.MatchOddsDTO;
import com.example.sportgamesmanagement.mapper.MatchOddsMapper;
import com.example.sportgamesmanagement.model.MatchOdds;
import com.example.sportgamesmanagement.repository.MatchOddsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MatchOddsServiceImpl implements MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchOddsMapper matchOddsMapper;

    @Override
    public MatchOddsDTO getById(String oddId) {
        return matchOddsMapper.toDto(matchOddsRepository.getOne(oddId));
    }

    @Override
    public List<MatchOddsDTO> getAll() {
        return matchOddsMapper.toDto(matchOddsRepository.findAll());
    }

    @Override
    public void delete(String oddId) {
        matchOddsRepository.deleteById(oddId);
    }

    @Override
    public MatchOdds create(MatchOddsDTO matchOddsDTO) {
        return matchOddsRepository.save(matchOddsMapper.toEntity(matchOddsDTO));
    }

    @Override
    public MatchOdds update(MatchOddsDTO matchOddsDTO) {
        return matchOddsRepository.save(matchOddsMapper.toEntity(matchOddsDTO));
    }

}
