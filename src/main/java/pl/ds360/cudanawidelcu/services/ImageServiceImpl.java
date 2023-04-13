/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.services;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import pl.ds360.cudanawidelcu.interfaces.ImageService;

/**
 *
 * @author ZABA
 */
@WebService(serviceName = "ImageService", endpointInterface = "pl.ds360.cudanawidelcu.interfaces.ImageService")
public class ImageServiceImpl implements ImageService {

    @Override
    public Image downloadImage(String name) {
        try {
            File image = new File("c:\\Users\\ZABA\\Downloads\\" + name);
            return ImageIO.read(image);
        } catch (IOException e) {
            return null;
        }
    }
    
}
