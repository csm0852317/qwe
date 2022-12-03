package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//
//输入：
//        [-2,1]
//        输出：
//        0
//        预期结果：
//        1  由于有的renturn的点  没有判断最大值  ，要保证每个点都判断最大值

//[-2,-1]
//        输出：
//        0
//        预期结果：
//        -1  这个用例没过的原因是  把负数置为零了
public class T124 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(-2);
        TreeNode node2=new TreeNode(-1);
        node1.right=node2;
        System.out.println(maxPathSum(node1));
    }
    static int max=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root==null) return 0;
        if (root.right==null&&root.left==null){
            return root.val;
        }
        dsf(root);
        return max;

    }

    public static int dsf(TreeNode node){


        int left =0;
        int right =0;
        if (node.left!=null){
            left=dsf(node.left);
            if (left<0){
                left=0;
            }
        }
        if (node.right!=null){
            right=dsf(node.right);
            if (right<0){
                right=0;
            }
        }
        max=Math.max(right+left+ node.val,max);
        if (node.right==null&&node.left==null){
            return node.val;
        }
        return left>right?left+ node.val:right+ node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
