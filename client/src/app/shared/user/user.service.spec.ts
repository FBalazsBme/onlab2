import { TestBed } from '@angular/core/testing';

import { UService } from './u.service';

describe('UService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UService = TestBed.get(UService);
    expect(service).toBeTruthy();
  });
});
