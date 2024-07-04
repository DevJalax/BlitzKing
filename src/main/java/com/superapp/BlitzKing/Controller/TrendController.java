package com.superapp.BlitzKing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.BlitzKing.Entity.Trend;
import com.superapp.BlitzKing.Service.TrendService;

@RestController
@RequestMapping("/trends")
public class TrendController {
	
    private final TrendService trendService;

    @Autowired
    public TrendController(TrendService trendService) {
        this.trendService = trendService;
    }

    @PostMapping
    public ResponseEntity<Void> updateTrend(@RequestParam String topic, @RequestParam String hashtag) {
        trendService.updateTrend(topic, hashtag);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Trend>> getTopTrends() {
        List<Trend> topTrends = trendService.getTopTrends();
        return ResponseEntity.ok(topTrends);
    }
    
}
