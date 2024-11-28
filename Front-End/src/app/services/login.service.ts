import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DadosLogin } from '../model/funcionario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = 'http://localhost:8080'

  constructor(
    private http: HttpClient
  ) { }

  public loginFuncionario(dadosLogin: DadosLogin): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/funcionario/login`, dadosLogin);
  }
}