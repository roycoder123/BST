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
    }
}
