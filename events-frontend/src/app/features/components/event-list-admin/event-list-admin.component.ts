import {Component, OnInit} from '@angular/core';
import {CurrencyPipe, DatePipe, NgForOf} from "@angular/common";
import {Event} from "../../../core/models/event";
import {EventService} from "../../../core/services/event.service";

@Component({
  selector: 'app-event-list-admin',
  standalone: true,
    imports: [
        CurrencyPipe,
        DatePipe,
        NgForOf
    ],
  templateUrl: './event-list-admin.component.html',
  styleUrl: './event-list-admin.component.scss'
})
export class EventListAdminComponent implements OnInit {
  events: Event[] = [];

  constructor(private eventService: EventService) {}

  ngOnInit(): void {
    this.eventService.getAllEvents().subscribe((data) => {
      this.events = data;
    });
  }

  deleteEvent(id: number): void {
    this.eventService.deleteEvent(id).subscribe(() => {
      this.events = this.events.filter(event => event.id !== id);
    });
  }
}
