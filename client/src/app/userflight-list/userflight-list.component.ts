import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlightService} from '@app/model/flight/flight.service';

@Component({
  selector: 'app-userflight-list',
  templateUrl: './userflight-list.component.html',
  styleUrls: ['./userflight-list.component.css']
})
export class UserflightListComponent implements OnInit {

  flights: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
    this.getAllFlights();
  }

  clearFilter() {
    this.searchText = '';
  }

  delete( id: number ) {
    this.flightService.deleteFlight(id)
      .subscribe(data => {
        this.getAllFlights();
      });
  }

  getAllFlights() {
    this.flightService.getAll().subscribe(data => {
      this.flights = data;
    });
  }



  getSelected() {

  }

}
