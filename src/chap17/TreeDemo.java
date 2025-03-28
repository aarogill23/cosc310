package chap17;

public class TreeDemo {

    public static Tree<String> createTreeSimple(String csvData){
    String[] data = csvData.split(",");
    Tree<String> simple = new Tree<>(data[0]);

    for(int i = 1; i < data.length; i++){
        simple.addChild(simple.root, data[i]);
    }

        return simple;
    }
    public static void main(String[] args) {
        /* Tree<String> airports = new Tree<>("BHM");
        airports.addChild(airports.root(),"ATL");
        Tree<String>.TreeNode<String> msp = airports.addChild(airports.root(),"MSP");
        airports.addChild(msp,"JFK");
        Tree<String>.TreeNode<String> ord = airports.addChild(msp, "ORD");
        airports.addChild(ord, "TPA");
        System.out.println(airports);
        System.out.println(airports.toString(msp, 0));
        System.out.println(airports.search("BHM"));
        System.out.println(airports.searchBreadth("BHM"));
        System.out.println(airports.search("ABC"));
        System.out.println(airports.searchBreadth("ABC"));
        System.out.println(airports.search("ORD"));
        System.out.println(airports.searchBreadth("ORD")); */

        System.out.println(createTreeSimple("BHM,ATL,MSP,JFK,ORD"));


    }
}
