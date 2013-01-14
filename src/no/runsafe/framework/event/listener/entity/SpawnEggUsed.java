package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.entity.ISpawnEggUsed;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnEggUsed extends EventRouter<ISpawnEggUsed, CreatureSpawnEvent>
{
	public SpawnEggUsed(IOutput output, IScheduler scheduler, ISpawnEggUsed handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(CreatureSpawnEvent event)
	{
		if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG))
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(CreatureSpawnEvent event)
	{
		return handler.OnSpawnEggUsed(
			ObjectWrapper.convert(event.getEntity()),
			ObjectWrapper.convert(event.getLocation())
		);
	}
}