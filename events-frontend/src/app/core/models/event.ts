import {EventCategory} from "../enums/event-category.enum";
import {Reservation} from "./reservation";

export class Event {
  id!: number;
  name!: string;
  description!: string;
  date!: Date;
  location!: string;
  category!: EventCategory;
  availableTickets!: number;
  reservations!: Reservation[];
}
