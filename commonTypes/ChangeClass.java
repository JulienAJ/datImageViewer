package commonTypes;

public class ChangeClass
{
	private ChangeType type;
	// name of the image for wich something changed
	private String value;

	public ChangeClass(ChangeType type, String value)
	{
		this.type = type;
		this.value = value;
	}

	public ChangeClass(ChangeType type)
	{
		this.type = type;
		this.value = null;
	}

	public ChangeType getType()
	{
		return this.type;
	}

	public String getValue()
	{
		return this.value;
	}
}
