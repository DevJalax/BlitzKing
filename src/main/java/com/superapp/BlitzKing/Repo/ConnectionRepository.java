package com.superapp.BlitzKing.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superapp.BlitzKing.Entity.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	
    List<Connection> findByUserIdAndConnectionType(Long userId, String connectionType);
    
    List<Connection> findByConnectionIdAndConnectionType(Long connectionId, String connectionType);
    
    void deleteByUserIdAndConnectionIdAndConnectionType(Long userId, Long connectionId, String connectionType);
}
