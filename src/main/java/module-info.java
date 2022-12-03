module com.example.swingmvcdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires static lombok;
    requires org.apache.commons.io;

    opens com.example.swingmvcdemo to javafx.fxml;
    exports com.example.swingmvcdemo;
}