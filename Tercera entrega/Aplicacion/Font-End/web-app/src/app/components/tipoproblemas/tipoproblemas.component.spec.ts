import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoproblemasComponent } from './tipoproblemas.component';

describe('TipoproblemasComponent', () => {
  let component: TipoproblemasComponent;
  let fixture: ComponentFixture<TipoproblemasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipoproblemasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoproblemasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
