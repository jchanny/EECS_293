package parser;

import java.util.List;

public enum NonTerminalSymbol implements Symbol{

    EXPRESSION {
        @Override
        public ParseState parse(List<Token> input){
            if(input == null)
                throw new NullPointerException("Input is null.");

            List<SymbolSequence> productions = SymTable.getSymbolSequence(EXPRESSION);
            for(SymbolSequence prod : productions){
                ParseState current = prod.match(input);
                if(current.isSuccess())
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
                if(current.isSuccess())
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
                if(current.isSuccess())
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
                if(current.isSuccess())
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
                if(current.isSuccess())
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
                if(current.isSuccess())
                    return current;
            }

            return ParseState.FAILURE;
        }
    }
}    
