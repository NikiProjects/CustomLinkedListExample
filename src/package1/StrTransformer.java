package package1;

public class StrTransformer implements MyTransformer<String> {
	
	private static String[] contents;
	
	
	public static void setVariable(String[] specificArr)
	{
	    contents = specificArr;
	}

	public static String[] getVariable()
	{
	    return contents;
	}


	public String transformElement(String e) {
		if(e.equals("elephent"))
		{
			return "elephant";
		}
		else {
			return e;
		}
		
	}

	
}
