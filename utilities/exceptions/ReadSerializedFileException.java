/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.utilities.exceptions;

public class ReadSerializedFileException extends Exception
{
    public ReadSerializedFileException()
    {
    }

    public ReadSerializedFileException(String message)
    {
        super(message);
    }

    public ReadSerializedFileException(Throwable cause)
    {
        super(cause);
    }

    public ReadSerializedFileException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
