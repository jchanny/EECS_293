package parser;

import java.util.List;
import java.util.Optional;


public class ParseInput {

    public static final Optional<Node> parseInput(List<Token> input){
        if(input == null)
            throw new NullPointerException("Input is null.");

        List<SymbolSequence> productions = SymTable.getSymbolSequence(NonTerminalSymbol.EXPRESSION);
        for(SymbolSequence prod : productions){
            ParseState current = prod.match(input);
            if(current.successful() && current.hasNoRemainder()){
                return Optional.of(current.getNode());
            }
        }

        return Optional.empty();
    }
}
