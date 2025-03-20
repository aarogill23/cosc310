package chap17;

import java.util.ArrayList;

public class Tree<E> {
    
    protected TreeNode<E> root;

<<<<<<< HEAD
    protected class TreeNode<E>{
        
        protected TreeNode<E> parent;
        protected ArrayList<TreeNode<E>> children;
        protected E data;

        public TreeNode(TreeNode<E> parent, ArrayList<TreeNode<E>> children, E data){
=======
    protected class TreeNode<E> {
        // attributes
        protected TreeNode<E> parent;
        protected ArrayList<TreeNode<E>> children;  
        protected E data;
        public TreeNode(TreeNode<E> parent, ArrayList<TreeNode<E>> children, E data) {
>>>>>>> f7fd251492a9c046060605a21d61c2a6815fb513
            this.parent = parent;
            this.children = children;
            this.data = data;
        }
<<<<<<< HEAD

        public void addChild(TreeNode<E> newChild){
            if(this.children == null){
                this.children = new ArrayList<>();
            }
            this.children.add(newChild);
            
        }

    }

    public Tree(){
        //Nothing to do here there is no root
    }

    public Tree(E rootData){
        root = new TreeNode<>(null, null, rootData);
    }

    public TreeNode<E> addChild(TreeNode<E> parent, E childData){

        TreeNode<E> child = new TreeNode<>(parent, null, childData);

        parent.addChild(child);
        
        
        return child;

    }

    public TreeNode<E> getRoot(){
        return root;
    }

    // The main size() method for the entire tree
    public long size(){
        return root==null?0:size(root);
    }


    // The size of the subtree rooted at n
    private long size(TreeNode<E> n){
        int nSize = 1;
        for(TreeNode<E> child: n.children){
            nSize += size(child);
        }
        
        return nSize;

    }

    @Override
    public String toString(){
        return size()==0?"EMPTY":toString(root, 0);
    }

    private String toString(TreeNode<E> n, int indent){
        String spacestring = " ".repeat(indent);
        String result = n.data.toString();
=======
        public void addChild(TreeNode<E> newchild) {
            if (this.children == null) {
                this.children = new ArrayList<>();
            }
            this.children.add(newchild);
        }
    }

    public Tree() {
        // nothing to do here ... we don't have a root yet
    }

    public Tree(E rootdata) {
        root = new TreeNode<>(null, null, rootdata);
    }

    public TreeNode<E> addChild(TreeNode<E> parent, E childdata) {
        // Step 1 - create the child (TreeNode)
        TreeNode<E> child = new TreeNode<>(parent, null, childdata);
        
        // Step 2 - tell the parent it has a new child
        parent.addChild(child);
        
        return child;
    }

    public TreeNode<E> root() {
        return root;
    }

    // the main size() method for the entire tree
    public long size() {       
        return root==null?0:size(root);
    }

    // the size of the subtree rooted at n
    public long size(TreeNode<E> n) {
        long nsize = 1;
        if (n.children != null) {
            for (TreeNode<E> child : n.children) {
                nsize += size(child);
            }
        }
        return nsize;
    }

    @Override
    public String toString() {
        return size()==0?"EMPTY":toString(root, 0);
    }

    public String toString(TreeNode<E> n, int indent) {
        String spacestring = " ".repeat(indent);
        String result = spacestring + n.data.toString();

        // FINISH THIS 
        // TURN OFF CO-PILOT FIRST
        // DON'T USE CHATGPT        
>>>>>>> f7fd251492a9c046060605a21d61c2a6815fb513

        return result;
    }

<<<<<<< HEAD
=======


>>>>>>> f7fd251492a9c046060605a21d61c2a6815fb513
}
