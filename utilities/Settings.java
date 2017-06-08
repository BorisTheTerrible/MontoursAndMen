package montours_and_men.utilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;

public class Settings implements Serializable
{
    //Version is sent by int for ease of use
    //it is in format 123456789 aka 123.456.789, Ex: 100120123 = 1.12.123
    public static final int VERSION = 100000000;
    public static final int CLIENT_PORT = 30001;
    
    public Dimension windowDimensions;
    
    public double fieldOfView;
    
    public boolean isFullscreen;
    public boolean isBorderless;
    
    public Settings()
    {
        windowDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        isFullscreen = false;
        isBorderless = false;
        fieldOfView = 90;
    }
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Field of view = ").append(fieldOfView).append("\n");
        stringBuilder.append("Is fullscreen = ").append(isFullscreen).append("\n");
        stringBuilder.append("Is borderless = ").append(isBorderless).append("\n");
        stringBuilder.append("Window dimensions = ").append(windowDimensions.toString()).append("\n");
        
        return stringBuilder.toString();
    }
}
