import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {PilotService} from '@app/model/pilot/pilot.service';
import {NgForm} from '@angular/forms';
import {Pilot} from '@app/_models/pilot';

@Component({
  selector: 'app-pilot-edit',
  templateUrl: './pilot-edit.component.html',
  styleUrls: ['./pilot-edit.component.css']
})

export class PilotEditComponent implements OnInit, OnDestroy {
  pilot: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private pilotService: PilotService) {
  }

  ngOnInit() {
    this.pilot = new Pilot ('default name', Size.SMALL, 100);
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.pilotService.get(id).subscribe((pilot: any) => {
          if (pilot) {
            this.pilot = pilot;
            this.pilot.href = pilot._links.self.href;
          } else {
            console.log(`Pilot with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/pilot-list']);
  }

  save(form: NgForm) {
/*    this.carService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));*/
  }

  remove(href) {
    this.pilotService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
