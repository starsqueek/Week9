package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A partial implementation of sorted binary trees.
 * <p>
 * The three constructors (construct an empty tree ({@link #BinaryTree()}, or a tree with a root value but no subtrees
 * ({@link #BinaryTree(Comparable)}, or a tree with a root value and left and right subtrees
 * ({@link #BinaryTree(Comparable, BinaryTree, BinaryTree)}), as well as the {@link #isEmpty()} method are already implemented.
 * <p>
 * For the remaining methods specified in the {@link BTree} interface ({@link #insert(Comparable)}, {@link #getValue()},
 * {@link #setValue(Comparable)}, {@link #getLeft()}, {@link #setLeft(BTree)}, {@link #getRight()}, {@link #setRight(BTree)},
 * {@link #contains(Comparable)}, and {@link #traverse()}) only a "stub" is provided.  For the logbook exercise you
 * should implement these methods.
 * <p>
 * Don't forget to test your implementation!
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Hugh Osborne.
 * @version December 2019.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {

    /**
     * The root node of this tree.
     */
    private TreeNode<T> root; 

    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     * @param value the value to be stored in the root of the tree.
     * @param left the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value,BinaryTree<T> left,BinaryTree<T> right) {
        root = new TreeNode<>(value,left,right);
    }

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     */
    public void insert(T value) {
        if (isEmpty()) {
            root = new TreeNode(value);
        } else if (value.compareTo(getValue()) < 0) {
            getLeft().insert(value);
        } else {
            getRight().insert(value);
    }
        System.out.println(value);
    }

    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     */

    public T getValue() {
        try {
            T rootvalue = (T) root.getValue();
            return rootvalue;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Change the value stored at the root of the tree.
     * @param value the new value to be stored at the root of the tree.
     */
    public void setValue(T value) {
        root.setValue(value);
    }

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     */
    public BTree<T> getLeft() {
        return root.getLeft();
    }

    /**
     * Change the left subtree of this tree.
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) {
        root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() {
        return root.getRight();
    }

    /**
     * Change the right subtree of this tree.
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) {
        root.setRight(tree);
        // implement setRight(BTree<T> tree) here
    }

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    public boolean contains(T value) {
        if (isEmpty()) {
            return false;
        } else if (value.compareTo(getValue()) == 0) {
            return true;
        } else if (value.compareTo(getValue()) < 0) {
            if(getLeft().contains(value) == true){ return true;}
        } else {
            getRight().contains(value);
            if(getLeft().contains(value) == true){ return true;}
        }
        return false;
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    public List<T> traverse() {
        try{
            getValue();
        } catch (NullPointerException r) {
            return null;
        }
        ArrayList traverselist = new ArrayList();
        traverselist.add(getValue());
        try{
            ArrayList addlist1 = (ArrayList) getLeft().traverse();
            traverselist.addAll(addlist1);
        } catch (NullPointerException e) {}
        try{
            ArrayList addlist2 = (ArrayList) getRight().traverse();
            traverselist.addAll(addlist2);
        } catch (NullPointerException e) {}
        traverselist.remove(null);
        return traverselist;
    }
}

