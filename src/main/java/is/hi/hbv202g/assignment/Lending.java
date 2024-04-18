package is.hi.hbv202g.assignment;

import java.time.LocalDate;

/**
 * Lýsir útláni bókar til notanda.
 * Inniheldur upplýsingar um bókina, notandann sem fékk bókina og skiladag.
 *
 * @author Nafn höfundar
 * @version 1.0
 */
public class Lending {

  private LocalDate dueDate; // Skiladagur bókar
  private Book book; // Bókin sem er útlánuð
  private User user; // Notandinn sem lánar bókina

  /**
   * Smiður fyrir Lending.
   * Býr til útlán með sjálfgefnum skiladegi sem er 30 dagar frá útlánsdegi.
   *
   * @param book Bókin sem er útlánuð.
   * @param user Notandinn sem lánar bókina.
   */
  public Lending(Book book, User user) {
    this.book = book;
    this.user = user;
    this.dueDate = LocalDate.now().plusDays(30); // Skiladagur setur 30 daga frá núverandi dagsetningu
  }

  /**
   * Nær í skiladag útlánsins.
   * @return Skiladagur bókarinnar.
   */
  public LocalDate getDueDate() {
    return this.dueDate;
  }

  /**
   * Setur nýjan skiladag fyrir útlánið.
   * @param dueDate Nýr skiladagur.
   */
  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  /**
   * Nær í bókina sem er útlánuð.
   * @return Bókin sem er útlánuð.
   */
  public Book getBook() {
    return this.book;
  }

  /**
   * Setur nýja bók fyrir útlánið.
   * @param book Ný bók til að setja í útlánið.
   */
  public void setBook(Book book) {
    this.book = book;
  }

  /**
   * Nær í notandann sem lánar bókina.
   * @return Notandinn sem lánar bókina.
   */
  public User getUser() {
    return this.user;
  }

  /**
   * Setur nýjan notanda fyrir útlánið.
   * @param user Nýr notandi til að setja í útlánið.
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Skilar lýsandi streng fyrir útlánið.
   * @return Strengur sem lýsir bókinni, notandanum og skiladegi.
   */
  @Override
  public String toString() {
    return (
      book.getTitle() +
      " loaned by " +
      user.getName() +
      ". Due date is: " +
      dueDate
    );
  }
}
