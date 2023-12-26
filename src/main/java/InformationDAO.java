import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InformationDAO {

    private Connection connection;

    public List<Information> getAllInformation() throws SQLException {
        List<Information> list = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM information")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int bank = resultSet.getInt("bank");
                String first = resultSet.getString("first");
                String last = resultSet.getString("last");
                Information information = new Information(id, bank, first, last);
                list.add(information);
            }
        }

        return list;
    }

    public void insertNewInformation(Information information) throws SQLException {
        String sql = "INSERT INTO information VALUES (? , ? , ? , ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, information.getId());
            preparedStatement.setInt(2, information.getBank());
            preparedStatement.setString(3, information.getFirst());
            preparedStatement.setString(4, information.getLast());
            preparedStatement.execute();
        }
    }


    public void deleteInformationById(int id) throws SQLException {
        String sql = "DELETE FROM information WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
    }

    public void updateInformation(Information information) throws SQLException {
        String sql = "UPDATE information SET bank = ?, first = ?, last = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, information.getBank());
            preparedStatement.setString(2, information.getFirst());
            preparedStatement.setString(3, information.getLast());
            preparedStatement.setInt(4, information.getId());
            preparedStatement.execute();
        }
    }

    public InformationDAO(Connection connection) {
        this.connection = connection;
    }
}

