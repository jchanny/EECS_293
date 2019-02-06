package parser;

import java.util.HashMap;
import java.util.ArrayList;

public enum NonTerminalSymbol implements Symbol{

    private static HashMap<NonTerminalSymbol, List<SymbolSequence>> symSequencesList = new HashMap<NonTerminalSymbol, List<SymbolSequence>>();

    private static List<SymbolSequence> getSymbolSequence(NonTerminalSymbol nonTerminal){
	if(symSequencesList.size() == 0){

	    //EXPRESSION symbol sequences
	    List<Symbol> expr = new ArrayList<Symbol>();
	    expr.add(TERM); expr.add(EXPRESSION_TAIL);
	    List<SymbolSequence> exprList = new ArrayList<SymbolSequence>();
	    exprList.add(SymbolSequence.build(expr));
	    symSequencesList.put(EXPRESSION, exprList);

	    //EXPRESSION_TAIL symbol sequences
	    List<Symbol> exprTail = new ArrayList<Symbol>();
	    exprTail.add(TerminalSymbol.PLUS); exprTail.add(TERM); exprTail.add(EXPRESSION_TAIL);
	    List<Symbol> exprTailMinus = new ArrayList<Symbol>();
	    exprTailMinus.add(TerminalSymbol.MINUS); exprTailMinus.add(TERM); exprTailMinus.add(EXPRESSION_TAIL);	    
	    List<SymbolSequence> exprTailList = new ArrayList<SymbolSequence>();
	    exprTailList.add(SymbolSequence.build(exprTail));
	    exprTailList.add(SymbolSequence.build(exprTailMinus));
	    exprTailList.add(SymbolSequence.EPSILON);
	    symSequencesList.put(EXPRESSION,exprTailList);

	    //TERM symbol sequences
	    List<Symbol> term = new ArrayList<Symbol>();
	    term.add(UNARY); term.add(TERM_TAIL);
	    List<SymbolSequence> termList = new ArrayList<SymbolSequence>();
	    termList.add(SymbolSequence.build(term));
	    symSequencesList.put(TERM, termList);

	    //TERM_TAIL symbol sequences
	    List<Symbol> termTailMult = new ArrayList<Symbol>();
	    termTailMult.add(TerminalSymbol.TIMES); termTailMult.add(UNARY); termTailMult.add(TERM_TAIL);
	    List<Symbol> termTailDivide = new ArrayList<Symbol>();
	    termTailDivide.add(TerminalSymbol.DIVIDE); termTailDivide.add(UNARY); termTailDivide.add(TERM_TAIL);			       
	    List<SymbolSequence> termTailList = new ArrayList<SymbolSequence>();
	    termTailList.add(SymbolSequence.build(termTailMult));
	    termTailList.add(SymbolSequence.build(termTailDivide));
	    termTailList.add(SymbolSequence.EPSILON);
	    symSequencesList.put(TERM_TAIL, termTailList);
	    
	    //UNARY symbol sequences
	    List<Symbol> minusFactor = new ArrayList<Symbol>();
	    minusFactor.add(TerminalSymbol.MINUS); minusFactor.add(FACTOR);
	    List<Symbol> factorPlain = new ArrayList<Symbol>();
	    factorPlain.add(TerminalSymbol.FACTOR);
	    List<SymbolSequence> unaryList = new ArrayList<SymbolSequence>();
	    unaryList.add(SymbolSequence.build(minusFactor));
	    unaryList.add(SymbolSequence.build(factorPlain));
	    symSequencesList.put(UNARY, unaryList);

	    //FACTOR symbol sequences
	    List<Symbol> factorParen = new ArrayList<Symbol>();
	    factorParen.add(TerminalSymbol.OPEN); factorParen.add(EXPRESSION);
	    factorParen.add(TerminalSymbol.CLOSE);
	    List<Symbol> factorVar = new ArrayList<Symbol>();
	    factorVar.add(TerminalSymbol.VARIABLE);
	    List<SymbolSequence> factorList = new ArrayList<SymbolSequence>();
	    factorList.add(SymbolSequence.build(factorParen));
	    factorList.add(SymbolSequence.build(factorVar));
	    symSequencesList.put(FACTOR, factorList);	    
	}
	
	return symSequencesList.get(nonTerminal);
    }
    
    EXPRESSION {
	
	@Override
	ParseState parse(List<Token> input){
	    if(input == null)
		throw new NullPointerException("Input is null.");
	    
	    List<SymbolSequence> productions = getSymbolSequence(EXPRESSION);
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
	ParseState parse(List<Token> input){
	    if(input == null)
		throw new NullPointerException("Input is null.");
	    
	    List<SymbolSequence> productions = getSymbolSequence(EXPRESSION);
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
	ParseState parse(List<Token> input){
	    if(input == null)
		throw new NullPointerException("Input is null.");
	    
	    List<SymbolSequence> productions = getSymbolSequence(EXPRESSION);
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
	ParseState parse(List<Token> input){
	    if(input == null)
		throw new NullPointerException("Input is null.");
	    
	    List<SymbolSequence> productions = getSymbolSequence(EXPRESSION);
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
	ParseState parse(List<Token> input){
	    if(input == null)
		throw new NullPointerException("Input is null.");
	    
	    List<SymbolSequence> productions = getSymbolSequence(EXPRESSION);
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
	ParseState parse(List<Token> input){
	    if(input == null)
		throw new NullPointerException("Input is null.");
	    
	    List<SymbolSequence> productions = getSymbolSequence(EXPRESSION);
	    for(SymbolSequence prod : productions){
		ParseState current = prod.match(input);
		if(current.isSuccess())
		    return current;
	    }

	    return ParseState.FAILURE;
	}	
    }
}    
