package com.hello.controller;

import com.hello.Entity.Event;
import com.hello.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }
    @GetMapping("/search")
    public List<Event> searchEvents(@RequestParam(required = false) String date,
                                    @RequestParam(required = false) String location,
                                    @RequestParam(required = false) String category) {
        return eventService.searchEvents(date, location, category);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event updatedEvent = eventService.updateEvent(id, eventDetails);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public List<Boolean> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        List<Boolean> response = new ArrayList<>();
        response.add(Boolean.TRUE);
        return response;
    }




}
