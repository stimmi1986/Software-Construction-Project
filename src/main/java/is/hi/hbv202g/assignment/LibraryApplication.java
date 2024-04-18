package is.hi.hbv202g.assignment;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Aðalforritið sem keyrir bókasafnskerfið með JavaFX notendaviðmóti.
 * Stjórnar mismunandi skjáum eins og innskráningu, aðalstjórnborði, bókastjórnun,
 * notendastjórnun og útlánastjórnun.
 */
public class LibraryApplication extends Application {

  private static Stage primaryStage; // Aðal svið forritsins

  /**
   * Byrjar forritið og stillir upp aðalglugga.
   * @param primaryStage Aðal svið JavaFX forritsins.
   */
  @Override
  public void start(Stage primaryStage) {
    LibraryApplication.primaryStage = primaryStage;
    loadSignInScene();
    primaryStage.setTitle("Library System");
    primaryStage.show();
  }

  /**
   * Hleður innskráningarskjá.
   */
  public static void loadSignInScene() {
    try {
      FXMLLoader loader = new FXMLLoader(
        LibraryApplication.class.getResource("LoginScreen.fxml")
      );
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Hleður aðalstjórnborðsskjá.
   */
  public static void loadMainDashboardScene() {
    try {
      FXMLLoader loader = new FXMLLoader(
        LibraryApplication.class.getResource("MainDashboard.fxml")
      );
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Hleður bókastjórnunarskjá.
   */
  public static void loadBookManagementScene() {
    try {
      FXMLLoader loader = new FXMLLoader(
        LibraryApplication.class.getResource("BookManagement.fxml")
      );
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Hleður notendastjórnunarskjá.
   */
  public static void loadUserManagementScene() {
    try {
      FXMLLoader loader = new FXMLLoader(
        LibraryApplication.class.getResource("UserManagement.fxml")
      );
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Hleður útlánastjórnunarskjá.
   */
  public static void loadLendingManagementScene() {
    try {
      FXMLLoader loader = new FXMLLoader(
        LibraryApplication.class.getResource("LendingManagement.fxml")
      );
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Aðalforrit sem byrjar JavaFX forritið.
   * @param args Færibreytur frá línuafskipun.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
