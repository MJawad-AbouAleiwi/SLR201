import java.io.Serializable;

public class HelloData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String message;
    private transient String transientMessage;

    public HelloData(String message, String transientMessage) {
        this.message = message;
        this.transientMessage = transientMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransientMessage() {
        return transientMessage;
    }

    public void setTransientMessage(String transientMessage) {
        this.transientMessage = transientMessage;
    }

    @Override
    public String toString() {
        return "HelloData{" +
                "message='" + message + '\'' +
                ", transientMessage='" + transientMessage + '\'' +
                '}';
    }
}
