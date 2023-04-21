/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.repositories;

import java.util.ArrayList;
import pl.ds360.cudanawidelcu.entities.Category;
import pl.ds360.cudanawidelcu.entities.Product;
import pl.ds360.cudanawidelcu.entities.Recipe;
import pl.ds360.cudanawidelcu.interfaces.RecipeRepository;

/**
 *
 * @author ZABA
 */
public class RecipeRepositoryImpl implements RecipeRepository {
    private int nextRecipeId;
    ArrayList<Recipe> recipes;
    
    public RecipeRepositoryImpl() {
        this.nextRecipeId = -1;
    }
    
    @Override
    public void init() {
        recipes = new ArrayList<>();
        
        Recipe nalesniki = new Recipe(++this.nextRecipeId, "Nalesniki", "Dobre nalesniki", Category.BREAKFAST);
        
        nalesniki.addProduct(new Product("mleko", "szklanka", 1.25));
        nalesniki.addProduct(new Product("jajka", "ilosc", 2D));
        nalesniki.addProduct(new Product("woda gazowana", "szklanka", 1D));
        recipes.add(this.nextRecipeId, nalesniki);
        
        
        Recipe spaghetti = new Recipe(++this.nextRecipeId, "Spaghetti pycha", "Spaghetti bez miesa ale dobre", Category.LUNCH);
        
        spaghetti.addProduct(new Product("makaron", "kg", 0.5));
        spaghetti.addProduct(new Product("mieso mielone", "kg", 0.2));
        spaghetti.addProduct(new Product("ser", "kg", 0.2));
        recipes.add(this.nextRecipeId, spaghetti);
        
        Recipe schabowe = new Recipe(++this.nextRecipeId, "Schabowe", "Schabowe jak u mamusi", Category.BREAKFAST);
        
        schabowe.addProduct(new Product("piers z kurczaka", "ilosc", 2D));
        recipes.add(this.nextRecipeId, schabowe);
        
        Recipe skry = new Recipe(++this.nextRecipeId, "Skyr", "Bialkowa moc", Category.DINNER);
        
        skry.addProduct(new Product("skyr", "ilosc", 1D));
        recipes.add(this.nextRecipeId, skry);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        if(recipe.getId() == -1){
            recipe.setId(++this.nextRecipeId);
            recipes.add(this.nextRecipeId, recipe);
        }
        else {
            recipes.add(recipe.getId(), recipe);
        }
    }

    @Override
    public void deleteRecipe(int id) {
        recipes.remove(id);
    }

    @Override
    public void deleteRecipe(String name) {
        int id = -1;
        for(Recipe recipe: recipes) {
            if(recipe.getName().equals(name)) {
                id = recipe.getId();
                break;
            }
        }
        
        if(id != -1)
            recipes.remove(id);
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipes.get(id);
    }

    @Override
    public Recipe getRecipe(String name) {
        int id = -1;
        for(Recipe recipe: recipes) {
            if(recipe.getName().equals(name)) {
                id = recipe.getId();
                break;
            }
        }
        
        if(id != -1)
            return recipes.get(id);
        
        return null;
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public void modifyRecipe(Recipe recipe) {
        recipes.set(recipe.getId(), recipe);
    }
}
