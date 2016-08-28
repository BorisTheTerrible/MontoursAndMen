package montours_and_men.utilities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import montours_and_men.Start;

public class Conversion {
    
    public static float sizeFactorY;
    public static float sizeFactorX;
    
    public static void setSizeFactor(Dimension dimension)
    {
        sizeFactorY = dimension.height/1000;
        sizeFactorX = dimension.width/1000;
    }
    
    public static Point getPointToSystem(Point point)//Point is center, works on 1000x1000 system
    {
        point.y /= sizeFactorY;
        point.x /= sizeFactorX;
        
        return point;
    }
    
    //Divide going from window to system, multiply going from system to window
    //System is 1000x1000, window is actual window location
    
    public static Rectangle getRectangleToWindow(Rectangle rectangle)
    {
        rectangle.height *= sizeFactorY;
        rectangle.width *= sizeFactorX;
        
        rectangle.y *= sizeFactorY;
        rectangle.x *= sizeFactorX;
        
        return rectangle;
    }
    
}
