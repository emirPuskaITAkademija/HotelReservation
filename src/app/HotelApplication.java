package app;

import app.controller.Controller;
import app.controller.constants.Constants;
import app.gui.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hajmo sada organizovati ovu aplikaciju po nekim principima
 * <p>
 * Ideja je da imamo glavnu klasu sa MAIN metodom. Naravno, ta klasa MORA
 * extends Application.
 * <p>
 * Čemu služi glavna klasa ? JavaFx GUI aplikaciju kreiramo unutar te glavne
 * klase.
 * <p>
 *
 * <p>
 * Ostatak klasa ćemo orgaizirati u tri dijela:
 * <li> 1. GUI -> LoginView ..neke druge ekrane: AdminView,UserView -> KONTEJNER
 * -> HBox, VBox, BorderPane, GridPane
 * <li> 2. Controller -> Singleton objekat : @ApplicationScoped, @SessionScoped,
 * @RequestScoped Controller INSTANCE -> FacesServlet
 *
 * <li> 3. Model -> ORM odnosno Biznis klasa sa entitetima i sva komunikacija
 * prema modelu ide preko Facade koja će biti interface unutar kojeg su
 * pobrojane metode koje su neophodne našoj JavaFx FacadeFactory
 *
 * <p>
 *
 * @author emir
 */
public class HotelApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        Controller controller  = Controller.getInstance();
        controller.setLoginView(loginView);
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(loginView, 650, 180);
        primaryStage.setTitle(Constants.LOGIN_VIEW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
