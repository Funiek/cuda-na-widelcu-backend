/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.interfaces;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import pl.ds360.cudanawidelcu.entities.Category;
import pl.ds360.cudanawidelcu.entities.Recipe;

/**
 *
 * @author ZABA
 */
@WebService(name = "RecipeService", targetNamespace = "http://cudanawidelcu.ds360.pl/")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface RecipeService {
    @WebMethod
    @WebResult(partName = "return")
    ArrayList<Recipe> getRecipes();
    
    @WebMethod
    String getRecipesToString();
    
    @WebMethod
    Recipe getRecipe(@WebParam(name = "id") int id);
    
    @WebMethod
    Recipe getRecipeByName(@WebParam(name = "name") String name);
    
    @WebMethod
    void addRecipe(@WebParam(name = "recipe") Recipe recipe);
    
    @WebMethod
    void modifyRecipe(@WebParam(name = "recipe") Recipe recipe);
    
    @WebMethod
    void deleteRecipe(@WebParam(name = "id") int id);
    
    @WebMethod
    void deleteRecipeByName(@WebParam(name = "name") String name);
    
    @WebMethod
    void rateRecipe(@WebParam(name = "id") int id, @WebParam(name = "vote") int vote);
    
    @WebMethod
    void rateRecipeByName(@WebParam(name = "name") String name, @WebParam(name = "vote") int vote);
    
    @WebMethod
    List<Recipe> getRecipesByCategory(@WebParam(name = "category") Category category);
}
