package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import model.TblUsuariocl3;

public class ClassUsuario {

    // Datos de la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/BDHERRERASANCHEZALONSOCL3?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Añade tu contraseña aquí

    // Método para obtener la conexión a la base de datos
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para validar el usuario
    public TblUsuariocl3 validarUsuario(String usuario, String password) {
        TblUsuariocl3 user = null;
        String query = "SELECT * FROM TBL_USUARIOCL3 WHERE USUARIOCL3 = ? AND PASSWORDCL3 = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, usuario);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new TblUsuariocl3();
                    user.setIdusuariocl3(rs.getInt("IDUSUARIOCL3"));
                    user.setUsuariocl3(rs.getString("USUARIOCL3"));
                    user.setPasswordcl3(rs.getString("PASSWORDCL3"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
}
