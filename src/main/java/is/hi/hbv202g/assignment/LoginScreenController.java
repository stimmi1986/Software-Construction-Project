package is.hi.hbv202g.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreenController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void handleLogin(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Login button pressed");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        if (validateCredentials(username, password)) {
            System.out.println("Login successful");
            LibraryApplication.loadMainDashboardScene();
        } else {
            System.out.println("Login failed");
        }
    }

    private boolean validateCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("database/users.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
