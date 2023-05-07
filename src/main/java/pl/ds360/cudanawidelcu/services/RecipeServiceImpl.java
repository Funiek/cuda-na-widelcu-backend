/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pl.ds360.cudanawidelcu.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import pl.ds360.cudanawidelcu.entities.Category;
import pl.ds360.cudanawidelcu.entities.Recipe;
import pl.ds360.cudanawidelcu.interfaces.RecipeRepository;
import pl.ds360.cudanawidelcu.interfaces.RecipeService;
import pl.ds360.cudanawidelcu.repositories.RecipeRepositoryImpl;
import pl.ds360.cudanawidelcu.interfaces.FileService;

/**
 *
 * @author ZABA
 */
@MTOM
@WebService(serviceName = "RecipeService", endpointInterface = "pl.ds360.cudanawidelcu.interfaces.RecipeService")
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class RecipeServiceImpl implements RecipeService {
    FileService imageService;
    RecipeRepository recipeRepository;

    public RecipeServiceImpl() {
        this.imageService = new FileServiceImpl();
        this.recipeRepository = new RecipeRepositoryImpl();
        recipeRepository.init();
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        return recipeRepository.getRecipes();
    }

    @Override
    public String getRecipesToString() {
        String str = "";
        
        for(Recipe recipe: recipeRepository.getRecipes()) {
            str += recipe.getName()+";";
        }
        
        return str;
    }

    @Override
    public Recipe getRecipe(int id) {
        Recipe recipe = recipeRepository.getRecipe(id);
        return (recipe != null) ? recipe : new Recipe();
    }

    @Override
    public Recipe getRecipeByName(String name) {
        Recipe recipe = recipeRepository.getRecipe(name);
        return (recipe != null) ? recipe : new Recipe();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeRepository.addRecipe(recipe);
    }

    @Override
    public void modifyRecipe(Recipe recipe) {
        recipeRepository.modifyRecipe(recipe);
    }

    @Override
    public void deleteRecipe(int id) {
        recipeRepository.deleteRecipe(id);
    }

    @Override
    public void deleteRecipeByName(String name) {
        recipeRepository.deleteRecipe(name);
    }

    @Override
    public void rateRecipe(int id, int vote) {
        Recipe recipe = recipeRepository.getRecipe(id); 
        int countVotes = recipe.getCountVotes() + 1;
        recipe.setCountVotes(countVotes);
        
        recipe.addVote(vote);
        
        Double newRating = 0.0;
        for(Integer integer: recipe.getVotes()) {
            newRating += integer;
        }
        newRating = newRating / countVotes;
        
        recipe.setRating(newRating);
    }

    @Override
    public void rateRecipeByName(String name, int vote) {
        Recipe recipe = recipeRepository.getRecipe(name); 
        int countVotes = recipe.getCountVotes() + 1;
        recipe.setCountVotes(countVotes);
        
        recipe.addVote(vote);
        
        Double newRating = 0.0;
        for(Integer integer: recipe.getVotes()) {
            newRating += integer;
        }
        newRating = newRating / countVotes;
        
        recipe.setRating(newRating);
    }

    @Override
    public List<Recipe> getRecipesByCategory(Category category) {
        
        List<Recipe> recipesByCategory = recipeRepository.getRecipes()
                .stream()
                .filter(r -> r.getCategory().equals(category))
                .collect(Collectors.toList());

//        ArrayList<Recipe> recipesByCategory = new ArrayList<>();
//        
//        for(Recipe recipe: recipeRepository.getRecipes()) {
//            if(recipe.getCategory() == category) {
//                recipesByCategory.add(recipe);
//            }
//        }
        
        return recipesByCategory;
    }

    
}
