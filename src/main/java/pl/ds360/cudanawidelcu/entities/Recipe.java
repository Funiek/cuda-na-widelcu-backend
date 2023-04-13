/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ZABA
 */
@XmlType(name = "Recipe")
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1286393242028201686L;
    
    private int id;
    private int nextProductId;
    private String name;
    private String description;
    private byte[] image;
    private ArrayList<Product> products;
    private Double rating;
    private ArrayList<Integer> votes;
    private int countVotes;
    private Category category;

    public Recipe(int id, int nextProductId, String name, String description, byte[] image, ArrayList<Product> products, Double rating, ArrayList<Integer> votes, int countVotes, Category category) {
        this.id = id;
        this.nextProductId = nextProductId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.products = products;
        this.rating = rating;
        this.votes = votes;
        this.countVotes = countVotes;
        this.category = category;
    }

    
    
    public Recipe(int id, String name, String description) {
        this.id = id;
        this.nextProductId = -1;
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
        this.rating = 0.0;
        this.votes = new ArrayList<>();
        this.countVotes = 0;
    }
    
    public Recipe() {
        this.nextProductId = -1;
        this.products = new ArrayList<>();
        this.rating = 0.0;
        this.votes = new ArrayList<>();
        this.countVotes = 0;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public ArrayList<Integer> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Integer> votes) {
        this.votes = votes;
    }
    
    public void addVote(Integer vote) {
        votes.add(vote);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getCountVotes() {
        return countVotes;
    }

    public void setCountVotes(int countVotes) {
        this.countVotes = countVotes;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getNextProductId() {
        return nextProductId;
    }

    public void setNextProductId(int nextProductId) {
        this.nextProductId = nextProductId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    public void addProduct(Product product) {
        if(product.getId() == -1) {
            product.setId(this.nextProductId++);
        }
        
        products.add(product);
    }
    
    public void deleteProduct(int id) {
        products.remove(id);
    }
}
