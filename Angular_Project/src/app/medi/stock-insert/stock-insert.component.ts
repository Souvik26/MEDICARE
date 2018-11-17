import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'stock-insert',
  templateUrl: './stock-insert.component.html',
  styleUrls: ['./stock-insert.component.scss']
})
export class StockInsertComponent implements OnInit {
  addStockForm:FormGroup;

  constructor(private _medicineService: MedicineService) { }

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
    console.log(this.addStockForm.getRawValue());
    this._medicineService.addStock(this.addStockForm.getRawValue());
  };

  resetStock = () => {
    this.createStockFormGroup();
  };
}
