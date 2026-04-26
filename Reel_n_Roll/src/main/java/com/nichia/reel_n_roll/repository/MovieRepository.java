//Aiswarya Prasanth
//764003038

package com.nichia.reel_n_roll.repository;
import com.nichia.reel_n_roll.model.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> searchByTitle(@Param("title") String title);

    @Query("SELECT m FROM Movie m WHERE m.genre LIKE %:genre%")
    List<Movie> searchByGenre(@Param("genre") String genre);

    @Modifying
    @Transactional
    @Query("UPDATE Movie m SET m.title = :title WHERE m.id = :id")
    void updateTitleById(@Param("id") Integer id, @Param("title") String title);
}