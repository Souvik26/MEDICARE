import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineInsertComponent } from './medicine-insert.component';

describe('MedicineInsertComponent', () => {
  let component: MedicineInsertComponent;
  let fixture: ComponentFixture<MedicineInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicineInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
