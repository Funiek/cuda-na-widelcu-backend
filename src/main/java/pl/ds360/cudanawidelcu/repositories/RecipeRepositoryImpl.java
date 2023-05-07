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
        
        Recipe nalesniki = new Recipe(++this.nextRecipeId, "Nalesniki", "Ulubiony przepis czytelników! Dzięki dodatkowi wody gazowanej naleśniki są bardziej delikatne, ale oczywiście naleśniki wyjdą również ze zwykłą wodą.\n" +
"\n" +
"Jeśli mamy czas, ciasto można przygotować pół godziny wcześniej, aby odpoczęło, ale nie jest to konieczne i naleśniki można od razu smażyć po zmiksowaniu składników.", Category.BREAKFAST);
        
        nalesniki.addProduct(new Product("mleko", "szklanka", 1.25));
        nalesniki.addProduct(new Product("jajka", "ilosc", 2D));
        nalesniki.addProduct(new Product("woda gazowana", "szklanka", 1D));
        recipes.add(this.nextRecipeId, nalesniki);
        
        
        Recipe spaghetti = new Recipe(++this.nextRecipeId, "Spaghetti", "Spaghetti bolognese to nie tylko niesamowicie pyszne, ale także łatwe do zrobienia danie! Niezależnie od tego, czy dopiero zaczynasz gotować, czy masz zaawansowane umiejętności, ta prosta wersja włoskiego klasyka z całą pewnością przypadnie Ci do gustu.", Category.LUNCH);
        
        spaghetti.addProduct(new Product("makaron", "kg", 0.5));
        spaghetti.addProduct(new Product("mieso mielone", "kg", 0.2));
        spaghetti.addProduct(new Product("ser", "kg", 0.2));
        recipes.add(this.nextRecipeId, spaghetti);
        
        Recipe schabowe = new Recipe(++this.nextRecipeId, "Schabowe", "Jaki powinien być kotlet schabowy? Powinien być cienki czy raczej gruby? Smażony na oleju roślinnym, maśle klarowanym czy na smalcu? Z kością czy bez niej? Jaki jest najbardziej klasyczny przepis na kotlet schabowy? Każdy robi go inaczej, ale mnie najbardziej smakuje ten, który jest po prostu wieprzową wersją sznycla wiedeńskiego, pozostającego wciąż najlepiej dopracowanym kotletem w panierce.\n" +
"\n" +
"Mój idealny kotlet jest cienki, z delikatną panierką odchodzącą od mięsa, tworzącą charakterystyczne duże purchle, równomiernie wysmażony, kolorem przypominający skrzypce Stradivariusa.", Category.BREAKFAST);
        
        schabowe.addProduct(new Product("piers z kurczaka", "ilosc", 2D));
        recipes.add(this.nextRecipeId, schabowe);
        
        Recipe skry = new Recipe(++this.nextRecipeId, "Skyr", "Skyr wymieszaj z jogurtem, masłem orzechowym, kakao, syropem klonowym i musli. Podziel na porcje, dodaj owoce. Mrożone wcześniej rozmroź – wyjmij je odpowiednio wcześniej z zamrażalnika albo wstaw na chwilę do mikrofalówki.", Category.DINNER);
        
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
