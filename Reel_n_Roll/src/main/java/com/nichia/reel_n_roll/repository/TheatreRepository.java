/*
Name: Sonali Bugwandin
University ID: 403003462
this is the repo
*/

package com.nichia.reel_n_roll.repository;

import com.nichia.reel_n_roll.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findByTheatreNameContaining(String theatreName);

    @Transactional
    @Modifying
    @Query("UPDATE Theatre t SET t.theatreName = ?1 WHERE t.theatreId = ?2")
    int updateTheatreNameById(String theatreName, Long id);

    void deleteById(Long id);
}