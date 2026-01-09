/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        TreeNode node;
        int dist;
        pair(TreeNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        pair p = solve(root,0);
        return p.node;
    }
    public pair solve(TreeNode root, int d){
        if(root == null) return new pair(null,d);
        pair l = solve(root.left,d+1);
        pair r = solve(root.right,d+1);
        if(l.dist == r.dist){
            return new pair (root,l.dist);
        }else{
            return l.dist > r.dist?l:r;
        }

    }
}
