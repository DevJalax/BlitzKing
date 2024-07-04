package com.superapp.BlitzKing.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.Story;
import com.superapp.BlitzKing.Repo.StoryRepository;

@Service
public class StoryService {
	
    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Story createStory(Story story) {
        story.setExpirationDate(LocalDateTime.now().plusDays(1)); // Set expiration date to 1 day from now
        return storyRepository.save(story);
    }

    public void shareStory(Long storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ResourceNotFoundException("Story not found"));
        story.setShared(true);
        storyRepository.save(story);
    }

    public List<Story> getSharedStories() {
        return storyRepository.findBySharedTrue();
    }

    public List<Story> getHighlights() {
        return storyRepository.findByHighlightTrue();
    }

    public void addToHighlight(Long storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ResourceNotFoundException("Story not found"));
        story.setHighlight(true);
        story.setMediaType(story.getMediaType());
        story.setMediaData(story.getMediaData());
        storyRepository.save(story);
    }
}
