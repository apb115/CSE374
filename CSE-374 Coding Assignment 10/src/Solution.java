// Name: Andrew Boothe
// Class: CSE-374
// Assignment: Binary Tree balancing tester
// Date: 11/12/2022


class Solution {
    public boolean isBalanced(TreeNode root) {
    	// Base Case: if the tree is empty it will be balanced
    	int nullCheck = branchHeight(root);
    	if (nullCheck == 0) return true;
    	
    	// recursive call to find l&r height of subtrees of root
    	int leftHeight = branchHeight(root.left);
    	int rightHeight = branchHeight(root.right);
    	
    	// Workhorse of function, checks balanced definition of no more difference than 1
    	//	as well as all subtrees being balanced
    	if ((leftHeight-rightHeight) <= 1) {
    		if (isBalanced(root.left)) {
    			if (isBalanced(root.right)) {
    				return true;
    			}
    		}
    	}
    	// if that function is not true there is an imbalance somewhere
		return false;
    }
    
    public static int branchHeight(TreeNode root) {
    	// sends blank tree height that will always return true to main function
    	if (root == null) return 0;
  
    	// Computes total max heights of a tree & recursion for subtrees, any level 
    	//	that is not null is a value of 1 added to total height
    	if (branchHeight(root.left) > branchHeight(root.right))
    		return branchHeight(root.left)+1;
    	else {
    		return branchHeight(root.right)+1;
    	}
    	
    }
    
    // For testing purposes
//    public static void main(String[] args) {
//		TreeNode test = new TreeNode(1, new TreeNode(2), new TreeNode(2));
//		test.left = new TreeNode(2, new TreeNode(3), new TreeNode(3));
//		test.right = new TreeNode(2, null, null);
//		test.left.left = new TreeNode(3, new TreeNode(4), new TreeNode(4));
//		System.out.println(isBalanced(test));
//		
//		TreeNode test2 = new TreeNode();
//		System.out.println(isBalanced(test2));
//	}
}

