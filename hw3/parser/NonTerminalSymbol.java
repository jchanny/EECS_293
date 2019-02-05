package parser;

public enum NonTerminalSymbol implements Symbol{

    EXPRESSION {
	
	@Override
	ParseState parse(List<Token> input){
	}	
    },

    EXPRESSION_TAIL {
	
	@Override
	ParseState parse(List<Token> input){
	}	
    },

    TERM {
	
	@Override
	ParseState parse(List<Token> input){
	}	
    },

    TERM_TAIL {
	
	@Override
	ParseState parse(List<Token> input){
	}	
    },
    
    UNARY {
	
	@Override
	ParseState parse(List<Token> input){
	}	
    },

    FACTOR {
	
	@Override
	ParseState parse(List<Token> input){
	}	
    }
}    
