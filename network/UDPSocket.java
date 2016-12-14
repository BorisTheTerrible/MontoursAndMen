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
    DatagramSocket datagramSocket;
    
    private final InetAddress receiverAddress;
    private final int receiverPort;

    public UDPSocket(InetAddress receiverAddress, int receiverPort) throws SocketException
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
        
        this.receiverAddress = receiverAddress;
        this.receiverPort = receiverPort;
    }
    
    public void send(Packet packet)
    {
        DatagramPacket datagramPacket = new DatagramPacket
        (
                packet.getBytes(), 
                packet.getBytes().length,
                receiverAddress, 
                receiverPort
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
