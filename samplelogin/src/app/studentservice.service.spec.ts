import { TestBed } from '@angular/core/testing';

import { StudentserviceService } from './studentservice.service';

describe('StudentserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StudentserviceService = TestBed.get(StudentserviceService);
    expect(service).toBeTruthy();
  });
});
