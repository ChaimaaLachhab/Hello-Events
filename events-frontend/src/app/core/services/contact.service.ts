import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Contact} from "../models/contact";

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private apiUrl = 'http://localhost:8080/api/contacts';

  constructor(private http: HttpClient) {}

  createContact(contact: Contact, user: any): Observable<Contact> {
    return this.http.post<Contact>(`${this.apiUrl}/client/create`, contact);
  }

  getAllContacts(user: any): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.apiUrl}/admin/all`);
  }

  getContactById(id: number, user: any): Observable<Contact> {
    return this.http.get<Contact>(`${this.apiUrl}/admin/find/${id}`);
  }

  updateContactStatus(id: number, contact: Contact): Observable<Contact> {
    return this.http.put<Contact>(`${this.apiUrl}/admin/update/${id}`, contact);
  }
}
