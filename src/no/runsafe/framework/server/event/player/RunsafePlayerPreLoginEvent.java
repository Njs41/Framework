package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.event.RunsafeEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.net.InetAddress;

@SuppressWarnings("deprecation")
public class RunsafePlayerPreLoginEvent extends RunsafeEvent
{
	public RunsafePlayerPreLoginEvent(AsyncPlayerPreLoginEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return RunsafeServer.Instance.getPlayer(event.getName());
	}

	public String getName()
	{
		return event.getName();
	}

	public void allow()
	{
		event.allow();
	}

	public void serverFull(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, message);
	}

	public void playerBanned(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, message);
	}

	public void playerNotWhitelisted(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, message);
	}

	public void disallow(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message);
	}

	public InetAddress getAddress()
	{
		return event.getAddress();
	}

	public boolean getHasBeenKicked()
	{
		return event.getResult() != org.bukkit.event.player.PlayerPreLoginEvent.Result.ALLOWED;
	}

	public String getKickMessage()
	{
		return event.getKickMessage();
	}

	public void setKickMessage(String message)
	{
		event.setKickMessage(message);
	}

	private final AsyncPlayerPreLoginEvent event;
}