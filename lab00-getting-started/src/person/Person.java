package person;

/**
 * This class represents a person The person has a first name, last name and an year of birth.
 */
public class Person {
  private String firstName;
  private String lastName;
  private int yearOfBirth;

  /**
   * Constructs a Person object and initializes it to the given first name, last name and year of
   * birth.
   *
   * @param theFirstName   the first name of this person
   * @param theLastName    the last name of this person
   * @param theYearOfBirth the year of birth of this person
   */

  public Person(String theFirstName, String theLastName, int theYearOfBirth)  {
    this.firstName = theFirstName;
    this.lastName = theLastName;
    this.yearOfBirth = theYearOfBirth;
  }

  /**
   * Get the First name of this person.
   *
   * @return the First name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the Last name of this person.
   *
   * @return the Last name of this person
   */

  public String getLastName() {
    return this.lastName;
  }

  /**
   * Return the Year of Birth of this person.
   *
   * @return the Year of Birth of this person
   */
  public int getYearOfBirth() {
    return this.yearOfBirth;
  }
}

