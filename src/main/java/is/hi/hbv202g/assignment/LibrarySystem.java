package is.hi.hbv202g.assignment;

import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Stjórnkerfi fyrir bókasafn sem heldur utan um bækur, notendur og útlán.
 * Hægt er að bæta við bókum, notendum og framkvæma útlán á bókum.
 * Kerfið notar einnig JavaFX til að sýna skilaboð í viðmóti.
 *
 * @author Nafn höfundar
 * @version 1.0
 */
public class LibrarySystem {

  private final Map<String, Book> books = new HashMap<>();
  private final Map<String, User> users = new HashMap<>();
  private final List<Lending> lendings = new ArrayList<>();

  private static final LibrarySystem instance = new LibrarySystem();

  /**
   * Smiður sem býr til nýtt tilvik af bókasafnskerfinu.
   * Sjálfgefið gögn eru búin til í kerfinu.
   */
  public LibrarySystem() {
    System.out.println("Library System created");
    initializeDefaultData();
  }

  /**
   * Upphafsstillir sjálfgefin gögn innan kerfisins.
   * Bætir við bókum og notendum í kerfið.
   */
  private void initializeDefaultData() {
    System.out.println("Initializing default data...");
    addBookWithTitleAndNameOfSingleAuthor("Book of Love", "Jane Doe");
    addBookWithTitleAndNameOfSingleAuthor("Exploring JavaFX", "John Doe");
    addBookWithTitleAndNameOfSingleAuthor(
      "The Great Gatsby",
      "F. Scott Fitzgerald"
    );
    addBookWithTitleAndNameOfSingleAuthor(
      "The Catcher in the Rye",
      "J. D. Salinger"
    );
    addBookWithTitleAndAuthorList(
      "The Hobbit",
            List.of(new Author("J. R. R. Tolkien"))
    );
    addBookWithTitleAndAuthorList(
      "The Lord of the Rings",
      List.of(new Author("J. R. R. Tolkien"))
    );
    addBookWithTitleAndAuthorList(
      "The Fellowship of the Ring",
            List.of(new Author("J. R. R. Tolkien"))
    );
    addStudentUser("John Doe", true);
    addStudentUser("Jane Doe", false);
    addStudentUser("Jim Doe", true);
    addStudentUser("Jill Doe", false);
    addStudentUser("Jack Doe", true);
    addStudentUser("Jill Doe", false);
    addFacultyMemberUser("Jane Doe", "Computer Science");
    addFacultyMemberUser("Jim Doe", "Industrial Engineering");
    addFacultyMemberUser("Jill Doe", "Computer Science");
    addFacultyMemberUser("Jack Doe", "Computer Science");
    addFacultyMemberUser("Jill Doe", "Mechanical Engineering");
    addFacultyMemberUser("Jane Doe", "Information Technology");
    addFacultyMemberUser("Jim Doe", "Information Technology");
    addFacultyMemberUser("Jill Doe", "mechanical engineering");
    addFacultyMemberUser("Jack Doe", "Industrial Engineering");
    addFacultyMemberUser("Jill Doe", "Mechanical Engineering");
    System.out.println("Books added, total count: " + books.size());
  }

  /**
   * Nær í tilvik af LibrarySystem.
   * @return tilvik af LibrarySystem
   */
  public static LibrarySystem getInstance() {
    return instance;
  }

  /**
   * Skilar öllum bókum sem eru skráðar í kerfinu.
   * @return safn af bókum
   */
  public Collection<Book> getAllBooks() {
    return books.values();
  }

  /**
   * Bætir við nýrri bók í kerfið með titli og höfundi.
   * @param title Titill bókarinnar
   * @param authorName Nafn höfundar bókarinnar
   */
  public void addBookWithTitleAndNameOfSingleAuthor(
    String title,
    String authorName
  ) {
    if (!books.containsKey(title)) {
      Book newBook = new Book(title, Arrays.asList(new Author(authorName)));
      books.put(title, newBook);
      System.out.println("Book added: " + title + " by " + authorName);
    }
  }

