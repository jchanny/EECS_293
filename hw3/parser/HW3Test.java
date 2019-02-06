package parser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW3Test{
    @Test
    public void testTerminalSymbol()
    {
        Symbol type = TerminalSymbol.PLUS;
        ArrayList<Token> test = new ArrayList<Token>();
        test.add(type);
        ParseState test = TerminalSymbol.parse(test);
        assertEquals(test.getNode.toString(), "+");

        Symbol type = NonTerminalSymbol.OPEN;
        ArrayList<Token> test2 = new ArrayList<Token>();
        test2.add(type);
        ParseState fail = TerminalSymbol.parse(test2);
        assertEquals(fail, ParseState.FAILURE);
    }

    @Test
    public void testNonTerminalSymbol(){
        Symbol type = NonTerminalSymbol.OPEN;
        ArrayList<Token> test = new ArrayList<Token>();
        test.add(type);
        ParseState test = NonTerminalSymbol.parse(test);
        assertEquals(test, ParseState.FAILURE);

        Connector plus = Connector.build(TerminalSymbol.PLUS);
        Variable a = Variable.build("a");
        Variable b = Variable.build("b");
        ArrayList<Token> test2 = new ArrayList<Token>();
        test2.add(plus); test2.add(a); test2.add(b);
        ParseState res = NonTerminalSymbol.EXPRESSION.parse(test2);
        assertEquals(true, res.successful());
    }

    //create symbol list for symbolsequence parameters
    public List<Symbol> testSymbol(){
        List<Symbol> symList = new ArrayList<Symbol> (new TerminalSymbol.MINUS);
        symList.add(new TerminalSymbol.PLUS);
        return symList;
    }

    //create SymbolSequence object
    public void testSymbolSequence(){
        SymbolSequence test = testSymbol();
        SymbolSequence result = SymbolSequence.build(test);
        Variable a = Variable.build("a");
        Connector plus = Connector.build(TerminalSymbol.PLUS);
        Variable b = Variable.build("b");
        ArrayList<Token> input = new ArrayList<Token>();
        input.add(a); input.add(plus); input.add(b);
        ParseState matchFail = result.match(input);
        assertEquals(matchFail.successful(), false);
    }

    //create token for node parameters
    public coin testToken() {
        Token coin = new Connector(testSymbol());
        return coin;
    }

    public Node testNode() {
        Node testNode = new LeafNode(testToken());
        return testNode;
    }

    //create ParseState Object
    public void testParseState() {
        ParseState tester = new ParseState(testNode(), testList());
    }

    public void testParseInput(){
        ArrayList<Token> input = new ArrayList<>();
        Variable a = Variable.build("a");
        Connector plus = Connector.build(TerminalSymbol.PLUS);
        Variable b = Variable.build("b");
        Connector divide = Connector.build(TerminalSymbol.DIVIDE);
        Variable c = Variable.build("c");
        input.add(a); input.add(plus); input.add(b); input.add(divide); input.add(c);

        System.out.println(ParseInput.parseInput(input));

    }
}
