import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PilotAddComponent } from './pilot-add.component';

describe('PilotAddComponent', () => {
  let component: PilotAddComponent;
  let fixture: ComponentFixture<PilotAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PilotAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PilotAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
