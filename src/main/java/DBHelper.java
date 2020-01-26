package main.java;

/**
 * Created by Cao Lei on 24/3/17.
 */

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import main.java.Entity.ContributorItemEntity;
import main.java.Entity.DemandItemEntity;
import main.java.Entity.FakeNewsItemEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

	public static void main(String args[]) {

		DBHelper dbHelper = new DBHelper(CommonShared.db_hostname, CommonShared.db_username, CommonShared.db_password);

		DemandItemEntity tmp = dbHelper.getDemandByID("1");

		Utils.log(tmp.full_content);

	}

	private BasicDataSource source;

	public DBHelper(String hostname, String username, String password) {
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

	public void status() {
		Utils.log(" Max active - " + source.getMaxActive() + "active - " + source.getNumActive() + " idle - "
				+ source.getNumIdle());
	}

	public ContributorItemEntity getContributorByID(String id) {
		ContributorItemEntity contribution_item = new ContributorItemEntity();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = source.getConnection();
			ps = con.prepareStatement("select * from contributor where id=?");
			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
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
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return contribution_item;
	}

	public List<ContributorItemEntity> getContributionList() {

		List<ContributorItemEntity> list = new ArrayList<ContributorItemEntity>();

		try {

			Connection con = source.getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement("select * from contributor");

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

	public DemandItemEntity getDemandByID(String id) {
		DemandItemEntity demand_item = new DemandItemEntity();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = source.getConnection();
			ps = con.prepareStatement("select * from demand where id=?");
			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
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
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return demand_item;
	}

	public List<DemandItemEntity> getDemandList() {

		List<DemandItemEntity> list = new ArrayList<DemandItemEntity>();

		try {
			Connection con = source.getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement("select * from demand");

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

	public FakeNewsItemEntity getFakenewsByID(String id) {
		FakeNewsItemEntity fakenews_item = new FakeNewsItemEntity();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = source.getConnection();
			ps = con.prepareStatement("select * from fakenews where id=?");
			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				fakenews_item.id = rs.getInt(1) + "";
				fakenews_item.item_type = rs.getString(2);
				fakenews_item.pic = rs.getString(3);
				fakenews_item.title = rs.getString(4);
				fakenews_item.full_content = rs.getString(5);
				fakenews_item.publish_date = rs.getString(6);
				fakenews_item.publish_date_epoch_time = rs.getString(7);
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return fakenews_item;
	}

	public List<FakeNewsItemEntity> getFakenewsList() {

		List<FakeNewsItemEntity> list = new ArrayList<FakeNewsItemEntity>();

		try {
			Connection con = source.getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement("select * from fakenews");

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

} // end
