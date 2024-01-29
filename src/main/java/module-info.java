module com.example.contabilidadreadytogo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.contabilidadreadytogo to javafx.fxml;
    exports Controlador;
    opens Controlador to javafx.fxml;
    exports Vista;
    opens Vista to javafx.fxml;
    opens Modelo to javafx.base;

}