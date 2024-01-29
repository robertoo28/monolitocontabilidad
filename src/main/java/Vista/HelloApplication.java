package Vista;

import Controlador.ConexionDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ConexionDB conexionDB = new ConexionDB();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/contabilidadreadytogo/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800f, 600);
        stage.setTitle("Ready To go");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}