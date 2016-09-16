/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game_manager.entity.entity_data;

public class Transform {
    
    //It should be noted that rotation is based off of a circle
    //As such, facing the positive x is rotation 0, negative x is rotation 180, etc...
    
    private double x = 0;
    private double y = 0;
    
    //This is in degrees
    private double rotation = 0;

    public Transform()
    {
        
    }
    
    public Transform(double x, double y)
    {
        this.x = x; 
        this.y = y;
    }
    
    public Transform(double x, double y, double rotation)
    {
        this.x = x; 
        this.y = y;

        this.rotation = rotation;
    }

    public void moveTo(int moveToX, int moveToY)
    {
        x = moveToX;
        y = moveToY;
    }
    
    public void move(int movementX, int movementY)
    {
        x += movementX;
        y += movementY;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
   
    public void rotateInDegrees(double rotateX)
    {
        rotation = rotation + rotateX;
        
        rotation = checkRotation(rotation);
    }
    
    private double checkRotation(double rotationAmmount)
    {
        if(rotationAmmount >= 360)
        {
            rotationAmmount -= 360;
            rotationAmmount = checkRotation(rotationAmmount);
        }
        else if(rotationAmmount < 0)
        {
            rotationAmmount = 360 - Math.abs(rotationAmmount);
            rotationAmmount = checkRotation(rotationAmmount);
        }
        
        return rotationAmmount;
    }
    
    public double getRotationInDegrees()
    {
        return rotation;
    }
}
