package is.hi.hbv202g.assignment;

import javafx.event.ActionEvent;

import java.io.InputStreamReader;

public class MainDashboardController {
    public void showBookManagement(ActionEvent actionEvent) {
        LibraryApplication.loadBookManagementScene();
    }

    public void showUserManagement(ActionEvent actionEvent) {
        LibraryApplication.loadUserManagementScene();
    }

    public void showLendingManagement(ActionEvent actionEvent) {
        LibraryApplication.loadLendingManagementScene();
    }
}
