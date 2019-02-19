/*Jeremy Chan jsc126
  Lennox Wildman law136
  Class for building children of an internal node*/
package parser;

import java.util.ArrayList;
import java.util.List;

final class SymbolSequence{

	private final List<Symbol> production;

	static final SymbolSequence EPSILON = new SymbolSequence(new ArrayList<Symbol>());

	private SymbolSequence(List<Symbol> production){
            this.production = production;
	}

	/*Takes in a list of Symbols and creates a new SymbolSequence*/
	static final SymbolSequence build(List<Symbol> production){
            if(production == null){
                throw new NullPointerException("Input is null.");
            }
            return new SymbolSequence(production);
	}

	/*Build method that takes variable number of Sybmols*/
	static final SymbolSequence build(Symbol ... symbols){
            if(symbols == null){
                throw new NullPointerException("Input is null.");
            }

            List<Symbol> prod = new ArrayList<Symbol>();
            for(Symbol sym : symbols){
                prod.add(sym);
            }

            return new SymbolSequence(prod);
	}

	/*Builds a new ParseState from a list of Tokens*/
	ParseState match(List<Token> input){
            if(input == null){
                throw new NullPointerException("Input is null.");
            }

            List<Token> remainderList = input;
            List<Node> children = new ArrayList<Node>();

            for(Symbol sym : production){
                ParseState result = sym.parse(remainderList);
                if(!result.successful()){
                    return ParseState.FAILURE;
                }
                //else
                children.add(result.getNode());
                remainderList = result.getRemainder();
            }

            return ParseState.build(InternalNode.build(children), remainderList);
	}

	public String toString(){
            return production.toString();
	}
}
