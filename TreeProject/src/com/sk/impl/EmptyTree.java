package com.sk.impl;

import com.sk.Tree;

/**
 * 
 * @author sdagur
 *
 */
public class EmptyTree implements Tree {

	@Override
	public boolean contains(int data) {
		return false;
	}

	@Override
	public Tree include(int x, Tree tree) {
		return new NonEmptyTree(x, new EmptyTree(), new EmptyTree());
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Tree union(Tree otherTree) {
		return otherTree;
	}

	@Override
	public Tree intersection(Tree otherTree) {
		return new EmptyTree();
	}

	public String toString() {
		return "()";
	}

	@Override
	public Tree getLeft() {
		return new EmptyTree();
	}

	@Override
	public Tree getRight() {
		return new EmptyTree();
	}

	@Override
	public int getElement() {
		return Integer.MIN_VALUE;
	}

	@Override
	public void setLeft(Tree tree) {
		// no implementation

	}

	@Override
	public void setRight(Tree tree) {
		// no implementation

	}

	@Override
	public void setElement(int ele) {
		// no implementation
		
	}

	@Override
	public Tree exclude(int x, Tree tree) {
		return new EmptyTree();
	}

	@Override
	public Tree copyTree(Tree tree) {
		return new EmptyTree();
	}

}
