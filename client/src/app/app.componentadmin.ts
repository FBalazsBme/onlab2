import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './_services';
import { User } from './_models';

@Component({ selector: 'appadmin', templateUrl: 'app.componentadmin.html' })
export class AppAdminComponent {
    currentUser: User;
    public isAdmin = true;
    public templateUrl = 'app.component.html';

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {
        if ( this.isAdmin === true ) {
          this.templateUrl = 'app.component.html';
        } else {
          this.templateUrl = 'app.component.html';
        }
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }

    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }
}
