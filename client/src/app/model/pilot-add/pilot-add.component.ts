import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {PilotService} from '@app/model/pilot/pilot.service';
import {FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import {User} from '@app/_models';
import {Pilot} from '@app/_models/pilot';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-pilot-add',
  templateUrl: './pilot-add.component.html',
  styleUrls: ['./pilot-add.component.css']
})
export class PilotAddComponent implements OnInit {
  addForm: FormGroup;

  sub: Subscription;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private pilotService: PilotService) {
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
    this.pilotService.save(addPilot)
      .pipe(first())
      .subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
