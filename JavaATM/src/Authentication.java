//: Handles user login by verifying the account number and PIN against the database. Returns a User object upon successful authentication.
// Arat Palacios-Suarez 12/12/24

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
    private Database database;

    public Authentication(Database database) {
        this.database = database;
    }

    public User login(String accountNumber, String pin) {
        try {
            Connection connection = database.getConnection();
            String query = "SELECT * FROM users WHERE account_number = ? AND pin = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);
            statement.setString(2, pin);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getString("account_number"),
                        resultSet.getString("holder_name"),
                        resultSet.getString("pin"),
                        resultSet.getDouble("checking_balance"),
                        resultSet.getDouble("saving_balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}