import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PilotService} from '@app/model/pilot/pilot.service';
import {LuggageService} from '@app/model/luggage/luggage.service';

@Component({
  selector: 'app-luggage-list',
  templateUrl: './luggage-list.component.html',
  styleUrls: ['./luggage-list.component.css']
})
export class LuggageListComponent implements OnInit {

  Luggage: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private luggageService: LuggageService) { }

  ngOnInit() {
    this.luggageService.getAll().subscribe(data => {
      this.Luggage = data;
    });
  }

  clearFilter() {
    this.searchText = '';
  }

  delete( id: number ) {
    this.luggageService.deleteLuggage(id).subscribe( data => {
      this.getAllLuggage();
    });

  }

  getAllLuggage() {
    this.luggageService.getAll().subscribe(data => {
      this.Luggage = data;
    });
  }
  getSelected() {

  }

}
