import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SourceGroupsComponent } from './source-groups.component';

describe('SourcePostsComponent', () => {
  let component: SourceGroupsComponent;
  let fixture: ComponentFixture<SourceGroupsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SourceGroupsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SourceGroupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
