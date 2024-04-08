package Punto1.Persistencia;

import Punto1.Concurso.RegistroConcurso;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class EnSQLRegistroInscripcion implements RegistroConcurso {


    @Override
    public void registrar(String nombre, LocalDateTime fecha, String concurso) {
        try (java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_de_datos_concurso", "root", "");
             PreparedStatement sent = conexion.prepareStatement("INSERT INTO `registro` (`nombre`, `fecha`, `concurso`) VALUES (?, ?, ?);");){
                sent.setString(1,nombre);
                sent.setString(2,fecha.toString());
                sent.setString(3,concurso);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
