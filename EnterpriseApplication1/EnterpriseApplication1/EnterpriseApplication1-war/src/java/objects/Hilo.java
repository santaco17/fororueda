/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author santa
 */
public class Hilo {

    public Hilo() {
    }

    private String title;
    private String description;
    private String creator;
    private String carModel;
    private String carBrand;
    
    public Hilo(String title, String description, String creator, String carBrand, String carModel) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.carModel = carModel;
        this.carBrand = carBrand;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreator() {
        return creator;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    
    @Override
    public String toString(){
        return title + " " + description + " " + creator + " " + carBrand + " " + carModel;
    }
    
}
