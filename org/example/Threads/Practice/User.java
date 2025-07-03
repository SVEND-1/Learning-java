package org.example.Threads.Practice;

public class User {
    private int id;
    private String login;
    private String password;
    private int balance;
    private int income;

    public User(int id, String login, String password, int balance, int income) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.income = income;
    }

    public User(String login, String password, int balance, int income) {
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.income = income;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
