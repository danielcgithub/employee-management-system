import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = '/api/v1/employees';

  constructor(private http: HttpClient) { }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getEmployee(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

}
