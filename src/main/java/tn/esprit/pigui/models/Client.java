package tn.esprit.pigui.models;

public class Client {
    private int id,phone;
    private String nom,adresse,email;

    public Client(int id, String nom,int phone, String adresse, String email) {
        this.id = id;
        this.nom = nom;
        this.phone = phone;
        this.adresse = adresse;
        this.email = email;
    }

    public Client( String nom,int phone, String adresse, String email) {
        this.nom = nom;
        this.phone = phone;
        this.adresse = adresse;
        this.email = email;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", phone=" + phone +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
