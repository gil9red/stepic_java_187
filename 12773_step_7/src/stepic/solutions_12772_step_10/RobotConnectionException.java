package stepic.solutions_12772_step_10;

/**
 * Created by ipetrash on 29.09.2016.
 */

public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}