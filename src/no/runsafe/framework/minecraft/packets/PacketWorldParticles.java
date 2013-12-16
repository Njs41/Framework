package no.runsafe.framework.minecraft.packets;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.networking.NetworkPacket;
import no.runsafe.framework.minecraft.WorldEffect;

public final class PacketWorldParticles extends NetworkPacket
{
	@SuppressWarnings("NumericCastThatLosesPrecision")
	public PacketWorldParticles(WorldEffect effect, ILocation location, WorldParticleOffset offset, int speed, int amount)
	{
		setData("a", effect.getName());
		setData("b", (float) location.getX());
		setData("c", (float) location.getY());
		setData("d", (float) location.getZ());
		setData("e", offset.getX());
		setData("f", offset.getY());
		setData("g", offset.getZ());
		setData("h", speed);
		setData("i", amount);
	}

	@Override
	public PacketType getPacketType()
	{
		return PacketType.WORLD_PARTICLES;
	}
}
