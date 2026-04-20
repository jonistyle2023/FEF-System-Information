module com.springmvc.app.fefsysteminformation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.springmvc.app.fefsysteminformation to javafx.fxml;
    opens ec.edu.upse.FEF.controlador to javafx.fxml;
    exports com.springmvc.app.fefsysteminformation;
    exports ec.edu.upse.FEF.modelo;
    exports ec.edu.upse.FEF.general;
}