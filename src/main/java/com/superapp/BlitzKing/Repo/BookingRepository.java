package com.superapp.BlitzKing.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
