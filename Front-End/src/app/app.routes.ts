import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FuncionarioComponent } from './components/funcionario/funcionario.component';
import { ObraComponent } from './components/obra/obra.component';


export const routes: Routes = [
    {path: '', component: LoginComponent},
    {path: "home", component: HomeComponent},
    {path: "funcionario", component: FuncionarioComponent},
    {path: "obra", component: ObraComponent}
];
