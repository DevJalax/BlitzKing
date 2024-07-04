package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.VideoStream;

@Repository
public interface VideoStreamRepository extends JpaRepository<VideoStream, Long> {

	List<VideoStream> findByLiveTrue();

}
