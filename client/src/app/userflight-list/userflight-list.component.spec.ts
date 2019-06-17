import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserflightListComponent } from './userflight-list.component';

describe('UserflightListComponent', () => {
  let component: UserflightListComponent;
  let fixture: ComponentFixture<UserflightListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserflightListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserflightListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
