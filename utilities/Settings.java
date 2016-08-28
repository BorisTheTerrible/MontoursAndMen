/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.utilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;

public class Settings implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public Dimension windowDimensions;
    public boolean isFullscreen;
    public boolean isBorderless;
    
    public Settings()
    {
        windowDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        isFullscreen = false;
        isBorderless = true;
    }
}
