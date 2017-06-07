/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import montours_and_men.network.packets.Packet;
import montours_and_men.utilities.SystemManager;

public final class TCPSocket
{
    private Socket socket;
    
    public TCPSocket(InetAddress serverAddress, int serverPort) throws IOException
    {
        try
        {
            socket = new Socket(serverAddress, serverPort);
        } 
        catch (IOException exception)
        {
            SystemManager.consolePrintStack(exception);
            throw exception;
        }
    }
    
    public void send(Packet packet) throws IOException
    {
        socket.getOutputStream().write(packet.getBytes());
    }
    
}
