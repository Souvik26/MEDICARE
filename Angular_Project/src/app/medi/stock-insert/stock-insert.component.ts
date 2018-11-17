import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MedicineService } from '../medicine.service';
import { error } from 'util';
import { StockInsertResponse } from './stock-insert-response';

@Component({
  selector: 'stock-insert',
  templateUrl: './stock-insert.component.html',
  styleUrls: ['./stock-insert.component.scss']
})
export class StockInsertComponent implements OnInit {
  addStockForm:FormGroup;
  stockDetails:StockInsertResponse[];

  constructor(private _medicineService: MedicineService) {
    this.getAllStock();
   }

  ngOnInit() {
    this.createStockFormGroup();
  }

  createStockFormGroup = () => {
    this.addStockForm = new FormGroup({
      batchId: new FormControl('',Validators.compose([
        Validators.required, 
        Validators.minLength(1)
      ])
      ),
      medicineName: new FormControl('',Validators.compose([
        Validators.required, 
        Validators.minLength(1)
      ])),
      companyName: new FormControl('',Validators.compose([
        Validators.required, 
        Validators.minLength(1)
      ])),
      batchPrice: new FormControl('',Validators.compose([
        Validators.required, 
        Validators.min(0)
      ])),
      manufactureDate: new FormControl('',Validators.compose([
        Validators.required
      ])),
      totalQuantity: new FormControl('',Validators.compose([
        Validators.required, 
        Validators.min(1)
      ])),
      expiryDate: new FormControl('',Validators.compose([
        Validators.required
      ])),
      costPerQuantity: new FormControl('',Validators.compose([
        Validators.required, 
        Validators.min(0)
      ])),
    });
  };

  insertStock = () => {
    this._medicineService.addStock(this.addStockForm.getRawValue()).subscribe(
        res => {
          console.log("The Response :: "+res);
          this.getAllStock();
        },
        error => {
          console.log("The Response :: "+error);
        }
        );
  };

  resetStock = () => {
    this.createStockFormGroup();
  };

  getAllStock = () => {
    this._medicineService.getAllStock().subscribe(
        res => {
          this.stockDetails=res;
          console.log("The Response :: "+res);
        },
        error => {
          console.log("The Response :: "+error);
        }
        );
  };
}
