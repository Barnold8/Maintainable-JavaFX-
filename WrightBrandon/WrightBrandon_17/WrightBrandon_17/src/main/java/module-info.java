module demo1_main  {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.media;

    opens   MVC to javafx.fxml;
    exports MVC;
    exports Mechanics;
    exports Utils;

}