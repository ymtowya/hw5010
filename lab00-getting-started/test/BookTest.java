

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import person.Book;
import person.Person;

/**
 * A JUnit test class for the Book class.
 */
public class BookTest {
  
  private Person myPerson;
  private Book myBook;
  
  @Before
  public void setUp() {
    this.myPerson = new Person("Cjar", "Rotey", 1999);
    this.myBook = new Book("Java", this.myPerson, 10.87f);
  }

  @Test
  public void testGetName1() {
    assertEquals("Cjar", myBook.getAuthor().getFirstName());
  }
  
  @Test
  public void testGetName2() {
    assertEquals("Rotey", myBook.getAuthor().getLastName());
  }
  
  @Test
  public void testGetYoB() {
    assertEquals(1999, myBook.getAuthor().getYearOfBirth());
  }
  
  @Test
  public void testGetTitle() {
    assertEquals("Java", myBook.getTitle());
  }
  
  @Test
  public void testGetPrice() {
    assertEquals(10.87f, myBook.getPrice(), 0.01f);
  }

}
