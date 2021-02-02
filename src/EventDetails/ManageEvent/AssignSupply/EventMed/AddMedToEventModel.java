package EventDetails.ManageEvent.AssignSupply.EventMed;

import EventDetails.ManageEvent.GetInformationForEvent;

import java.util.ArrayList;

public class AddMedToEventModel {
    GetInformationForEvent ev = new GetInformationForEvent();

    protected String[] getSearchedList(String[] info, String text) {
        String sql = "select ID from HEALTH_PRODUCT where ID like ? or name like ?";

        return ev.getSearchedListForEvent(info, text, sql);
    }


    protected int getTotalID() {
        String sql = "select count(ID) from HEALTH_PRODUCT ";
        return ev.getTotalNumberOfIDs(sql);
    }


    protected String[] getMedList(String[] info) {
        String sql = "select ID from HEALTH_PRODUCT ";
        return ev.getList(info, sql);
    }


    public boolean isAssignMedSuccessful(ArrayList<String> id, String eventID) {
        String sql = "insert into event_health values(?,?)";
        return ev.isAssignSuccessful(id, eventID, sql);
    }
}
