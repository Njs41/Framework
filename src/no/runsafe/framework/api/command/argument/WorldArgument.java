package no.runsafe.framework.api.command.argument;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Multiverse;

import javax.annotation.Nullable;
import java.util.List;

public class WorldArgument extends CommandArgumentSpecification implements ITabComplete, IValueExpander
{
	public WorldArgument()
	{
		this(true);
	}

	public WorldArgument(boolean required)
	{
		super("world");
		this.required = required;
	}

	@Override
	public boolean isRequired()
	{
		return required;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		return Lists.transform(
			Multiverse.Get().getAllWorlds(),
			new Function<IWorld, String>()
			{
				@Override
				public String apply(@Nullable IWorld world)
				{
					assert world != null;
					return world.getName();
				}
			}
		);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, String value)
	{
		for (IWorld world : Multiverse.Get().getAllWorlds())
			if (world.getName().toLowerCase().startsWith(value.toLowerCase()))
				return world.getName();

		return null;
	}

	private final boolean required;
}
