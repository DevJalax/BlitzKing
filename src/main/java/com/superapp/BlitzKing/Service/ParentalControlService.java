package com.superapp.BlitzKing.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.ContentRestriction;
import com.superapp.BlitzKing.Repo.ContentRestrictionRepository;

@Service
public class ParentalControlService {
	
    private final ContentRestrictionRepository contentRestrictionRepository;

    @Autowired
    public ParentalControlService(ContentRestrictionRepository contentRestrictionRepository) {
        this.contentRestrictionRepository = contentRestrictionRepository;
    }

    public List<String> getRestrictedContentForAge(int age) {
        List<ContentRestriction> restrictions = contentRestrictionRepository.findByMinAgeGreaterThanEqual(age);
        return restrictions.stream()
                .map(ContentRestriction::getRestrictedContent)
                .collect(Collectors.toList());
    }
}
