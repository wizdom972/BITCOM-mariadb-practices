package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.UserVo;

public class UserDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.123:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading error: " + e);
		}
		
		return conn;
	}

	public boolean insert(UserVo vo) {
		boolean result = false;
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?, ?)");) {

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getPhone());
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}

	public List<UserVo> findAll() {
		List<UserVo> result = new ArrayList<>();
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT no, name, email, phone FROM user");
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				UserVo vo = new UserVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setPhone(rs.getString(4));
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}

	public boolean deleteByNo(Long no) {
		boolean result = false;
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE no = ?")) {

			pstmt.setLong(1, no);
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}
}
