package projectx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ThroneInheritance {
	 private Map<String, List<String>> tree;
	    private Set<String> deathNames;
	    inputConstraints contraints = new  inputConstraints();
	    private String kingName;
		 
		   public ThroneInheritance( String kingName) {
				if (contraints.islength(kingName)) {
					if (contraints.isStringLowerCase(kingName)){
						  tree = new HashMap();
	        deathNames = new HashSet();
	        this.kingName = kingName;
						}else {
							System.out.println("Name should be in lowercase");
		                    System. exit(1);		
						}
				}else {
					 System.out.println("Name length should be between 1 and 16");
	                    System. exit(1);	
				}
				    }

		    public void birth(String parentName, String childName) {
		  
		    	if (contraints.islength(parentName)) {
		    		if (contraints.islength(childName)) {
		    			if (contraints.isStringLowerCase(childName) & contraints.isStringLowerCase(parentName)) {
		    				if (!tree.containsKey(parentName)) {
	    		    		
		    					tree.put(parentName, new ArrayList<String>());
			    			
			    			}
			    				tree.get(parentName).add(childName);
			    				//System.out.println(getInheritanceOrder().toString());
	                } else {
	                    System.out.println("All names should be in lower case");
	                    System. exit(1);
	                }

	            } else {
	                System.out.println("Names length should be between 1 and 16");
	                System. exit(1);
	            }

	        } else {
	            System.out.println("Parent length should be between 1 and 16"); 
		    
		    }

		    		}

		    	public void death(String name) {
			   
		    		deathNames.add(name);
	                 System.out.println(getInheritanceOrder().toString());	        
	    }
	    
	    public List<String> getInheritanceOrder() {
	        List<String>  curOrder = new ArrayList();
	         Successor(kingName, curOrder);
	          return  curOrder;
	    }
		   

	private void Successor(String parentName, List<String> curOrder) {
	        if (!deathNames.contains(parentName)) {
	            curOrder.add(parentName);
	        	 }
	         if (tree.containsKey(parentName)) {
	            List<String> childs = tree.get(parentName);
	             for (String child : childs) {
	            	Successor(child ,curOrder);
	                	}    
	            }

	}
	
	
	
	
}

// constraints class
 class inputConstraints {
	 //distinct constraint
	  public boolean distinct (String kingName, String childName) {
	        if (kingName.equals(childName)) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	 
	 
   //length constraint
    public boolean islength(String string){
        String n = string;
        if (n.length() >=1 & n.length() <=15) {
            return true;
        } else {
            return false;
        }

    }
    public boolean isStringLowerCase(String name){
        char[] charArray = name.toCharArray();
        for(int i=0; i < charArray.length; i++){
          
            if( Character.isLetter(charArray[i]) ){
              
                if( !Character.isLowerCase( charArray[i] ))
                    return false;
            }
        }
        return true;
    }}