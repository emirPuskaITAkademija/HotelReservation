package app.controller.events;

public class EventBus {

    private final LoginEvent loginEvent = new LoginEvent();
    private final CancelEvent cancelEvent = new CancelEvent();
    private final LogoutEvent logoutEvent = new LogoutEvent();
    private final AddUserEvent addUserEvent = new AddUserEvent();
    private final DeleteUserEvent deleteUserEvent = new DeleteUserEvent();

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }

    public CancelEvent getCancelEvent() {
        return cancelEvent;
    }

    public LogoutEvent getLogoutEvent() {
        return logoutEvent;
    }

    public AddUserEvent getAddUserEvent() {
        return addUserEvent;
    }

    public DeleteUserEvent getDeleteUserEvent() {
        return deleteUserEvent;
    }
    
    

}
