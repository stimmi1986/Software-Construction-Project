package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

class Book {

  private String title;
  private List<Author> authors;

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book(String title, String authorName) {
    this.title = title;
    this.authors = new ArrayList<>();
    this.authors.add(new Author(authorName));
  }

  public Book(String title, List<Author> authors) {
    this.title = title;
    this.authors = authors;
  }

  public List<Author> getAuthors() {
    return this.authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  public void addAuthor(Author author) {
    this.authors.add(author);
  }
}
