package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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


    public LendingManagementController() {
        librarySystem = LibrarySystem.getInstance();
    }

    public void initialize() {
        updateLendingsListView();
    }

    private void updateLendingsListView() {
        lendingsListView.setItems(FXCollections.observableArrayList(librarySystem.getAllLendings()));

    }

    public void handleLendBook(ActionEvent actionEvent) {
        String bookTitle = bookTitleField.getText();
        String userName = userNameField.getText();
        Book book = librarySystem.findBookByTitle(bookTitle);
        User user = librarySystem.findUserByName(userName);

        if (book != null && user != null) {
            librarySystem.borrowBook(user, book);
            updateLendingsListView();
        } else {
            messageLabel.setText("User or book not found");
            System.out.println("Book or user not found");
        }
    }

    public void handleReturnBook(ActionEvent actionEvent) {
        String bookTitle = bookTitleField.getText();
        String userName = userNameField.getText();
        Book book = librarySystem.findBookByTitle(bookTitle);
        User user = librarySystem.findUserByName(userName);

        if (book != null && user != null) {
            librarySystem.returnBook(user, book);
            updateLendingsListView();
        } else {
            System.out.println("Book or user not found");}
    }

    @FXML
    public void onBack(ActionEvent actionEvent) {
        LibraryApplication.loadMainDashboardScene();
    }
}
