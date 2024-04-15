package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UserManagementController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField studentFeeField;
    @FXML
    private TextField facultyDepartmentField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private ListView<String> usersListView;

    private LibrarySystem librarySystem;

    public UserManagementController() {
        this.librarySystem = LibrarySystem.getInstance();
    }

    public void initialize() {
        userTypeComboBox.setItems(FXCollections.observableArrayList("Student", "FacultyMember"));
        userTypeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            boolean isStudent = "Student".equals(newValue);
            studentFeeField.setVisible(isStudent);
            facultyDepartmentField.setVisible(!isStudent);
        });
    }

    public void handleAddUser(ActionEvent actionEvent) {
        String name = nameField.getText();
        String userType = userTypeComboBox.getValue();
        if (name == null || name.isEmpty() || userType == null) {
            System.out.println("Please enter a name and select a user type.");
            return;
        }

        if ("Student".equals(userType)) {
            boolean feePaid = Boolean.parseBoolean(studentFeeField.getText());
            librarySystem.addStudentUser(name, feePaid);
        } else if ("FacultyMember".equals(userType)) {
            String department = facultyDepartmentField.getText();
            librarySystem.addFacultyMemberUser(name, department);
        }
        refreshUsersListView();
        clearForm();
    }

    private void refreshUsersListView() {
        ObservableList<String> userNames = FXCollections.observableArrayList(librarySystem.getAllUserNames());
        usersListView.setItems(userNames);
    }

    private void clearForm() {
        nameField.clear();
        studentFeeField.clear();
        facultyDepartmentField.clear();
        userTypeComboBox.getSelectionModel().clearSelection();
    }

    public void onBack(ActionEvent actionEvent) {
        LibraryApplication.loadMainDashboardScene();
    }
}
