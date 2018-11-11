import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
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
      batchId: new FormControl(''),
      medicineName: new FormControl(''),
      companyName: new FormControl(''),
      batchPrize: new FormControl(''),
      manufactureDate: new FormControl(''),
      totalQuantity: new FormControl(''),
      expiryDate: new FormControl(''),
      costPerQuantity: new FormControl(''),
      ratePerQuantity: new FormControl('')
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
