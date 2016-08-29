package montours_and_men.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class Data
{
     
    public static void writeFile(File file, StringBuilder builder)
    {
        try
        {
            if (!file.createNewFile()) 
            {
                SystemManager.consolePrintError("File already exists at " + file.getPath());
                return;
            }

            FileWriter fstream = new FileWriter(file.getPath());
            BufferedWriter out = new BufferedWriter(fstream);

            out.write(builder.toString());

            out.close();
        }
        catch (Exception e)
        {          
            SystemManager.consolePrintStack(e);
        }
    }
    
    public static Object readValue(String string)
    {
       return null; 
    }
    
    private static StringBuilder readFile(File file)
    {
        if(!file.exists())
        {
            SystemManager.consolePrintError("Attempted to read file that doesn't exist at " + file.getPath());
            return null;
        }
        
        StringBuilder builder = new StringBuilder();
        
        BufferedReader br = null;
        
        try
        {
            //read from file
            String currentLine;

            br = new BufferedReader(new FileReader("/Users/games/Desktop/Java/File.txt"));

            while ((currentLine = br.readLine()) != null)
            {
                builder.append(currentLine);
            }

        } 
        catch (IOException e)
        {
            SystemManager.consolePrintStack(e);
        }
        finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            } 
            catch (IOException e)
            {
                SystemManager.consolePrintStack(e);
            }
        }
        
        return builder;
    }
}
