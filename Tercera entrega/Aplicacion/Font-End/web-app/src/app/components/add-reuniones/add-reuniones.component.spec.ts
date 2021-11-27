import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddReunionesComponent } from './add-reuniones.component';

describe('AddReunionesComponent', () => {
  let component: AddReunionesComponent;
  let fixture: ComponentFixture<AddReunionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddReunionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddReunionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
