/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.utilities;

public class NoObjectFile extends Exception
{
    public NoObjectFile()
    {
    }

    public NoObjectFile(String message)
    {
        super(message);
    }

    public NoObjectFile(Throwable cause)
    {
        super(cause);
    }

    public NoObjectFile(String message, Throwable cause)
    {
        super(message, cause);
    }
}
