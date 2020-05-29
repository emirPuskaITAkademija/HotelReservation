package app.controller.events;

import app.business.FacadeFactory;
import app.business.model.User;
import app.controller.Controller;
import app.controller.constants.Constants;
import app.gui.LoginView;
import app.gui.admin.AdminView;
import app.gui.user.UserView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class LoginEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        LoginView loginView = Controller.getInstance().getLoginView();
        String username = loginView.getUsernameTextField().getText();
        String password = loginView.getPasswordField().getText();
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            loginView.getMessageLabel().setText(Constants.EMPTY_USERNAME_PASSWORD_NOT_ALLOWED);
            return;
        }
        User user = FacadeFactory.getFacade().login(username, password);
        if(user == null){
            loginView.getMessageLabel().setText(Constants.BAD_USERNAME_PASSWORD_COMBINATION);
        }else{
            BorderPane view;//BorderLayout + JPanel = BorderPane
            Controller.getInstance().setLoggedUser(user);
            //ADMINISTRATOR
            if(Constants.ADMIN.equals(user.getIdPrivilege().getName())){
                view = new AdminView();
                Controller.getInstance().setAdminView((AdminView)view);
                Controller.getInstance().getPrimaryStage().setTitle("Admin panel: " + user.getName()+" "+user.getSurname());
            }else{
                view = new UserView();
                Controller.getInstance().setUserView((UserView) view);
                Controller.getInstance().getPrimaryStage().setTitle("Panel :" + user.getName()+" " + user.getSurname());
            }
            Scene scene = new Scene(view, 650, 300);
            Controller.getInstance().getPrimaryStage().setScene(scene);
        }
    }
}
