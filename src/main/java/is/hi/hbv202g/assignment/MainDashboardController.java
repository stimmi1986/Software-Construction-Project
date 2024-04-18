package is.hi.hbv202g.assignment;

import javafx.event.ActionEvent;

/**
 * Controller fyrir aðalstjórnborðsskjá bókasafnskerfisins.
 * Veitir aðgang að öðrum stjórnborðsskjám eins og bókastjórnun, notendastjórnun,
 * og útlánastjórnun, og möguleika á að útskrá notanda.
 */
public class MainDashboardController {

  /**
   * Sýnir bókastjórnunarskjáinn.
   * @param actionEvent Viðburðurinn sem gefur til kynna aðgerðina.
   */
  public void showBookManagement(ActionEvent actionEvent) {
    LibraryApplication.loadBookManagementScene();
  }

  /**
   * Sýnir notendastjórnunarskjáinn.
   * @param actionEvent Viðburðurinn sem gefur til kynna aðgerðina.
   */
  public void showUserManagement(ActionEvent actionEvent) {
    LibraryApplication.loadUserManagementScene();
  }

  /**
   * Sýnir útlánastjórnunarskjáinn.
   * @param actionEvent Viðburðurinn sem gefur til kynna aðgerðina.
   */
  public void showLendingManagement(ActionEvent actionEvent) {
    LibraryApplication.loadLendingManagementScene();
  }

  /**
   * Meðhöndlar útskráningu notanda og fer aftur á innskráningarskjá.
   * @param actionEvent Viðburðurinn sem gefur til kynna aðgerðina.
   */
  public void handleLogout(ActionEvent actionEvent) {
    LibraryApplication.loadSignInScene();
  }
}
