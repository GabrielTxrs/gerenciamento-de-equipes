import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DadosLogin } from '../../model/funcionario-model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  // loginService = inject(LoginService);
  
  constructor
  (
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private route: Router)
    {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      senha: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  ngOnInit(): void {}

  public loginFuncionario() {
    const dadosLogin: DadosLogin = {
      email: this.loginForm.get('email')?.value,
      senha: this.loginForm.get('senha')?.value
    }
    console.log(dadosLogin);
    this.loginService.loginFuncionario(dadosLogin).subscribe((res: any) => {
      console.log(res);
      localStorage.setItem('token', res.token);
      this.route.navigateByUrl('/home');
    });
  }

}