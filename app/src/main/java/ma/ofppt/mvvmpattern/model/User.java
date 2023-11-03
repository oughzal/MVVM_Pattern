package ma.ofppt.mvvmpattern.model;

import androidx.annotation.NonNull;

public class User {
    String nom;
    String prenom;
    public User(String nom,String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @NonNull
    @Override
    public String toString() {
        return this.prenom + " " + this.nom;
    }
}
