/*
Name: Sonali Bugwandin
University ID: 403003462
service file
*/

package com.nichia.reel_n_roll.service;

import com.nichia.reel_n_roll.model.Theatre;
import com.nichia.reel_n_roll.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository repo;

    public TheatreService(TheatreRepository repo) {
        this.repo = repo;
    }

    public List<Theatre> getAll() {
        return repo.findAll();
    }

    public Theatre getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Theatre save(Theatre theatre) {
        return repo.save(theatre);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Theatre> search(String name) {
        return repo.findByTheatreNameContaining(name);
    }
}