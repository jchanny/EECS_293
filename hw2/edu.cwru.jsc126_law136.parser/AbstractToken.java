package edu.cwru.jsc126_law136.parser;

public abstract class AbstractToken implements Token{
    
    public final boolean matches(TerminalSymbol type){
	return (type == getType());
    }
}
