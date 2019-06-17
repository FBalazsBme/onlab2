import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PilotListComponent} from './pilot-list/pilot-list.component';
import {MainMenuComponent} from './main-menu/main-menu.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: 'pilot-list',
    component: PilotListComponent
  },
  {
    path: 'main-menu',
    component: MainMenuComponent
  }
];

export const routing = RouterModule.forRoot(routes);

export class AppRoutingModule { }
