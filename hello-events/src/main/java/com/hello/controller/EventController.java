package com.hello.controller;


import com.hello.Entity.Event;
import com.hello.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
