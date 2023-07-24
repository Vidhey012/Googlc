/*Algorithm 
 
Step 1: Create a class TreeNode, that contains the data element to be stored, a reference to the left child and a reference to the right child. 
Step 2: Insert operation: 
 	If the key of the current node is greater than the key to be inserted, then move to the left.  	If the key of the current node is less than the key to be inserted, then move to the right. 
Step 3: Remove operation: 
 	Search for the required key in the tree. Let the node be x 
 	If x is a leaf node, then make the corresponding branch as null. 
If x has one child, then make the child of x, a child of the parent of x. 
If x has one two children, then find the inorder successor of x. Let it be m. Replace the key of x with m and remove the node that contains the value m in the right branch of x. 
Step 4: Print operation: 
 	Print the key of every node in the tree by performing an inorder traversal. 
 
Source Code */

import java.util.Scanner;

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int d) {
    data = d;
    left = right = null;
  }
}

public class Set {

  TreeNode root;

  Set() {
    root = null;
  }

  public TreeNode insert(TreeNode root, int element) {
    if (root == null) {
      root = new TreeNode(element);
      return root;
    }
    if (root.data < element) {
      root.right = insert(root.right, element);
    } else if (root.data > element) {
      root.left = insert(root.left, element);
    }
    return root;
  }

  public int inorderSuccessor(TreeNode root) {
    TreeNode temp = root;
    while (temp.left != null) temp = temp.left;
    return temp.data;
  }

  public TreeNode remove(TreeNode root, int element) {
    if (root == null) return root;
    if (root.data > element) {
      root.left = remove(root.left, element);
    } else if (root.data < element) {
      root.right = remove(root.right, element);
    } else {
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;
      root.data = inorderSuccessor(root.right);
      root.right = remove(root.right, root.data);
    }
    return root;
  }

  public void print(TreeNode root) {
    if (root == null) return;
    print(root.left);
    System.out.print(root.data + " ");
    print(root.right);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Set s = new Set();
    System.out.println("1. Insert\n2. Remove\n3. Print\n4. Exit");
    while (true) {
      System.out.print("Option: ");
      int option = scanner.nextInt();
      if (option == 1) {
        System.out.print("Enter element: ");
        int element = scanner.nextInt();
        s.root = s.insert(s.root, element);
      } else if (option == 2) {
        System.out.print("Enter element: ");
        int element = scanner.nextInt();
        s.root = s.remove(s.root, element);
      } else if (option == 3) {
        s.print(s.root);
        System.out.println();
      } else {
        break;
      }
    }
  }

}