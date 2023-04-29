package DAOs.NonVehicle;

import DAOs.MySqlDao;
import DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import DTOs.Dealer;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlDealerDao extends MySqlDao implements DealerDaoInterface {

    public void insertDealer(String name, String address, String phone_num) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO DEALERS VALUES (null,?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone_num);


            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertDealer() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


    }

    public List<Dealer> findAllDealers() throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Dealer> dealers = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM DEALERS";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone_num = rs.getString("phone_num");


                Dealer d = new Dealer(id, name, address, phone_num);
                dealers.add(d);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllDealers() " + e.getMessage());
        } finally {
            errorHandling(rs, ps, conn);
        }
        return dealers;
    }
    public void deleteById(int id) throws DaoException
    {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("dealers","vehicle_id",id);
    }
    public Dealer findDealerById(int id) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Dealer dealer = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM DEALERS WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {

                int dealer_id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone_num = rs.getString("phone_num");


                dealer = new Dealer(dealer_id,name,address,phone_num);
            }
        } catch (SQLException e) {
            throw new DaoException("findDealerById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return dealer;
    }

}
