package is.hi.hbv202g.assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class LibrarySystem {

  private final Map<String, Book> books = new HashMap<>();
  private final Map<String, User> users = new HashMap<>();
  private final List<Lending> lendings = new ArrayList<>();
  @FXML
  private Label messageLabel;

  private static final LibrarySystem instance = new LibrarySystem();

  public LibrarySystem() {
    System.out.println("Library System created");
    initializeDefaultData();
  }

  private void initializeDefaultData() {
    System.out.println("Initializing default data...");
    addBookWithTitleAndNameOfSingleAuthor("Book of Love", "Jane Doe");
    addBookWithTitleAndNameOfSingleAuthor("Exploring JavaFX", "John Doe");
    addBookWithTitleAndNameOfSingleAuthor("The Great Gatsby", "F. Scott Fitzgerald");
    addBookWithTitleAndNameOfSingleAuthor("The Catcher in the Rye", "J. D. Salinger");
    addBookWithTitleAndAuthorList("The Hobbit",Arrays.asList(new Author("J. R. R. Tolkien")));
    addBookWithTitleAndAuthorList("The Lord of the Rings", Arrays.asList(new Author("J. R. R. Tolkien")));
    addBookWithTitleAndAuthorList("The Fellowship of the Ring", Arrays.asList(new Author("J. R. R. Tolkien")));
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

  public static LibrarySystem getInstance() {
    return instance;
  }

  public Collection<Book> getAllBooks() {
    return books.values();
  }

  public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
    if (!books.containsKey(title)) {
      Book newBook = new Book(title, Arrays.asList(new Author(authorName)));
      books.put(title, newBook);
      System.out.println("Book added: " + title + " by " + authorName);
    }
  }

  public void addBookWithTitleAndAuthorList(String title, List<Author> authors) {
    if (!books.containsKey(title)) {
      Book newBook = new Book(title, authors);
      books.put(title, newBook);
      System.out.println("Book added with multiple authors: " + title);
    }
  }

  public void addStudentUser(String name, boolean feePaid) {
    User newUser = new Student(name, feePaid);
    users.put(name, newUser);
    System.out.println("Student user added: " + name);
  }

  public void addFacultyMemberUser(String name, String department) {
    User newUser = new FacultyMember(name, department);
    users.put(name, newUser);
    System.out.println("Faculty member added: " + name);
  }

  public Book findBookByTitle(String title) {
    return books.get(title);
  }

  public User findUserByName(String name) {
    return users.get(name);
  }

  public void borrowBook(User user, Book book) {
    if (users.containsValue(user) && books.containsValue(book)) {
      Lending lending = new Lending(book, user);
      lendings.add(lending);
      System.out.println("Book borrowed: " + book.getTitle() + " by " + user.getName());
      System.out.println("Due date: " + lending.getDueDate());
    } else {
      System.out.println("User or book not found.");
    }
  }

  public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
    Lending lending = lendings.stream()
            .filter(l -> l.getBook().equals(book) && l.getUser().equals(facultyMember))
            .findFirst()
            .orElse(null);
    if (lending != null) {
      lending.setDueDate(newDueDate);
      System.out.println("Lending extended for book: " + book.getTitle() + " to " + newDueDate);
    } else {
      System.out.println("Lending not found.");
    }
  }

  public void returnBook(User user, Book book) {
    Lending lending = lendings.stream()
            .filter(l -> l.getBook().equals(book) && l.getUser().equals(user))
            .findFirst()
            .orElse(null);
    if (lending != null) {
      lendings.remove(lending);
      System.out.println("Book returned: " + book.getTitle() + " by " + user.getName());
    } else {
      System.out.println("Book not found.");
    }
  }

  public List<String> getAllUserNames() {
    return users.values().stream().map(User::getName).collect(Collectors.toList());
  }

  public List<Lending> getAllLendings() {
    return lendings;
  }


}
