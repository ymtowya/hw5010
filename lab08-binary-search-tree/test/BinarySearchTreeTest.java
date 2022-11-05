import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;

public class BinarySearchTreeTest {
  
  BinarySearchTree<Integer> tree1;

  @Before
  public void setUp() throws Exception {
    tree1 = new BinarySearchTreeImpl<>();
  }

  @Test
  public final void test() {
    tree1.add(7);
    tree1.add(6);
    tree1.add(9);
    tree1.add(2);
    assertTrue(tree1.present(6));
    BinarySearchTree<Integer> tree2 = new BinarySearchTreeImpl<>();
    int[] nums = new int[] {953, -128, -176, 174, -528, -568, 185, 161, 303, 171, -231};
    for (int tmp : nums) {
      tree2.add(tmp);
    }
    System.out.println(tree2.inOrder());
  }
  
  @Test
  public final void testPresent() {
    int[] nums = new int[] {685, -671, -970, 600, -637, -588, -467, -415, -764, 234, -629};
    for (int tmp : nums) {
      tree1.add(tmp);
    }
    assertFalse(tree1.present(-998));
  }

}
