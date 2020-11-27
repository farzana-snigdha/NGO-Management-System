package Person.EmployeeDet.UpdateEmployee;

import Person.EmployeeDet.EmployeeDetailsModel;
import Utilities.ShowAlertDialogue;
import Utilities.PersonalInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class UpdateEmployeeController implements Initializable {
    @FXML
    public TextField employeeID;
    @FXML
    public TextField employeeName;
    @FXML
    public TextField employeeEmailID;
    @FXML
    public TextField employeePassword;
    @FXML
    public DatePicker employeeDOB;
    @FXML
    public TextField employeePhoneNumber;
    @FXML
    public ComboBox employeeGender;
    @FXML
    public ComboBox employeeDesignation;
    @FXML
    public TextField employeeAddress;

    UpdateEmployeeModel updateEmployeeModel = new UpdateEmployeeModel();

    private final ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Others");
   private final ObservableList<String> designation = FXCollections.observableArrayList();

    @FXML
    private void handleConfirmButton() throws  ParseException {
        Date dobDate = new SimpleDateFormat("MM/dd/yyyy").parse(employeeDOB.getEditor().getText());
        if (updateEmployeeModel.isUpdateEmployeeSuccessful(dobDate, employeeGender.getSelectionModel().getSelectedItem().toString(),
                employeeAddress.getText(), employeePhoneNumber.getText(), employeeDesignation.getSelectionModel().getSelectedItem().toString(),
                employeeEmailID.getText(), employeePassword.getText(), Integer.parseInt(employeeID.getText()))) {
            new ShowAlertDialogue().infoBox("update Successful!", null, "update Employee");
            refreshTextField();
        }
    }

    private void refreshTextField() {
        employeeDOB.getEditor().setText("");
        employeeAddress.setText("");
        employeePhoneNumber.setText("");
        employeeEmailID.setText("");
        employeePassword.setText("");
        employeeID.setText("");
        employeeName.setText("");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextFields.bindAutoCompletion(employeeID, new PersonalInformation().getIDList("select emp_id from employee"));

        employeeGender.setItems(gender);
        new EmployeeDetailsModel().getDesignation(designation);
        employeeDesignation.setItems(designation);


    }

    @FXML
    public void IDOnEnter() {
        String[] list = new String[3];
        String[] info = updateEmployeeModel.setEmployeeInformation(list, Integer.parseInt(employeeID.getText()));
        employeeName.setText(info[0]);
        employeeEmailID.setText(info[2]);
        employeePassword.setText(info[1]);
    }

}