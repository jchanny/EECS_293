/*Jeremy Chan jsc126
  Lennox Wildman law136
  Class for building children of an internal node*/
package parser;

import java.util.ArrayList;

final class SymbolSequence{

    private final List <Symbol> production;
	
    private SymbolSequence(List <Symbol> production){
	this.production = production;
    }

    static final SymbolSequence build(List <Symbol> production){
	if(production == null)
	    throw new NullPointerException("Input is null.");

	return new SymbolSequence(production);
    }

    static final SymbolSequence build(Symbol ... symbols){
	
    }
    
    ParseState match(List <Token> input){
	if(input == null){
	    throw new NullPointerException("Input is null.");
	}
	List <Token> remainderList = input;
	List <Token> children = new ArrayList<Token>();
	
    }

    String toString(){
	return production.toString();
    }
}
