package stepic.solutions_12766_step_12;

/**
 * Created by ipetrash on 11.09.2016.
 */


public class Main {

/*
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)

В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз,
направо или налево. Ваша задача — привести робота в заданную точку игрового поля.

Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):
public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
    }

    public int getX() {
        // текущая координата X
    }

    public int getY() {
        // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}

Direction, направление взгляда робота,  — это перечисление:

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}


Пример
В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0,
robot.getDirection() == Direction.UP

Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:

robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();

*/

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction needDirection = robot.getDirection();

        // Поиск и выход на линию x
        if (toX > robot.getX()) {
            needDirection = Direction.RIGHT;
        } else if (toX < robot.getX()) {
            needDirection = Direction.LEFT;
        }

        while (robot.getDirection() != needDirection) {
            robot.turnRight();
        }

        while (robot.getX() != toX) {
            robot.stepForward();
        }
        // Поиск и выход на линию x

        // Поиск и выход на линию y
        if (toY > robot.getY()) {
            needDirection = Direction.UP;
        } else if (toY < robot.getY()) {
            needDirection = Direction.DOWN;
        }

        while (robot.getDirection() != needDirection) {
            robot.turnRight();
        }

        while (robot.getY() != toY) {
            robot.stepForward();
        }
        // Поиск и выход на линию y

        System.out.println();
    }

    public static void main(String[] args) {
        moveRobot(new Robot(0, 0, Direction.UP), 3, 0);
        moveRobot(new Robot(0, 0, Direction.UP), -3, 0);

        moveRobot(new Robot(0, 0, Direction.UP), 0, 3);
        moveRobot(new Robot(0, 0, Direction.UP), 0, -3);
    }
}
