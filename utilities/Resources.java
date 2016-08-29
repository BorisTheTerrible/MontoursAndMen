/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.utilities;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import montours_and_men.Start;
import montours_and_men.game_manager.GameManager;

public class Resources
{
    public Settings settings;
    
    public BufferedImage playerImage;
    public BufferedImage grassImage;//100x100
    public BufferedImage startImage;
    
    public String classPath;

    public Resources()
    {
        settings = new Settings();
        
        classPath = System.getProperty("java.class.path");//Gets class path to location of jar file
        classPath += "/montours_and_men/resources/";//Adds the jar path to resources file
        
        try
        {
            playerImage = ImageIO.read(new File(classPath + "Player.png"));
            grassImage = ImageIO.read(new File(classPath + "Grass+.png"));
            startImage = ImageIO.read(new File(classPath + "Start.png"));
        }
        catch (Exception e)
        {
            SystemManager.consolePrintStack(e);
        }
    }
    
    public void resizeImages()
    {
        playerImage = resizeImage(playerImage);
        grassImage = resizeImage(grassImage);
        startImage = resizeImage(startImage);
    }
    
    private BufferedImage resizeImage(BufferedImage image)
    {
        BufferedImage newImage;
        
        int newWidth = (int)(image.getWidth()*Conversion.sizeFactorY);
        int newHeight = (int)(image.getHeight()*Conversion.sizeFactorX);
        
        int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
        
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(image, 0, 0, newWidth, newHeight, null);
	g.dispose();	
	g.setComposite(AlphaComposite.Src);
 
	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING,
	RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
 
	return resizedImage;
    }

    public void writeSave(GameManager gm, String name)
    {
        
    }
}
