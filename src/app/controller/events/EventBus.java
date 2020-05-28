package app.controller.events;

public class EventBus {

    private final LoginEvent loginEvent = new LoginEvent();
    private final CancelEvent cancelEvent = new CancelEvent();
    private final LogoutEvent logoutEvent = new LogoutEvent();

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }

    public CancelEvent getCancelEvent() {
        return cancelEvent;
    }

    public LogoutEvent getLogoutEvent() {
        return logoutEvent;
    }

}
