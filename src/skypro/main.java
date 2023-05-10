package skypro;

import skypro.exceptions.WrongLoginException;
import skypro.exceptions.WrongPasswordException;
public class main {
    public static void main(String[] args) {
        setPersonData("Mavile_Seytoplaeva13", "Mavile_Seytoplaeva", "Mavile_Seytoplaeva");
    }

    public static void setPersonData(String login, String password, String confirmPassword) {
        PersonData personData = new PersonData();
        try {
            personData.setLogin(login);
            personData.setPassword(password);
            personData.setConfirmPassword(confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Укоротите ваш Логин");
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        } finally {
            System.out.println("Метод закончил работу");
        }

    }
}
