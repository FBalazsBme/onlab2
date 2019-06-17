import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
import { fakeBackendProvider } from './_helpers';

import {AdminComponent, AppComponent, UserComponent} from './app.component';
import { routing }        from './app.routing';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { AlertComponent } from './_components';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import {FilterPipe} from '@app/filter.pipe';
import { PilotListComponent } from './pilot-list/pilot-list.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { PilotEditComponent } from './model/pilot-edit/pilot-edit.component';
import { AircraftEditComponent } from './model/aircraft-edit/aircraft-edit.component';
import { AircraftListComponent } from './aircraft-list/aircraft-list.component';

import { AirportListComponent } from './airport-list/airport-list.component'
;
import { FlightListComponent } from './flight-list/flight-list.component';
import { LuggageListComponent } from './luggage-list/luggage-list.component';
import {AppAdminComponent} from '@app/app.componentadmin';
import { AircraftAddComponent } from './model/aircraft-add/aircraft-add.component'
;
import { AirportAddComponent } from './model/airport-add/airport-add.component';
import { FlightAddComponent } from './model/flight-add/flight-add.component';
import {PilotAddComponent} from '@app/model/pilot-add/pilot-add.component';
import { ToastrModule } from 'ngx-toastr';
import { UserListComponent } from './user-list/user-list.component';
import {PassengerListComponent} from '@app/passenger-list/passenger-list.component';
import {LuggageAddComponent} from '@app/model/luggage-add/luggage-add.component';
import {PassengerAddComponent} from '@app/model/passenger-add/passenger-add.component';
import { UserflightListComponent } from './userflight-list/userflight-list.component';
@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    ToastrModule.forRoot()
  ],
    declarations: [
      AppComponent,
      AppAdminComponent,
      AdminComponent,
      UserComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent ,
        PilotListComponent,
      AircraftEditComponent,
      PilotAddComponent,
      PilotEditComponent,
      FilterPipe,
      LuggageListComponent,
      FlightListComponent,
      AirportListComponent,
      AircraftListComponent,
      PassengerListComponent,
      FlightAddComponent,
      LuggageAddComponent,
      PassengerAddComponent,
      AirportAddComponent,
      AircraftAddComponent,
      UserListComponent,
      UserflightListComponent],
    providers: [

        // provider used to create fake backend
        fakeBackendProvider
    ],
    bootstrap: [AppComponent,
      UserComponent]
})

export class AppModule { }
