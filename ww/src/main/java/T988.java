import java.util.PriorityQueue;
import java.util.Queue;

//给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
//
//        返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
//
//        注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
//
//        例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。 
//    节点的叶节点是没有子节点的节点。
//输入：
//        [25,1,3,1,3,0,2]
//        输出：
//        "add"
//        预期结果：
//        "adz"  原因是由于reverse()后要进一步reverse才能还原。
    public class T988 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(25);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(3);
        TreeNode node6=new TreeNode(0);
        TreeNode node7=new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        node3.left=node7;
        System.out.println(smallestFromLeaf(node1));
    }

    static Queue<String> queue = new PriorityQueue<>();
    public static String smallestFromLeaf(TreeNode root) {
        if (root==null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        asff(root,stringBuilder);
        return queue.poll();
    }
    public static void asff(TreeNode root,StringBuilder str) {
        str.append((char)(root.val+97));
        if (root.right==null&&root.left==null){
            queue.offer(str.reverse().toString());
            str.reverse();
        }
        if (root.left!=null){
            asff(root.left,str);
        }
        if (root.right!=null){
            asff(root.right,str);
        }
        str.deleteCharAt(str.length()-1);

    }
}
