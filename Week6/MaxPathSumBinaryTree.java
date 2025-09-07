class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class MaxPathSumBinaryTree {
    
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode node) {
        if (node == null) 
            return 0;
        
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        
        int current = node.val + left + right;
        maxSum = Math.max(maxSum, current);
        
        return node.val + Math.max(left, right);
    }
}
