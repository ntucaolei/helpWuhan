package main.java.search;

import main.java.DBHelper;
import main.java.Entity.ContributorItemEntity;
import main.java.Entity.DemandItemEntity;
import main.java.Entity.FakeNewsItemEntity;
import main.java.Utils;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchDBHelper {

    public static final String db_hostname = "3.0.108.253";
    public static final String db_username = "root";
    public static final String db_password = "help5HanDev@2020";

    private BasicDataSource source;

    public SearchDBHelper(String hostname, String username, String password) {
        Utils.log("Creating DB " + hostname);
        try {
            source = new BasicDataSource();
            source.setDriverClassName("com.mysql.jdbc.Driver");
            String connection = "jdbc:mysql://" + hostname + ":3306/5han?autoReconnect=true";
            source.setUrl(connection);
            source.setPassword(password);
            source.setUsername(username);
            source.setTestOnBorrow(true);
            source.setInitialSize(100);
            source.setMaxActive(4000);
            source.setMaxIdle(100);
            Connection con = source.getConnection();
            con.close();
            Utils.log("*********************");
            Utils.log("Finish Initialize DB!");
            Utils.log("*********************");

        } catch (Exception e) {
            e.printStackTrace();
            Utils.log("fail to initialize DB! ");
        }
    }

    public static SearchDBHelper localdbhelper = null;

    public static SearchDBHelper getLocalDBHelper() {

        if (localdbhelper == null) {
            localdbhelper = new SearchDBHelper(db_hostname, db_username, db_password);
        }

        return localdbhelper;
    }

    public void status() {
        Utils.log(" Max active - " + source.getMaxActive() + "active - " + source.getNumActive() + " idle - "
                + source.getNumIdle());
    }
    //根据解决状态、物资类型进行模糊查询
    public List<DemandItemEntity> queryDemandListByCondition(String topicStatus, String itemType, String content) {

        List<DemandItemEntity> list = new ArrayList<DemandItemEntity>();

        try {
            Connection con = source.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from demand where topic_status=? and item_type=? and instr(title,?) > 0");
            ps.setString(1, topicStatus);
            ps.setString(2, itemType);
            ps.setString(3, content);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                DemandItemEntity demand_item = new DemandItemEntity();
                demand_item.id = rs.getInt(1) + "";
                demand_item.item_type = rs.getString(2);
                demand_item.title = rs.getString(3);
                demand_item.full_content = rs.getString(4);

                demand_item.publish_date = rs.getString(5);
                demand_item.address = rs.getString(6);
                demand_item.contact_person_name = rs.getString(7);

                demand_item.contact = rs.getString(8);
                demand_item.topic_status = rs.getString(9);
                demand_item.urgency_rating = rs.getString(10);

                demand_item.verify_status = rs.getString(11);
                demand_item.publish_date_epoch_time = rs.getString(12);

                list.add(demand_item);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //根据解决状态、物资类型进行模糊查询
    public List<ContributorItemEntity> queryContributorListByCondition(String topicStatus, String itemType, String content) {

        List<ContributorItemEntity> list = new ArrayList<ContributorItemEntity>();

        try {

            Connection con = source.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from contributor where topic_status=? and item_type=? and instr(title,?) > 0");
            ps.setString(1, topicStatus);
            ps.setString(2, itemType);
            ps.setString(3, content);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ContributorItemEntity contribution_item = new ContributorItemEntity();
                contribution_item.id = rs.getInt(1) + "";
                contribution_item.item_type = rs.getString(2);
                contribution_item.title = rs.getString(3);
                contribution_item.full_content = rs.getString(4);

                contribution_item.publish_date = rs.getString(5);
                contribution_item.address = rs.getString(6);
                contribution_item.contact_person_name = rs.getString(7);

                contribution_item.contact = rs.getString(8);
                contribution_item.topic_status = rs.getString(9);
                contribution_item.urgency_rating = rs.getString(10);

                contribution_item.verify_status = rs.getString(11);
                contribution_item.publish_date_epoch_time = rs.getString(12);

                list.add(contribution_item);

            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<FakeNewsItemEntity> queryFakeNewsListByCondition(String itemType, String content) {


        List<FakeNewsItemEntity> list = new ArrayList<FakeNewsItemEntity>();

        try {
            Connection con = source.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from fakenews where item_type=? and instr(title,?) > 0");
            ps.setString(1, itemType);
            ps.setString(2, content);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FakeNewsItemEntity fakenews_item = new FakeNewsItemEntity();
                fakenews_item.id = rs.getInt(1) + "";
                fakenews_item.item_type = rs.getString(2);
                fakenews_item.pic = rs.getString(3);
                fakenews_item.title = rs.getString(4);
                fakenews_item.full_content = rs.getString(5);
                fakenews_item.publish_date = rs.getString(6);
                fakenews_item.publish_date_epoch_time = rs.getString(7);

                list.add(fakenews_item);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
