import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FuncionarioComponent } from './components/home/funcionario/funcionario.component';
import { ObraComponent } from './components/home/obra/obra.component';
import { BemVindoComponent } from './components/home/bem-vindo/bem-vindo.component';


export const routes: Routes = [
    { path: '', component: LoginComponent },
    {
        path: "home", component: HomeComponent, children: [
            { path: '', component: BemVindoComponent },
            { path: 'funcionario', component: FuncionarioComponent },
            { path: 'obra', component: ObraComponent }
        ]
    }
];
