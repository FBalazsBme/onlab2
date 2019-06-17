import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {PilotService} from '@app/model/pilot/pilot.service';
import {Pilot} from '@app/_models/pilot';
import {first} from 'rxjs/operators';
import {AircraftService} from '@app/model/aircraft/aircraft.service';

@Component({
  selector: 'app-aircraft-add',
  templateUrl: './aircraft-add.component.html',
  styleUrls: ['./aircraft-add.component.css']
})
export class AircraftAddComponent implements OnInit {

  addForm: FormGroup;

  sub: Subscription;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private aircraftService: AircraftService) {
  }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      name: [''],
      license: ['']
    });

  }

  gotoList() {
    this.router.navigate(['/pilot-list']);
  }

  onSubmit() {
    let addPilot : Pilot = new Pilot(this.addForm.controls['name'].value,
      this.addForm.controls['license'].value
    );
    this.aircraftService.save(addPilot)
      .pipe(first())
      .subscribe(result => {
        this.gotoList();
      }, error => console.error(error));
  }

}
