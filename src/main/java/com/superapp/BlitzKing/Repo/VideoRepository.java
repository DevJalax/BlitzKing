package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superapp.BlitzKing.Entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	List<Video> findByPostId(Long postId);
	
}
