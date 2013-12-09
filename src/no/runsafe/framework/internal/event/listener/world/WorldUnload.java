package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.IWorldUnload;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldUnloadEvent;

public final class WorldUnload extends EventRouterBase<IWorldUnload, WorldUnloadEvent>
{
	WorldUnload(IDebug output, IScheduler scheduler, IWorldUnload handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(WorldUnloadEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(WorldUnloadEvent event)
	{
		handler.OnWorldUnload(ObjectWrapper.convert(event.getWorld()));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IWorldUnload.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new WorldUnload(output, scheduler, (IWorldUnload) subscriber);
			}
		};
	}
}
