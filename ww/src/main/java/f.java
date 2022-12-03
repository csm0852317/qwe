import java.util.*;

public class f {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(8);
        TreeNode node4=new TreeNode(11);
        TreeNode node5=new TreeNode(13);
        TreeNode node6=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(2);
        TreeNode node9=new TreeNode(5);
        TreeNode node10=new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;
        System.out.println();

        System.out.println(longestUnivaluePath(node1,22));
    }
    static int num=0;
    public static int longestUnivaluePath(TreeNode root, int sum) {

        if (root==null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (treeNodes.size()!=0){
            int size = treeNodes.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node = treeNodes.poll();
                if (node.val==sum){
                    num++;
                }
                   if (node.left!=null){
                       dsf(node.left,sum,node.val);
                       treeNodes.offer(node.left);
                   }
                if (node.right!=null){
                    dsf(node.right,sum,node.val);
                    treeNodes.offer(node.right);
                }
            }
        }
        return num;
    }

    public static void dsf(TreeNode root, int sum, int val){
        if (sum==val+root.val){
            num++;
            return ;
        }
        if (val+root.val>sum){
            return;
        }
        if (root.left!=null) {
            dsf(root.left,sum, root.val+val);
        }
        if (root.right!=null){
            dsf(root.right,sum, root.val+val);
        }
    }

    int max=0;
    public int longestUnivaluePath2(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int left=0;
        int right=0;
        if (root.left!=null) {
            left=we(root.left, root.val);
        }

        if (root.right!=null){
            right=we(root.right,root.val);
        }
        max= Math.max(max,left+right);

        return max;
    }
    public int we(TreeNode root,int val) {
        int left=0;
        int right=0;
        if (root.left!=null) {
             left = we(root.left, root.val);
        }

        if (root.right!=null){
            right= we(root.right,root.val);
        }
        max= Math.max(max,left+right);

        if (root.val==val){
        return left >= right ? left+1 : right+1;
         }else {
            return 0;
        }
    }
    public  static List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) return new ArrayList<>();

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
                TreeNode node = treeNodes.poll();
                List<Integer> group = new ArrayList<>();

                group.add(node.val);
        if (node.val==targetSum && node.right==null &&node.left==null){
            result.add(new ArrayList<>(group));
        }
                if (node.left!=null){
                    hdf(node.left,targetSum,node.val,group);
                    treeNodes.offer(node.left);
                }
                if (node.right!=null){
                    hdf(node.right,targetSum,node.val,group);
                    treeNodes.offer(node.right);
        }
        return result;
    }
    public static void hdf(TreeNode root, int sum, int val,List<Integer> group){
        group.add(root.val);
        if (sum==val+root.val&& root.right==null &&root.left==null){
            result.add(new ArrayList<>(group));
        }
        if (root.left!=null) {
            hdf(root.left,sum, root.val+val,group);
        }
        if (root.right!=null){
            hdf(root.right,sum, root.val+val,group);
        }
        group.remove(group.size()-1);
    }

    //T437路径总和三 传递值时没能递增 数据溢出
    public static int pathSum11(TreeNode root, int targetSum) {
        if (root==null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (treeNodes.size()!=0){
            int size = treeNodes.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node = treeNodes.poll();
                if (node.val==targetSum){
                    num++;
                }
                if (node.left!=null){
                    wrre(node.left,targetSum,node.val);
                    treeNodes.offer(node.left);
                }
                if (node.right!=null){
                    wrre(node.right,targetSum,node.val);
                    treeNodes.offer(node.right);
                }
            }
        }
        return num;
    }
    public static void wrre(TreeNode root,int targetSum,long val) {
        if (val+root.val == targetSum){
            num++;
        }

        if (root.left!=null) {
            wrre(root.left,targetSum, root.val+val);
        }

        if (root.right!=null){
            wrre(root.right,targetSum,root.val+val);
        }
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
