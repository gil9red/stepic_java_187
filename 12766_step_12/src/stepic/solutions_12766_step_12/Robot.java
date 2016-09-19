package stepic.solutions_12766_step_12;

/**
 * Created by ipetrash on 19.09.2016.
 */

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class Robot {
    private Direction direction;
    private int x;
    private int y;

    Robot() {
        this(0, 0, Direction.UP);
    }

    Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // повернуться на 90 градусов против часовой стрелки
    public void turnLeft() {
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;

            case DOWN:
                direction = Direction.RIGHT;
                break;

            case LEFT:
                direction = Direction.DOWN;
                break;

            case RIGHT:
                direction = Direction.UP;
                break;
        }

        System.out.println(String.format("turnLeft: %s", direction));
    }

    // повернуться на 90 градусов по часовой стрелке
    public void turnRight() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;

            case DOWN:
                direction = Direction.LEFT;
                break;

            case LEFT:
                direction = Direction.UP;
                break;

            case RIGHT:
                direction = Direction.DOWN;
                break;
        }

        System.out.println(String.format("turnRight: %s", direction));
    }

    // шаг в направлении взгляда
    // за один шаг робот изменяет одну свою координату на единицу
    public void stepForward() {
        switch (direction) {
            case UP:
                y += 1;
                break;

            case DOWN:
                y -= 1;
                break;

            case LEFT:
                x -= 1;
                break;

            case RIGHT:
                x += 1;
                break;
        }

        System.out.println(String.format("stepForward: direction: %s, x: %s, y: %s", direction, x, y));
    }
}