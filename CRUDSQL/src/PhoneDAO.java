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

    public void read() throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        ResultSet rs = statement.executeQuery("select * from phone");
        while (rs.next()) {
            System.out.println(rs.getInt("stid") + " " + rs.getString("prov") + " " + rs.getInt("number"));
        }
    }

    public void delete(String num) throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        statement.executeUpdate("delete from phone where number=" + num);
        System.out.println("Delete has been successful");
    }

    public void update(String num, int stid, String prov) throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        statement.executeUpdate("update phone set number=" + num + " where stid=" + stid + " and prov='" + prov + "'");
    }

    public void search(int stid) throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        ResultSet rs = statement.executeQuery("select * from phone where stid=" + stid);
        while (rs.next()) {
            System.out.println(rs.getInt("stid") + " " + rs.getString("prov") + " " + rs.getInt("number"));
        }
    }

    public void insert(int stid, String prov, int number) throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        statement.executeUpdate("insert into phone values (" + stid + ", '" + prov + "', " + number + ")");
        System.out.println("Insert has been successful");
    }

    public void create(Phone phone) throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        int id = phone.getStid();
        String prov = phone.getProv();
        int number = phone.getNumber();
        String str = "insert into phone values ('" + id + "', '" + prov + "', '" + number + "')";
        statement.executeUpdate(str);
        System.out.println("Create has been succesful");
    }

    public void sort() throws SQLException {
        Statement statement = ConnectionDB.connectionDB().createStatement();
        ResultSet rs = statement.executeQuery("select * from phone order by stid");
        while (rs.next()) {
            System.out.println(rs.getInt("stid") + " " + rs.getString("prov") + " " + rs.getInt("number"));
        }
    }

}
