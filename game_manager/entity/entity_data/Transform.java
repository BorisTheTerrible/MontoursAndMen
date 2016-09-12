/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game_manager.entity.entity_data;

public class Transform {

    private double x = 0;
    private double y = 0;
    private double z = 0;
    
    private double rotationX = 0;
    private double rotationY = 0;

    public Transform()
    {
        
    }
    
    public Transform(double y, double x, double rotationX)
    {
        this.y = y;
        this.x = x;  

        this.rotationX = rotationX;
    }
    
    public Transform(double y, double x, double z,  double rotationX, double rotationY)
    {
        this.y = y;
        this.x = x;  
        this.z = z;
        
        this.rotationX = rotationX;
        this.rotationY = rotationY;
    }

    public void moveTo(int moveToX, int moveToY)
    {
        z = moveToX;
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
    
    public double getZ()
    {
        return z;
    }
    
    public void rotate(double rotateX, double rotateY)
    {
        rotationX = rotationX + rotateX;
        rotationY = rotationY + rotateY;
        
        rotationX = checkRotation(rotationX);
        rotationY = checkRotation(rotationY);
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
    
    public double getRotationX()
    {
        return rotationX;
    }
    
    public double getRotationY()
    {
        return rotationY;
    }
}
