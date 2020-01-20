import binaryTree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TreeTest<T extends Comparable<? super T>> {

    /**
     * Tests a depth-first traversal of a binary tree to see if the correct result is produced. This test has a node number of 5
     *
     */
    @Test
    void TestBinTree5() throws NullPointerException{
        BinaryTree<T> newtree = new BinaryTree();
        int limit = 5;
        Random rand = new Random();
        for(int index=0;index<limit;index++){
            Integer inttest = rand.nextInt((50 - 0) + 1) + 0;
            newtree.insert((T) inttest);
        }
        System.out.println(newtree.traverse());
    }

    /**
     * Tests a depth-first traversal of a binary tree to see if the correct result is produced. This test has a node number of 7
     *
     */
    @Test
    void TestBinTree7() throws NullPointerException{
        BinaryTree<T> newtree = new BinaryTree();
        int limit = 7;
        Random rand = new Random();
        for(int index=0;index<limit;index++){
            Integer inttest = rand.nextInt((50 - 0) + 1) + 0;
            newtree.insert((T) inttest);
        }
        System.out.println(newtree.traverse());
    }
}
