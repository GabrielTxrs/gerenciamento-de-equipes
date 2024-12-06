import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DadosLogin, Funcionario } from '../model/funcionario-model';

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

  public cadastrarFuncionario(dadosFuncionario: Funcionario): Observable<Funcionario> {
    return this.http.post<Funcionario>(`${this.apiUrl}/funcionario/cadastro`, dadosFuncionario);
  }

  public getFuncionarios(): Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>(`${this.apiUrl}/funcionario/get`);
  }
  public deleteFuncionario(idFuncionario: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/funcionario/delete/${idFuncionario}`);
  }

}