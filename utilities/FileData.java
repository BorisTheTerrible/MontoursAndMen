package montours_and_men.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public final class FileData
{
    public static void writeObjectFile(File file, Object object)
    {
        FileOutputStream fileOutputStream;
        
        try
        {
            fileOutputStream = new FileOutputStream(file);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            SystemManager.consolePrintStack(fileNotFoundException);
            return;
        }
        
        ObjectOutputStream objectOutputStream;
        
        try
        {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        }
        catch(IOException ioException)
        {
            SystemManager.consolePrintStack(ioException);
        }
    }
    
    public static Object readObjectFile(File file) throws NoObjectFileException
    {
        Object object = null;
        FileInputStream fileInputStream = null;
        
        try
        {
            fileInputStream = new FileInputStream(file);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            throw new NoObjectFileException(fileNotFoundException);
        }
        
        ObjectInputStream objectInputStream = null;
        
        try
        {
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            try
            {
                object = objectInputStream.readObject();
            } 
            catch (ClassNotFoundException classNotFoundException)
            {
                throw new NoObjectFileException(classNotFoundException);
            }
            
            objectInputStream.close();
        }
        catch(IOException ioException)
        {
            throw new NoObjectFileException(ioException);
        }
        
        return object;
    }
    
    public static void writeFile(File file, StringBuilder stringBuilder)
    {
        try
        {
            if (!file.createNewFile()) 
            {
                SystemManager.consolePrintError("File already exists at " + file.getPath());
                return;
            }

            FileWriter fileWriter = new FileWriter(file.getPath());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(stringBuilder.toString());

            bufferedWriter.close();
        }
        catch (Exception exception)
        {          
            SystemManager.consolePrintStack(exception);
        }
    }
    
    public static StringBuilder readFile(File file)
    {
        if(!file.exists())
        {
            SystemManager.consolePrintError("Attempted to read file that doesn't exist at " + file.getPath());
            return null;
        }
        
        StringBuilder builder = new StringBuilder();
        
        BufferedReader bufferedReader = null;
        
        try
        {
            //read from file
            String currentLine;

            bufferedReader = new BufferedReader(new FileReader(file.getPath()));

            while ((currentLine = bufferedReader.readLine()) != null)
            {
                builder.append(currentLine);
            }
        } 
        catch (IOException ioException)
        {
            SystemManager.consolePrintStack(ioException);
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            } 
            catch (IOException ioException)
            {
                SystemManager.consolePrintStack(ioException);
            }
        }
        
        return builder;
    }
}
