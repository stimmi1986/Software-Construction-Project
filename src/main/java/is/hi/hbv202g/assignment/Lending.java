package is.hi.hbv202g.assignment;

import java.time.LocalDate;

class Lending {

  private LocalDate dueDate;
  private Book book;
  private User user;

  public Lending(Book book, User user) {
    this.book = book;
    this.user = user;
    this.dueDate = LocalDate.now().plusDays(30);
  }

  public LocalDate getDueDate() {
    return this.dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public Book getBook() {
    return this.book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return book.getTitle() + " loaned by " + user.getName() + ". Due date is: " + dueDate;
  }

}
