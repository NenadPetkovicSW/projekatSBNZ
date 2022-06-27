import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPlayListsComponent } from './my-play-lists.component';

describe('MyPlayListsComponent', () => {
  let component: MyPlayListsComponent;
  let fixture: ComponentFixture<MyPlayListsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyPlayListsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPlayListsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
