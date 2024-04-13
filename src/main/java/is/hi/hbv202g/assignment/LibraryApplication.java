package is.hi.hbv202g.assignment;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryApplication extends Application {

  private static Stage primaryStage;

  @Override
  public void start(Stage primaryStage) {
    LibraryApplication.primaryStage = primaryStage;
    loadSignInScene();
    primaryStage.setTitle("Library System");
    primaryStage.show();
  }

  public void loadSignInScene() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadMainDashboardScene() {
    try {
      FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("MainDashboard.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadBookManagementScene() {
    try {
      FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("BookManagement.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadUserManagementScene() {
    try {
      FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("UserManagement.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadLendingManagementScene() {
    try {
      FXMLLoader loader = new FXMLLoader(LibraryApplication.class.getResource("LendingManagement.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
    LibrarySystem myLibrarySystem = new LibrarySystem();
    launch(args);
  }
}
