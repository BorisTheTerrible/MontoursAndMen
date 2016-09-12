/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.utilities;

public class NoObjectFileException extends Exception
{
    public NoObjectFileException()
    {
    }

    public NoObjectFileException(String message)
    {
        super(message);
    }

    public NoObjectFileException(Throwable cause)
    {
        super(cause);
    }

    public NoObjectFileException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
