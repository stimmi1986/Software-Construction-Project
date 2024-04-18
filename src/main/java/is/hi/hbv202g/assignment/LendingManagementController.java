package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller fyrir útlánastjórnun í bókasafnskerfi.
 * Veitir viðmóti fyrir notanda til að lána og skila bókum, og fylgist með útlánum.
 */
public class LendingManagementController {

  @FXML
  private TextField bookTitleField;

  @FXML
  private TextField userNameField;

  @FXML
  private ListView<Lending> lendingsListView;

  @FXML
  private Label messageLabel;

  private final LibrarySystem librarySystem;

  /**
   * Smiður sem tengir þennan controller við LibrarySystem.
   */
  public LendingManagementController() {
    librarySystem = LibrarySystem.getInstance();
  }

  /**
   * Upphafsstilla viðmót þegar það er hlaðið.
   */
  public void initialize() {
    updateLendingsListView();
  }

  /**
   * Uppfærir lista yfir útlán á viðmóti.
   */
  private void updateLendingsListView() {
    lendingsListView.setItems(
      FXCollections.observableArrayList(librarySystem.getAllLendings())
    );
  }

  /**
   * Meðhöndlar atburð þegar lánað er bók.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
  public void handleLendBook(ActionEvent actionEvent) {
    String bookTitle = bookTitleField.getText();
    String userName = userNameField.getText();
    Book book = librarySystem.findBookByTitle(bookTitle);
    User user = librarySystem.findUserByName(userName);

    if (book != null && user != null) {
      librarySystem.borrowBook(user, book);
      updateLendingsListView();
      messageLabel.setText("Book loaned successfully.");
    } else {
      messageLabel.setText("User or book not found");
      System.out.println("Book or user not found");
    }
  }

  /**
   * Meðhöndlar atburð þegar bók er skilað.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
  public void handleReturnBook(ActionEvent actionEvent) {
    String bookTitle = bookTitleField.getText();
    String userName = userNameField.getText();
    Book book = librarySystem.findBookByTitle(bookTitle);
    User user = librarySystem.findUserByName(userName);

    if (book != null && user != null) {
      librarySystem.returnBook(user, book);
      updateLendingsListView();
      messageLabel.setText("Book returned successfully.");
    } else {
      messageLabel.setText("Book or user not found");
      System.out.println("Book or user not found");
    }
  }

  /**
   * Meðhöndlar atburð til að snúa aftur í aðalviðmótið.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
  @FXML
  public void onBack(ActionEvent actionEvent) {
    LibraryApplication.loadMainDashboardScene();
  }
}
