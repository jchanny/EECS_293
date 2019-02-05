/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class
*/
package parser;

public enum TerminalSymbol implements Symbol{
    
    VARIABLE {
	@Override
	ParseState parse(List<Token> input){
	    
	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    },

    PLUS {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    },

    MINUS {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    },

    TIMES {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    },

    DIVIDE {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    },

    OPEN {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    },

    CLOSE {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		
	    }else{
		return ParseState.FAILURE;
	    }
	}
	
    }
}
