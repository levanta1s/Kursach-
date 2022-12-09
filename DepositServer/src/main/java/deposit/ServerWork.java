package deposit;

import java.io.*;
import java.sql.*;

public class ServerWork {
    private BufferedReader in;
    private PrintWriter out;

    public ServerWork(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public void getId(int idOperation) throws IOException, SQLException {
        switch (idOperation) {
            case 1:
                authorization();
                break;
            case 2:
                sendUserInformation();
                break;
            case 3:
                changeClientsInformation();
                break;
            case 4:
                sendUsersContractsInformation();
                break;
            case 5:
                sendUsersDepositsInformation();
                break;
            case 6:
                sendDepositTypesInformation();
                break;
            case 7:
                addIntoDatabase();
                break;
            case 8:
                deleteFromDatabase();
                break;
            case 9:
                changeUserInfo();
                break;
            case 10:
                sendEmployeesInformation();
                break;
            case 11:
                calculatePlannedMoney();
                break;
            case 12:
                calculateFinalAmountOfMoney();
                break;
            case 13:
                calculateInitialAmountOfMoney();
                break;
            case 14:
                calculatePercent();
                break;
            case 15:
                checkIfUserExists();
                break;
            case 16:
                checkIfUserExistsToEdit();
                break;
            case 17:
                checkIfEmployeeExists();
                break;
            case 18:
                checkIfEmployeeExistsToEdit();
                break;
        }
    }

    private void authorization() throws IOException, SQLException {
        System.out.println("Выбран 1 кейс");
        String selection = in.readLine();//прокидывается сотрудник или нет
        String login = in.readLine();
        String password = in.readLine();
        //String login = in.readLine();//номер операции(в меню пользователя
        //String password = in.readLine();
        String value = "";
        ResultSet result1;
        ResultSet result2;
        if (selection.equals("yes")) {
            String sqlString2 = "select * from employees where EmployeeLogin = '" + login + "' and EmployeePassword = '" + password + "'";
            result2 = DatabaseConnection.getInstance().select(sqlString2);
            if (result2.next()) {
                //out.println(result2.getString("Position"));
                value = "Employee";
            } else {
                //out.println("error");
            }
        } else {
            System.out.println("Логин: " + login + " Пароль: " + password);
            String sqlString = "SELECT * FROM clients WHERE ClientLogin = '" + login + "' AND ClientPassword = '" + password + "'";
            System.out.println("Строчка: " + sqlString);
            result1 = DatabaseConnection.getInstance().select(sqlString);
            System.out.println("Результат: " + result1.getRow());
            if (result1.next()) {
                //out.println(result1.getString("ClientLogin"));
                value = "Client";
            } else {
                //out.println("error");
            }
        }
        if(login.equals("Admin") && password.equals("Admin") && selection.equals("yes"))
            value = "Admin";
        out.println(value);
    }

    private void sendUserInformation() throws SQLException, IOException {
        System.out.println("Выбран 2 кейс");
        ResultSet result = DatabaseConnection.getInstance().select(in.readLine());
        int count = 0;
        if (result.first()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(count);
        result.first();
        for (int i = 0; i < count; i++) {
            out.println((double) result.getFloat("ClientID"));
            out.println(result.getString("ClientLogin"));
            out.println(result.getString("ClientPassword"));
            out.println(result.getString("ClientFullName"));
            out.println(result.getString("ClientPassport"));
            out.println(result.getString("ClientPhoneNumber"));
            out.println(result.getString("ClientAdress"));
            result.next();
        }
    }


    private void changeClientsInformation() throws IOException {
        System.out.println("Выбран 3 кейс");
        String previousLogin = in.readLine();
        String login = in.readLine();
        String password = in.readLine();
        String phoneNumber = in.readLine();

        String sqlString = "UPDATE clients SET ClientLogin = '" + login + "' WHERE ClientLogin = '" + previousLogin + "'";
        DatabaseConnection.getInstance().update(sqlString);
        sqlString = "UPDATE clients SET ClientPassword = '" + password + "' WHERE ClientLogin = '" + login + "'";
        DatabaseConnection.getInstance().update(sqlString);
        sqlString = "UPDATE clients SET ClientPhoneNumber = '" + phoneNumber + "' WHERE ClientLogin = '" + login + "'";
        DatabaseConnection.getInstance().update(sqlString);
        String rez = "OK";
        out.println(rez);
    }

    private void sendUsersContractsInformation() throws SQLException, IOException {
        System.out.println("Выбран 4 кейс");
        ResultSet result = DatabaseConnection.getInstance().select(in.readLine());
        int count = 0;
        if (result.first()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(count);
        result.first();
        for (int i = 0; i < count; i++) {
            out.println((double) result.getFloat("ContractNumber"));
            out.println(result.getDate("DateOfSigning").toString());
            out.println((double) result.getFloat("ClientID"));
            out.println((double) result.getFloat("EmployeeID"));
            result.next();
        }
    }

    private void sendUsersDepositsInformation() throws SQLException, IOException {
        System.out.println("Выбран 5 кейс");
        ResultSet result = DatabaseConnection.getInstance().select(in.readLine());
        int count = 0;
        if (result.first()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(count);
        result.first();
        for (int i = 0; i < count; i++) {
            out.println((double) result.getFloat("DepositNumber"));
            out.println((double) result.getFloat("InitialMoney"));
            out.println(result.getDate("DateOfOpening").toString());
            out.println((double) result.getFloat("PlannedFinalMoney"));
            out.println((double) result.getFloat("TypeID"));
            out.println((double) result.getFloat("ContractNumber"));
            out.println((double) result.getFloat("ClientID"));
            result.next();
        }
    }

    private void sendDepositTypesInformation() throws SQLException, IOException {
        System.out.println("Выбран 6 кейс");
        ResultSet result = DatabaseConnection.getInstance().select(in.readLine());
        int count = 0;
        if (result.first()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(count);
        result.first();
        for (int i = 0; i < count; i++) {
            out.println((double) result.getInt("TypeID"));
            out.println(result.getString("TypeName"));
            out.println((double) result.getInt("TypeMinMoney"));
            out.println((double) result.getInt("TypeMaxMoney"));
            out.println((double) result.getInt("TypePeriod"));
            out.println((double) result.getInt("TypeCapitalization"));
            out.println((double) result.getInt("TypeInterestRate"));
            result.next();
        }
    }

    private void addIntoDatabase() {
        System.out.println("Выбран 7 кейс");
        int code = 1;
        try {
            DatabaseConnection.getInstance().insert(in.readLine());
        } catch (IOException ex) {
            code = 0;
        }
        out.println(code);
    }


    public void deleteFromDatabase() {
        System.out.println("Выбран 8 кейс");
        int code = 1;
        try {
            String sqlString = in.readLine();
            DatabaseConnection.getInstance().delete(sqlString);
        } catch (IOException ex) {
            code = 0;
        }
        out.println(code);
    }


    private void changeUserInfo() throws IOException {
        System.out.println("Выбран 9 кейс");
        String sqlString = in.readLine();
        DatabaseConnection.getInstance().update(sqlString);
        int code = 1;
        out.println(code);
    }


    private void sendEmployeesInformation() throws SQLException, IOException {
        System.out.println("Выбран 10 кейс");
        ResultSet result = DatabaseConnection.getInstance().select(in.readLine());
        int count = 0;
        if (result.first()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(count);
        result.first();
        for (int i = 0; i < count; i++) {
            out.println((double) result.getInt("EmployeeID"));
            out.println(result.getString("EmployeeLogin"));
            out.println(result.getString("EmployeePassword"));
            out.println(result.getString("EmployeeFullName"));
            out.println((double) result.getInt("ContractNumber"));
            out.println(result.getDate("DateOfRecruitment").toString());
            out.println((double) result.getInt("Position"));
            result.next();
        }
    }


    private void calculatePlannedMoney() throws SQLException, IOException {
        System.out.println("Выбран 11 кейс");
        int initialMoney = (int) Double.parseDouble(in.readLine());
        int typeID = (int) Double.parseDouble(in.readLine());
        String sql = "select * from depositTypes WHERE TypeID=" + typeID;
        ResultSet result = DatabaseConnection.getInstance().select(sql);
        result.first();
        int capitalization = result.getInt("TypeCapitalization");
        double period = result.getInt("TypePeriod");
        int percent = result.getInt("TypeInterestRate");


        double finalMoney;
        period /= 12.0;
        finalMoney = 1 + percent / (double) (100 * capitalization);
        finalMoney = Math.pow(finalMoney, (capitalization * period));
        finalMoney *= initialMoney;
        finalMoney *= 100;
        int resultInt = (int) finalMoney;
        resultInt /= 100;
        out.println(resultInt);
    }

    private void calculateFinalAmountOfMoney() throws IOException {
        System.out.println("Выбран 12 кейс");
        double initialAmountOfMoney = Double.parseDouble(in.readLine());
        double percent = Double.parseDouble(in.readLine());
        double capitalization = Double.parseDouble(in.readLine());
        double numberOfYears = Double.parseDouble(in.readLine());

        double finalAmountOfMoney;
        finalAmountOfMoney = 1 + percent / (100 * capitalization);
        int power = (int) (capitalization * numberOfYears);
        finalAmountOfMoney = Math.pow(finalAmountOfMoney, power);
        finalAmountOfMoney *= initialAmountOfMoney;
        out.println(finalAmountOfMoney);
    }


    private void calculateInitialAmountOfMoney() throws IOException {
        System.out.println("Выбран 13 кейс");
        double finalAmountOfMoney = Double.parseDouble(in.readLine());
        double percent = Double.parseDouble(in.readLine());
        double capitalization = Double.parseDouble(in.readLine());
        double numberOfYears = Double.parseDouble(in.readLine());

        double initialAmountOfMoney = 0;
        double parentheses = 1 + (percent / (100 * capitalization));
        parentheses = Math.pow(parentheses, (capitalization * numberOfYears));
        initialAmountOfMoney = finalAmountOfMoney / parentheses;
        out.println(initialAmountOfMoney);

    }


    private void calculatePercent() throws IOException {
        System.out.println("Выбран 14 кейс");
        double initialAmountOfMoney = Double.parseDouble(in.readLine());
        double finalAmountOfMoney = Double.parseDouble(in.readLine());
        double capitalization = Double.parseDouble(in.readLine());
        double numberOfYears = Double.parseDouble(in.readLine());

        double percent = finalAmountOfMoney / initialAmountOfMoney;
        double power = 1 / (numberOfYears * capitalization);
        percent = Math.pow(percent, power);
        percent -= 1;
        percent *= capitalization;
        out.println(percent);
    }

    private void checkIfUserExists() throws SQLException, IOException {
        System.out.println("Выбран 15 кейс");
        String login = in.readLine();
        ResultSet result;
        String sqlString = "select * from clients where ClientLogin = '" + login + "'";
        result = DatabaseConnection.getInstance().select(sqlString);
        if (result.next()) {
            out.println("0");
        } else {
            out.println("1");
        }
    }

    private void checkIfUserExistsToEdit() throws SQLException, IOException {
        System.out.println("Выбран 16 кейс");
        String login = in.readLine();
        String myLogin = in.readLine();
        ResultSet result;
        String sqlString = "select * from clients where ClientLogin = '" + login + "' and ClientLogin!='" + myLogin + "'";
        result = DatabaseConnection.getInstance().select(sqlString);
        if (result.next()) {
            out.println("0");
        } else {
            out.println("1");
        }
    }


    private void checkIfEmployeeExists() throws SQLException, IOException {
        System.out.println("Выбран 17 кейс");
        String login = in.readLine();
        ResultSet result;
        String sqlString = "select * from employees where EmployeeLogin = '" + login + "'";
        result = DatabaseConnection.getInstance().select(sqlString);
        if (result.next()) {
            out.println("0");
        } else {
            out.println("1");
        }
    }

    private void checkIfEmployeeExistsToEdit() throws SQLException, IOException {
        System.out.println("Выбран 18 кейс");
        String login = in.readLine();
        String myLogin = in.readLine();
        ResultSet result;
        String sqlString = "select * from employees where EmployeeLogin = '" + login + "' and EmployeeLogin!='" + myLogin + "'";
        result = DatabaseConnection.getInstance().select(sqlString);
        if (result.next()) {
            out.println("0");
        } else {
            out.println("1");
        }
    }

}
