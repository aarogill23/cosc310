package chap17;

public class TreeDemo {
    public static void main(String[] args) {
        Tree<String> airports = new Tree<>("BHM");
        airports.addChild(airports.root(),"ATL");
        Tree<String>.TreeNode<String> msp = airports.addChild(airports.root(),"MSP");
        airports.addChild(msp,"JFK");
        Tree<String>.TreeNode<String> ord = airports.addChild(msp, "ORD");
        airports.addChild(ord, "TPA");
        System.out.println(airports);

    }
}
