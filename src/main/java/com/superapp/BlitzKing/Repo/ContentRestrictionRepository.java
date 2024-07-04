package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.ContentRestriction;

@Repository
public interface ContentRestrictionRepository extends JpaRepository<ContentRestriction, Long> {
	
    List<ContentRestriction> findByMinAgeGreaterThanEqual(int age);

}
