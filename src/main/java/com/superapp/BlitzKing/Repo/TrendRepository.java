package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.Trend;

@Repository
public interface TrendRepository extends JpaRepository<Trend, Long> {
	
    List<Trend> findTop10ByOrderByCountDesc();

}
