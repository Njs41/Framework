package no.runsafe.framework.server.event.player;

import no.runsafe.framework.IKernel;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.event.player.IPlayerDeathEvent;
import no.runsafe.framework.event.player.IPlayerKickEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class RunsafePlayerDeathEvent extends RunsafeEntityDeathEvent
{
	public RunsafePlayerDeathEvent(PlayerDeathEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public void setDeathMessage(String deathMessage)
	{
		this.event.setDeathMessage(deathMessage);
	}

	public String getDeathMessage()
	{
		return this.event.getDeathMessage();
	}

	public int getNewExp()
	{
		return this.event.getNewExp();
	}

	public void setNewExp(int exp)
	{
		this.event.setNewExp(exp);
	}

	public int getNewLevel()
	{
		return this.event.getNewLevel();
	}

	public void setNewLevel(int level)
	{
		this.event.setNewLevel(level);
	}

	public int getNewTotalExp()
	{
		return this.event.getNewTotalExp();
	}

	public void setNewTotalExp(int totalExp)
	{
		this.event.setNewTotalExp(totalExp);
	}

	public boolean getKeepLevel()
	{
		return this.event.getKeepLevel();
	}

	public void setKeepLevel(boolean keepLevel)
	{
		this.event.setKeepLevel(keepLevel);
	}

	public void Fire()
	{
		for (IKernel plugin : RunsafePlugin.Instances.values())
			for (IPlayerDeathEvent listener : plugin.getComponents(IPlayerDeathEvent.class))
				listener.OnPlayerDeathEvent(this);
	}

	private final PlayerDeathEvent event;
}