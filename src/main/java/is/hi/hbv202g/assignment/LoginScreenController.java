package is.hi.hbv202g.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller fyrir innskráningarskjá í bókasafnskerfinu.
 * Stjórnar innskráningaraðgerðum og vinnur úr notendanöfnum og lykilorðum.
 */
public class LoginScreenController {

  @FXML
  private TextField usernameField; // Textareitur fyrir notendanafn

  @FXML
  private PasswordField passwordField; // Textareitur fyrir lykilorð

  @FXML
  private Label loginLabel; // Label sem sýnir skilaboð við innskráningu

  /**
   * Meðhöndlar innskráningarviðburð þegar notandi ýtir á innskráningahnappinn.
   * @param actionEvent Viðburðurinn sem gefur til kynna að innskráningarhnappur var ýtt.
   */
  public void handleLogin(ActionEvent actionEvent) {
    String username = usernameField.getText();
    String password = passwordField.getText();

    System.out.println("Login button pressed");
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);

    if (validateCredentials(username, password)) {
      System.out.println("Login successful");
      LibraryApplication.loadMainDashboardScene(); // Skiptir yfir í aðalstjórnborðið
    } else {
      loginLabel.setText("Login failed"); // Birtir villuboð ef innskráning mistekst
    }
  }

  /**
   * Athugar hvort innskráningarupplýsingar passi við gögn í gagnagrunni.
   * @param username Notendanafn sem skal athuga.
   * @param password Lykilorð sem skal athuga.
   * @return Skilar true ef innskráning er rétt, annars false.
   */
  private boolean validateCredentials(String username, String password) {
    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(
          getClass().getResourceAsStream("database/users.txt")
        )
      )
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (
          parts.length == 2 &&
          parts[0].equals(username) &&
          parts[1].equals(password)
        ) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
