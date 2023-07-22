package practice.p2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class mirrorImage {
    public static void main(String[] args) {
        int[] minHeap = { 10, 20, 30, 60, 40, 50, 45, 70, 80, 90, 100, 110, 120, 130, 140 };
        int[] ans = new int[minHeap.length];
        int i = 0;
        TreeNode root = new TreeNode(minHeap[0], null, null);
        // TreeNode temp=root;
        // TreeNode head=root;
        // System.out.println(root.toString());
        createMinHeap(minHeap, root, 0);
        invert(root);
        // System.out.println(root.toString());
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode top = q.remove();
            if (top != null) {
                ans[i++] = top.val;
                q.add(top.left);
                q.add(top.right);
            }
        }
        System.out.println("Min Heap" + " " + Arrays.toString(minHeap));
        System.out.println("Mirror Image" + " " + Arrays.toString(ans));
    }

    private static void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

    private static void createMinHeap(int[] minHeap, TreeNode root, int idx) {
        if (idx >= minHeap.length) {
            return;
        }
        int lc = 2 * idx + 1;
        int rc = 2 * idx + 2;
        if (lc < minHeap.length) {
            TreeNode left = new TreeNode(minHeap[lc], null, null);
            root.left = left;
            // root=root.left;
            createMinHeap(minHeap, root.left, lc);
        }
        if (rc < minHeap.length) {
            TreeNode right = new TreeNode(minHeap[rc], null, null);
            root.right = right;
            createMinHeap(minHeap, root.right, rc);
        }
    }
}
