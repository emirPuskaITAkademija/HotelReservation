package app.controller.events;

import app.controller.Controller;
import app.controller.constants.Constants;
import app.gui.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class LogoutEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        //Login ekran
        LoginView loginView = new LoginView();
        Controller.getInstance().setLoginView(loginView);

        Scene scene = new Scene(loginView, 650, 180);

        Controller.getInstance().getPrimaryStage().setTitle(Constants.LOGIN_VIEW_TITLE);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }
}
