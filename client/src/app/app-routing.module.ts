import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PilotListComponent} from './pilot-list/pilot-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/pilot-list', pathMatch: 'full' },
  {
    path: 'pilot-list',
    component: PilotListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
