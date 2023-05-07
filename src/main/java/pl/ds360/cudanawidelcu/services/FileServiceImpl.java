/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.ds360.cudanawidelcu.services;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import pl.ds360.cudanawidelcu.interfaces.FileService;
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;   
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import javax.jws.HandlerChain;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

/**
 *
 * @author ZABA
 */
@MTOM
@WebService(serviceName = "FileService", endpointInterface = "pl.ds360.cudanawidelcu.interfaces.FileService")
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
@HandlerChain(file="handler-chain.xml")
public class FileServiceImpl implements FileService {

    @Override
    public Image downloadImage(String name) {
        try {
            File image = new File(this.getClass().getClassLoader().getResource("data\\" + name + ".jpeg").getFile());
            return ImageIO.read(image);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public byte[] downloadRecipeProductsPdf(String recipeName, String products) throws IOException {
        Path pdfPath = Paths.get("C:\\Users\\Krzysiek\\Documents\\CudaNaWidelcu\\" + recipeName + ".pdf");
        File f = new File("C:\\Users\\Krzysiek\\Documents\\CudaNaWidelcu\\" + recipeName + ".pdf");
        
        if(f.exists())
            return Files.readAllBytes(pdfPath);
        
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Krzysiek\\Documents\\CudaNaWidelcu\\" + recipeName + ".pdf");
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, fos);
            doc.open();
            
            doc.add(new Paragraph(recipeName + " - składniki:"));
            
            for(String product: products.split(";")) {
                doc.add(new Paragraph(product));
            }
            
            doc.close();
            fos.close();
            writer.close();
        } catch (DocumentException ex) {
            Logger.getLogger(FileServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        return Files.readAllBytes(pdfPath);
    }
    
}
