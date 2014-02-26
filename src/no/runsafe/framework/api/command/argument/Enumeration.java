package no.runsafe.framework.api.command.argument;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enumeration extends CommandArgumentSpecification implements ListOf.Compatible
{
	public class Required extends Enumeration
	{
		public Required(String name, java.lang.Enum<?>[] values)
		{
			super(name, values);
		}

		public Required(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
		{
			super(name, values, defaultValue);
		}

		@Override
		public boolean isRequired()
		{
			return true;
		}
	}

	public class Optional extends Enumeration
	{
		public Optional(String name, java.lang.Enum<?>[] values)
		{
			super(name, values);
		}

		public Optional(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
		{
			super(name, values, defaultValue);
		}

		@Override
		public boolean isRequired()
		{
			return false;
		}
	}

	protected Enumeration(String name, java.lang.Enum<?>[] values)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (java.lang.Enum<?> value : values)
		{
			this.values.put(value.name(), value);
			names.add(value.name());
		}
		alternatives = ImmutableList.copyOf(names);
		this.required = false;
		defaultValue = null;
	}

	@Deprecated
	public Enumeration(String name, java.lang.Enum<?>[] values, boolean required)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (java.lang.Enum<?> value : values)
		{
			this.values.put(value.name(), value);
			names.add(value.name());
		}
		alternatives = ImmutableList.copyOf(names);
		this.required = required;
		defaultValue = null;
	}

	@Deprecated
	public Enumeration(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (java.lang.Enum<?> value : values)
		{
			this.values.put(value.name(), value);
			names.add(value.name());
		}
		alternatives = ImmutableList.copyOf(names);
		required = true;
		this.defaultValue = defaultValue.name();
	}

	@Deprecated
	public Enumeration(String name, Iterable<String> values, boolean required)
	{
		super(name);
		alternatives = ImmutableList.copyOf(values);
		this.required = required;
		defaultValue = null;
	}

	@SuppressWarnings("NullableProblems")
	@Deprecated
	public Enumeration(String name, Iterable<String> values, String defaultValue)
	{
		super(name);
		alternatives = ImmutableList.copyOf(values);
		required = true;
		this.defaultValue = defaultValue;
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
		//noinspection ReturnOfCollectionOrArrayField
		return alternatives;
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return defaultValue;
		for (String alternative : alternatives)
			if (alternative.toLowerCase().startsWith(value.toLowerCase()))
				return alternative;

		return defaultValue;
	}

	@Nullable
	public java.lang.Enum<?> getValue(Map<String, String> params)
	{
		if (values.containsKey(params.get(name)))
			return values.get(params.get(name));

		return null;
	}

	private final boolean required;
	private final ImmutableList<String> alternatives;
	private final Map<String, java.lang.Enum<?>> values = new HashMap<String, java.lang.Enum<?>>(0);
	@Nullable
	private final String defaultValue;
}