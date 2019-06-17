import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LuggageEditComponent } from './luggage-edit.component';

describe('LuggageEditComponent', () => {
  let component: LuggageEditComponent;
  let fixture: ComponentFixture<LuggageEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LuggageEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LuggageEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
