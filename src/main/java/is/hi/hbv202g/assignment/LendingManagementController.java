package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class LendingManagementController {
    public TextField bookTitleField;
    public TextField userNameField;
    public ListView<Lending> lendingsListView;

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

    public void onBack(ActionEvent actionEvent) {
        LibraryApplication.loadMainDashboardScene();
    }
}
