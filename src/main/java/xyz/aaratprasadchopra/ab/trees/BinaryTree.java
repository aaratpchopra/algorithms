package xyz.aaratprasadchopra.ab.trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinaryTree<T> {
    private TreeNode root;
    private Scanner scanner;
    private final ArrayDeque<TreeNode> queue;
    private final ArrayDeque<TreeNode> stack;
    private Class<T> clazz;

    public BinaryTree() {
        this.root = null;
        this.scanner = null;
        this.queue = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }

    public BinaryTree(Class<T> clazz) {
        this.clazz = clazz;
        this.root = null;
        this.scanner = null;
        this.queue = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
        if (clazz == Integer.class || clazz == String.class)
            genericTree();
        else
            System.out.println("For Generic Tree, Only Integer and String is Compatible!");
    }

    private void genericTree() {
        this.scanner = new Scanner(System.in);
        T data;
        System.out.println("Construct a Tree Based on The Requirements. Would Be Either String or an Integer!");
        System.out.print("Enter Root Element -->\t");
        if (this.clazz.getName().equals(Integer.class.getName()))
            data = (T) ((Integer) this.scanner.nextInt());
        else
            data = (T) this.scanner.nextLine();
        this.root = new TreeNode(data);
        this.queue.add(this.root);

        TreeNode treeNode;
        var current = this.root;

        if (this.clazz.getName().equals(Integer.class.getName())) {
            while (!queue.isEmpty()) {
                System.out.print("LEFT ELEMENT -->\t");
                data = (T) ((Integer) this.scanner.nextInt());
                if ((Integer) data != -1) {
                    treeNode = new TreeNode(data);
                    current.left = treeNode;
                    this.queue.add(treeNode);
                }

                System.out.print("RIGHT ELEMENT -->\t");
                data = (T) ((Integer) this.scanner.nextInt());
                if ((Integer) data != -1) {
                    treeNode = new TreeNode(data);
                    current.right = treeNode;
                    this.queue.add(treeNode);
                }
                current = this.queue.remove();
            }
        } else {
            while (!queue.isEmpty()) {
                System.out.print("LEFT ELEMENT -->\t");
                data = (T) this.scanner.nextLine();
                if (!data.equals("")) {
                    treeNode = new TreeNode(data);
                    current.left = treeNode;
                    this.queue.add(treeNode);
                }

                System.out.print("RIGHT ELEMENT -->\t");
                data = (T) this.scanner.nextLine();
                if (!data.equals("")) {
                    treeNode = new TreeNode(data);
                    current.right = treeNode;
                    this.queue.add(treeNode);
                }
                current = this.queue.remove();
            }
        }
        System.out.println(this.root);
    }

    public void constructTree(T[] array) {
        this.construct(array);
    }

    public void constructTree(List<T> list) {
        this.construct((T[]) list.toArray());
    }

    private void construct(T[] array) {
        System.out.println("This Function Constructs a \"Complete Binary Tree\"!");
        if (this.root != null) {
            this.root = null;
            System.out.println("The Existing Tree Has Been Destroyed!");
        }
        this.queue.clear();
        this.root = new TreeNode(array[0]);
        var current = this.root;
        boolean isLeft = true;

        for (int i = 1; i < array.length; i++) {
            var treeNode = new TreeNode(array[i]);
            if (isLeft) {
                current.left = treeNode;
                this.queue.add(treeNode);
                isLeft = false;
            } else {
                current.right = treeNode;
                this.queue.add(treeNode);
                current = this.queue.remove();
                isLeft = true;
            }
        }
        System.out.println(this.root);
    }

    public void preOrder() {
        this.preOrderImpl(this.root);
        System.out.println();
    }

    public void inOrder() {
        this.inOrderImpl(this.root);
        System.out.println();
    }

    public void postOrder() {
        this.postOrderImpl(this.root);
        System.out.println();
    }

    public void preOrderItr() {
        this.preOrderItrImpl(this.root);
        System.out.println();
    }

    public void inOrderItr() {
        this.inOrderItrImpl(this.root);
        System.out.println();
    }

    public void postOrderItr() {
        this.postOrderItrImpl(this.root);
        System.out.println();
    }

    private void preOrderImpl(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + "\t");
        preOrderImpl(root.left);
        preOrderImpl(root.right);
    }

    private void preOrderItrImpl(TreeNode root) {
        if (root == null)
            return;

        var current = this.root;
        while (!this.stack.isEmpty() || current != null) {
            if (current != null) {
                System.out.print(current.data + "\t");
                this.stack.push(current);
                current = current.left;
            } else {
                current = this.stack.pop();
                current = current.right;
            }
        }
    }

    private void inOrderImpl(TreeNode root) {
        if (root == null)
            return;
        inOrderImpl(root.left);
        System.out.print(root.data + "\t");
        inOrderImpl(root.right);
    }

    private void inOrderItrImpl(TreeNode root) {
        if (root == null)
            return;

        var current = root;
        this.stack.clear();
        while (!this.stack.isEmpty() || current != null) {
            if (current != null) {
                this.stack.push(current);
                current = current.left;
            } else {
                current = this.stack.pop();
                System.out.print(current.data + "\t");
                current = current.right;
            }
        }
    }

    private void postOrderImpl(TreeNode root) {
        if (root == null)
            return;
        postOrderImpl(root.left);
        postOrderImpl(root.right);
        System.out.print(root.data + "\t");
    }

    private void postOrderItrImpl(TreeNode root) {
        if (root == null)
            return;

        var current = root;
        TreeNode preAddr = null;
        while (!this.stack.isEmpty() || current != null) {
            if (current != null) {
                this.stack.push(current);
                preAddr = current;
                current = current.left;
            } else {
                current = this.stack.pop();
                if (preAddr == current) {
                    var newTN = new TreeNode(current);
                    this.stack.push(newTN);
                    current = current.right;
                } else {
                    System.out.print(current.data + "\t");
                    current = null;
                }
            }
        }
    }

    private class TreeNode {
        TreeNode left;
        T data;
        TreeNode right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public TreeNode(TreeNode treeNode) {
            this.data = treeNode.data;
            this.left = treeNode.left;
            this.right = treeNode.right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "left=" + left +
                    ", data=" + data +
                    ", right=" + right +
                    '}';
        }
    }
}
