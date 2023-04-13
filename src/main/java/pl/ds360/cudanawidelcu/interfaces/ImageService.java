/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.interfaces;

import java.awt.Image;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author ZABA
 */
@WebService(name = "ImageService", targetNamespace = "http://cudanawidelcu.ds360.pl/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface ImageService {
    
    @WebMethod
    Image downloadImage(@WebParam(name = "recipeName") String recipeName);
}
