import {Component, OnInit} from '@angular/core';
import {EventService} from "../../core/services/event.service";
import {RouterLink, RouterModule} from "@angular/router";
import {DatePipe, NgForOf, NgIf} from "@angular/common";
import { HttpClientModule } from '@angular/common/http';
import {Event} from "../../core/models/event";

//import {EventListComponent} from "../events/components/event-list/event-list.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterLink,
    DatePipe,
    HttpClientModule, RouterModule, NgForOf, NgIf
  ],

  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  events: Event[] = [];

  constructor(private eventService: EventService) {}
  ngOnInit(): void {
    this.eventService.getAllEvents().subscribe(events => {
      this.events = events;
    });
  }


}
