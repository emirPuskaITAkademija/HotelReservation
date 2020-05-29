package app.controller.events;

import app.business.FacadeFactory;
import app.business.model.User;
import app.controller.Controller;
import app.gui.admin.UserAdminPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * 
 * DZ : clear input fields
 * <li>
 * hash lozinke
 * JEDNOSMJERNA ulica -> MD5, SHA256 ..
 * 
 * ferida123 -> text +  miskanje = hashovanu lozinku u bazi
 * <li> 1. ferida.bobar  -> ferida123 
 * 
 * ferida123 = ferida123 + hash = hashovanuVrijednostUnosa
 * if(hashovanuVrijednostUnosa.equals(hashovaniPassrod)->
 * 
 * 
 * @author emir
 */
public class AddUserEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        UserAdminPanel userAdminPanel = Controller.getInstance().getAdminView().getUserAdminPanel();
        User user = new User(null, userAdminPanel.getUsernameTextField().getText(), 
                userAdminPanel.getPasswordField().getText(), 
                userAdminPanel.getNameField().getText(),
                userAdminPanel.getSurnameField().getText());
        user.setIdPrivilege(userAdminPanel.getPrivilegedChoiceBox().getValue());
        //snimit usera u bazu
        FacadeFactory.getFacade().saveUser(user);
        //osvjezi tabelu 
        userAdminPanel.reloadTableData();
    }
}