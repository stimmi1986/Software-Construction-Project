package is.hi.hbv202g.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Lýsir bók innan bókasafnskerfisins.
 * Hver bók hefur titil og einn eða fleiri höfunda.
 */
public class Book {

  private String title; // Titill bókarinnar
  private List<Author> authors; // Listi yfir höfunda bókarinnar

  /**
   * Smiður sem býr til bók með einum höfundi.
   * @param title Titill bókarinnar.
   * @param authorName Nafn höfundarins.
   */
  public Book(String title, String authorName) {
    this.title = title;
    this.authors = new ArrayList<>();
    this.authors.add(new Author(authorName));
  }

  /**
   * Smiður sem býr til bók með lista af höfundum.
   * @param title Titill bókarinnar.
   * @param authors Listi af höfundum bókarinnar.
   */
  public Book(String title, List<Author> authors) {
    this.title = title;
    this.authors = new ArrayList<>(authors);
  }

  /**
   * Nær í titil bókarinnar.
   * @return Titill bókarinnar.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Setur titil bókarinnar.
   * @param title Nýr titill fyrir bókina.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Nær í lista yfir höfunda bókarinnar.
   * @return Listi yfir höfunda.
   */
  public List<Author> getAuthors() {
    return this.authors;
  }

  /**
   * Setur höfunda bókarinnar.
   * @param authors Nýr listi yfir höfunda.
   */
  public void setAuthors(List<Author> authors) {
    this.authors = new ArrayList<>(authors);
  }

  /**
   * Bætir við nýjum höfundi að bókinni.
   * @param author Höfundur sem á að bæta við.
   */
  public void addAuthor(Author author) {
    this.authors.add(author);
  }

  // Dæmi um aðferðir sem gætu þurft frekari útfærslu eða hafa ekki verið útfærðar
  public String getDueDate() {
    throw new UnsupportedOperationException(
      "Unimplemented method 'getDueDate'"
    );
  }

  public String getBookCount() {
    throw new UnsupportedOperationException(
      "Unimplemented method 'getBookCount'"
    );
  }
}
