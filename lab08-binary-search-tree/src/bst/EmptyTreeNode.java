package bst;

import java.util.ArrayList;
import java.util.List;

public class EmptyTreeNode<T extends Comparable<T>> implements TreeNode<T> {

  @Override
  public TreeNode<T> add(T data) {
    return new NormalTreeNode<T>(data);
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public String preOrder() {
    return "";
  }

  @Override
  public String inOrder() {
    return "";
  }

  @Override
  public String postOrder() {
    return "";
  }

}
