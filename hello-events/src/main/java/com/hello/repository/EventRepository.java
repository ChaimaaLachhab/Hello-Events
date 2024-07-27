package com.hello.repository;

import com.hello.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event,Long> {

    List<Event> findEventByDateOrLocationOrCategory(LocalDateTime date, String location, String category);
}
