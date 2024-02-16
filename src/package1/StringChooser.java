package package1;

public class StringChooser implements MyChooser<String> {

private static String[] contents;
	
	
	public static void setVariable(String[] specificArr)
	{
	    contents = specificArr;
	}

	public static String[] getVariable()
	{
	    return contents;
	}
	
	@Override
	public boolean chooseElement(String e) {
		if (e.contains("h"))
		{
			return false;
		}
		else
			return true;
	}

}
