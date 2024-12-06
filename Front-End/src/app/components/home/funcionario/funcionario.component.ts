import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, PatternValidator, ReactiveFormsModule, Validators } from '@angular/forms';
import { Funcionario } from '../../../model/funcionario-model';
import { LoginService } from '../../../services/login.service';

@Component({
  selector: 'app-funcionario',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './funcionario.component.html'
})
export class FuncionarioComponent implements OnInit {
  funcionarioForm: FormGroup;
  funcionarios: Funcionario[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
  ) {
    this.funcionarioForm = this.formBuilder.group({
      nome: ['Teste', [Validators.required, Validators.minLength(2)]],
      cpf: ['123.456.789-12', [Validators.required, Validators.pattern('^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$')]],
      email: ['exemplo@email.com', [Validators.required, Validators.email]],
      senha: ['123456', [Validators.required, Validators.minLength(6)]],
      cargo: ['Funcionario', [Validators.required, Validators.minLength(6)]],
    });
  }
  ngOnInit(): void {
    this.getFuncionarios();
  }

  cadastrarFuncionario() {
    if (this.funcionarioForm.valid) {
      const dadosFuncionario: Funcionario = {
        nome: this.funcionarioForm.get('nome')?.value,
        cpf: this.funcionarioForm.get('cpf')?.value.replaceAll(".", '').replace("-", ''),
        email: this.funcionarioForm.get('email')?.value,
        senha: this.funcionarioForm.get('senha')?.value,
        cargo: this.funcionarioForm.get('cargo')?.value,
      }
      this.loginService.cadastrarFuncionario(dadosFuncionario).subscribe((funcionarioCadastrado: Funcionario) => {
        console.log(funcionarioCadastrado);
        this.getFuncionarios();
      });
    }
  }
  private getFuncionarios() {
    this.loginService.getFuncionarios().subscribe((funcionarios: Funcionario[]) => {
      this.funcionarios = funcionarios;
    });
  }
  public deleteFuncionario(idFuncionario: any) {
    this.loginService.deleteFuncionario(idFuncionario).subscribe(() => {
      this.getFuncionarios();
    });
  }
}
