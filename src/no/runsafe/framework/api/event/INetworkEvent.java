package no.runsafe.framework.api.event;

import no.runsafe.framework.minecraft.event.RunsafeNetworkEvent;

public interface INetworkEvent
{
	void onNetworkEvent(RunsafeNetworkEvent networkEvent);
}