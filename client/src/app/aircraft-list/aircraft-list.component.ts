import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PilotService} from '@app/model/pilot/pilot.service';
import {AircraftService} from '@app/model/aircraft/aircraft.service';

@Component({
  selector: 'app-aircraft-list',
  templateUrl: './aircraft-list.component.html',
  styleUrls: ['./aircraft-list.component.css']
})
export class AircraftListComponent implements OnInit {

  aircrafts: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private aircraftService: AircraftService) { }

  ngOnInit() {
    this.getAllAircraft();
  }

  clearFilter() {
    this.searchText = '';
  }

  delete( id: number ) {
    this.aircraftService.deleteAircraft(id)
      .subscribe(data => {
        this.getAllAircraft();
      });
  }

  getAllAircraft() {
    this.aircraftService.getAll().subscribe(data => {
      this.aircrafts = data;
    });
  }



  getSelected() {

  }

}
