import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './_guards';
import {PilotListComponent} from '@app/pilot-list/pilot-list.component';
import {AircraftListComponent} from '@app/aircraft-list/aircraft-list.component';
import {AirportListComponent} from '@app/airport-list/airport-list.component';
import {FlightListComponent} from '@app/flight-list/flight-list.component';
import {LuggageListComponent} from '@app/luggage-list/luggage-list.component';
import {PilotAddComponent} from '@app/model/pilot-add/pilot-add.component';
import {UserListComponent} from '@app/user-list/user-list.component';
import {AirportAddComponent} from '@app/model/airport-add/airport-add.component';
import {AircraftAddComponent} from '@app/model/aircraft-add/aircraft-add.component';
import {FlightAddComponent} from '@app/model/flight-add/flight-add.component';
import {LuggageAddComponent} from '@app/model/luggage-add/luggage-add.component';
import {PassengerListComponent} from '@app/passenger-list/passenger-list.component';
import {PassengerAddComponent} from '@app/model/passenger-add/passenger-add.component';
import {UserflightListComponent} from '@app/userflight-list/userflight-list.component';
import {PilotEditComponent} from '@app/model/pilot-edit/pilot-edit.component';

const appRoutes: Routes = [
    { path: '', component: LoginComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
  {
    path: 'passenger-list',
    component: PassengerListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'aircraft-list',
    component: AircraftListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'airport-list',
    component: AirportListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'flight-list',
    component: FlightListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'userflight-list',
    component: UserflightListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'luggage-list',
    component: LuggageListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'user-list',
    component: UserListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'pilot-list',
    component: PilotListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'pilot-edit',
    component: PilotEditComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'passenger-add',
    component: PilotAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'aircraft-add',
    component: AircraftAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'airport-add',
    component: AirportAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'flight-add',
    component: FlightAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'luggage-add',
    component: LuggageAddComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'pilot-add',
    component: PilotAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'passenger-add',
    component: PassengerAddComponent,
    canActivate: [AuthGuard]
  },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