  /**
   * Bætir við nýrri bók í kerfið með titli og lista af höfundum.
   * @param title Titill bókarinnar
   * @param authors Listi af höfundum bókarinnar
   */
  public void addBookWithTitleAndAuthorList(
    String title,
    List<Author> authors
  ) {
    if (!books.containsKey(title)) {
      Book newBook = new Book(title, authors);
      books.put(title, newBook);
      System.out.println("Book added with multiple authors: " + title);
    }
  }

  /**
   * Bætir nýjum nemanda við kerfið.
   * @param name Nafn nemandans.
   * @param feePaid Boolean gildi sem segir til um hvort skráningargjald hafi verið greitt.
   */
  public void addStudentUser(String name, boolean feePaid) {
    User newUser = new Student(name, feePaid);
    users.put(name, newUser);
    System.out.println("Student user added: " + name);
  }

  /**
   * Bætir nýjum kennara við kerfið.
   * @param name Nafn kennarans.
   * @param department Deild sem kennarinn tilheyrir.
   */
  public void addFacultyMemberUser(String name, String department) {
    User newUser = new FacultyMember(name, department);
    users.put(name, newUser);
    System.out.println("Faculty member added: " + name);
  }

  /**
   * Finna bók eftir titli.
   * @param title Titill bókarinnar sem leitað er að.
   * @return Skilar bókinni ef hún finnst, annars null.
   */
  public Book findBookByTitle(String title) {
    return books.get(title);
  }

  /**
   * Finna notanda eftir nafni.
   * @param name Nafn notandans sem leitað er að.
   * @return Skilar notandanum ef hann finnst, annars null.
   */
  public User findUserByName(String name) {
    return users.get(name);
  }

  /**
   * Gerir notanda kleift að lána bók.
   * @param user Notandinn sem er að lána bókina.
   * @param book Bókin sem er verið að lána.
   */
  public void borrowBook(User user, Book book) {
    if (users.containsValue(user) && books.containsValue(book)) {
      Lending lending = new Lending(book, user);
      lendings.add(lending);
      System.out.println(
        "Book borrowed: " + book.getTitle() + " by " + user.getName()
      );
      System.out.println("Due date: " + lending.getDueDate());
    } else {
      System.out.println("User or book not found.");
    }
  }

  /**
   * Frímerkir lán á bók til nýs skiladags fyrir kennara.
   * @param facultyMember Kennarinn sem er með bókina á láni.
   * @param book Bókin sem er á láni.
   * @param newDueDate Nýr skiladagur fyrir bókina.
   */
  public void extendLending(
    FacultyMember facultyMember,
    Book book,
    LocalDate newDueDate
  ) {
    Lending lending = lendings
      .stream()
      .filter(l -> l.getBook().equals(book) && l.getUser().equals(facultyMember)
      )
      .findFirst()
      .orElse(null);
    if (lending != null) {
      lending.setDueDate(newDueDate);
      System.out.println(
        "Lending extended for book: " + book.getTitle() + " to " + newDueDate
      );
    } else {
      System.out.println("Lending not found.");
    }
  }

  /**
   * Skilar bók aftur í kerfið.
   * @param user Notandinn sem skilar bókinni.
   * @param book Bókin sem er verið að skila.
   */
  public void returnBook(User user, Book book) {
    Lending lending = lendings
      .stream()
      .filter(l -> l.getBook().equals(book) && l.getUser().equals(user))
      .findFirst()
      .orElse(null);
    if (lending != null) {
      lendings.remove(lending);
      System.out.println(
        "Book returned: " + book.getTitle() + " by " + user.getName()
      );
    } else {
      System.out.println("Book not found.");
    }
  }

  /**
   * Nær í alla notendanöfn í kerfinu.
   * @return Listi yfir nöfn allra notenda.
   */
  public List<String> getAllUserNames() {
    return users
      .values()
      .stream()
      .map(User::getName)
      .collect(Collectors.toList());
  }

  /**
   * Nær í allar útlánaskráningar í kerfinu
   * @return Listi yfir útlánaskráningar í kerfinu.
   */
  public List<Lending> getAllLendings() {
    return lendings;
  }
}
