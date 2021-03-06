package com.mifos.objects.db;

import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;


public class Client extends SugarRecord<Client>
{
    private int clientId;
    private String clientName;
    private AttendanceType attendanceType;
    private MifosGroup mifosGroup;

    @Ignore
    private List<Loan> loans;

    public MifosGroup getMifosGroup() {
        return mifosGroup;
    }

    public void setMifosGroup(MifosGroup mifosGroup) {
        this.mifosGroup = mifosGroup;
    }

    @Override
    public String toString()
    {
        return new Gson().toJson(this);
    }

    public boolean isNew() {
        long count = Select.from(Client.class).where(Condition.prop("client_id").eq(clientId)).count();
        return count == 0;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public AttendanceType getAttendanceType()
    {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType)
    {
        this.attendanceType = attendanceType;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public int getClientId()
    {
        return clientId;
    }

    public void setClientId(int clientId)
    {
        this.clientId = clientId;
    }


}
