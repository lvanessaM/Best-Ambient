import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListReunionesComponent } from './list-reuniones.component';

describe('ListReunionesComponent', () => {
  let component: ListReunionesComponent;
  let fixture: ComponentFixture<ListReunionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListReunionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListReunionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
