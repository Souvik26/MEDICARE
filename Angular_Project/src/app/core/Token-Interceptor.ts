import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  loginToken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmMiLCJqdGkiOiJhYmMiLCJpYXQiOjE1NDIyMjAwNjYsImV4cCI6MTU0MjgyNDg2Niwicm9sZUlkIjoiYWJjIiwiZW1haWxBZGRyZXNzIjoiYWJjIn0.pBmhmgBFA7_LIcye6hVeUlD2yU70yFfTGgwSmoUwfSGCcvr0m_4iqVY843EfGZTIiWuncmxST3WJ87YoFsvfyQ";
  constructor() {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    request = request.clone({
      setHeaders: {
        Authorization : `${this.loginToken}`
      }
    });
    return next.handle(request);
  }
}