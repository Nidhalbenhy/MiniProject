import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Salarie } from 'src/app/model/Salarie';
import { SalariesService } from 'src/app/service/salaries.service';

@Component({
  selector: 'app-add-salaries',
  templateUrl: './add-salaries.component.html',
  styleUrls: ['./add-salaries.component.css']
})
export class AddSalariesComponent implements OnInit {

 salariesForm: FormGroup;
 salariess;
 testt;
  constructor(private salariesService: SalariesService, private router: Router) { 
   
  }

  ngOnInit() {

    this.salariesForm = new FormGroup({
      matricule: new FormControl('', [Validators.required],this.isMatriculeExist.bind(this)),
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      dateNaissance: new FormControl('',Validators.required), 
      adresse: new FormControl('',Validators.required),
      
  });
  }

  onSubmit() {
    var btn=<HTMLInputElement> document.getElementById("myBtn");
    btn.disabled= true;
    if (!this.salariesForm.valid) {
      return;
    }

    let salarie: Salarie = new Salarie(
     this.salariesForm.controls['matricule'].value,
     this.salariesForm.controls['nom'].value,
     this.salariesForm.controls['prenom'].value,
     this.salariesForm.controls['dateNaissance'].value,
     this.salariesForm.controls['adresse'].value,
     
   );

   this.salariesService.SaveSalarie(salarie).subscribe(
     resp => {
       this.salariesForm.reset();
       this.salariesForm.controls['matricule'].setValue('');
      
       console.log(resp);
       
       this.router.navigateByUrl("/salaries");
        
     }, err => {
       console.log(err.error);
      
      });
   }

   getAllFormer(){
     this.salariesService.getAllSalaries().subscribe(resp=>{
      console.log(resp);
      this.salariess=resp.body;

     })
   }

    isMatriculeExist (control: AbstractControl) {
      return new Promise(resolve=>{
        this.salariesService.getMatriculeExist(control.value).subscribe(async res => {
          await this.save(res);       
          if (this.testt == true)
            {
              console.log('11111');
              resolve( { matriculeTaken: true });
            } 
            else
            {
            console.log('222222');
            resolve( null);
            }
        })
      });
    }

    save(val){
    this.testt=val; 
   
    }
    
  }
  


  





  

 


  


