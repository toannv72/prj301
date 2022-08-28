/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.course;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CourseObj {

    private Map<String, Integer> item;
    private String customerID;

    public Map<String, Integer> getItems() {
        return item;
    }

    public void setItems(Map<String, Integer> item) {
        this.item = item;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void addToCourse(String title) {
        if (item == null) {
            item = new HashMap<>();
        }
        int quantity = 1;
        if (item.containsKey(title)) {
            quantity = item.get(title) + 1;
        }
        item.put(title, quantity);
    }

    public void deleteCourse(String title) {
        if (item == null) {
            return;
        }
        if (item.containsKey(title)) {
            item.remove(title);
            if (item.isEmpty()) {
                item = null;
            }
        }
    }
}
