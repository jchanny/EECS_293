package parser;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW2Test{
    @Test
    public void testVariable(){
        Variable test = Variable.build("x");
        Variable shouldEqualTest = Variable.build("x");
        assertEquals(test, shouldEqualTest);

        assertEquals("x", test.toString());
        assertEquals("x", test.getRepresentation());
        assertEquals(TerminalSymbol.VARIABLE, test.getType());
    }

    public void testConnector(){
        Connector test = Connector.build(TerminalSymbol.PLUS);
        assertEquals((TerminalSymbol.PLUS), test.toString());
    }

    public void testLeafNode(){
        LeafNode test = LeafNode.build(Variable.build("x"));
        assertEquals(1, test.toList().size());
        assertEquals("x", test.toString());
    }

    public void testInternalNode(){
        LeafNode bottom = LeafNode.build(Variable.build("x"));
        LinkedList<Node> test = new LinkedList<>();
        test.add(bottom);
        InternalNode parent = InternalNode.build(test);
        LinkedList<Node> test2 = new LinkedList<>();
        test2.add(LeafNode.build(Variable.build("y")));
        InternalNode superParent = InternalNode.build(test2);

        assertEquals("[y,[x]]", superParent.toString());
        assertEquals(2, superParent.toList().size());
    }

}
