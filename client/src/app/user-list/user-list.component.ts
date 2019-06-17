import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '@app/_services';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {


  users: Array<any>;
  searchText = '';

  constructor(
    private router: Router,
    private userService: UserService) { }

  ngOnInit() {
    this.userService.getAll().subscribe(data => {
      this.users = data;
    });
  }

  clearFilter() {
    this.searchText = '';
  }

  delete( id: number ) {
    this.userService.delete(id).subscribe( data => {
      this.getAllUsers();
    });

  }

  getAllUsers() {
    this.userService.getAll().subscribe(data => {
      this.users = data;
    });
  }
  getSelected() {

  }

}
