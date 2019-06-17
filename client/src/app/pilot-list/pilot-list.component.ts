import { Component, OnInit } from '@angular/core';
import {PilotService} from '../model/pilot/pilot.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Globals} from '@app/_globals/globals';

@Component({
  selector: 'app-pilot-list',
  templateUrl: './pilot-list.component.html',
  styleUrls: ['./pilot-list.component.css']
})
export class PilotListComponent implements OnInit {

  public API = 'http://localhost:4200';
  pilots: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private pilotService: PilotService,
    private http: HttpClient) { }

  ngOnInit() {
    this.pilotService.getAll().subscribe(data => {
      this.pilots = data;
    });
  }

  clearFilter() {
    this.searchText = '';
  }

  navigateToEdit(id: number) {
    this.http.get(this.API + '/pilot-edit/' + id);
  }

  delete( id: number ) {
    this.pilotService.deletePilot(id).subscribe( data => {
      this.getAllPilots();
    });

  }

  getAllPilots() {
    this.pilotService.getAll().subscribe(data => {
      this.pilots = data;
    });
  }
  getSelected() {

  }

}
