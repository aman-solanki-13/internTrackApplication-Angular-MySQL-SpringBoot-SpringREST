import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InternLandingPageComponent } from './intern-landing-page.component';

describe('InternLandingPageComponent', () => {
  let component: InternLandingPageComponent;
  let fixture: ComponentFixture<InternLandingPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InternLandingPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InternLandingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
