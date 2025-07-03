package org.example.Threads.Practice;

import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UserDB {
    private final Connection connection;
    private final ReadWriteLock rwLock;
    private final Lock writeLock;
    private final Lock readLock;
    public UserDB(final Connection connection) {
        this.connection = connection;
        rwLock = new ReentrantReadWriteLock();
        writeLock = rwLock.writeLock();
        readLock = rwLock.readLock();
    }

    public boolean insert(final User user) {
        writeLock.lock();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3,user.getBalance());
            statement.setInt(4,user.getIncome());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 1) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getInt(1));
                        return true;
                    } else {
                        System.err.println("Не удалось получить сгенерированный ключ");
                        return false;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Ошибка при вставке пользователя: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        finally {
            writeLock.unlock();
        }
    }

    public User read(final String login) {
        readLock.lock();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, login);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User result = new User();
                result.setId(rs.getInt("id"));
                result.setLogin(login);
                result.setPassword(rs.getString("password"));
                result.setBalance(rs.getInt("balance"));
                result.setIncome(rs.getInt("income"));
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            readLock.unlock();
        }
        return null;
    }


    public boolean update(final User user) {
        boolean result = false;

        writeLock.lock();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setInt(1, user.getBalance());
            statement.setInt(2, user.getIncome());
            statement.setInt(3, user.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            writeLock.unlock();
        }
        return result;
    }

    public boolean delete(final User user) {
        writeLock.lock();
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setInt(1, user.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            readLock.lock();
        }
    }


    enum SQLUser {
        GET("SELECT users.id, users.login, users.password, users.balance ,users.income FROM users  WHERE users.login = (?)"),
        INSERT("INSERT INTO users (id, login, password, balance, income) VALUES (DEFAULT, (?), (?), (?), (?)) RETURNING id"),
        DELETE("DELETE FROM users WHERE id = ?"),
        UPDATE("UPDATE users SET balance = (?),income = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
