package com.hello.repository;

import com.hello.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event,Long> {
    List<Event> findByDateContaining(String date);
    List<Event> findByLocationContaining(String location);
    List<Event> findByCategoryContaining(String category);
    List<Event> findByDateContainingAndLocationContainingAndCategoryContaining(String date, String location, String category);
}
