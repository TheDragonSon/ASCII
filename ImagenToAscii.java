
package RigoChallenge;

import javax.swing.*; 
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;



public class ImagenToAscii {
 
    
    JFrame cuadroResult;
    JTextArea areadeTexto;
    BufferedImage image; 
    double gValue;
    PrintWriter pw;
    FileWriter fw;
   
    
    
    
     public void cuadroVisible() 
    {
        cuadroResult = new JFrame();
        cuadroResult.setSize(500, 500);
        cuadroResult.setVisible(true);
        cuadroResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadroResult.setTitle("iASCIIfy by Aravind Rao");
        
        areadeTexto = new JTextArea();
        areadeTexto.setRows(1000);
        areadeTexto.setColumns(1000);
        Font font = new Font("Monospaced", Font.BOLD, 5); 
        areadeTexto.setFont(font); 
        cuadroResult.getContentPane().add(BorderLayout.NORTH, areadeTexto);
        
          try {
            
            pw = new PrintWriter(fw = new FileWriter(("result.txt"), true)); 
        } catch (FileNotFoundException ffx) {} 
          catch (IOException iox) {}
    }
     
         public void leerImagen() 
    {
    try {
        image = ImageIO.read(new File("image6.jpg")); 
       } 
    catch (IOException e) {}
    
       for (int y = 0; y <image.getHeight(); y++) 
       {
        for (int x = 0; x < image.getWidth(); x++) 
        {
            Color pixelColor = new Color(image.getRGB(x,y)); 
            gValue = (((pixelColor.getRed()*0.2989)+(pixelColor.getBlue()*0.5870)+(pixelColor.getGreen()*0.1140)));
            areadeTexto.append(escaladeGris(gValue));
            print(escaladeGris(gValue));
        }
        areadeTexto.append("\n");
       try
{
    pw.println("");
    pw.flush();
    fw.flush();
}
catch(Exception ex){}
       }
   
    }
         
public String escaladeGris (double g)
    {
    String str = " ";
    

    if (g >= 230)
    {
        str = " ";
    }
    else if (g >= 200)
    {
        str = ".";
    }
    else if (g >= 180)
    {
        str = "*";
    }
    else if (g>= 160)
    {
        str = ":";
    }
    else if (g >= 130)
    {
        str = "o";
    }
    else if (g >= 100)
    {
        str = "&";
    }
    else if (g >= 70)
    {
        str = "8";
    }
    else if (g >= 50)
    {
        str = "#";
    }
    else
    {
        str = "@";
    }

    return str; 
        
    }
    
        public String viceversa(double g) 
    {
    String str = " ";

    if (g >= 230)
    {
        str = "@";
    }
    else if (g >= 200)
    {
        str = "#";
    }
    else if (g >= 180)
    {
        str = "8";
    }
    else if (g>= 160)
    {
        str = "&";
    }
    else if (g >= 130)
    {
        str = "o";
    }
    else if (g >= 100)
    {
        str = ":";
    }
    else if (g >= 70)
    {
        str = "*";
    }
    else if (g >= 50)
    {
        str = ".";
    }
    else
    {
        str = " ";
    }

    return str;
        
    }
    
    public void print(String str)
    {
try
{
    pw.print(str);
    pw.flush();
    fw.flush();
}
catch(Exception ex){}
}
 
    public static void main(String[] args) {
    ImagenToAscii ascii = new ImagenToAscii();
    ascii.cuadroVisible();
    ascii.leerImagen();
    
    }
     
     
    
}
