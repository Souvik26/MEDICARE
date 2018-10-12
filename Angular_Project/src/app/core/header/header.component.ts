import { Component, OnInit, Input } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Input() brandingData : any;
  constructor(private _commonService:CommonService) { }

  ngOnInit() {
  }

}
