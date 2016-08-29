package montours_and_men.window_manager;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import montours_and_men.Start;
import montours_and_men.utilities.Settings;

public class Window extends JFrame
{
    Settings settings = Start.resources.settings;
    Display display;

    public Window()
    {
        super("Mountours - And - Men");
        
        display = new Display();
        
        intialize();
    }
    
    private void intialize()
    {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        
        if (settings.isFullscreen)
        {
            GraphicsEnvironment graphicsEnviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice graphicsDevice = graphicsEnviroment.getDefaultScreenDevice();
            
            graphicsDevice.setFullScreenWindow(this);
        }
        
        setUndecorated(settings.isBorderless);//False for developing
        
        setSize(settings.windowDimensions);
        display.setSize(settings.windowDimensions);
        display.setBounds(0, 0, settings.windowDimensions.width, settings.windowDimensions.height);
        
        add(display);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void tickInput()
    {
        display.tickInput();
    }

    public void tickGraphics()
    {
        paintComponents(getGraphics());
    }
}
