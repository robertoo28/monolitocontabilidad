package Controlador;
import Modelo.Contabilidad;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContabilidadDAO {
    private ConexionDB fabricaConexion;
    public ContabilidadDAO(){
        this.fabricaConexion = new ConexionDB();
    }
    public Contabilidad contabilidad;
    public boolean registrarIngreso(Contabilidad contabilidad){

        try {
            String SQL = "insert into tcontabilidad(ingreso,concepto,fecha) "
                    +" values(?,?,?)";
            Connection connection = this.fabricaConexion.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            sentencia.setDouble(1, contabilidad.getIngreso());
            sentencia.setString(2,contabilidad.getConcepto());
            sentencia.setString(3,contabilidad.getFecha());
            sentencia.executeUpdate();
            sentencia.close();
            return true;


        }catch (Exception e){
            System.err.println("Error al registrar ingresos"+ e.getMessage());
            e.printStackTrace();
            return false;

        }



    }
    public boolean registrarEgreso(Contabilidad contabilidad){

        try {
            String SQL = "insert into tcontabilidad(egreso,concepto,fecha) "
                    +" values(?,?,?)";
            Connection connection = this.fabricaConexion.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            sentencia.setDouble(1, contabilidad.getEgreso());
            sentencia.setString(2,contabilidad.getConcepto());
            sentencia.setString(3,contabilidad.getFecha());
            sentencia.executeUpdate();
            sentencia.close();
            return true;

        }catch (Exception e ){
            System.err.println("Error al registrar egresos"+ e.getMessage());
            e.printStackTrace();

            return false;

        }




    }
    public List<Contabilidad> listar(){
        List<Contabilidad> listaContable = new ArrayList<>();
        try {

            String SQL = "select * from db_contabilidad_readytogo.TCONTABILIDAD";
            Connection connection = this.fabricaConexion.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            ResultSet data = sentencia.executeQuery();
            while(data.next()){
                Contabilidad contabilidad = new Contabilidad();
                contabilidad.setId(data.getInt(1));
                contabilidad.setIngreso(data.getDouble(2));
                contabilidad.setConcepto(data.getString(3));
                contabilidad.setFecha(data.getString(4));
                contabilidad.setEgreso(data.getDouble(5));
                listaContable.add(contabilidad);
                System.out.println(contabilidad.toString());

            }
            data.close();
            sentencia.close();




        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("SE hizo mal tareas");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();


        }
        return listaContable;
    }

}
