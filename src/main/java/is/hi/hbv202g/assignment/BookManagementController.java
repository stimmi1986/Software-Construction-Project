package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BookManagementController {

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private ListView<Book> booksListView;

    private LibrarySystem librarySystem;

    public BookManagementController() {
        librarySystem = LibrarySystem.getInstance();
    }

    @FXML
    public void initialize() {
        updateBooksListView();
    }

    private void updateBooksListView() {
        booksListView.setItems(FXCollections.observableArrayList(librarySystem.getAllBooks()));
        booksListView.setCellFactory(param -> new ListCell<Book>() {
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);
                if (empty || book == null) {
                    setText(null);
                } else {
                    setText(book.getTitle() + " by " + book.getAuthors().get(0).getName());
                }
            }
        });
    }

    @FXML
    public void handleAddBook(ActionEvent actionEvent) {
        String title = titleTextField.getText();
        String authorName = authorTextField.getText();

        if (title.isEmpty() || authorName.isEmpty()) {
            // Handle error: Title or Author is empty.
            System.out.println("Book title and author are required.");
            return;
        }

        librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        updateBooksListView();
        clearForm();
    }

    private void clearForm() {
        titleTextField.clear();
        authorTextField.clear();
    }

    @FXML
    public void onBack(ActionEvent actionEvent) {
        LibraryApplication.loadMainDashboardScene();
    }
}
