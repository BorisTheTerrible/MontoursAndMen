/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.game.entity.entity_data;

public final class Vector2D
{
    private double x = 0;
    private double y = 0;
    
    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void set(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void add(double x, double y)
    {
        this.x += x;
        this.y += y;
    }
}
