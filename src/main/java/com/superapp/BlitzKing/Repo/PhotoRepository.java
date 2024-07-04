package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>{

	List<Photo> findByPostId(Long postId);
	
}
