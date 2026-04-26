/*
Name: Sonali Bugwandin
University ID: 403003462
this is the repo
*/

package com.nichia.reel_n_roll.repository;

import com.nichia.reel_n_roll.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findByTheatreNameContaining(String theatreName);

}