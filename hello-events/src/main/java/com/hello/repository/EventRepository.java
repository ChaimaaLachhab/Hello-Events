package com.hello.repository;

import com.hello.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository <Event,Long> {
    List<Event> findByDateContaining(String date);
    List<Event> findByLocationContaining(String location);
    List<Event> findByCategoryContaining(String category);

    @Query("SELECT e FROM Event e WHERE " +
            "(CAST(:date AS string) IS NULL OR CAST(e.date AS string) LIKE %:date%) AND " +
            "(COALESCE(:location, '') = '' OR e.location LIKE %:location%) AND " +
            "(COALESCE(:category, '') = '' OR e.category LIKE %:category%)")
    List<Event> findByDateLocationCategory(
            @Param("date") String date,
            @Param("location") String location,
            @Param("category") String category);
}
