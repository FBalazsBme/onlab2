import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AircraftService} from '@app/model/aircraft/aircraft.service';
import {AirportService} from '@app/model/airport/airport.service';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.css']
})
export class AirportListComponent implements OnInit {


  airports: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private airportService: AirportService) { }

  ngOnInit() {
    this.getAllAirport();
  }

  clearFilter() {
    this.searchText = '';
  }

  delete( id: number ) {
    this.airportService.deleteAirport(id)
      .subscribe(data => {
        this.getAllAirport();
      });
  }

  getAllAirport() {
    this.airportService.getAll().subscribe(data => {
      this.airports = data;
    });
  }



  getSelected() {

  }

}
