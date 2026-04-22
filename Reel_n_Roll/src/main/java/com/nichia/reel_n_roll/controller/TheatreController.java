package com.nichia.reel_n_roll.controller;

import com.nichia.reel_n_roll.model.Theatre;
import com.nichia.reel_n_roll.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@CrossOrigin("*")
public class TheatreController {

    private final TheatreService service;

    public TheatreController(TheatreService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<Theatre> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Theatre getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // SEARCH BY NAME
    @GetMapping("/search")
    public List<Theatre> search(@RequestParam String name) {
        return service.search(name);
    }

    // ADD NEW
    @PostMapping
    public Theatre add(@RequestBody Theatre theatre) {
        return service.save(theatre);
    }

    // UPDATE EXISTING
    @PutMapping("/{id}")
    public Theatre update(@PathVariable Long id, @RequestBody Theatre theatre) {
        theatre.setTheatreId(id);
        return service.save(theatre);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}