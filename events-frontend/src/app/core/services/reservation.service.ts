import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Reservation} from "../models/reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private apiUrl = 'http://localhost:8080/api/reservations';

  constructor(private http: HttpClient) {}

  purchaseTicket(eventId: number, user: any): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.apiUrl}/client/purchase/${eventId}`, user);
  }

  getUserTickets(user: any): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.apiUrl}/client/all`);
  }

  getAllPurchases(user: any): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.apiUrl}/admin/purchases`);
  }
}
