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
import model.vo.SumaProveedor;

public class SumaProveedorDao {

    public ArrayList<SumaProveedor> rankingSumaProveedor() throws SQLException {

        ArrayList<SumaProveedor> suma = new ArrayList<SumaProveedor>();
        Connection conexion= JDBCUtilities.getConnection();

        try {
            String sql= "SELECT SUM(c.Cantidad) as 'suma cantidades' "
                            +"FROM Compra c "
                            +"GROUP BY c.Proveedor "
                            +"HAVING c.Proveedor = 'Homecenter'";
            
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // while (resultSet.next()) {
                SumaProveedor sumaProveedor = new SumaProveedor();
                sumaProveedor.setCantidad(resultSet.getString("suma cantidades"));
                suma.add(sumaProveedor);
            // }
            resultSet.close();
            statement.close();


        } catch (Exception e) {
            System.err.println("Error consultando SumaProveedor! "+e);
        }

        finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return suma;
    }

}