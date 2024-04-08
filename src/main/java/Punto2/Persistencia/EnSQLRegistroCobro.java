package Punto2.Persistencia;

import Punto2.Restaurante.RegistroCobro;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class EnSQLRegistroCobro implements RegistroCobro {
    @Override
    public void registro(LocalDateTime fecha, double monto) {
        try (java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_de_datos_cobro", "root", "");
             PreparedStatement sent = conexion.prepareStatement("INSERT INTO `registro` (`fecha`, `monto`) VALUES (?, ?);");){
            sent.setString(1,fecha.toString());
            sent.setDouble(2,monto);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
