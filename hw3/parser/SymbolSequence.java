/*Jeremy Chan jsc126
  Lennox Wildman law136
  Class for building children of an internal node*/
package parser;

import java.util.ArrayList;

final class SymbolSequence{

    private final List<Symbol> production;

    static final SymbolSequence EPSILON = new SymbolSequence(new ArrayList<Symbol>());
    
    private SymbolSequence(List<Symbol> production){
	this.production = production;
    }

    /*Takes in a list of Symbols and creates a new SymbolSequence*/
    static final SymbolSequence build(List<Symbol> production){
	if(production == null)
	    throw new NullPointerException("Input is null.");

	return new SymbolSequence(production);
    }

    /*Build method that takes variable number of Sybmols*/
    static final SymbolSequence build(Symbol ... symbols){
	if(symbols == null)
	    throw new NullPointerException("Input is null.");
	
	List<Symbol> prod = new ArrayList<Symbol>();
	for(Symbol sym : symbols){
	    prod.add(sym);
	}

	return new SymbolSequence(prod);
    }

    /*Builds a new ParseState from a list of Tokens*/
    ParseState match(List<Token> input){
	if(input == null)
	    throw new NullPointerException("Input is null.");
	
	List<Token> remainderList = input;
	List<Token> children = new ArrayList<Token>();
	
	for(Symbol sym : production){
	    ParseState result = sym.parse(remainderList);
	    if(result == ParseState.FAILURE)
		return failure;
	    //else
	    children.add(result);
	    remainderList = result.getRemainder();
	}

	return ParseState.build(new InternalNode(children), remainderList);
    }

    String toString(){
	return production.toString();
    }
}
