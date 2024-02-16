package package1;

public class NumberChooser implements MyChooser<Integer> {

	private static Integer[] contents;
	
	
	public static void setVariable(Integer[] specificArr)
	{
	    contents = specificArr;
	}

	public static Integer[] getVariable()
	{
	    return contents;
	}

		
	
	@Override
	public boolean chooseElement(Integer num) {
		if(num > 100) {
			return true;
			
		}
		return false;
	}

}
