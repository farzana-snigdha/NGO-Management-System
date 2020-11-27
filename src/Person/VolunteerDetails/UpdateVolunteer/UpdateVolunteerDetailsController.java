package Person.VolunteerDetails.UpdateVolunteer;

import Utilities.PersonalInformation;
import Utilities.ShowAlertDialogue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

public class UpdateVolunteerDetailsController {
    @FXML
    private TextField VolunteerID;

    @FXML
    private TextField VolunteerName;

    @FXML
    private TextField VolunteerEmailID;

    @FXML
    private TextField VolunteerPhoneNumber;

    @FXML
    private TextField VolunteerAddress;

    @FXML
    private TextField VolunteerOccupation;

    UpdateVolunteerModel updateVolunteerModel=new UpdateVolunteerModel();
    @FXML
    void handleConfirmUpdateBtn() {
        if (updateVolunteerModel.isUpdateVolunteerSuccessful(VolunteerAddress.getText(),VolunteerPhoneNumber.getText(),VolunteerOccupation.getText(),
                VolunteerEmailID.getText(),VolunteerID.getText())){
            new ShowAlertDialogue().infoBox("update Successful!", null, "update Doctor");
            refreshTextField();

        }
    }

    private void refreshTextField() {
        VolunteerID.setText("");
        VolunteerName.setText("");
        VolunteerEmailID.setText("");
        VolunteerAddress.setText("");
        VolunteerOccupation.setText("");
        VolunteerPhoneNumber.setText("");
    }

    public void IDOnEnter() {
        String[] list = new String[4];
        String[] info = updateVolunteerModel.setVolunteerInformation(list, VolunteerID.getText());
        VolunteerEmailID.setText(info[0]);
        VolunteerOccupation.setText(info[2]);
        VolunteerPhoneNumber.setText(info[1]);
        VolunteerAddress.setText(info[3]);
        VolunteerName.setText(info[4]);

    }
    public void initialize() {
        TextFields.bindAutoCompletion(VolunteerID, new PersonalInformation().getIDList("select Volunteer_id from Volunteer"));
    }

}
