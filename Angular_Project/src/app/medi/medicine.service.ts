import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient : HttpClient) { }

  addStock(stockData){
    var stockDBData = {
      "batchId": stockData.batchId,
      "companyName": stockData.companyName,
      "expiryDate": "2018-11-14T18:31:49.020Z",
      "manufactureDate": "2018-11-14T18:31:49.020Z",
      "medicineName": stockData.medicineName,
      "prize": stockData.prize,
      "quantity": {
        "costPerQuantity": stockData.costPerQuantity,
        "totalQuantity": stockData.totalQuantity
      }
    };
    this.httpClient.post('/medicare/services/addStock',test).subscribe(
      (res:Response) => {
          console.log("The Response :: "+res);
        }
       ); 
  }
}
