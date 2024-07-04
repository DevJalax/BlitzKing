package com.superapp.BlitzKing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.BlitzKing.Entity.Connection;
import com.superapp.BlitzKing.Service.ConnectionService;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {
	
    private final ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping
    public ResponseEntity<Connection> createConnection(@RequestBody Connection connection) {
        Connection savedConnection = connectionService.createConnection(connection);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConnection);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Connection>> getUserConnections(
            @PathVariable Long userId,
            @RequestParam(required = false) String connectionType) {
        List<Connection> userConnections = connectionService.getUserConnections(userId, connectionType);
        return ResponseEntity.ok(userConnections);
    }

    @GetMapping("/connections/{connectionId}")
    public ResponseEntity<List<Connection>> getConnectionUsers(
            @PathVariable Long connectionId,
            @RequestParam(required = false) String connectionType) {
        List<Connection> connectionUsers = connectionService.getConnectionUsers(connectionId, connectionType);
        return ResponseEntity.ok(connectionUsers);
    }

    @DeleteMapping("/{userId}/{connectionId}")
    public ResponseEntity<Void> deleteConnection(
            @PathVariable Long userId,
            @PathVariable Long connectionId,
            @RequestParam String connectionType) {
        connectionService.deleteConnection(userId, connectionId, connectionType);
        return ResponseEntity.noContent().build();
    }
}
