/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window_manager.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input implements KeyListener, MouseListener
{
    private static InputList currentInputList;
    
    public static InputList lastInputList = new InputList();
    
    public void tickInput()
    {
        currentInputList = lastInputList;
        
        lastInputList = new InputList();
    }
    
    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
        currentInputList.keyTyped.add(keyEvent.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        currentInputList.keyPressed.add(keyEvent.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {
        currentInputList.keyReleased.add(keyEvent.getKeyChar());
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        currentInputList.mouseClicked.add(mouseEvent.getButton());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        currentInputList.mousePressed.add(mouseEvent.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        currentInputList.mouseReleased.add(mouseEvent.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
        currentInputList.hasMouseFocus = true;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
        currentInputList.hasMouseFocus = false;
    }   
}
