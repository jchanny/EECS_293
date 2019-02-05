/*Jeremy Chan jsc126
  Lennox Wildman law136

  Variable class*/
package parser;

public final class Variable extends AbstractToken{

    private final String representation;

    //cache to prevent creating redundant variables
    private static Cache<String, Variable> cache;
    
    private Variable(String representation){
	this.representation = representation;
    }
    
    public TerminalSymbol getType(){
	return TerminalSymbol.VARIABLE;
    }

    /*checks if variable already exists in cache, otherwise, builds + returns new var*/
    public static final Variable build(String representation){
	if(representation == null){
	    throw new NullPointerException("Representation is null.");
	}

	return cache.get(representation, (t) -> new Variable(t));
    }

    public String toString(){
	return representation;
    }
    
    public final String getRepresentation(){
	return representation;
    }
}
