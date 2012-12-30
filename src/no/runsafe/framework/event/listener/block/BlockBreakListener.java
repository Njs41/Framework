package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockBreakEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.block.RunsafeBlockBreakEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

@SuppressWarnings("deprecation")
@Deprecated
public class BlockBreakListener extends EventRouter<IBlockBreakEvent, BlockBreakEvent>
{
	public BlockBreakListener(IOutput output, IScheduler scheduler, IBlockBreakEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockBreakEvent event)
	{
		super.AcceptEvent(event);
	}

	public boolean OnEvent(BlockBreakEvent event)
	{
		handler.OnBlockBreakEvent(new RunsafeBlockBreakEvent(event));
		return true;
	}
}