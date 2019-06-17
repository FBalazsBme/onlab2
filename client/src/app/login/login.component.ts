import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

import {AlertService, AuthenticationService, UserService} from '@app/_services';
import {Observable} from 'rxjs';
import {User} from '@app/_models';

@Component({templateUrl: 'login.component.html'})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  users: Array<any>;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alertService: AlertService,
    private userService: UserService,
    private toastr: ToastrService
  ) {
    // redirect to home if already logged in
    if (this.authenticationService.currentUserValue) {
      this.router.navigate(['/']);
    }
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    // itt folytatni
    //
    //

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

    this.loading = true;

    this.userService.getHash('http://localhost:8080/checklogin?userName=' + this.f.username.value + '&password=' + this.f.password.value)
      .subscribe(
        data => {

          let userexists = data.boolresponse;
          console.log(userexists);

          if ( userexists ) {
            this.authenticationService.login(this.f.username.value, this.f.password.value)
              .pipe(first())
              .subscribe(
                data2 => {
                  this.router.navigate([this.returnUrl]);
                });
          } else {
            this.toastr.error('Login failed');
          }
        },
        err => {

          console.log(err);
          console.log(err.status);
          if( err.status === 403) {
            this.toastr.error('Incorrect password');
          }
          if( err.status === 400) {
            this.toastr.error('User not found');
          }
        }
      );



  }
}
