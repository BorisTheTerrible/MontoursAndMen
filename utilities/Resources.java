package montours_and_men.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import montours_and_men.game_manager.GameManager;

public class Resources
{
    public Settings settings;
    
    public BufferedImage playerImage;
    public BufferedImage grassImage;//100x100
    public BufferedImage startImage;

    public Resources()
    {
        String rootDirectory = getRootDirectory();
        
        File settingsFile = new File(rootDirectory.concat("Settings.ser"));
        
        try
        {
            settings = (Settings)FileData.readObjectFile(settingsFile);
        }
        catch(NoObjectFileException noObjectFileException)
        {
            settings = new Settings();
        }
        
        try
        {
            playerImage = ImageIO.read(new File(rootDirectory.concat("Player.png")));
            grassImage = ImageIO.read(new File(rootDirectory.concat("Grass+.png")));
            startImage = ImageIO.read(new File(rootDirectory.concat("Start.png")));
        }
        catch (Exception exception)
        {
            SystemManager.consolePrintStack(exception);
        }
    }
    
    public static String getRootDirectory()
    {
        String rootDirectory;
        
        rootDirectory = System.getProperty("java.class.path");//Gets class path to location of jar file
        rootDirectory = rootDirectory.concat("/montours_and_men/resources/");//Adds the jar path to resources file
        
        return rootDirectory;
    }

    public void writeSave(GameManager gm, String name)
    {
        
    }
}
