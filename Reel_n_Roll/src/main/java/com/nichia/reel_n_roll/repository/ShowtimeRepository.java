// Reema Maryam Naheem 397000990
package com.nichia.reel_n_roll.repository;

import com.nichia.reel_n_roll.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

    List<Showtime> findAll();
    Showtime save(Showtime showtime);
    Showtime findByShowId(int showId);
    void deleteById(Integer id);
    List<Showtime> findByMovieId(Integer movieId);

    @Query("SELECT s FROM Showtime s WHERE s.screenNumber = :screenNumber")
    List<Showtime> findByScreenNumber(@Param("screenNumber") String screenNumber);
    List<Showtime> findByShowDate(String showDate);

    @Modifying
    @Transactional
    @Query("UPDATE Showtime s SET s.screenNumber = :screenNumber WHERE s.showId = :id")
    int updateScreenNumberById(@Param("id") int id, @Param("screenNumber") String screenNumber);
}