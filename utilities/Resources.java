package montours_and_men.utilities;

import montours_and_men.utilities.exceptions.NoObjectFileException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import montours_and_men.game.GameManager;

public class Resources
{
    //Settings file should be serialized and saved whenver the game exits
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
        //Called if the file doesn't exist, it then creates a new file
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
    
    public void saveSettings()
    {
        File settingsFile = new File(getRootDirectory().concat("Settings.ser"));
        
        FileData.writeObjectFile(settingsFile, settings);
    }
    
    public static String getRootDirectory()
    {
        String rootDirectory;
        
        //Gets class path to location of jar file
        rootDirectory = System.getProperty("java.class.path");
        //Adds the jar path to resources file
        rootDirectory = rootDirectory.concat("/montours_and_men/resources/");
        
        return rootDirectory;
    }
}
