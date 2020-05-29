package app.gui.admin;

import app.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//BorderLayout + JPanel = BorderPane

public class AdminView extends BorderPane {

    //uzajamno su isključivi kada ih dodamo u grupu-> odnosno jedan je aktivan samo unutar grupe
    private final ToggleButton userToggleButton = new ToggleButton("Korisnici");
    private final ToggleButton roomToggleButton = new ToggleButton("Sobe");
    //
    private final Button logoutToggleButton = new Button("Odjava");

    private UserAdminPanel userAdminPanel;
    private RoomAdminPanel roomAdminPanel;

    public AdminView() {

        //TABELA SA KORISNICIMA
        userAdminPanel = new UserAdminPanel();
        setCenter(userAdminPanel);

        ToggleGroup toggleGroup = new ToggleGroup();
        userToggleButton.setToggleGroup(toggleGroup);
        roomToggleButton.setToggleGroup(toggleGroup);

        userToggleButton.setSelected(true);

        HBox mainMenu = new HBox();
        mainMenu.setSpacing(5);
        mainMenu.setPadding(new Insets(10, 10, 10, 10));

        logoutToggleButton.setOnAction(Controller.getInstance().getEventBus().getLogoutEvent());
        logoutToggleButton.setText("Odjava (" + Controller.getInstance().getLoggedUser() + ")");
        mainMenu.getChildren().addAll(userToggleButton, roomToggleButton);

        userToggleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                userAdminPanel = new UserAdminPanel();
                setCenter(userAdminPanel);
            }
        });

        roomToggleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                roomAdminPanel = new RoomAdminPanel();
                setCenter(roomAdminPanel);
            }
        });

        HBox logoutBox = new HBox(logoutToggleButton);
        logoutBox.setAlignment(Pos.CENTER_RIGHT);
        logoutBox.setPadding(new Insets(10, 10, 10, 10));

        GridPane topPane = new GridPane();
        topPane.add(mainMenu, 0, 0);
        topPane.add(logoutBox, 1, 0);

        setTop(topPane);

    }

    public UserAdminPanel getUserAdminPanel() {
        return userAdminPanel;
    }

    public void setUserAdminPanel(UserAdminPanel userAdminPanel) {
        this.userAdminPanel = userAdminPanel;
    }

    public RoomAdminPanel getRoomAdminPanel() {
        return roomAdminPanel;
    }

    public void setRoomAdminPanel(RoomAdminPanel roomAdminPanel) {
        this.roomAdminPanel = roomAdminPanel;
    }

}
