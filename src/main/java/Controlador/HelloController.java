package Controlador;

import Modelo.Contabilidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController {
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String fechaComoString = fechaActual.format(formateador);
    @FXML
    private Label welcomeText;
    @FXML
    private TableView <Contabilidad>tabla;
    @FXML
    private Button btnIngreso;
    @FXML
    private Button btnEgreso;
    @FXML
    private TextField textFieldMonto;
    @FXML
    private TextField textFieldConcepto;

    private ContabilidadDAO contabilidadDAO;
    ConexionDB conexionDB;





    @FXML
   void onIngresoButtonClick(ActionEvent event){
        this.contabilidadDAO = new ContabilidadDAO();
        Contabilidad contabilidad = new Contabilidad();
        contabilidad.setIngreso(Double.parseDouble(textFieldMonto.getText()));
        contabilidad.setConcepto(textFieldConcepto.getText());
        contabilidad.setFecha(fechaComoString);
        System.out.println(contabilidad.toString());
        boolean resp= this.contabilidadDAO.registrarIngreso(contabilidad);


        if(resp){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exito");
            alert.setHeaderText(null);
            alert.setContentText("Se creo correctamente");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            limpiarCampos();
            cargarcontable();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("SE hizo mal");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
        }



    }
    @FXML
    void onEgresoButtonClick(ActionEvent event){
        this.contabilidadDAO = new ContabilidadDAO();
        Contabilidad contabilidad = new Contabilidad();
        contabilidad.setEgreso(Double.parseDouble(textFieldMonto.getText()));
        contabilidad.setConcepto(textFieldConcepto.getText());
        contabilidad.setFecha(fechaComoString);
        System.out.println(contabilidad.toString());
        boolean resp= this.contabilidadDAO.registrarEgreso(contabilidad);

        if(resp){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exito");
            alert.setHeaderText(null);
            alert.setContentText("SE hizo bien");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            limpiarCampos();
            cargarcontable();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("SE hizo mal");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
        }
    }
    private void limpiarCampos(){
        textFieldConcepto.setText("");
        textFieldMonto.setText("");


    }

    public void cargarcontable(){
        tabla.getItems().clear();
        tabla.getColumns().clear();
        this.contabilidadDAO = new ContabilidadDAO();
        List<Contabilidad> contabilidades = this.contabilidadDAO.listar();
        ObservableList <Contabilidad> data = FXCollections.observableArrayList(contabilidades);
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory("id")); // ingreso fecha egreso
        TableColumn conceptoCol = new TableColumn("Concepto");
        conceptoCol.setCellValueFactory(new PropertyValueFactory("concepto"));
        TableColumn ingresoCol = new TableColumn("Ingreso");
        ingresoCol.setCellValueFactory(new PropertyValueFactory("ingreso"));
        TableColumn fechaCol = new TableColumn("Fecha");
        fechaCol.setCellValueFactory(new PropertyValueFactory("fecha"));
        TableColumn egresoCol = new TableColumn("Egreso");
        egresoCol.setCellValueFactory(new PropertyValueFactory("egreso"));
        tabla.setItems(data);
        tabla.getColumns().addAll(idCol,ingresoCol,conceptoCol,fechaCol,egresoCol);




    }
    @FXML
    private void initialize(){
        cargarcontable();
    }

}