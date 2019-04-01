import { TestBed } from '@angular/core/testing';

import { PilotaService } from './pilota.service';

describe('PilotaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PilotaService = TestBed.get(PilotaService);
    expect(service).toBeTruthy();
  });
});
