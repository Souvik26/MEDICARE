import { Component, OnInit } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { SignupComponent } from '../signup/signup.component';
import { Router, ActivatedRoute } from '../../../node_modules/@angular/router';
import { BaseComponent } from '../core/base/base.component';
import { CommonService } from '../core/common.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent extends BaseComponent implements OnInit {

  model: any = {};

  bsModalRef: BsModalRef;
  constructor(private modalService: BsModalService,
              private router: Router,
              protected route:ActivatedRoute,
              protected commonService:CommonService
) {
  super(route, commonService);
}
 
  openModalWithComponent() {
    this.bsModalRef = this.modalService.show(SignupComponent);
  }

  login = () => {
    console.log(this.model);
    sessionStorage.setItem("loggedInTokenId","Abcd");
    this.router.navigate(['/home']);
  }
  ngOnInit() {
  }

}
