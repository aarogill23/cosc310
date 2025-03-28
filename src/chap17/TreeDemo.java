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
        System.out.println(airports); **/

        System.out.println();

        String csvstr = "ATL,PEK,LAX,DXB,HND,ORD,LHR,HKG,PVG,CDG,DFW,CAN,AMS,FRA,IST,DEL,JFK,SIN,ICN,DEN,BKK,SFO,KUL,MAD,LAS,CTU,BCN,SEA,PHX,MIA,MUC,SYD,FCO,EWR,MCO,SHA,CLT,YYZ,LGW,MSP,BOM,SZX,MEL,MNL,IAH,KMG,ZRH,GRU,OSL,ARN,DME,DOH,VIE,BNE,CPH,HEL,BRU,SVO,MXP,MAN,LIM,YVR,TXL,NRT,AUH,STN,LGG,LIS,HOU,BOG,PRG,WAW,ATH,GIG,LGA,CAI,TPE,SGN,LED,BUD,CGK,TXL,OTP,BSB,GMP,CHC,CMN,SAN,OKA,AKL,THR,TUN,ALG,KWI,DUB,CRK,CPT,ABV,BNE,SGF,ICT,OMA,ELP,BUF,BHM,HSV,MDT,PSP,RNO,GEG,MYR,ORF,ANC,FLL,PIT,CLE,SNA,JAX,MSY,SMF,PDX";
        Tree<String> leftleaning = createLeftLeaningBinaryTree(csvstr);
        System.out.println(leftleaning);

        System.out.println();

        Tree<String> rightleaning = createRightLeaningBinaryTree(csvstr);
        System.out.println(rightleaning);
        
        System.out.println();

        Tree<String> balanced = createBalancedBinaryTree(csvstr);
        System.out.println(balanced);
    }

   

    public static Tree<String> createRightLeaningBinaryTree(String csvdata) {
        String items[] = csvdata.split(",");
        if (items.length == 0)
            return new Tree<>();

        Tree<String> rightleaning = new Tree<>(items[0]);
        Tree<String>.TreeNode<String> parent = rightleaning.root();
        int childcount = 0;
        for (int i=1; i<items.length; i++) {
            if (childcount==2) {
                parent = parent.children.get(1);
                childcount = 1;
            } else {
                childcount++;
            }
            rightleaning.addChild(parent, items[i]);
        }
        return rightleaning;
    }

    public static Tree<String> createLeftLeaningBinaryTree(String csvdata) {
        String items[] = csvdata.split(",");
        if (items.length == 0)
            return new Tree<>();

        Tree<String> leftleaning = new Tree<>(items[0]);
        Tree<String>.TreeNode<String> parent = leftleaning.root();
        int childcount = 0;
        for (int i=1; i<items.length; i++) {
            if (childcount==2) {
                parent = parent.children.get(0);
                childcount = 1;
            } else {
                childcount++;
            }
            leftleaning.addChild(parent, items[i]);
        }
        return leftleaning;
    }

    public static Tree<String> createBalancedBinaryTree(String csvdata) {
        java.util.Random random = new java.util.Random();
        String items[] = csvdata.split(",");
        if (items.length == 0)
            return new Tree<>();

        Tree<String> balanced = new Tree<>(items[0]);
        Tree<String>.TreeNode<String> parent = balanced.root();
        int childcount = 0;
        for (int i=1; i<items.length; i++) {
            if (childcount==2) {
                parent = parent.children.get(random.nextInt(2));
                childcount = 1;
            } else {
                childcount++;
            }
            balanced.addChild(parent, items[i]);
        }
        return balanced;
    }


}
