package app;

import app.controller.Controller;
import app.gui.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Hajmo sada organizovati ovu aplikaciju po nekim principima
 * <p>
 * Ideja je da imamo glavnu klasu sa MAIn metodom.
 * <p>
 * Ostatak klasa ćemo orgaizirati u tri dijela:
 * <li> 1. GUI
 * <li> 2. Controller -> Singleton objekat
 * <li> 3. Model -> ORM  odnosno Biznis klasa sa entitetima i sva komunikacija
 * prema modelu ide preko Facade koja će biti interface unutar kojeg su pobrojane metode koje su neophodne našoj JavaFx
 * FacadeFactory
 * 
 * <p>
 * 
 * @author Grupa2
 */
public class HotelApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 
        //LoginView ekran
        LoginView loginView = new LoginView();
        Controller.getInstance().setLoginView(loginView);
        Controller.getInstance().setPrimaryStage(primaryStage);
        //Ferida i Kaniti -> svima isto bez obzira da li se radi o admin ili običnom
        Scene scene = new Scene(loginView, 650, 180);
        primaryStage.setTitle(" Hotel Managment application LOGIN");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
