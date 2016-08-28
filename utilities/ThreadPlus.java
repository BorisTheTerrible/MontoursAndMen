
package montours_and_men.utilities;


public abstract class ThreadPlus implements Runnable
{
    public final Thread thread;
    
    public static volatile boolean shouldStop = false;
   
    public ThreadPlus()
    {
        thread = new Thread(this, "Default");
    }

    public synchronized void start()
    {
        thread.start();
    }

    public synchronized void stop()
    {
        shouldStop = true;
    }
    
    abstract protected void tick();

    @Override
    public void run()
    {
        while (!shouldStop)
        {
            tick();
                
            try
            {
                thread.sleep(50L);//1000 miliseconds equals 1 second
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

    }
}
