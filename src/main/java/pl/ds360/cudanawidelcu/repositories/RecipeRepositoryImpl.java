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
        recipes.add(++this.nextRecipeId, new Recipe(this.nextRecipeId, "Nalesniki", "Dobre nalesniki", Category.BREAKFAST));
        recipes.add(++this.nextRecipeId, new Recipe(this.nextRecipeId, "Spaghetti pycha", "Spaghetti bez miesa ale dobre", Category.BREAKFAST));
        recipes.add(++this.nextRecipeId, new Recipe(this.nextRecipeId, "Schabowe", "Schabowe jak u mamusi", Category.BREAKFAST));
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
