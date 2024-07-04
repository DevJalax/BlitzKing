package com.superapp.BlitzKing.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.Lens;
import com.superapp.BlitzKing.Repo.LensRepository;

@Service
public class LensService {
	
    private final LensRepository lensRepository;

    @Autowired
    public LensService(LensRepository lensRepository) {
        this.lensRepository = lensRepository;
    }

    public Lens createLens(LensDTO lensDTO) {
        Lens lens = new Lens();
        lens.setName(lensDTO.getName());
        lens.setDescription(lensDTO.getDescription());
        lens.setImageUrl(lensDTO.getImageUrl());
        lens.setEffectUrl(lensDTO.getEffectUrl());
        return lensRepository.save(lens);
    }

    public List<Lens> getAllLenses() {
        return lensRepository.findAll();
    }

    public Optional<Lens> getLensById(Long id) {
        return lensRepository.findById(id);
    }
}
