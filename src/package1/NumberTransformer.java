package package1;

public class NumberTransformer implements MyTransformer<Integer> {
	
private static Integer[] contents;
	
	
public static void setVariable(Integer[] specificArr)
{
    contents = specificArr;
}

public static Integer[] getVariable()
{
    return contents;
}

	
	public Integer transformElement(Integer e) {
		Integer newNum = e + 5;
		return newNum;
		
	}

	
}
