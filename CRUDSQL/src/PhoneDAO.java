import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {
    List<Phone> phoneList = new ArrayList<>();

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void fillPhone() throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from phone");
        while (resultSet1.next()) {
            int id = resultSet1.getInt(1);
            String prov = resultSet1.getString(2);
            int number = resultSet1.getInt(3);
            Phone phone = new Phone(id, prov, number);
            phoneList.add(phone);
        }
    }

    public void printPhoneList() {
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.println(phoneList.get(i).getStid() + " " + phoneList.get(i).getProv() + " " + phoneList.get(i).getNumber());
        }
    }
}