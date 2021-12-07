package com.example.td5_app;

public class Contact {
    private String nom;
    private String prenom;
    private String imageUrl;
    public Contact(String prenom, String nom,String urlPhoto){
        this.prenom = prenom;
        this.nom=nom;
        this.imageUrl = urlPhoto;
    }
    public String getmFirstName(){
        return prenom;
    }
    public String getmLastName(){
        return nom;
    }
    public String getmImageUrl(){
        return imageUrl;
    }
}
