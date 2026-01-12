public class Main {
    public static void main(String[] args){
        //test case code that uses insert, remove, search, and toString throughout the test cases

        BST tree = new BST();
       //parent case with 0 child
       System.out.println("#1 - Original Tree: ");
       tree.insert(6);
       tree.insert(7);
       tree.toString();
       System.out.println("Is 6 there before? " + tree.search(6));
       System.out.println("Is 7 there before? " + tree.search(7));
       System.out.println();
       tree.remove(7);
       System.out.println("#1 - After Remove: ");
       tree.toString();
       System.out.println("Is 6 there after? " + tree.search(6));
       System.out.println("Is 7 there after? " + tree.search(7));
       System.out.println("Is it a BST? " + tree.isBSTOrNot());
       System.out.println();

       //parent case with 1 child
       BST tree1 = new BST();
       System.out.println("#2 - Original Tree: ");
       tree1.insert(6);
       tree1.insert(7);
       tree1.insert(8);
       tree1.toString();
       tree1.remove(7);
       System.out.println("#2 - After Remove: ");
       tree1.toString();

       //root case with 2 child
       BST tree2 = new BST();
       tree2.insert(6);
       tree2.insert(8);
       tree2.insert(7);
       tree2.insert(9);
       System.out.println("#3 - Original Tree");
       tree2.toString();
       tree2.remove(8);
       System.out.println("#3 - After Remove: ");
       tree2.toString();

       //part 2 - root case with 2 child
       BST tree3 = new BST();
       tree3.insert(6);
       tree3.insert(4);
       tree3.insert(2);
       tree3.insert(5);
       System.out.println("#4 - Original Tree");
       tree3.toString();
       tree3.remove(4);
       System.out.println("#4 - After Remove: ");
       tree3.toString();

        //part 3 - root case with 2 child
       BST tree4 = new BST();
       tree4.insert(10);
       tree4.insert(8);
       tree4.insert(9);
       tree4.insert(4);
       tree4.insert(6);
       tree4.insert(2);
       System.out.println("#5 - Original Tree");
       tree4.toString();
       System.out.println("Print Tree: ");
       tree4.printTree();
       tree4.remove(4);
       System.out.println("#5 - After Remove: ");
       tree4.toString();
       System.out.println("Print Tree: ");
       tree4.printTree();

       //rotate testing
       BST tree5 = new BST();
       tree5.insert(10);
       tree5.insert(11);
       tree5.insert(12);
       System.out.println("#6: Before rotate");
       tree5.toString();
       System.out.println("Print Tree: ");
       tree5.printTree();
       tree5.rotateLeft(tree5.root, null);
       System.out.println("#6: After rotate");
       tree5.toString();
       System.out.println("Print Tree: ");
       tree5.printTree();

       //rotate testing
       BST tree6 = new BST();
       tree6.insert(10);
       tree6.insert(9);
       tree6.insert(8);
       System.out.println("#7: Before rotate");
       tree6.toString();
       System.out.println("Print Tree: ");
       tree6.printTree();
       tree6.rotateRight(tree6.root, null);
       System.out.println("#7: After rotate");
       tree6.toString();
       System.out.println("Print Tree: ");
       tree6.printTree();
       System.out.println();

       //height testing
        BST tree7 = new BST();
        tree7.insert(4);
        tree7.insert(5);
        tree7.insert(7);
        tree7.insert(6);
        System.out.println("Height Testing: ");
        System.out.println("Print Tree: ");
        tree7.printTree();
        System.out.println("Test 1 (should return 0): " + tree7.getHeight(null));
        System.out.println("Test 2 (should return 4): " + tree7.getHeight(tree7.root));
        System.out.println("Test 3 (should return 3): " + tree7.getHeight(tree7.root.right));
        System.out.println("Test 4 (should return 2): " + tree7.getHeight(tree7.root.right.right));
        System.out.println("Test 5 (should return 1): " + tree7.getHeight(tree7.root.right.right.left));

        //balance testing
        BST tree8 = new BST();
        tree8.insert(4);
        tree8.insert(5);
        tree8.insert(7);
        tree8.insert(6);
        System.out.println("Height Testing: ");
        System.out.println("Print Tree: ");
        tree8.printTree();
        System.out.println("Test 1 (should return 0): " + tree7.getBalance(null));
        System.out.println("Test 2 (should return 3): " + tree7.getBalance(tree7.root));
        System.out.println("Test 3 (should return 2): " + tree7.getBalance(tree7.root.right));
        System.out.println("Test 4 (should return -1): " + tree7.getBalance(tree7.root.right.right));
        System.out.println("Test 5 (should return 0): " + tree7.getBalance(tree7.root.right.right.left));
    }
}
