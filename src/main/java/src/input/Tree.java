package src.input;

import java.util.*; // for Stack class

//import abcTree.AbcNode;

public class Tree {

	public Node root; // first node of tree
	
	public Tree() // constructor
	{
		root = null;
	} // no nodes in tree yet

	public Node createTree(String string, int iData) { // -------------------------
		root = null;
		Node node = new Node();
		node.string = string;
		node.split();
		//System.out.println("string: " + node.string + " number: " + node.iData + " operator: " + node.operator);
		//if (iData * 2 + 2 < nodeArray.length) {
			
			if (node.numberOrOperator) {
				node.leftChild = createTree(node.before, iData * 2 + 1);
				//System.out.println("left child " + node.leftChild.iData);
				node.rightChild = createTree(node.after, iData * 2 + 2);
				//System.out.println("right child " + node.rightChild.iData);
			//}
		}root = node;
			return root;
		
	}

} // end class Tree