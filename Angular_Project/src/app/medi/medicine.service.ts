import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient : HttpClient) { }

  addStock(stockData){
    var test = {
      "batchId": 0,
      "companyName": "ABC",
      "expiryDate": "2018-11-14T18:31:49.020Z",
      "manufactureDate": "2018-11-14T18:31:49.020Z",
      "medicineName": "acd",
      "prize": 0,
      "quantity": {
        "availableQuantity": 0,
        "costPerQuantity": 0,
        "ratePerQuantity": 0,
        "totalQuantity": 0
      }
    };
    this.httpClient.post('/medicare/services/addStock',test).subscribe(
      (res:Response) => {
          console.log("The Response :: "+res);
        }
       ); 
  }
}
