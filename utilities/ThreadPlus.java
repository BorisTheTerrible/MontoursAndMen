
package montours_and_men.utilities;


public abstract class ThreadPlus implements Runnable
{
    public final Thread thread;
    
    private volatile boolean shouldStop = false;
    private volatile long sleepLength = 5L;
   
    public ThreadPlus()
    {
        thread = new Thread(this, "Default");
    }

    public void start()
    {
        thread.start();
    }

    public void stop()
    {
        shouldStop = true;
    }
    
    abstract protected void tick();

    protected void setSleepLength(long sleepLength)
    {
        this.sleepLength = sleepLength;
    }
    
    @Override
    public void run()
    {
        while (!shouldStop)
        {
            tick();
                
            try
            {
                Thread.sleep(sleepLength);//1000 miliseconds equals 1 second
            } 
            catch (Exception exception)
            {
                SystemManager.consolePrintStack(exception);
            }
        }

    }
}
