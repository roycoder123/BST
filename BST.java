//Author: Roy Rozin Date: 12/22/2025 Description: Logic for inserting, searching, removing, and printing a binary search tree
import java.util.ArrayList;

class BST {
    Node root;

    public BST(){
        root = null;
    }

    //pre condition: key is not null
    //post condition: calls the private insert function
    void insert(int key){
       insert(key, root);
    }

    //pre condition: key and node are not null
    //post condition: a new node with value 'key' is inserted into the tree into the correct spot
    private void insert(int key, Node node){
        if(node == null){
            root = new Node(key);
            return;
        }
        if(key < node.key){
            if(node.left == null){
                node.left = new Node(key);
                return;
            }
            else{
                insert(key, node.left);
            }
        }
        if(key > node.key){
            if(node.right == null){
                node.right = new Node(key);
                return;
            }
            else{
                insert(key, node.right);
            }
        }
        return;
    }
    
    //pre condition: key is not null
    //post condition: calls the private search function
    boolean search(int key){
        return search(key, root);
    }

    //pre condition: key is not null
    //post condition: returns true if a node with that value is in the tree and false otherwise
    private boolean search(int key, Node node){
        if(node == null){
            return false;
        }
        if(key == node.key){
            return true;
        }
        if(key < node.key){
            return search(key, node.left);
        }
        return search(key, node.right);
    }

    //pre condition: key is not null
    //post condition: calls private remove function
    int remove(int key){
        return remove(key, root);
    }

    //pre condition: key is not null
    //post condition: removes the node with the value 'key' in the tree according to the 0 child, 1 child, and 2 child cases
    private int remove(int key, Node node){
        //isn't-there case
        if(!search(key)){
            return -1;
        }

        //root case
        if(key == node.key){
            //0 children
            if(node.left == null && node.right == null){
                root = null;
                return 0;
            }

            //1 child
            if((node.left == null && node.right != null) || (node.left != null && node.right == null)){
                if(node.left == null && node.right != null){
                    root = node.right;
                }
                if(node.left != null && node.right == null){
                    root = node.left;
                }
            }
            
            //2 child
            if(node.left != null && node.right != null){
                Node replacement = node.right;
                Node replacementparent = node;
                while(replacement.left != null){
                    replacementparent = replacement;
                    replacement = replacement.left;
                }
                replacementparent.left = null;
                root.key = replacement.key;
            }

        }

        //if it isn't the root, we now have to find the parent node of the node we are going to remove as well as the node itself
        Node parent = root; //parent of the node you are removing
        Node remove = null; //node you are removing
        while(parent != null){
            if(parent.left != null && parent.left.key == key){
                remove = parent.left;
                break;
            }
            else if(parent.right != null && parent.right.key == key){
                remove = parent.right;
                break;
            }
            else if(key < parent.key){
                parent = parent.left;
            }
            else if(key > parent.key){
                parent = parent.right;
            }
        }

        //0 children case
        if(remove != null && remove.left == null && remove.right == null){
            if(parent.left == remove && parent.left.key == key){
                parent.left = null;
            }
           else{
                parent.right = null;
            }
        }

        //1 child case
        if((remove != null && remove.left == null && remove.right != null) || (remove != null && remove.left != null && remove.right == null)){

            //if the one child is on the right
            if(remove.left == null && remove.right != null){
                //if the remove is on the left
                if(parent.left == remove && parent.left.key == key){
                    parent.left = remove.right;
                }
                //if the remove is on the right
                if(parent.right == remove && parent.right.key == key){
                    parent.right = remove.right;
                }
            }

            //if the one child is on the left
            if(remove.left != null && remove.right == null){
                //if the remove is on the left
                if(parent.left == remove && parent.left.key == key){
                    parent.left = remove.left;
                }
                //if the remove is on the right
                if(parent.right == remove && parent.right.key == key){
                    parent.right = remove.left;
                }
            }
        }

        //2 child case
        if(remove != null && remove.left != null && remove.right != null){
            //if the remove is on the left
            if(parent.left == remove && parent.left.key == key){
                Node replacement = remove.left;
                Node replacementparent = remove;
                if(replacement.right == null){
                    replacementparent.left = null;
                    parent.left.key = replacement.key;
                }
                else{
                    while(replacement.right != null){
                        replacementparent = replacement;
                        replacement = replacement.right;
                    }
                    replacementparent.right = null;
                    parent.left.key = replacement.key;
                }
            }
            //if the remove is on the right
            if(parent.right == remove && parent.right.key == key){
                Node replacement = remove.left;
                Node replacementparent = remove;
                if(replacement.right == null){
                    replacementparent.left = null;
                    parent.right.key = replacement.key;
                }
                else{
                    while(replacement.right != null){
                        replacementparent = replacement;
                        replacement = replacement.right;
                    }
                    replacementparent.right = null;
                    parent.right.key = replacement.key;
                }
            }
        }
        return -1;
    }

