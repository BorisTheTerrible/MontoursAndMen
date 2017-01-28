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
import montours_and_men.utilities.exceptions.ReadSerializedFileException;

public final class FileData
{
    //File is actual file location to save, Object is object to serialize
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
    
    public static Object readObjectFile(File file) throws ReadSerializedFileException
    {
        Object object = null;
        FileInputStream fileInputStream = null;
        
        try
        {
            fileInputStream = new FileInputStream(file);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            throw new ReadSerializedFileException(fileNotFoundException);
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
                throw new ReadSerializedFileException(classNotFoundException);
            }
            
            objectInputStream.close();
        }
        catch(IOException ioException)
        {
            throw new ReadSerializedFileException(ioException);
        }
        
        return object;
    }
    
    public static void writeFile(File file, StringBuilder stringBuilder)
    {
        try
        {
            //Checks if the file can be created and that it doesn't already exists
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
        //Checks to make sure the file exists
        if(!file.exists())
        {
            SystemManager.consolePrintError("Attempted to read file that doesn't exist at " + file.getPath());
            return null;
        }
        
        //Used to store the read file text
        StringBuilder builder = new StringBuilder();
        
        BufferedReader bufferedReader = null;
        
        try
        {
            //Stores the current read line
            String currentLine;

            bufferedReader = new BufferedReader(new FileReader(file.getPath()));

            //Checks if the read line isn't null
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
