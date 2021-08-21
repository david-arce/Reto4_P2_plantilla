package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.LiderCiudad;

public class LiderCiudadDao {

    public ArrayList<LiderCiudad> rankingLiderCiudad() throws SQLException {
        
        ArrayList<LiderCiudad> nombreLider = new ArrayList<LiderCiudad>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String sql= "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido as 'Nombre Líder' "
                        +"FROM Lider l " 
                        +"WHERE l.Ciudad_Residencia = 'Londres'";

            PreparedStatement statement= conexion.prepareStatement(sql);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()) {
                LiderCiudad liderCiudad= new LiderCiudad();
                liderCiudad.setNombreLider(resultSet.getString("Nombre Líder"));
                nombreLider.add(liderCiudad);
            }
        } catch (Exception e) {
            System.err.println("Error consultando LiderCiudad! "+e);
        }

        finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return nombreLider;
    }

}