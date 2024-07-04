package com.superapp.BlitzKing.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.Lens;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long> {
 
}
