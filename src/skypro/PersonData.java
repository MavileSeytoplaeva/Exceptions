package skypro;

import skypro.exceptions.WrongLoginException;
import skypro.exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonData {
    private String login;
    private String password;
    private String confirmPassword;

    public PersonData() {
    }

    public void setPassword(String password) {
        if (password.length() < 20) {
            if (checkMatching(password)) {
                this.password = password;
            } else
                System.out.println("Пароль не подходит под требования");
        } else
            System.out.println("Пароль должен быть строго меньше 20 символов.");
    }

    public void setLogin(String login) {
        if (login.length() <= 20) {
            if (checkMatching(login)) {
                this.login = login;
            } else
                System.out.println("Пароль не подходит под требования");
        } else
            throw new WrongLoginException("Логин не должен быть длиннее 20 символов.");
    }
    private boolean checkMatching(String string){
        String regex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    public void setConfirmPassword(String confirmPassword) {
        if(confirmPassword.equals(password)) {
            this.confirmPassword = confirmPassword;
        } else
            throw new WrongPasswordException("Пароли не совпадают");
    }
}
