package com.hello.service;

import com.hello.Entity.Event;
import com.hello.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    public List<Event> searchEvents(String date, String location, String category) {
        if (date != null && location != null && category != null) {
            return eventRepository.findByDateContainingAndLocationContainingAndCategoryContaining(date, location, category);
        } else if (date != null) {
            return eventRepository.findByDateContaining(date);
        } else if (location != null) {
            return eventRepository.findByLocationContaining(location);
        } else if (category != null) {
            return eventRepository.findByCategoryContaining(category);
        } else {
            return eventRepository.findAll();
        }
    }
}
