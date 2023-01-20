module kocak.tic_tac_toe {
    requires javafx.controls;
    requires javafx.fxml;


    opens kocak.View to javafx.fxml;
    opens Controller to javafx.fxml;
    exports kocak.View;
    exports Controller;
    exports Model;
}