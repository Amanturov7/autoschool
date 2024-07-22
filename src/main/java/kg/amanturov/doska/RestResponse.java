package kg.amanturov.doska;

public class RestResponse {
    private Status status;
    private Object data;
    private String message;
    private boolean blocked;
    private boolean popup = false;

    public RestResponse(Object data) {
        this(Status.SUCCESS, data, false);
    }

    public RestResponse(Status status, Object data) {
        this(status, data, false);
    }

    public RestResponse(Status status, Object data, String message) {
        this(status, data, message, false);
    }

    public RestResponse(Status status, Object data, String message, boolean blocked) {
        this(status, data, message, blocked, false);
    }

    public RestResponse(Status status, Object data, String message, boolean blocked, boolean popup) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.blocked = blocked;
        this.popup = popup;
    }

    public RestResponse(Status status, Object data, boolean blocked) {
        this(status, data, blocked, false);
    }

    public RestResponse(Status status, Object data, boolean blocked, boolean popup) {
        this.status = status;
        this.data = data;
        this.blocked = blocked;
        this.popup = popup;
    }

    public RestResponse() {

    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public static enum Status {
        SUCCESS("success"), FAIL("fail"), ERROR("error");

        private String name;

        Status(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}

