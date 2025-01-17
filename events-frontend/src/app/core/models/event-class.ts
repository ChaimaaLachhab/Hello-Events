import {EventCategory} from "../enums/event-category.enum";
import {Reservation} from "./reservation";

export class EventClass {
  name!: string;
  description!: string;
  image!: string;
  price!: number;
  date!: Date;
  location!: string;
  category!: EventCategory;
  availableTickets!: number;
  reservations!: Reservation[];
}
