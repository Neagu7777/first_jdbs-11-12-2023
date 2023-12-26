import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        //DAO = data access object

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty")) {

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS person (number int, First Name, Last Name)");
            statement.execute("CREATE TABLE IF NOT EXISTS abc (id int)");
            statement.execute("CREATE TABLE IF NOT EXISTS information (id int, bank int, first name, last name )");


            ResultSet resultSet = statement.executeQuery("SELECT * FROM information");

            resultSet.next();
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt("bank"));
            System.out.println(resultSet.getString("first"));
            System.out.println(resultSet.getString(4));

            resultSet.next();
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt("bank"));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));

            resultSet.next();
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt("bank"));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString("last"));
// второй способ
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getInt("bank"));
                System.out.println(resultSet.getString("first"));
                System.out.println(resultSet.getString(4));
            }

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int bank = resultSet.getInt(2);
                String first_name = resultSet.getString("first");
                String last_name = resultSet.getString("last");
                Information information = new Information(id, bank, first_name, last_name);
                System.out.println(information);
            }


            System.out.println("Подключено");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

