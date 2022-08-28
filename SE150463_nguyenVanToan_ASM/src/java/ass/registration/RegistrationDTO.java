/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.registration;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RegistrationDTO implements Serializable {

    private String name, image, description;
    private int tuitionFee;
    private String startDate, endDate, category;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String name, String image, String description, int tuitionFee, String startDate, String endDate, String category) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