    //pre condition: tree is not null
    //post condition: prints the value given by the private toString function
    public String toString(){
        System.out.println(toString(root, ""));
        return "";
    }

    //pre condition: tree is not null
    //post condition: returns a string that has the values of the nodes in the tree in the form of strings
    private String toString(Node node, String str){
        if(root == null){
            return " ";
        }

        ArrayList<ArrayList<Node>> nodes = new ArrayList();
        inOrder(nodes, 0, root);

        for(int i = 0; i < nodes.size(); i++){
            for(int z = 0; z < nodes.get(i).size(); z++){
                str += " ";
                str += nodes.get(i).get(z).key + "";
            }
            str += "\n";
        }
        return str;
    }

    //pre condition: 2D array list of nodes is not null, node is not null
    //post condition: called in the private toString that takes all the values from the tree and puts it into a 2D arrayList in order
    private void inOrder(ArrayList<ArrayList<Node>> nodes, int depth, Node node){
        if(node == null){
            return;
        }
        inOrder(nodes, depth + 1, node.left);
        while(nodes.size() <= depth){
            nodes.add(new ArrayList<Node>());
        }
        nodes.get(depth).add(node);
        inOrder(nodes, depth + 1, node.right);
    }

    //Add the following functions to your BST
    //Please use this code to verify your tree integrity
    public boolean isBSTOrNot() {
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
        // check for root is not null or not
        if (root == null) {
            return true;
        }
        // check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
        if(root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key) && isBSTOrNot(root.right, root.key, maxValue)){
            return true;
        }
        return false;
    }

    // please use the following pieces of code to display your tree in a more easy to follow style (Note* you'll need to place the Trunk class in it's own file)
    public static void showTrunks(Trunk p){
        if (p == null) {
            return;
        }
 
        showTrunks(p.prev);
        System.out.print(p.str);
    }
 
    public void printTree(){
        printTree(root, null, false);
    }

    private void printTree(Node root, Trunk prev, boolean isLeft){
        if (root == null) {
            return;
        }
 
        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);
 
        printTree(root.right, trunk, true);
 
        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        }
        else {
            trunk.str = "`———";
            prev.str = prev_str;
        }
 
        showTrunks(trunk);
        System.out.println(" " + root.key);
 
        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";
 
        printTree(root.left, trunk, false);
    }

    //rotate right
    //pre-condition: tree is not null
    //post-condition: right rotation around subroot, then connecting it back to the prev node
    public void rotateRight(Node subRoot, Node prev){
        //null check
        if(subRoot == null || subRoot.left == null){
            return;
        }

        //do the rotation
        Node temp = subRoot.left;
        subRoot.left = temp.right;
        temp.right = subRoot;

        //reconnect
        if(prev == null){
            root = temp;
        }
        else if(prev.left == subRoot){
            prev.left = temp;
        }
        else{
            prev.right = temp;
        }
    }
  
    //rotate left
    //pre-condition: tree is not null
    //post-condition: left rotation around subroot, then connecting it back to the prev node
    public void rotateLeft(Node subRoot, Node prev){
        //null check
        if(subRoot == null || subRoot.right == null){
            return;
        }

        //do the rotation
        Node temp = subRoot.right;
        subRoot.right = temp.left;
        temp.left = subRoot;

        //reconnect
        if(prev == null){
            root = temp;
        }
        else if(prev.left == subRoot){
            prev.left = temp;
        }
        else{
            prev.right = temp;
        }
    }

    //height
    //pre condition: tree is not null
    //post condition: returns number of edges on longest path from node to a leaf
    public int getHeight(Node node){
        if(node == null){
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    //balance
    //pre condition: tree is not null
    //post condition: returns difference between the height of the right subtree and the left subtree
    public int getBalance(Node node){
        if(node == null){
            return 0;
        }
        int right = getHeight(node.right);
        int left = getHeight(node.left);
        return right - left;
    }
}