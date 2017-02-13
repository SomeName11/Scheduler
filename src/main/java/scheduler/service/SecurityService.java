package main.java.scheduler.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String login, String password);
}
