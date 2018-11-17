import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { StockInsertResponse } from './stock-insert/stock-insert-response';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient : HttpClient) { }

  addStock (stockData):Observable<StockInsertResponse>{
     return this.httpClient.post<StockInsertResponse>('/medicare/services/addStock',this.createAddStockJSON(stockData)); 
  }

  createAddStockJSON(stockData){
    return {
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
  }

  getAllStock ():Observable<StockInsertResponse[]>{
    return this.httpClient.get<StockInsertResponse[]>('/medicare/services/getAllStock'); 
 }
}
