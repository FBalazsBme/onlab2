import { Component, OnInit } from '@angular/core';
import {PilotService} from '../model/pilot/pilot.service';

@Component({
  selector: 'app-pilot-list',
  templateUrl: './pilot-list.component.html',
  styleUrls: ['./pilot-list.component.css']
})
export class PilotListComponent implements OnInit {

  pilots: Array<any>;
  searchText = '';

  constructor(private pilotService: PilotService) { }

  ngOnInit() {
    this.pilotService.getAll().subscribe(data => {
      this.pilots = data;
    });
  }

  clearFilter() {
    this.searchText = '';
  }

  getSelected() {

  }

}
