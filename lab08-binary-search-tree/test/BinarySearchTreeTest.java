import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinarySearchTree.
 *
 */
public class BinarySearchTreeTest {
  
  BinarySearchTree<Integer> tree1;
  BinarySearchTree<Integer> tree2;
  BinarySearchTree<Integer> tree3;
  BinarySearchTree<Integer> tree4;

  /**
   * Set up the trees.
   *
   * @throws IOException if input invalid
   */
  @Before
  public void setUp() throws IOException {
    tree1 = new BinarySearchTreeImpl<>();
    tree2 = new BinarySearchTreeImpl<>();
    tree3 = new BinarySearchTreeImpl<>();
    tree4 = new BinarySearchTreeImpl<>();
    
    int[] nums1 = new int[] {7, 6, 9, 10, 13, -1, -7, -6, 8};
    for (int tmp : nums1) {
      tree1.add(tmp);
    }
    
    int[] nums2 = new int[] {953, -128, -176, 174, -528, -568, 185, 161, 303, 171, -231};
    for (int tmp : nums2) {
      tree2.add(tmp);
    }
    
    int[] nums3 = new int[] {685, -671, -970, 600, -637, -588, -467, -415, -764, 234, -629};
    for (int tmp : nums3) {
      tree3.add(tmp);
    }
  }
  
  @Test
  public final void testConstruct() {
    BinarySearchTree<Integer> tree5 = new BinarySearchTreeImpl<>();
    assertEquals(0, tree5.size());
    assertEquals(0, tree5.height());
  }

  @Test
  public final void testAdd() {
    tree4.add(7);
    tree4.add(6);
    assertFalse(tree4.present(9));
    tree4.add(9);
    assertTrue(tree4.present(9));
  }
  
  @Test
  public final void testAddExist() {
    assertEquals(11, tree2.size());
    tree2.add(161);
    assertEquals(11, tree2.size());
  }
  
  @Test
  public final void testSize() {
    assertEquals(0, tree4.size());
    assertEquals(11, tree3.size());
  }
  
  @Test
  public final void testPresent() {
    // true
    assertTrue(tree1.present(-1));
    assertTrue(tree2.present(-176));
    assertTrue(tree3.present(600));
    assertTrue(tree3.present(-629));
    // false
    assertFalse(tree1.present(71));
    assertFalse(tree2.present(-998));
    assertFalse(tree3.present(-651));
    assertFalse(tree4.present(0));
  }
  
  @Test
  public final void testMinimum() {
    assertEquals(Integer.valueOf(-7), tree1.minimum());
    assertEquals(Integer.valueOf(-568), tree2.minimum());
    assertEquals(Integer.valueOf(-970), tree3.minimum());
    assertEquals(null, tree4.minimum());
  }
  
  @Test
  public final void testMaximum() {
    assertEquals(Integer.valueOf(13), tree1.maximum());
    assertEquals(Integer.valueOf(953), tree2.maximum());
    assertEquals(Integer.valueOf(685), tree3.maximum());
    assertEquals(null, tree4.maximum());
  }
  
  @Test
  public final void testPreOrder() {
    assertTrue("[]".equals(tree4.preOrder()));
    assertTrue("[7 6 -1 -7 -6 9 8 10 13]".equals(tree1.preOrder()));
  }
  
  @Test
  public final void testInOrder() {
    assertTrue("[]".equals(tree4.inOrder()));
    assertTrue("[-568 -528 -231 -176 -128 161 171 174 185 303 953]".equals(tree2.inOrder()));
  }
  
  @Test
  public final void testPostOrder() {
    assertTrue("[]".equals(tree4.postOrder()));
    assertTrue("[-764 -970 -629 234 -415 -467 -588 -637 600 -671 685]".equals(tree3.postOrder()));
  }
  
  @Test
  public final void testHeight() {
    assertEquals(5, tree1.height());
    assertEquals(5, tree2.height());
    assertEquals(8, tree3.height());
    assertEquals(0, tree4.height());
  }

}
