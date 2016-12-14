/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network.packets;

import java.nio.ByteBuffer;
import montours_and_men.game.entity.entity_data.Transform;

public final class LocationPacket extends Packet
{
    private final Transform transform;
    
    public LocationPacket(final Transform transform)
    {
        super(1);
        this.transform = transform;
    }
    
    @Override
    public byte[] getBytes()
    {
        //Data in transform needed to be sent,
        //plus size of packet id
        ByteBuffer byteBuffer = ByteBuffer.allocate(24 + 4 + 4);
        byteBuffer.putInt(packetId);
        byteBuffer.putDouble(transform.getX());
        byteBuffer.putDouble(transform.getY());
        byteBuffer.putDouble(transform.getRotationInDegrees());
        
        return byteBuffer.array();
    }
}
