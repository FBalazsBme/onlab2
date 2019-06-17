import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LuggageAddComponent } from './luggage-add.component';

describe('LuggageAddComponent', () => {
  let component: LuggageAddComponent;
  let fixture: ComponentFixture<LuggageAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LuggageAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LuggageAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
