/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ZABA
 */
@XmlType(name = "Product")
public class Product implements Serializable {
    private static final long serialVersionUID = 8286393242028201686L;

    private int id;
    private String name;
    private String measure;
    private Double qty;
    private Category category;
    
    public Product(String name, String measure, Double qty) {
        this.name = name;
        this.measure = measure;
        this.qty = qty;
    }
    
    public Product(String name, String measure, Double qty, Category category) {
        this.name = name;
        this.measure = measure;
        this.qty = qty;
        this.category = category;
    }

    public Product(int id, String name, String measure, Double qty) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.qty = qty;
    }

    public Product(int id, String name, String measure, Double qty, Category category) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.qty = qty;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }
}
