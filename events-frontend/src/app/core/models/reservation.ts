import {User} from "./user";

export class Reservation {
  id!: number;
  event!: Event;
  user!: User;
  purchaseDate!: Date;
}
