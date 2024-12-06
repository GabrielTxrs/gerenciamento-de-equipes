export interface DadosLogin {
    email: string;
    senha: string;
}

export interface Funcionario {
    idFuncionario?: number;
    cpf: string;
    nome: string;
    cargo: string;
    email: string;
    senha: string;
}