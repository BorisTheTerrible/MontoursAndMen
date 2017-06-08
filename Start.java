package montours_and_men;

import montours_and_men.game.GameManager;
import montours_and_men.network.NetworkManager;
import montours_and_men.utilities.Resources;
import montours_and_men.utilities.SystemManager;
import montours_and_men.utilities.ExtendedThread;
import montours_and_men.window.Window;

public class Start extends ExtendedThread
{
    public static final Resources resources = new Resources();
    
    public static final NetworkManager networkManager = new NetworkManager();
    
    private static GameManager game;
    
    private final SystemManager system = new SystemManager();
    private final Window window = new Window();
    
    public Start()
    {
        networkManager.tryEstablishConnection("127.0.0.1", 30000);
        
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
    
    public static GameManager getGameManager()
    {
        return game;
    }
    
    public static void main(String[] args)
    {
        Start start = new Start();
    }
}
