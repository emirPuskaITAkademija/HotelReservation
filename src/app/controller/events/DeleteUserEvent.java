/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.events;

import app.business.FacadeFactory;
import app.business.model.User;
import app.controller.Controller;
import app.gui.admin.UserAdminPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author emir
 */
public class DeleteUserEvent implements EventHandler<ActionEvent>{
      @Override
    public void handle(ActionEvent event) {
        UserAdminPanel userAdminPanel = Controller.getInstance().getAdminView().getUserAdminPanel();
        User user = userAdminPanel.getSelectedUser();
        if (user != null) {
            FacadeFactory.getFacade().deleteUser(user);
            userAdminPanel.reloadTableData();
        }

    }
}
