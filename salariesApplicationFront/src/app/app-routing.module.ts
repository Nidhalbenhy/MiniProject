import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddSalariesComponent } from './salaries/add-salaries/add-salaries.component';
import { SalariesComponent } from './salaries/salaries/salaries.component';

const routes: Routes = [
  { path: '', component: SalariesComponent ,  pathMatch: 'full'},
  { path: 'salaries', component: SalariesComponent },
  { path: 'addSalaries', component: AddSalariesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
