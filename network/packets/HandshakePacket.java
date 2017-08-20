/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network.packets;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import montours_and_men.Start;
import montours_and_men.utilities.Settings;

public final class HandshakePacket extends Packet
{
    //Handshake packet is always sent as big endian, or network order
    
    public final int version;
    public final boolean isBigEndian;
    public String username;
    //public char[] password;
    
    public HandshakePacket(String username)
    {
        super(5);
        
        this.username = username;
        version = Settings.VERSION;
        isBigEndian = true;
    }
    
    @Override
    public byte[] getBytes()
    {
        byte[] usernameBytes = username.getBytes(StandardCharsets.US_ASCII);
        
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 + 4 + 1 + usernameBytes.length);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(packetId);
        byteBuffer.putInt(version);
        byteBuffer.put(Packet.packageBoolean(isBigEndian));
        byteBuffer.put(usernameBytes);
        
        return byteBuffer.array();
    }
}
