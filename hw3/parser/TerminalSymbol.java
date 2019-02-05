/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class
*/
package parser;

import java.util.Arrays;

public enum TerminalSymbol implements Symbol{
    
    VARIABLE {
	@Override
	ParseState parse(List<Token> input){
	    
	    if(input.get(0).getType() == TerminalSymbol.VARIABLE){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);
	    }
	    //else
	    return ParseState.FAILURE;	    
	}
	
    },

    PLUS {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.PLUS){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);

	    }
	    //else
	    return ParseState.FAILURE;	    
	}
	
    },

    MINUS {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.MINUS){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);

	    }
	    //else
	    return ParseState.FAILURE;
	}
	
    },

    TIMES {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.TIMES){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);

	    }
	    //else
	    return ParseState.FAILURE;
	}
	
    },

    DIVIDE {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.DIVIDE){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);

	    }
	    //else
	    return ParseState.FAILURE;	    
	}
	
    },

    OPEN {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.OPEN){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);

	    }
	    //else
	    return ParseState.FAILURE;	    
	}
	
    },

    CLOSE {
	@Override
	ParseState parse(List<Token> input){

	    if(input.get(0).getType() == TerminalSymbol.CLOSE){
		//parsing success
		Token leafNode = input.get(0);
		List <Token> remainderList = Arrays.asList(input).remove(0);
		return ParseState.build(leafNode, remainderList);

	    }
	    //else
	    return ParseState.FAILURE;	    
	}
	
    }
}
