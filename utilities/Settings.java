package montours_and_men.utilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;

public class Settings implements Serializable
{
    private static final long serialVersionUID = 1l;
    
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
    
    public static long getCurrentSerialVersionUID()
    {
        return serialVersionUID;
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
