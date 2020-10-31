package EmployeeDet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateEmployeeController implements Initializable {
    @FXML
    private Pane updateEmployeePane;
    @FXML
    private void handleConfirmButton() throws IOException{
        Pane pane  = FXMLLoader.load(getClass().getResource("../EmployeeDet/employeeDetails.fxml"));
        updateEmployeePane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}