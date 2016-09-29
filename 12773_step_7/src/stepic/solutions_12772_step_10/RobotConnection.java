package stepic.solutions_12772_step_10;

/**
 * Created by ipetrash on 29.09.2016.
 */


public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}
