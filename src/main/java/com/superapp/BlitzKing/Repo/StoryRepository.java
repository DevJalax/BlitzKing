package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    
	List<Story> findBySharedTrue();
   
    List<Story> findByHighlightTrue();
}
