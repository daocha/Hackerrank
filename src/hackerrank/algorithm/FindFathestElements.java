package hackerrank.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * [Facebook Question]
 * 
 * Find the distance between the fathest two elements in a binary tree
 * 
 * e.g input:
 * 			5
 * 		   / \
 * 		  4   3
 *       / \   \
 *      6   1   7
 *       \     /
 *        0   2 
 *       / \
 *      9   8 
 * 
 * result: 7
 * 
 * e.g input:
 * 			5
 * 		   / \
 * 		  4   3
 *       / \   \
 *      6   1   7
 *     / \   \   \
 *   14   0   10  2
 *       / \   \
 *      9   8   11
 *      	   /
 *      	 12
 *          /
 *        13
 *        
 * result: 9
 * 
 * @author Ray LI
 * @date Oct 25, 2017
 * @contact ray@daocha.me
 */
public class FindFathestElements {
	private static class Node {
		public Node(int val, Node parent) {
			this.val = val;
			this.parent = parent;
		}

		int val;
		Node parent;
		Node left;
		Node right;
	}

	static int steps = 0;

	public static void main(String[] args) {
		// case 1
		{
			Node root = new Node(5, null);
			root.left = new Node(4, root);
			root.right = new Node(3, root);
			root.left.left = new Node(6, root.left);
			root.left.right = new Node(1, root.left);
			root.left.left.right = new Node(0, root.left.left);
			root.left.left.right.left = new Node(9, root.left.left.right);
			root.left.left.right.right = new Node(8, root.left.left.right);
			root.right.right = new Node(7, root.right);
			root.right.right.left = new Node(2, root.right.right);

			LinkedList<Node> bottomNodes = new LinkedList<Node>();
			int maxdistance = 0;
			findBottomNodes(bottomNodes, root);
			for (int i = 0; i < bottomNodes.size(); i++) {
				for (int j = 0; j != i && j < bottomNodes.size(); j++) {
					Node node1 = bottomNodes.get(i);
					Node node2 = bottomNodes.get(j);
					steps = 0;
					maxdistance = Math.max(maxdistance, findDistance(node1, node2));
				}
			}

			System.out.println("Fathest distance: " + maxdistance);
		}

		// case 2
		{
			Node root = new Node(5, null);
			root.left = new Node(4, root);
			root.right = new Node(3, root);
			root.left.left = new Node(6, root.left);
			root.left.right = new Node(1, root.left);
			root.left.right.right = new Node(10, root.left.right);
			root.left.right.right.right = new Node(11, root.left.right.right);
			root.left.right.right.right.left = new Node(12, root.left.right.right.right);
			root.left.right.right.right.left.left = new Node(13, root.left.right.right.right.left);
			root.left.left.right = new Node(0, root.left.left);
			root.left.left.right.left = new Node(9, root.left.left.right);
			root.left.left.right.right = new Node(8, root.left.left.right);
			root.right.right = new Node(7, root.right);
			root.right.right.right = new Node(2, root.right.right);

			LinkedList<Node> bottomNodes = new LinkedList<Node>();
			int maxdistance = 0;
			findBottomNodes(bottomNodes, root);
			for (int i = 0; i < bottomNodes.size(); i++) {
				for (int j = 0; j != i && j < bottomNodes.size(); j++) {
					Node node1 = bottomNodes.get(i);
					Node node2 = bottomNodes.get(j);
					steps = 0;
					maxdistance = Math.max(maxdistance, findDistance(node1, node2));
				}
			}

			System.out.println("Fathest distance: " + maxdistance);
		}
	}

	private static boolean isChild(Node parent, Node checkNode) {
		if (parent.left == checkNode || parent.right == checkNode) {
			return true;
		}

		boolean child = false;
		if (parent.left != null) {
			child = child || isChild(parent.left, checkNode);
		}

		if (parent.right != null) {
			child = child || isChild(parent.right, checkNode);
		}

		return child;
	}

	private static void findBottomNodes(List<Node> bottomNodes, Node node) {
		if (node.left == null && node.right == null) {
			bottomNodes.add(node);
		} else {
			if (node.left != null) {
				findBottomNodes(bottomNodes, node.left);
			}
			if (node.right != null) {
				findBottomNodes(bottomNodes, node.right);
			}
		}
	}

	/** find the distance between two elements */
	private static int findDistance(Node node1, Node node2) {
		// no other child, go on finding parent;
		Node parent1 = findParent(node1);
		Node parent2 = findParent(node2);

		if (parent1 == parent2) {
			return steps;
		} else if (isChild(parent1, parent2)) {
			while (parent2 != parent1) {
				parent2 = findParent(parent2);
			}
			return steps;
		} else if (isChild(parent2, parent1)) {
			while (parent1 != parent2) {
				parent1 = findParent(parent1);
			}
			return steps;
		} else {
			return findDistance(parent1, parent2);
		}
	}

	private static Node findParent(Node node) {
		if (node.parent == null) {
			return node;
		}

		if (node.parent.left == null || node.parent.right == null) {
			steps++;
			return findParent(node.parent);
		}
		steps++;
		return node.parent;
	}

}
