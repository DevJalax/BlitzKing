package com.superapp.BlitzKing.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.Connection;
import com.superapp.BlitzKing.Repo.ConnectionRepository;

@Service
public class ConnectionService {
	
    private final ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public void createConnection(Connection connection) {
        connectionRepository.save(connection);
    }

    public List<Connection> getUserConnections(Long userId, String connectionType) {
        return connectionRepository.findByUserIdAndConnectionType(userId, connectionType);
    }

    public List<Connection> getConnectionUsers(Long connectionId, String connectionType) {
        return connectionRepository.findByConnectionIdAndConnectionType(connectionId, connectionType);
    }

    public void deleteConnection(Long userId, Long connectionId, String connectionType) {
        connectionRepository.deleteByUserIdAndConnectionIdAndConnectionType(userId, connectionId, connectionType);
    }
}