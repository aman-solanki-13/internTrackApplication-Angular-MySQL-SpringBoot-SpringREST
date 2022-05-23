import { TestBed } from '@angular/core/testing';

import { InternServicesService } from './intern-services.service';

describe('InternServicesService', () => {
  let service: InternServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InternServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
