package app.gui.admin;

import app.business.FacadeFactory;
import app.business.model.Privilege;
import app.business.model.User;
import app.controller.Controller;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//USER panel administratorima -> usere -> izbrisati usera, dodavanje novog usera, izmijeniti mozda ime useru

public class UserAdminPanel extends VBox {

    private Label titleLabel = new Label("Administracija korisnika");
    //TableView<User>
    private final TableView<User> userTableView = new TableView<>();
    private List<User> users = null;

    private TextField usernameTextField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private TextField nameTextField = new TextField();
    private TextField surnameTextField = new TextField();
    //ComboBox
    private ChoiceBox<Privilege> privilegedChoiceBox = new ChoiceBox<>();

    private Button addUserButton = new Button("Dodaj");
    private Button deleteUserButton = new Button("Obriši");

    public UserAdminPanel() {
        titleLabel.setFont(new javafx.scene.text.Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));

        try {
            users = FacadeFactory.getFacade().getAllUsers();
        } catch (Exception ex) {
            users = new ArrayList<>();
        }

        //username, name, surname, privilege
        TableColumn usernameColumn = new TableColumn("Korisničko ime");
        usernameColumn.setMinWidth(150);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));

        TableColumn nameColumn = new TableColumn("Ime");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        //EDITOVANJE JEDNE KOLONE
        //TextField
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //Kad zavrsim editovanje kroz TextField sta cu raditi
        nameColumn.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
            @Override
            public void handle(CellEditEvent<User, String> cellEditEvent) {
                int indexReda = cellEditEvent.getTablePosition().getRow();
                User user = cellEditEvent.getTableView().getItems().get(indexReda);
                String staruVrijednostImena = cellEditEvent.getOldValue();
                String novuVrijednostImena = cellEditEvent.getNewValue();
                user.setName(novuVrijednostImena);
                System.out.println("OLD: " + cellEditEvent.getOldValue());
                System.out.println("NEW NAME: " + cellEditEvent.getNewValue());
                FacadeFactory.getFacade().updateUser(user);
            }
        });

        TableColumn surnameColumn = new TableColumn("Prezime");
        surnameColumn.setMinWidth(100);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));

        TableColumn privilegeColumn = new TableColumn("Privilegija");
        privilegeColumn.setMinWidth(150);
        privilegeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("idPrivilege"));

        ObservableList<User> observabilnaListaUsera = FXCollections.observableArrayList(users);
        userTableView.setItems(observabilnaListaUsera);
        userTableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, privilegeColumn);
        userTableView.setEditable(true);
        
        HBox formaZaDodavanjeKorisnika = createFormForAddingUser();
        getChildren().addAll(titleLabel, userTableView, formaZaDodavanjeKorisnika);
    }

    private HBox createFormForAddingUser() {
        HBox hbox = new HBox();
        hbox.setSpacing(3);

        usernameTextField.setMaxWidth(75);
        usernameTextField.setPromptText("Kor. ime");

        passwordField.setMaxWidth(75);
        passwordField.setPromptText("Lozinka");

        nameTextField.setMaxWidth(100);
        nameTextField.setPromptText("Ime");

        surnameTextField.setMaxWidth(100);
        surnameTextField.setPromptText("Prezime");

        //combo box 
        List<Privilege> privileges = FacadeFactory.getFacade().getAllPrivileges();
        //list ne radi moja tabela, ne radi moj choice box ... UI controls ne rade sa lista nego rade sa observabilnim listama
        ObservableList<Privilege> observablePrivileges = FXCollections.observableArrayList(privileges);
        privilegedChoiceBox.setItems(observablePrivileges);
        privilegedChoiceBox.getSelectionModel().select(0);
        privilegedChoiceBox.setMaxWidth(150);

        hbox.getChildren().addAll(usernameTextField, passwordField, nameTextField, surnameTextField, privilegedChoiceBox, addUserButton, deleteUserButton);
        addUserButton.setOnAction(Controller.getInstance().getEventBus().getAddUserEvent());
        deleteUserButton.setOnAction(Controller.getInstance().getEventBus().getDeleteUserEvent());
        return hbox;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getNameField() {
        return nameTextField;
    }

    public TextField getSurnameField() {
        return surnameTextField;
    }

    public ChoiceBox<Privilege> getPrivilegedChoiceBox() {
        return privilegedChoiceBox;
    }

    public void clearAllFields() {
        usernameTextField.setText("");
        passwordField.setText("");
        nameTextField.setText("");
        surnameTextField.setText("");
        privilegedChoiceBox.getSelectionModel().select(0);
    }

    public void reloadTableData() {
        try {
            users = FacadeFactory.getFacade().getAllUsers();
        } catch (Exception ex) {
            users = new ArrayList<>();
        }
        ObservableList<User> observableUsers = FXCollections.observableArrayList(users);
        userTableView.setItems(observableUsers);
    }

    public User getSelectedUser() {
        return userTableView.getSelectionModel().getSelectedItem();
    }
}
