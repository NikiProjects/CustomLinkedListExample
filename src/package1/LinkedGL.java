package package1;



public class LinkedGL<E> {

	
    
// start of Node inner class	
	
	class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    } // this is where the Node class ends
	
	
	//end of Node inner class Node

    
    // the front keeps changing as you add more Nodes
	// the front represents the newest Node that is added.
    Node front; // the head Node
    int size;
    
    public boolean isEmpty() {
    	
    	if(this.size == 0)
    		return true;
    	else 
    		return false;
    				
    	
    }  
    
    public LinkedGL(E[] contents) {
        // Fill in this constructor
    	
    	
    	for(E arrValue : contents) {
    		size = size + 1;
    		if (this.front == null) { 
        		Node new_node = new Node(arrValue, null); 
                this.front = new_node; 
            } // end of if
    		// Else traverse till the last node 
            // and insert the new_node there 
    		else { 
        //both the 'front' and 'last' variable should represent the newest Node that has been added.
                Node last = this.front; 
                
    //the below while loop is just to make sure that the Node that has been assigned to the variable 'last' has a value of null for the Node's variable 'next'.           
                while (last.next != null) { 
                    last = last.next; 
                } 
       
                // Insert the new_node at last node 
                Node new_node = new Node(arrValue, null);
                last.next = new_node; 
                
            } // end of else
    	
    	}// end of for loop
    	
    	Class arrayClass = contents.getClass();
    	Class component = arrayClass.getComponentType();
        String dataType = null;
    	
    	if (component != null) {
           System.out.println("Component type is " + component.getName());
           dataType = component.getName();
        } else {
        	
           System.out.println("Component type is null");
        }
    	
    	if(dataType.equals("java.lang.String")) {
    		String strArr[] = new String[size];
    		for(int i = 0; i < contents.length; i++) {
    			strArr[i] = (String) contents[i];	
    		} //end of for
    		StrTransformer.setVariable(strArr);
    		StringChooser.setVariable(strArr);
    		
    	}
    	else if(dataType.equals("java.lang.Integer")) {
    		Integer intArr[] = new Integer[size];
    		for(int i = 0; i < contents.length; i++) {
    			intArr[i] = (Integer) contents[i];	
    		} //end of for
    		NumberTransformer.setVariable(intArr);
    		NumberChooser.setVariable(intArr);
    		
    	}
    	
    	
    	
    } // end of constructor
	
	
 
    
    
 // Method to print the LinkedList. 
    public void printList(LinkedGL list) 
    { 
        Node currNode = list.front; 
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("Printing values directly from the LinkedList: "); 
    
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.value + " "); 
    
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 	
	
    
public E[] toArray() {
	E[] arr	= (E[]) new Object[size];
//	E[] arrays = (E[])new Object[];
//	E[] a = null;
//	Class<E> clazz = ClassUtils.getParameterizedClass(getClass());
	int arrayIndex = 0;
//	System.out.println("The size is: " + size);
		E[] arrayGeneric = (E[])java.lang.reflect.Array.newInstance( 
	             arr.getClass().getComponentType(), size); 
	 
	
	 Node currNode = this.front; 	
     while (currNode != null) { 
         // Print the data at current node 
       
         arrayGeneric[arrayIndex] = currNode.value;
         // Go to next node 
         currNode = currNode.next; 
         arrayIndex = arrayIndex + 1;
     } 
    
     System.out.println();
     System.out.println();
     System.out.println();
    System.out.println("Values from LinkedList transferred into Array");
    for(E genericArrVal : arrayGeneric) {
    	System.out.println(genericArrVal);
    }
    
    return arrayGeneric;
    } // end of toArray method
 

public void chooseAll(MyChooser mc) {
	if(mc instanceof NumberChooser) {
		Integer[] intArrOrig = NumberChooser.getVariable();
		Integer intArrTransformed[] = new Integer[size];
		
		for(int i = 0; i < size; i++) {
			boolean isChosen = mc.chooseElement(intArrOrig[i]);
			
			if(isChosen) {
			intArrTransformed[i] = (Integer)intArrOrig[i];
			}
		}

		System.out.println("The chosen array values are:");
		for(Integer transformedArrValue: intArrTransformed) {
			System.out.println(transformedArrValue);
		}
		}	//end of instanceof block
	else if(mc instanceof StringChooser) {
		String[] strArrOrig = StringChooser.getVariable();
		String strArrTransformed[] = new String[size];
		
		for(int i = 0; i < size; i++) {
			boolean isChosen = mc.chooseElement(strArrOrig[i]);
			
			if(isChosen) {
			strArrTransformed[i] = (String)strArrOrig[i];
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("The chosen array values are:");
		for(String transformedArrValue: strArrTransformed) {
			System.out.println(transformedArrValue);
		}
		}	
}


public void transformAll(MyTransformer mt) {
	
	if(mt instanceof NumberTransformer) {
	Integer[] intArrOrig = NumberTransformer.getVariable();
	Integer intArrTransformed[] = new Integer[size];
	
	for(int i = 0; i < size; i++) {
		intArrTransformed[i] = (Integer) mt.transformElement(intArrOrig[i]);
	}

	System.out.println("The transformed array contains the values:");
	for(Integer transformedArrValue: intArrTransformed) {
		System.out.println(transformedArrValue);
	}
	}
	else if(mt instanceof StrTransformer) {
		String[] strArrOrig = StrTransformer.getVariable();
		String strArrTransformed[] = new String[size];
		
		for(int i = 0; i < size; i++) {
			strArrTransformed[i] = (String) mt.transformElement(strArrOrig[i]);
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("The transformed array contains the values:");
		for(String transformedArrValue: strArrTransformed) {
			System.out.println(transformedArrValue);
		}
		
	}
	
}




public static void main(String[] args) {
	String[] input = {"elephent", "dog", "Apple", "elephent"};	
//	Integer[] input = {19, 200, 300};
		 LinkedGL list = new LinkedGL(input);
		list.printList(list);
		list.toArray();
		System.out.println();
		System.out.println();
		
		System.out.println("Output of isEmpty function");
		System.out.println(list.isEmpty());

//		NumberTransformer numTransformer = new NumberTransformer();
		StrTransformer strTransformer = new StrTransformer();
		
		//NumberChooser numChooser = new NumberChooser();
		StringChooser strChooser = new StringChooser();
		
		
		list.transformAll(strTransformer);
		list.chooseAll(strChooser);
		
	} //end of main


}
