import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateGroupComponent } from './update-group.component';

describe('UpdatePostComponent', () => {
  let component: UpdateGroupComponent;
  let fixture: ComponentFixture<UpdateGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
