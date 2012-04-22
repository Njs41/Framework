package no.runsafe.framework.server.event.block;

import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.block.BlockBreakEvent;

public class RunsafeBlockBreakEvent extends RunsafeBlockEvent implements CancellableEvent
{
    public RunsafeBlockBreakEvent(BlockBreakEvent toWrap)
    {
        super(toWrap);
        event = toWrap;
    }

    public RunsafePlayer getPlayer()
    {
        return new RunsafePlayer(event.getPlayer());
    }

    @Override
    public boolean getCancelled()
    {
        return event.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel)
    {
        event.setCancelled(cancel);
    }

    private BlockBreakEvent event;
}