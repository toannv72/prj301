/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toan.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CartObj implements Serializable {

    private String customerId;
    private Map<String, Integer> items;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String title) {
        if (this.items == null) {
            this.items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if (items.containsKey(title)) {
            quantity = items.get(title) + 1;
            /*value of title key*/
        }
        this.items.put(title, quantity);
    }

    public void removeItemTocart(String title) {
        if (this.items.containsKey(title)) {
            items.replace(title, items.get(title) - 1);
        }
        if (items.get(title) == 0) {
            items.remove(title);
        }
    }
}
