package com.sk;

/**
 * 
 * @author sdagur
 *
 */
public interface Tree {

	/**
	 * This method is to check if data exist in tree.
	 * 
	 * @param data
	 * @return boolean
	 */
	boolean contains(int data);

	/**
	 * Method is to include data to tree.
	 * 
	 * @param x
	 * @param tree
	 * @return Tree
	 */
	Tree include(int x, Tree tree);

	/**
	 * Method to remove data from tree.
	 * 
	 * @param x
	 * @param tree
	 * @return Tree
	 */
	Tree exclude(int x, Tree tree);

	/**
	 * Method to return union of present tree to other tree.
	 * 
	 * @param otherTree
	 * @return Tree
	 */
	Tree union(Tree otherTree);

	/**
	 * Method to return intersection tree of this tree to other tree.
	 * 
	 * @param otherTree
	 * @return Tree
	 */
	Tree intersection(Tree otherTree);

	/**
	 * 
	 * Method to get left tree structure of the tree.
	 * 
	 * @return Tree
	 */
	Tree getLeft();

	/**
	 * Method to get right tree structure of the tree.
	 * 
	 * @return Tree
	 */
	Tree getRight();

	/**
	 * Method to set left tree structure of the tree.
	 * 
	 * @param tree
	 */
	void setLeft(Tree tree);

	/**
	 * Method to get right tree structure of the tree.
	 * 
	 * @param tree
	 */
	void setRight(Tree tree);

	/**
	 * Method to check if tree is empty.
	 * 
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * Method to get data element from tree.
	 * 
	 * @return integer element
	 */
	int getElement();

	/**
	 * Method to set data element in current tree.
	 * 
	 * @param ele
	 */
	void setElement(int ele);

	/**
	 * Method to copy input tree.
	 * 
	 * @param tree
	 * @return tree
	 */
	Tree copyTree(Tree tree);
}
