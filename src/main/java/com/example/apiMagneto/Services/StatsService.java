package com.example.apiMagneto.Services;


import com.example.apiMagneto.DTO.StatsResponse;
import com.example.apiMagneto.Repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    public StatsService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public StatsResponse getStats() {
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }
}