/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class that attempts to build parse tree from productions
 */
package parser;

import java.util.*;

public enum NonTerminalSymbol implements Symbol{

	EXPRESSION, EXPRESSION_TAIL , TERM , TERM_TAIL , UNARY , FACTOR;

	private static final Map<NonTerminalSymbol, Map<TerminalSymbol, SymbolSequence>> productions = ProductionsMap.getProductionsMap();

	/*attempt to parse input tokens against list of productions*/
	public ParseState parse(List<Token> input){
            Objects.requireNonNull(input, "Input is null.");

            TerminalSymbol lookAhead;

            if(input.size() == 0){
                lookAhead = null;
            }
            else{
                lookAhead = input.get(0).getType();
            }

            SymbolSequence production = productions.get(this).get(lookAhead);

            if(production == null){
                return ParseState.FAILURE;
            }

            ParseState current = production.match(input);
            return current;
	}

	public static final Optional<Node> parseInput(List<Token> input){
            Objects.requireNonNull(input,"Input is null.");

            TerminalSymbol lookAhead;

            if(input.size() == 0){
                lookAhead = null;
            }
            else{
                lookAhead = input.get(0).getType();
            }

            SymbolSequence production = productions.get(NonTerminalSymbol.EXPRESSION).get(lookAhead);

            if(production == null){
                return Optional.ofNullable(null);
            }

            ParseState current = production.match(input);

            if(current.hasNoRemainder()){
                return Optional.of(current.getNode());
            }

            return Optional.empty();
	}

}    
