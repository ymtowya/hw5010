package person;

/**
 * This class represents a book. A book has a title, an author and a price.
 */
public class Book {
  private String title;
  private Person author;
  private float price;
  
  // TODO: Add something to this assignment with respect to Javadocs

  /**
   * Construct a Book object that has the provided title, author and  price.
   *
   * @param theTitle  the title to be given to this book
   * @param theAuthor the author to be given to this book
   * @param thePrice  the price to be assigned to this book
   */

  public Book(String theTitle, Person theAuthor, float thePrice) {
    this.title = theTitle;
    this.author = theAuthor;
    this.price = thePrice;
  }

  /**
   * Return the title of this book.
   *
   * @return the title of this book
   */

  public String getTitle() {
    return this.title;
  }

  /**
   * Return the price of this book.
   *
   * @return the price of this book
   */
  public float getPrice() {
    return this.price;
  }

  /**
   * Return the author of this object.
   *
   * @return the author of this object as a @link{Person}
   */
  public Person getAuthor() {
    return this.author;
  }

}