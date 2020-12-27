import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { SalariesCriteria } from 'src/app/criteria/salarie-criteria';
import { SalariesService } from 'src/app/service/salaries.service';
const ELEMENT_DATA: any[] = [];

@Component({
  selector: 'app-salaries',
  templateUrl: './salaries.component.html',
  styleUrls: ['./salaries.component.css']
})

export class SalariesComponent implements OnInit {
  critere: SalariesCriteria;
  dataSource = new MatTableDataSource<any>(ELEMENT_DATA);
  displayedColumns: string[];
  searchSalarieForm:FormGroup;
  salarie;
  salariess;

  constructor(private salariesService: SalariesService,private router:Router) { }
  
  ngOnInit(): void {  
    this.displayedColumns= ['1', '2', '3', '4','5' ];
    this.getAllSalaries();
    this.createSearchForm();
  }

  createSearchForm(): void {
    this.searchSalarieForm = new FormGroup({
      nomSalarie: new FormControl()
    });
  }


  getAllSalaries() {
    this.salariesService.getAllSalaries().subscribe(
      (data:any) => {
        console.log(data.body);
        this.salarie = data.body;     
      },
      (error) => {
        // console.log(error.error.message);
       },
       ()=>{
         this.initTableFromSearch();
       }
    );
  }

  initTableFromSearch() {
    ELEMENT_DATA.length = 0;
    for (let i = 0; i < this.salarie.length; i++) {   
        ELEMENT_DATA.push(this.salarie[i]); 
    }
    this.dataSource = new MatTableDataSource<any>(ELEMENT_DATA); 
  }

  addSalaries(){
    this.router.navigateByUrl("/addSalaries")
  }
 
  onSearch(){
    let values = this.searchSalarieForm.value;
    this.critere = new SalariesCriteria(   
      values.nom,
      );
    console.log(this.searchSalarieForm.value);
    this.critere.nom = this.searchSalarieForm.controls.nomSalarie.value;
    console.log(this.critere);
    this.salariesService.searchSalaries(this.critere.nom).subscribe(
      (result:any) => {
        this.salarie = result.body;
        console.log(this.salarie);
        this.initTableFromSearch(); 
      },
      (error) => console.log(error),
      () => {    
      }
    )
  }

}
