/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Xristos Aslamagidis
 */
public class Municipallity {
    int municipality_id;
    String name;
    String deparment;
    String law;
    String country;
    int fax;
    int telephone;
    String road;
    int numberOfRoad;
    int postCode;
    String mayor;
    int population;
    
     /*-----Getters----- */

    public int getMunicipality_id() {
        return municipality_id;
    }

    public String getName() {
        return name;
    }

    public String getDeparment() {
        return deparment;
    }

    public String getLaw() {
        return law;
    }

    public String getCountry() {
        return country;
    }

    public int getFax() {
        return fax;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getRoad() {
        return road;
    }

    public int getNumberOfRoad() {
        return numberOfRoad;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getMayor() {
        return mayor;
    }

    public int getPopulation() {
        return population;
    }
    
    /*-------Setters---*/

    public void setMunicipality_id(int municipality_id) {
        this.municipality_id = municipality_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setNumberOfRoad(int numberOfRoad) {
        this.numberOfRoad = numberOfRoad;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    
    
    
   
    
    
}
