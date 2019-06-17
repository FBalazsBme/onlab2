import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PilotService} from '@app/model/pilot/pilot.service';
import {PassengerService} from '@app/model/passenger/passenger.service';

@Component({
  selector: 'app-passenger-list',
  templateUrl: './passenger-list.component.html',
  styleUrls: ['./passenger-list.component.css']
})
export class PassengerListComponent implements OnInit {


  passengers: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private passengerService: PassengerService) { }

  ngOnInit() {
    this.passengerService.getAll().subscribe(data => {
      this.passengers = data;
    });
  }

  clearFilter() {
    this.searchText = '';
  }

  delete( id: number ) {
    this.passengerService.deletePassenger(id).subscribe( data => {
      this.getAllPassenger();
    });

  }

  getAllPassenger() {
    this.passengerService.getAll().subscribe(data => {
      this.passengers = data;
    });
  }
  getSelected() {

  }




}
