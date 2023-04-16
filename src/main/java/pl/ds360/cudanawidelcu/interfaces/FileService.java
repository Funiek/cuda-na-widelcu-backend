/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.interfaces;

import java.awt.Image;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author ZABA
 */
@WebService(name = "FileService", targetNamespace = "http://cudanawidelcu.ds360.pl/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface FileService {
    
    @WebMethod
    Image downloadImage(@WebParam(name = "recipeName") String recipeName);
    
    @WebMethod
    byte[] downloadRecipeProductsPdf(@WebParam(name = "recipeName") String recipeName) throws IOException;
}
