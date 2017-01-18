package montours_and_men;

import montours_and_men.game.GameManager;
import montours_and_men.network.NetworkManager;
import montours_and_men.utilities.Resources;
import montours_and_men.utilities.SystemManager;
import montours_and_men.utilities.ExtendedThread;
import montours_and_men.window.Window;

public class Start extends ExtendedThread
{
    //Version is sent by int for ease of use
    //it is in format 123456789 aka 123.456.789, Ex: 100120123 = 1.12.123
    public static final int VERSION = 100100100;
    public static final int CLIENT_PORT = 30001;
    
    public static final Resources resources = new Resources();
    
    public static final NetworkManager networkManager = new NetworkManager();
    
    private static GameManager game;
    
    private final SystemManager system = new SystemManager();
    private final Window window = new Window();
    
    public Start()
    {
        //setSleepLength(10L); 
        start();
    }
    
    @Override
    protected void tick()
    {
        //Tick windowInput -> game -> windowGraphics -> system
        //Resources doesn't tick
        
        window.tickInput();
        
        if(game != null)
            game.tick();
        
        window.tickGraphics();
        system.tick();
    }
    
    //This should be called whenever the game is exited
    @Override
    protected void exitCleanup()
    {
        SystemManager.consolePrint("Ayy lamo");
        resources.saveSettings();
    }
    
    public static GameManager getGameManager()
    {
        return game;
    }
    
    public static void main(String[] args)
    {
        Start start = new Start();
    }
}
