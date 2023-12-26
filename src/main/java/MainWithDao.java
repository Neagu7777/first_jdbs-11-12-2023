import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class MainWithDao {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "qwerty")) {

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS information (id int, bank int, first_name VARCHAR(255), last_name VARCHAR(255))");

            InformationDAO informationDAO = new InformationDAO(connection);

            // Вставка новой информации
            Information newInformation = new Information(5, 25897455, "Dmitrii", "Ivanov");
            informationDAO.insertNewInformation(newInformation);

            // Получение всех записей
            List<Information> allInformation = informationDAO.getAllInformation();
            for (Information info : allInformation) {
                System.out.println(info);
            }

            // Удаление записи по ID
            informationDAO.deleteInformationById(5);

            // Обновление записи
            Information updatedInformation = new Information(1, 123456, "Evgenii", "Popov");
            informationDAO.updateInformation(updatedInformation);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
