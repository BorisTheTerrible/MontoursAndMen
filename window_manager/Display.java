/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window_manager;

import java.awt.Color;
import java.awt.Graphics;
import montours_and_men.window_manager.input.Input;
import javax.swing.JPanel;

public class Display extends JPanel
{
    public final Input input;
   
    public Display()
    {
        input = new Input();
    }
    
    public void tickInput()
    {
        input.tickInput();
    }
    
    @Override
    public void paint(Graphics graphics)
    {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }
}
