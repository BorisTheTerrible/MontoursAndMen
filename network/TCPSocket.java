/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import montours_and_men.network.packets.Packet;

public final class TCPSocket
{
    private final Socket socket;
    
    public TCPSocket(InetSocketAddress inetSocketAddress) throws Exception
    {
        socket = new Socket(inetSocketAddress.getAddress(), inetSocketAddress.getPort());
    }
    
    public void send(Packet packet) throws IOException
    {
        socket.getOutputStream().write(packet.getBytes());
    }
}
