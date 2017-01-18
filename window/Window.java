package montours_and_men.window;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import montours_and_men.Start;
import montours_and_men.utilities.Settings;
import montours_and_men.utilities.SystemManager;

public class Window extends JFrame
{
    private final Settings settings = Start.resources.settings;
    private final Display display;

    public Window()
    {
        //Sets name of window
        super("Mountours - And - Men");
        
        display = new Display();
        
        intialize();
    }
    
    private void intialize()
    {
        setResizable(false);
        setBackground(Color.WHITE);
        
        if (settings.isFullscreen)
        {
            GraphicsEnvironment graphicsEnviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //Theoretically gets the current used screen
            GraphicsDevice graphicsDevice = graphicsEnviroment.getDefaultScreenDevice();
            
            graphicsDevice.setFullScreenWindow(this);
        }
        
        //Sets if the window has a border or not
        setUndecorated(settings.isBorderless);
        
        setSize(settings.windowDimensions);
        display.setSize(settings.windowDimensions);
        display.setBounds(0, 0, settings.windowDimensions.width, settings.windowDimensions.height);
        
        add(display);
        addKeyListener(display.input);
        addMouseListener(display.input);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //This should be called when the window is closed
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent event)
            {
                Start.stop();
            }
        });
        
        //This should be called the the application quitted
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                SystemManager.consolePrint("Wat");
                Start.stop();
            }
        });
        
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
