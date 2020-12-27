import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError,  tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class SalariesService {
private host ='http://localhost:8080';
  constructor(private http: HttpClient) { }

  getAllSalaries(){
    return this.http.get(this.host+"/salaries/allSalaries",{observe:'response'});
    }

    SaveSalarie(salarie){
    return this.http.post(this.host+"/salaries/saveSalaries",salarie,{observe:'response'});
    }

    searchSalaries(nom) {
      return this.http.get(this.host + "/salaries/query?nom="+nom,{observe:'response'});
    }

    getMatriculeExist(matricule: String): Observable<boolean>  {
    
      const url = `${this.host + '/salaries/isMatriculeExist/?matricule=' + matricule}`;
      return this.http.get<boolean>(url);
    }
  
}
