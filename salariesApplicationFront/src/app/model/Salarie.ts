export class Salarie {
    
    id:string
      matricule: string;
      nom: string;
      prenom: string;
      dateNaissance:Date;
      adresse: string;
      
          constructor(matricule: string, nom: string, prenom: string,dateNaissance: Date,
        adresse: string) {
  this.matricule = matricule;
  this.nom = nom;
  this.prenom = prenom;
  this.dateNaissance = dateNaissance;
  this.adresse= adresse;
  }
}