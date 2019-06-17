import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AircraftAddComponent } from './aircraft-add.component';

describe('AircraftAddComponent', () => {
  let component: AircraftAddComponent;
  let fixture: ComponentFixture<AircraftAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AircraftAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AircraftAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
