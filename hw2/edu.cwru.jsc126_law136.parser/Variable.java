package edu.cwru.jsc126_law136.parser;

public final class Variable extends AbstractToken{

    private final String representation;

    private Variable(String representation){
	this.representation = representation;
    }
    
    public TerminalSymbol getType(){
	return TerminalSymbol.VARIABLE;
    }

    public static final Variable build(String representation){
	if(representation == null){
	    throw new NullPointerException("Representation is null.");
	}
	return new Variable(representation);
    }

    public String toString(){
	return representation;
    }
    
    public final String getRepresentation(){
	return representation;
    }
}
