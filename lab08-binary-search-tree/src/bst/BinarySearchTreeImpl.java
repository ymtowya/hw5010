package bst;


/**
 * Implementation of Binary Search Tree.
 *
 * @param <T> Comparable Type T
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private TreeNode<T> root;
  
  /**
   * Init the Tree.
   *
   */
  public BinarySearchTreeImpl() {
    this.root = new EmptyTreeNode<>();
  }
  
  @Override
  public void add(T data) {
    if (root == null) {
      return;
    }
    this.root = root.add(data);
  }

  @Override
  public int size() {
    if (root == null) {
      return 0;
    }
    return root.size();
  }

  @Override
  public int height() {
    if (root == null) {
      return 0;
    }
    return root.height();
  }

  @Override
  public boolean present(T data) {
    if (root == null) {
      return false;
    }
    return root.present(data);
  }

  @Override
  public T minimum() {
    if (root == null) {
      return null;
    }
    return root.minimum();
  }

  @Override
  public T maximum() {
    if (root == null) {
      return null;
    }
    return root.maximum();
  }

  @Override
  public String preOrder() {
    if (root == null) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(root.preOrder().strip().trim());
    sb.append("]");
    return  sb.toString();
  }

  @Override
  public String inOrder() {
    if (root == null) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(root.inOrder().strip().trim());
    sb.append("]");
    return  sb.toString();
  }

  @Override
  public String postOrder() {
    if (root == null) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(root.postOrder().strip().trim());
    sb.append("]");
    return  sb.toString();
  }
  
  @Override
  public String toString() {
    return this.inOrder();
  }

}
