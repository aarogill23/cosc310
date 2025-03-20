package chap17;

import java.util.ArrayList;

public class Tree<E> {
    
    protected TreeNode<E> root;

    protected class TreeNode<E>{
        
        protected TreeNode<E> parent;
        protected ArrayList<TreeNode<E>> children;
        protected E data;

        public TreeNode(TreeNode<E> parent, ArrayList<TreeNode<E>> children, E data){
            this.parent = parent;
            this.children = children;
            this.data = data;
        }

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

        return result;
    }

}
