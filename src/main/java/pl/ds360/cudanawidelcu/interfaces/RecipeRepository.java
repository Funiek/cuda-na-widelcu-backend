/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.interfaces;

import java.util.ArrayList;
import pl.ds360.cudanawidelcu.entities.Recipe;

/**
 *
 * @author ZABA
 */
public interface RecipeRepository {
    void init();
    void addRecipe(Recipe recipe);
    void modifyRecipe(Recipe recipe);
    void deleteRecipe(int id);
    void deleteRecipe(String name);
    Recipe getRecipe(int id);
    Recipe getRecipe(String name);
    ArrayList<Recipe> getRecipes();
}
