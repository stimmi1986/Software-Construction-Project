package is.hi.hbv202g.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controller fyrir notendastjórnunarskjáinn í bókasafnskerfinu.
 * Stjórnar bætingu og sýningu notenda, hvort sem er nemendur eða kennarar.
 */
public class UserManagementController {

  @FXML
  private TextField nameField; // Textasvið fyrir nafn notanda

  @FXML
  private TextField studentFeeField; // Textasvið fyrir greiðslustöðu nemenda

  @FXML
  private TextField facultyDepartmentField; // Textasvið fyrir deild kennara

  @FXML
  private ComboBox<String> userTypeComboBox; // Valbox fyrir tegund notanda

  @FXML
  private ListView<String> usersListView; // Listasýning fyrir nöfn notenda

  private LibrarySystem librarySystem; // Vísun í bókasafnkerfið

  /**
   * Smiður sem tengir þennan controller við LibrarySystem.
   */
  public UserManagementController() {
    this.librarySystem = LibrarySystem.getInstance();
  }

  /**
   * Upphafsstilling viðmóts þegar það er hlaðið.
   */
  public void initialize() {
    userTypeComboBox.setItems(
      FXCollections.observableArrayList("Student", "FacultyMember")
    );
    userTypeComboBox
      .getSelectionModel()
      .selectedItemProperty()
      .addListener((options, oldValue, newValue) -> {
        boolean isStudent = "Student".equals(newValue);
        studentFeeField.setVisible(isStudent);
        facultyDepartmentField.setVisible(!isStudent);
      });
  }

  /**
   * Meðhöndlar viðburð til að bæta við nýjum notanda.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
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

  /**
   * Uppfærir listann yfir notendur á viðmóti.
   */
  private void refreshUsersListView() {
    ObservableList<String> userNames = FXCollections.observableArrayList(
      librarySystem.getAllUserNames()
    );
    usersListView.setItems(userNames);
  }

  /**
   * Hreinsar allar inntaksreitir á viðmótinu.
   */
  private void clearForm() {
    nameField.clear();
    studentFeeField.clear();
    facultyDepartmentField.clear();
    userTypeComboBox.getSelectionModel().clearSelection();
  }

  /**
   * Meðhöndlar atburð til að fara aftur í aðalstjórnborðsskjáinn.
   * @param actionEvent Atburðurinn sem gefur til kynna aðgerðina.
   */
  public void onBack(ActionEvent actionEvent) {
    LibraryApplication.loadMainDashboardScene();
  }
}
