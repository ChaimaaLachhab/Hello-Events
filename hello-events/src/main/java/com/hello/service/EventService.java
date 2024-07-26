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

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found for this id :: " + id));
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setLocation(eventDetails.getLocation());
        event.setDate(eventDetails.getDate());
        event.setCategory(eventDetails.getCategory());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found for this id :: " + id));
        eventRepository.delete(event);
    }
}