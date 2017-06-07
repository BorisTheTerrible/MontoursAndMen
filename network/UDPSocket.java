/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import montours_and_men.Start;
import montours_and_men.network.packets.Packet;
import montours_and_men.utilities.SystemManager;

public final class UDPSocket
{
    private DatagramSocket datagramSocket;

    public UDPSocket(InetAddress serverAddress, int serverPort) throws SocketException
    {
        try
        {
            datagramSocket = new DatagramSocket(Start.CLIENT_PORT);
        } 
        catch (SocketException socketException)
        {
            SystemManager.consolePrintStack(socketException);
            datagramSocket = null;
            
            throw socketException;
        }
    }
    
    public void send(Packet packet)
    {
        DatagramPacket datagramPacket = new DatagramPacket
        (
                packet.getBytes(), 
                packet.getBytes().length,
                datagramSocket.getInetAddress(), 
                datagramSocket.getPort()
        );
        
        try
        {
            datagramSocket.send(datagramPacket);
        } 
        catch (IOException ioException)
        {
            SystemManager.consolePrintStack(ioException);
        }
    }
    
    /*
    public Packet waitAndReceive()
    {
        
    }
    */
}
