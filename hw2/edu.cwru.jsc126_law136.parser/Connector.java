/*Jeremy Chan jsc126
  Lennox Wildman law136

  Connector class*/
package edu.cwru.jsc126_law136.parser;

public final class Connector extends AbstractToken{

    TerminalSymbol type;

    private static Cache<TerminalSymbol, Connector> cache;
    
    private Connector(TerminalSymbol type){
	this.type = type;
    }

    public TerminalSymbol getType(){
	return type;
    }

    /*creates new Connector of type if doesn't already exist in cache*/
    public static final Connector build(TerminalSymbol type){
	if(type == null)
	    throw new NullPointerException("Type is null.");
	if(type != TerminalSymbol.PLUS || type != TerminalSymbol.MINUS || type != TerminalSymbol.TIMES || type != TerminalSymbol.DIVIDE || type != TerminalSymbol.OPEN || type != TerminalSymbol.CLOSE)
	    throw new IllegalArgumentException("Invalid connector type.");

	return cache.get(type, (t) -> new Connector(t));
    }

    public String toString(){
	if(type == TerminalSymbol.PLUS)
	    return "+";
	if(type == TerminalSymbol.MINUS)
	    return "-";
	if(type == TerminalSymbol.TIMES)
	    return "*";
	if(type == TerminalSymbol.DIVIDE)
	    return "/";
	if(type == TerminalSymbol.OPEN)
	    return "(";
	if(type == TerminalSymbol.CLOSE)
	    return ")";
	return "";
    }
}
