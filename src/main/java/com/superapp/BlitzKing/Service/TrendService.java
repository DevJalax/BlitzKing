package com.superapp.BlitzKing.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.Trend;
import com.superapp.BlitzKing.Repo.TrendRepository;

@Service
public class TrendService {
	
    private final TrendRepository trendRepository;

    @Autowired
    public TrendService(TrendRepository trendRepository) {
        this.trendRepository = trendRepository;
    }

    public void updateTrend(String topic, String hashtag) {
        Trend trend = trendRepository.findByTopicAndHashtag(topic, hashtag)
                .orElse(new Trend(topic, hashtag, 0, LocalDateTime.now()));
        trend.setCount(trend.getCount() + 1);
        trend.setTimestamp(LocalDateTime.now());
        trendRepository.save(trend);
    }

    public List<Trend> getTopTrends() {
        return trendRepository.findTop10ByOrderByCountDesc();
    }
}
