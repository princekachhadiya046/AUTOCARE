package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // =========================
    // LOGIN
    // =========================
    public User login(String email, String password) {

        String sql =
                "SELECT user_id, full_name, email, password, role "
              + "FROM users "
              + "WHERE email = ? AND password = ?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    User user = new User();

                    user.setUserId(
                            rs.getInt("user_id")
                    );

                    user.setFullName(
                            rs.getString("full_name")
                    );

                    user.setEmail(
                            rs.getString("email")
                    );

                    user.setPassword(
                            rs.getString("password")
                    );

                    user.setRole(
                            rs.getString("role")
                    );

                    return user;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }


    // =========================
    // GET ALL USERS
    // =========================
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql =
                "SELECT user_id, full_name, email, "
              + "password, role "
              + "FROM users "
              + "ORDER BY user_id";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id")
                );

                user.setFullName(
                        rs.getString("full_name")
                );

                user.setEmail(
                        rs.getString("email")
                );

                user.setPassword(
                        rs.getString("password")
                );

                user.setRole(
                        rs.getString("role")
                );

                users.add(user);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return users;
    }


    // =========================
    // ADD USER
    // =========================
    public boolean addUser(User user) {

        String sql =
                "INSERT INTO users "
              + "(user_id, full_name, email, password, role) "
              + "VALUES (users_seq.NEXTVAL, ?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    user.getFullName()
            );

            ps.setString(
                    2,
                    user.getEmail()
            );

            ps.setString(
                    3,
                    user.getPassword()
            );

            ps.setString(
                    4,
                    user.getRole()
            );

            int result =
                    ps.executeUpdate();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    
    // =========================
// GET USER BY ID
// =========================
public User getUserById(int userId) {

    String sql =
            "SELECT user_id, full_name, email, "
          + "password, role "
          + "FROM users "
          + "WHERE user_id = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, userId);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id")
                );

                user.setFullName(
                        rs.getString("full_name")
                );

                user.setEmail(
                        rs.getString("email")
                );

                user.setPassword(
                        rs.getString("password")
                );

                user.setRole(
                        rs.getString("role")
                );

                return user;
            }
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return null;
}

    // =========================
    // UPDATE USER
    // =========================
    public boolean updateUser(User user) {

        String sql =
                "UPDATE users "
              + "SET full_name = ?, "
              + "email = ?, "
              + "password = ?, "
              + "role = ? "
              + "WHERE user_id = ?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    user.getFullName()
            );

            ps.setString(
                    2,
                    user.getEmail()
            );

            ps.setString(
                    3,
                    user.getPassword()
            );

            ps.setString(
                    4,
                    user.getRole()
            );

            ps.setInt(
                    5,
                    user.getUserId()
            );

            int result =
                    ps.executeUpdate();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    // =========================
// DELETE USER
// =========================
public boolean deleteUser(int userId) {

    String sql =
            "DELETE FROM users "
          + "WHERE user_id = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setInt(1, userId);

        int result =
                ps.executeUpdate();

        return result > 0;

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}

}