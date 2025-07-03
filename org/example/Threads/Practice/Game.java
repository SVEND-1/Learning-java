package org.example.Threads.Practice;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Game {
    private final UserDB userDB;
    private final Scanner scanner;
    private GameSessionThread gameSessionThread;
    private User currentUser;
    private final Lock userLock;
    public Game() {
        this.userDB = DataBaseConnection.getInstance().getUserDB();
        this.scanner = new Scanner(System.in);
        userLock = new ReentrantLock();
    }

    public void startGame() {
        while (true) {
            printMenu();
            int choice = readUserChoice();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> startGameSession();
                case 4 -> {
                    System.out.println("Выход из игры");
                    gameSessionThread.stopRunning();
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== Меню ===");
        System.out.println("1 - Зарегистрироваться");
        System.out.println("2 - Войти");
        System.out.println("3 - Начать игру");
        System.out.println("4 - выйти");
        System.out.print("Выберите действие: ");
    }

    private int readUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите число!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void register() {
        System.out.print("\nВведите логин: ");
        String login = scanner.next();

        System.out.print("Введите пароль: ");
        String password = scanner.next();


        User newUser = new User(login, password, 0, 1);
        if (userDB.insert(newUser)) {
            userLock.lock();
            try {
                currentUser = newUser;
            } finally {
                userLock.unlock();
            }
            System.out.println("Регистрация прошла успешно!");
        } else {
            System.out.println("Ошибка при регистрации. Попробуйте позже.");
        }
    }

    private void login() {
        System.out.print("\nВведите логин: ");
        String login = scanner.next();

        System.out.print("Введите пароль: ");
        String password = scanner.next();


        User user = userDB.read(login);
        if (user == null) {
            System.out.println("Пользователь не найден!");
            return;
        }

        if (!user.getPassword().equals(password)) {
            System.out.println("Неверный пароль!");
            return;
        }

        userLock.lock();
        try {
            currentUser = user;
        } finally {
            userLock.unlock();
        }
        System.out.println("Вход выполнен успешно!");
        System.out.printf("Текущий баланс: %d, доход: %d/сек%n",
                user.getBalance(), user.getIncome());
    }

    private void startGameSession()  {
        if (currentUser == null) {
            System.out.println("Сначала войдите или зарегистрируйтесь!");
            return;
        }
        if(gameSessionThread == null) {
            gameSessionThread = new GameSessionThread(currentUser);
            gameSessionThread.start();
        }

        System.out.println("\n=== Игра началась ===");

        boolean flag = true;

        while (flag) {
            printGameMenu();
            int choice = readUserChoice();

            switch (choice) {
                case 1 -> upIncome();
                case 2 -> getInfoUser();
                case 3 -> flag = false;
                default -> System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    private void upIncome() {
        userLock.lock();
        try {
            if (currentUser == null) return;

            int cost = currentUser.getIncome() * 15;
            if (currentUser.getBalance() >= cost) {
                currentUser.setBalance(currentUser.getBalance() - cost);
                currentUser.setIncome(currentUser.getIncome() + 1);
                if (userDB.update(currentUser)) {
                    System.out.println("Доход увеличен!");
                } else {
                    System.out.println("Ошибка при обновлении данных");
                }
            } else {
                System.out.println("Недостаточно средств");
            }
        } finally {
            userLock.unlock();
        }
    }

    private void getInfoUser(){
        System.out.println("Текущий пользователь: " + currentUser.getLogin());
        System.out.printf("Баланс: %d, доход: %d/сек%n",
                currentUser.getBalance(), currentUser.getIncome());
    }

    private void printGameMenu(){
        System.out.println("1 - Увеличить доход(Стоимость: " + currentUser.getIncome() * 15 + ")");
        System.out.println("2 - Узнать баланс");
        System.out.println("3 - завершить");
    }
}

