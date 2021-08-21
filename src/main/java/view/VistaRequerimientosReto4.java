package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;

import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 {

    public static ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento1() {

        System.out.println("-----Proyecto Ciudad-------");
        System.out.println("Constructora Fecha_Inicio Clasificación");
        try {
            ArrayList<ProyectoCiudad> proyectos = controlador.consultarProyectoCiudad();

            for(ProyectoCiudad p: proyectos){
                System.out.printf("%s %s %s %n",p.getConstructora(), p.getFechaInicio(), p.getClasificacion());
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void requerimiento3() {

        System.out.println("-----Suma cantidades-------");
        System.out.println("Suma cantidades");
        try {
            ArrayList<SumaProveedor> suma = controlador.consultarSumaProveedor();

            for (SumaProveedor sumaProveedor : suma) {
                System.out.println(sumaProveedor.getCantidad());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento4() {

        System.out.println("-----Líder Ciudad-------");
        System.out.println("Nombre líder");
        try {
            ArrayList<LiderCiudad> nombreLider = controlador.consultarLiderCiudad();

            for (LiderCiudad lider : nombreLider) {
                System.out.println(lider.getNombreLider());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    } 

}
