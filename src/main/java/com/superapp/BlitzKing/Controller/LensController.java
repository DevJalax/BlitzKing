package com.superapp.BlitzKing.Controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.BlitzKing.Entity.Lens;
import com.superapp.BlitzKing.Service.LensService;

@RestController
@RequestMapping("/api/lenses")
public class LensController {
    private final LensService lensService;

    @Autowired
    public LensController(LensService lensService) {
        this.lensService = lensService;
    }

    @PostMapping
    public ResponseEntity<Lens> createLens(@RequestBody LensDTO lensDTO) {
        Lens createdLens = lensService.createLens(lensDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLens);
    }

    @GetMapping
    public ResponseEntity<List<Lens>> getAllLenses() {
        List<Lens> lenses = lensService.getAllLenses();
        return ResponseEntity.ok(lenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lens> getLensById(@PathVariable Long id) {
        Optional<Lens> lens = lensService.getLensById(id);
        return lens.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

}
