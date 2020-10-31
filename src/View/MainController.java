package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane employeeDetailsBorderPane;
    @FXML
    private void viewDetails() throws IOException{
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../View/employeeDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
