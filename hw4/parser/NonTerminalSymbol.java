/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class that attempts to build parse tree from productions
 */
package parser;

import java.util.List;
import java.util.Optional;

public enum NonTerminalSymbol implements Symbol{

    EXPRESSION, EXPRESSION_TAIL , TERM , TERM_TAIL , UNARY , FACTOR;

    private static final Map<NonTerminalSymbol, Map<TerminalSymbol, SymbolSequence>> productions = ProductionsMap.getProductionsMap();
    
    /*attempt to parse input tokens against list of productions*/
    public ParseState parse(List<Token> input){
	if(input == null)
	    throw new NullPointerException("Input is null.");
	
	//List<SymbolSequence> productions = SymTable.getSymbolSequence(this);
	for(SymbolSequence prod : productions){
	    ParseState current = prod.match(input);
	    if(current.successful())
		return current;
	}

	return ParseState.FAILURE;
    }

      public static final Optional<Node> parseInput(List<Token> input){
        if(input == null)
            throw new NullPointerException("Input is null.");

	// List<SymbolSequence> productions = SymTable.getSymbolSequence(NonTerminalSymbol.EXPRESSION);
        for(SymbolSequence prod : productions){
            ParseState current = prod.match(input);
            if(current.successful() && current.hasNoRemainder()){
                return Optional.of(current.getNode());
            }
        }

        return Optional.empty();
    }

}    
