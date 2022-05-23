import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorLandingPageComponent } from './mentor-landing-page.component';

describe('MentorLandingPageComponent', () => {
  let component: MentorLandingPageComponent;
  let fixture: ComponentFixture<MentorLandingPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MentorLandingPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorLandingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
