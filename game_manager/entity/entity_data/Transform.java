/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game_manager.entity.entity_data;

public class Transform {

    private double x;
    private double y;
    private double rotation;

    public Transform()
    {
        x = 0.0;
        y = 0.0;
        rotation = 0.0;
    }
    
    public Transform(double y, double x, double rotation)
    {
        this.y = y;
        this.x = x;  
        this.rotation = rotation;
    }

    public void move(int movementX, int movementY)
    {
        
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public void rotate(double rotationAmmount)
    {
        double newRotation = rotation + rotationAmmount;
        
        rotation = checkRotation(newRotation);
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
    
    public double getRotation()
    {
        return rotation;
    }
}
