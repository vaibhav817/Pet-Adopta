package pet.project.PetAdopa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class PetDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;
    private String petName;
    private int age;
    private double price;
    private String species;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    
    public PetDetails(){}
    public PetDetails(String petName, int age,double price, String species,byte[] image){
        this.petName=petName;
        this.age=age;
        this.price=price;
        this.species=species;
        this.image =image;
    }
    public void setImage(byte[] image){
        this.image=image;
    }
    public byte[] getImage(){
        return this.image;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPetId(int petId){
        this.petId=petId;
    }
    public void setPetName(String petName){
        this.petName=petName;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setSpecies(String species){
        this.species=species;
    }
    public int getPetId(){
        return this.petId;
    }
    public String getPetName(){
        return this.petName;
    }
    public int getAge(){
        return this.age;
    }
    public String getSpecies(){
        return this.species;
    }
}
