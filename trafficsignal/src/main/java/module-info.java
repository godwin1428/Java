module com.example.trafficsignal {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.trafficsignal to javafx.fxml;
    exports com.example.trafficsignal;
}