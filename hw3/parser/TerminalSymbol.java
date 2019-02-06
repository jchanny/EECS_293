/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class representing TerminalSymbol node builders
*/
package parser;

import java.util.Arrays;
import java.util.List;

public enum TerminalSymbol implements Symbol{

	VARIABLE {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.VARIABLE){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);
			}
			//else
			return ParseState.FAILURE;
		}

	},

	PLUS {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.PLUS){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);

			}
			//else
			return ParseState.FAILURE;
		}

	},

	MINUS {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.MINUS){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);

			}
			//else
			return ParseState.FAILURE;
		}

	},

	TIMES {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.TIMES){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);

			}
			//else
			return ParseState.FAILURE;
		}

	},

	DIVIDE {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.DIVIDE){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);

			}
			//else
			return ParseState.FAILURE;
		}

	},

	OPEN {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.OPEN){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);

			}
			//else
			return ParseState.FAILURE;
		}

	},

	CLOSE {
		@Override
		public ParseState parse(List<Token> input){

			if(input.get(0).getType() == TerminalSymbol.CLOSE){
				//parsing success
				Node leafNode = LeafNode.build(input.get(0));
				List <Token> remainderList = Arrays.asList(input).remove(0);
				return ParseState.build(leafNode, remainderList);

			}
			//else
			return ParseState.FAILURE;
		}

	}
}
