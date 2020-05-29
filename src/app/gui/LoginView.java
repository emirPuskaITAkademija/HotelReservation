package app.gui;

import app.controller.Controller;
import app.controller.events.EventBus;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

//JPanel + GridLayot = GridPane
public class LoginView extends GridPane {

    private final Label usernameLabel = new Label("Korisničko ime:");
    private final TextField usernameTextField = new TextField();
    private final Label passwordLabel = new Label("Lozinka:");
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Prijava");
    private final Button cancelButton = new Button("Odustani");
    private final Label messageLabel = new Label();

    public LoginView() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        setAlignment(Pos.CENTER);

        add(usernameLabel, 0, 0);
        add(usernameTextField, 1, 0);

        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);

        //FlowLayout + JPanel =  FlowPane
        //loginButton + cancelButton = FlowPane
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.getChildren().addAll(loginButton, cancelButton);
        add(flowPane, 1, 2);

        add(messageLabel, 1, 3);
        
        //oživit ćemo ih preko Controller
        Controller controller = Controller.getInstance();
        EventBus eventBus = controller.getEventBus();
        loginButton.setOnAction(eventBus.getLoginEvent());
        cancelButton.setOnAction(eventBus.getCancelEvent());
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

}
