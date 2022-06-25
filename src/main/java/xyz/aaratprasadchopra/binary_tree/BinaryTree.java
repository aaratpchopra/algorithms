package xyz.aaratprasadchopra.binary_tree;

import java.util.ArrayDeque;

public class BinaryTree<T> {
    private TreeNode root;
    private final ArrayDeque<TreeNode> queue;

    public BinaryTree() {
        this.root = null;
        this.queue = new ArrayDeque<>();
    }

    public BinaryTree(T[] data) {
        this.root = null;
        this.queue = new ArrayDeque<TreeNode>();
        constructTree(data);
    }

    private void constructTree(T[] data) {
        TreeNode current = null;
        var goLeft = true;
        for (var d : data) {
            var treeNode = new TreeNode(d);

            if (this.root == null) {
                this.root = treeNode;
                current = this.root;
                this.queue.add(current);
                continue;
            }

            if (goLeft) {
                this.queue.add(current);
                current = this.queue.poll();
                current.left = treeNode;
                current = current.left;
                this.queue.add(current);
                goLeft = false;
            } else {
                this.queue.add(current);
                current = this.queue.poll();
                current.right = treeNode;
                current = current.right;
                this.queue.add(current);
                goLeft = true;
            }
        }
        this.queue.clear();
        System.out.println(this.queue);
    }

    public void preOrder() {
        if (this.root == null)
            return;

    }

    private String representation() {
        System.out.println(this.queue);
        if (this.root == null) {
            return "null";
        }
        System.out.println(this.queue);
        var str = new StringBuilder();
        this.queue.add(this.root);
        str.append(this.root.data);
        while (this.queue.size() != 0) {
            var current = this.queue.poll();
            this.queue.add(current);
            current = current.left;
            str.append(current.data);
            this.queue.add(current);
            current = this.queue.poll();
            current = current.right;
            str.append(current.data);
            this.queue.add(current);
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return this.representation();
    }

    private class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
