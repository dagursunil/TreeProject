package com.sk.impl;

import java.util.ArrayList;

import com.sk.Tree;

/**
 * 
 * @author sdagur
 *
 */
public class NonEmptyTree implements Tree {

	private int elem;
	private Tree left;
	private Tree right;

	public NonEmptyTree(int elem, Tree left, Tree right) {
		this.elem = elem;
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean contains(int data) {
		if (data < elem) {
			return left.contains(data);
		} else if (data > elem) {
			return right.contains(data);
		} else {
			return true;
		}

	}

	@Override
	public Tree include(int x, Tree tree) {

		if (tree instanceof EmptyTree) {
			return new NonEmptyTree(x, new EmptyTree(), new EmptyTree());
		}
		if (x < tree.getElement()) {
			tree.setLeft(tree.include(x, tree.getLeft()));
		} else if (x > tree.getElement()) {
			tree.setRight(tree.include(x, tree.getRight()));
		}
		return tree;
	}

	@Override
	public Tree intersection(Tree otherTree) {
		Tree treeIntersection = this;
		ArrayList<Integer> listFirstTree = storeTreeElements(treeIntersection);
		ArrayList<Integer> listSecond = storeTreeElements(otherTree);
		// remove common tree elements
		listFirstTree.removeAll(listSecond);
		for (Integer data : listFirstTree) {
			exclude(data, treeIntersection);
		}
		return treeIntersection;
	}

	@Override
	public Tree union(Tree tree2) {
		Tree treeUnion = this;
		ArrayList<Integer> list = storeTreeElements(tree2);
		for (Integer data : list) {
			if (!treeUnion.contains(data)) {
				this.include(data, treeUnion);
			}
		}
		return treeUnion;
	}

	@Override
	public Tree exclude(int data, Tree tree) {
		if (tree instanceof EmptyTree) {
			return tree;
		}

		if (data < tree.getElement()) {
			tree.setLeft(exclude(data, tree.getLeft()));
		} else if (data > tree.getElement()) {
			tree.setRight(exclude(data, tree.getRight()));
		} else {
			// tree with left and right as empty trees only (leaf node).
			if (tree.getLeft() instanceof EmptyTree && tree.getRight() instanceof EmptyTree) {
				return new EmptyTree();
			} else if (tree.getLeft() instanceof EmptyTree) {
				// node with only right non empty tree.
				return tree.getRight();
			} else if (tree.getRight() instanceof EmptyTree) {
				// node with only left non empty tree.
				return tree.getLeft();
			} else {
				// tree with both left and right non empty trees.
				// search for max number in right sub tree
				Integer maxValue = minValue(tree.getRight());
				tree.setElement(maxValue);
				tree.setRight(exclude(maxValue, tree.getRight()));
			}
		}
		return tree;
	}

	private Integer minValue(Tree node) {
		if (!(node.getLeft() instanceof EmptyTree)) {
			return minValue(node.getLeft());
		}
		return node.getElement();
	}

	// Method that stores elements of a tree.
	private ArrayList<Integer> storeTreeElements(Tree tree) {
		ArrayList<Integer> list1 = new ArrayList<>();
		storeElements(tree, list1);
		return list1;
	}

	// A Method that stores elements of a tree in a list.
	private ArrayList<Integer> storeElements(Tree tree, ArrayList<Integer> list) {
		if (tree instanceof EmptyTree) {
			return list;
		}
		// recur on the left child
		storeElements(tree.getLeft(), list);
	
		// Adds data to the list
		list.add(tree.getElement());

		// recur on the right child
		storeElements(tree.getRight(), list);

		return list;
	}

	@Override
	public Tree getLeft() {
		return left;
	}

	@Override
	public Tree getRight() {
		return right;
	}

	@Override
	public void setLeft(Tree tree) {
		left = tree;
	}

	@Override
	public void setRight(Tree tree) {
		right = tree;
	}

	public String toString() {
		return "(" + elem + ", " + left.toString() + ", " + right.toString() + ")";
	}

	@Override
	public int getElement() {
		return elem;
	}

	@Override
	public void setElement(int ele) {
		this.elem = ele;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Tree copyTree(Tree tree) {
		if (tree instanceof EmptyTree) {
			return new EmptyTree();
		}
		int element = tree.getElement();
		Tree left = copyTree(tree.getLeft());
		Tree right = copyTree(tree.getRight());
		Tree copyTree = new NonEmptyTree(element, left, right);
		return copyTree;

	}

}
