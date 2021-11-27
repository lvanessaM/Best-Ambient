import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPublicacionesComponent } from './add-publicaciones.component';

describe('AddPublicacionesComponent', () => {
  let component: AddPublicacionesComponent;
  let fixture: ComponentFixture<AddPublicacionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPublicacionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPublicacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
