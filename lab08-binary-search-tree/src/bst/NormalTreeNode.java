package bst;

import java.util.ArrayList;
import java.util.List;

public class NormalTreeNode<T extends Comparable<T>> implements TreeNode<T> {
  
  private T myData;
  private TreeNode<T> leftChild;
  private TreeNode<T> rightChild;
  
  public NormalTreeNode(T theData) {
    this.myData = theData;
    this.leftChild = new EmptyTreeNode<>();
    this.rightChild = new EmptyTreeNode<>();
  }

  @Override
  public TreeNode<T> add(T data) {
    if (data.compareTo(myData) == 0) {
      return this;
    } else if (data.compareTo(myData) < 0) {
      this.leftChild = this.leftChild.add(data);
    } else {
      this.rightChild = this.rightChild.add(data);
    }
    return this;
  }

  @Override
  public int size() {
    return 1 + this.leftChild.size() + this.rightChild.size();
  }

  @Override
  public int height() {
    return 1 + Math.max(this.leftChild.height(), this.rightChild.height());
  }

  @Override
  public boolean present(T data) {
    if (data.compareTo(myData) == 0) {
      return true;
    }
    return leftChild.present(data) || rightChild.present(data);
  }

  @Override
  public T minimum() {
    T fetchedT = this.leftChild.minimum();
    if (fetchedT == null) {
      return this.myData;
    }
    return fetchedT;
  }

  @Override
  public T maximum() {
    T fetchedT = this.rightChild.maximum();
    if (fetchedT == null) {
      return this.myData;
    }
    return fetchedT;
  }

  @Override
  public List<String> preOrder() {
    
    List<String> resList = new ArrayList<>();
    resList.add(this.myData.toString());
    resList.addAll(this.leftChild.preOrder());
    resList.addAll(this.rightChild.preOrder());
    
    return resList;
//    StringBuilder sb = new StringBuilder();
//    
//    sb.append(this.myData.toString());
//    sb.append(" ");
//    sb.append(this.leftChild.preOrder());
//    sb.append(this.rightChild.preOrder());
//    
//    return sb.toString();
  }

  @Override
  public List<String> inOrder() {
    
    List<String> resList = new ArrayList<>();
    resList.addAll(this.leftChild.inOrder());
    resList.add(this.myData.toString());
    resList.addAll(this.rightChild.inOrder());
    
    return resList;
    
//    StringBuilder sb = new StringBuilder();
//    
//    sb.append(this.leftChild.inOrder());
//    sb.append(this.myData.toString());
//    sb.append(" ");
//    sb.append(this.rightChild.inOrder());
//    
//    return sb.toString();
  }

  @Override
  public List<String> postOrder() {
    
    List<String> resList = new ArrayList<>();
    resList.addAll(this.leftChild.postOrder());
    resList.addAll(this.rightChild.postOrder());
    resList.add(this.myData.toString());
    
    return resList;
    
//    StringBuilder sb = new StringBuilder();
//    
//    sb.append(this.leftChild.postOrder());
//    sb.append(this.rightChild.postOrder());
//    sb.append(this.myData.toString());
//    sb.append(" ");
//    
//    List<T> myList = new ArrayList<>();
//    
//    return sb.toString();
  }

}
