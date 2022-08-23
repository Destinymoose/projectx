package projectx;

public class Successor {

	public static void main(String[] args) {
		ThroneInheritance t= new ThroneInheritance("king");
        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "matthew");
        t.birth("bob", "alex"); 
        t.getInheritanceOrder();
        t.death("bob");
       	
        System.out.print("");
	}

}
