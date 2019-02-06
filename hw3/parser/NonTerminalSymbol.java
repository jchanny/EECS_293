/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class that attempts to build parse tree from productions
 */
package parser;

import java.util.List;
import java.util.Optional;

public enum NonTerminalSymbol implements Symbol{

    EXPRESSION {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.successful())
                    return current;
            }

            return ParseState.FAILURE;
        }

    },

    EXPRESSION_TAIL {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.successful())
                    return current;
            }

            return ParseState.FAILURE;
        }
    },

    TERM {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.successful())
                    return current;
            }

            return ParseState.FAILURE;
        }
    },

    TERM_TAIL {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.successful())
                    return current;
            }

            return ParseState.FAILURE;
        }
    },

    UNARY {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.successful())
                    return current;
            }

            return ParseState.FAILURE;
        }
    },

    FACTOR {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.successful())
                    return current;
            }

            return ParseState.FAILURE;
        }
    }
}    
