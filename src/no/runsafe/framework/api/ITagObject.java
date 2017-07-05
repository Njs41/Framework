package no.runsafe.framework.api;

import net.minecraft.server.v1_11_R1.NBTTagCompound;

public interface ITagObject
{
	NBTTagCompound getTagCompound();
	Object cloneWithNewCompound(NBTTagCompound compound);
}
