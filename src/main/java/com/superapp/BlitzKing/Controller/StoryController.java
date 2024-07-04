package com.superapp.BlitzKing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.BlitzKing.Entity.Story;
import com.superapp.BlitzKing.Service.StoryService;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
	
    private final StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping
    public Story createStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @PutMapping("/{id}/share")
    public void shareStory(@PathVariable Long id) {
        storyService.shareStory(id);
    }

    @GetMapping("/shared")
    public List<Story> getSharedStories() {
        return storyService.getSharedStories();
    }

    @GetMapping("/highlights")
    public List<Story> getHighlights() {
        return storyService.getHighlights();
    }

    @PutMapping("/{id}/highlight")
    public void addToHighlight(@PathVariable Long id) {
        storyService.addToHighlight(id);
    }
}