 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.utilities;

import java.io.File;
import java.io.Serializable;
import montours_and_men.game.GameManager;

public class Save implements Serializable
{
    public String name;
    
    private GameManager gameManager;
    
    public Save(GameManager gm)
    {
        
    }
    
    public Save(File file)
    {
        
    }
    
    public GameManager getGameManager()
    {
        return gameManager;
    }
    
}
