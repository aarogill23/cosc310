package chap17;

import java.util.ArrayList;

public class Tree<E> {
    
    protected TreeNode<E> root;

    protected class TreeNode<H> {
        // attributes
        protected TreeNode<E> parent;
        protected ArrayList<TreeNode<E>> children;  
        protected E data;
        public TreeNode(TreeNode<E> parent, ArrayList<TreeNode<E>> children, E data) {
            this.parent = parent;
            this.children = children;
            this.data = data;
        }
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

    /**
     * 
     * @param e - the data we are searching for
     * @return first node containing the data if found otherwise null
     */
    public TreeNode<E> search(E e) {
        return root==null ? null : search(e, root);
    }

    public TreeNode<E> search(E e, TreeNode<E> n) {
        if (n.data.equals(e)) {
            return n;
        }
        if (n.children != null) {
            for (TreeNode<E> child : n.children) {
                TreeNode<E> hit = search(e, child);
                if (hit != null) {
                    return hit;
                }
            }            
        }
        return null;
    }

    // alternative search method that uses BFS instead of DFS
    public TreeNode<E> searchBreadth(E e) {
        ArrayList<TreeNode<E>> bfsqueue = new ArrayList<>();
        bfsqueue.add(root);
        return searchBreadth(e, bfsqueue);
    }

    public TreeNode<E> breadthSearch(E e, TreeNode<E> n){
        if(n.data.equals(e)){
            return n;
        }

        if (n.children != null){
            for(TreeNode<E> child : n.children){
                if(child.equals(e))
                    return child;
            }
            for(TreeNode<E> child : n.children){
                TreeNode<E> hit = breadthSearch(e, child);
                if(hit != null)
                    return hit;
            }

        }


        return null;
    }

    // BFS helper, but NOT useful for API b/c how do you know what "queue" to pass in?
    protected TreeNode<E> searchBreadth(E e, ArrayList<TreeNode<E>> bfsqueue) {
        if (bfsqueue.isEmpty()) {
            return null;
        }
        TreeNode<E> n = bfsqueue.remove(0);
        if (n.data.equals(e)) {
            return n;
        }
        if (n.children != null) {
            for (TreeNode<E> child : n.children) {
                bfsqueue.add(child);
            }
        }
        return searchBreadth(e, bfsqueue);
    
    
    }

    @Override
    public String toString() {
        return size()==0?"EMPTY":toString(root, 0);
    }

    public String toString(TreeNode<E> n, int indent) {
        String spacestring = "-".repeat(indent);
        String result = spacestring + n.data.toString();
        if (n.children != null) {
            for (TreeNode<E> child : n.children) {
            result += "\n" + toString(child, indent + 2);
            }
        }

        return result;
    }

}
