import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './_services';
import { User } from './_models';

@Component({ selector: 'app', templateUrl: 'app.component.html' })
export class AppComponent {
    currentUser: User = null;
    public isAdmin = true;
    public reload = false;
    public templateUrl = 'app.component.html';

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {
        this.authenticationService.currentUser.subscribe(x =>
          {
            this.currentUser = x;
            this.isAdmin = this.currentUser.admin;

            /*this.router.navigate(['/login']);*/
          });
        this.reload =
          JSON.parse(localStorage.getItem('reload'));
        if( this.reload === false || this.reload === null) {
          setTimeout(() =>
            {
              this.reload = true;
              let x = this.reload.toString();
              localStorage.setItem('reload', x);
              location.reload();
            },
            5000);
        }

    }

    logout() {
      this.reload = false;
      let x = this.reload.toString();
      localStorage.setItem('reload', x);
      this.authenticationService.logout();
      this.router.navigate(['/login']);
    }
}

@Component({ selector: 'appusercomponent', templateUrl: 'app.componentuser.html' })
export class UserComponent extends AppComponent {

}

@Component({ selector: 'appadmincomponent', templateUrl: 'app.componentadmin.html' })
export class AdminComponent extends AppComponent {

}
