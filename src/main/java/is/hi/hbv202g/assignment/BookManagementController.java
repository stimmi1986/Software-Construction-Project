package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller fyrir bókastjórnunarskjáinn í bókasafnskerfinu.
 * Stjórnar bætingu og sýningu bóka.
 */
public class BookManagementController {

  @FXML
  private TextField titleTextField; // Textareitur fyrir titil bókar

  @FXML
  private TextField authorTextField; // Textareitur fyrir höfund bókar

  @FXML
  private ListView<Book> booksListView; // Listasýning fyrir bækur

  private LibrarySystem librarySystem; // Vísun í bókasafnkerfið

  /**
   * Smiður sem tengir þennan controller við LibrarySystem.
   */
  public BookManagementController() {
    librarySystem = LibrarySystem.getInstance();
  }

  /**
   * Upphafsstilling viðmóts þegar það er hlaðið.
   */
  @FXML
  public void initialize() {
    updateBooksListView();
  }

  /**
   * Uppfærir listann yfir bækur á viðmóti.
   */
  private void updateBooksListView() {
    booksListView.setItems(
      FXCollections.observableArrayList(librarySystem.getAllBooks())
    );
    booksListView.setCellFactory(param ->
      new ListCell<Book>() {
        @Override
        protected void updateItem(Book book, boolean empty) {
          super.updateItem(book, empty);
          if (empty || book == null) {
            setText(null);
          } else {
            setText(
              book.getTitle() + " by " + book.getAuthors().get(0).getName()
            );
          }
        }
      }
    );
  }

  /**
   * Meðhöndlar viðburð til að bæta við nýrri bók.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
  @FXML
  public void handleAddBook(ActionEvent actionEvent) {
    String title = titleTextField.getText();
    String authorName = authorTextField.getText();

    if (title.isEmpty() || authorName.isEmpty()) {
      System.out.println("Book title and author are required.");
      return;
    }

    librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
    updateBooksListView();
    clearForm();
  }

  /**
   * Hreinsar allar inntaksreitir á viðmótinu.
   */
  private void clearForm() {
    titleTextField.clear();
    authorTextField.clear();
  }

  /**
   * Meðhöndlar atburð til að fara aftur í aðalstjórnborðsskjáinn.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
  @FXML
  public void onBack(ActionEvent actionEvent) {
    LibraryApplication.loadMainDashboardScene();
  }
}
