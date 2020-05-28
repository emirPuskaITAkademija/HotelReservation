package app.controller;

import app.business.model.User;
import app.controller.events.EventBus;
import app.gui.LoginView;
import app.gui.admin.AdminView;
import app.gui.user.UserView;
import javafx.stage.Stage;

/**
 * SINGLETON
 *
 * @author Grupa2
 */
public class Controller {

    //VIEWS
    private LoginView loginView;
    private UserView userView;
    private AdminView adminView;
    private final EventBus eventBus = new EventBus();
    private Stage primaryStage;
    //MODEL
    private User loggedUser;

    private Controller() {
        System.out.println("Kreiram Controller objekat");
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    private static Controller INSTANCE = null;

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }
}
