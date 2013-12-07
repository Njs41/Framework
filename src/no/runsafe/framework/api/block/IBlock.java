package no.runsafe.framework.api.block;

import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.block.RunsafeBlockState;

@SuppressWarnings("InstanceMethodNamingConvention")
public interface IBlock extends IMetadata
{
	void set(Item type);
	RunsafeWorld getWorld();
	RunsafeBlockState getBlockState();
	RunsafeLocation getLocation();
	Item getMaterial();
	void setMaterial(Item material);
	void breakNaturally();
	boolean is(Item type);
	boolean hasInterface();
	boolean isInteractBlock();
	boolean canPassThrough();
	boolean isHazardous();
	boolean isAir();
	boolean isWater();
	boolean isLava();
	boolean isAbleToFall();
	byte getData();
	void setData(byte data);
}
