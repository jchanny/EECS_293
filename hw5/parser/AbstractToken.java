/*Jeremy Chan jsc126
  Lennox Wildman law136

  AbstractToken class
*/
package parser;

import java.util.HashSet;

public abstract class AbstractToken implements Token{

    private static final HashSet<TerminalSymbol> operators;

    static {
	HashSet<TerminalSymbol> validOperators = new HashSet<TerminalSymbol>();
	validOperators.put(TerminalSymbol.PLUS);
	validOperators.put(TerminalSymbol.MINUS);
	validOperators.put(TerminalSymbol.MULTIPLY);
	validOperators.put(TerminalSymbol.DIVIDE);
	operators = validOperators;
    }
    
    private TerminalSymbol type;

    public TerminalSymbol getType(){
	return type;
    }

    /*returns whether or not @param type is equal to Token's type*/
    public final boolean matches(TerminalSymbol type){
	return (type == getType());
    }

    public boolean isOperator(){
	if(operators.contains(getType()))
	    return true;

	return false;
    }
}
