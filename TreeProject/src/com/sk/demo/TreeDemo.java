package com.sk.demo;

import com.sk.Tree;
import com.sk.impl.EmptyTree;
import com.sk.impl.NonEmptyTree;

/**
 * 
 * @author sdagur
 *
 */
public class TreeDemo {

	public static void main(String[] args) {

		Tree tree1 = new NonEmptyTree(2, new EmptyTree().include(1, new EmptyTree()),
				new EmptyTree().include(4, new EmptyTree()));
		tree1.include(5, tree1);
		tree1.include(3, tree1);
		tree1.include(7, tree1);
		System.out.println("Tree 1 ::: "+tree1.toString());
		tree1.exclude(4, tree1);
		System.out.println("Modified Tree 1 after exclusion ::: "+tree1.toString());

		Tree tree2 = new NonEmptyTree(3, new EmptyTree().include(2, new EmptyTree()),
				new EmptyTree().include(4, new EmptyTree()));
		tree2.include(5, tree2);
		System.out.println("Tree 2 ::: " + tree2.toString());
		
		Tree treeCopyForUnion = tree1.copyTree(tree1);
		Tree unionTree = treeCopyForUnion.union(tree2);
		System.out.println("Union Tree ::: " + unionTree.toString());
		
		Tree treeCopyForInterscetion = tree1.copyTree(tree1);
		Tree interSection = treeCopyForInterscetion.intersection(tree2);
		System.out.println("Intersection ::: " + interSection);

	}

}
