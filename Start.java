
package montours_and_men;

import montours_and_men.game_manager.GameManager;
import montours_and_men.utilities.Resources;
import montours_and_men.utilities.SystemManager;
import montours_and_men.utilities.ThreadPlus;
import montours_and_men.window_manager.Window;

public class Start extends ThreadPlus
{
    public static final Resources resources = new Resources();
    
    private static GameManager game;
    
    private final SystemManager system = new SystemManager();
    private final Window window = new Window();
    
    public Start()
    {
        //setSleepLength(50L); 
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
