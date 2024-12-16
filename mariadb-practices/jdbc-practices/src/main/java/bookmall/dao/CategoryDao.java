package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;

public class CategoryDao {
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

	public boolean insert(CategoryVo vo) {
		boolean result = false;

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO category(name) VALUES (?)",
						Statement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(1, vo.getName());
			result = pstmt.executeUpdate() == 1;
			
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
	            if (rs.next()) {
	                vo.setNo(rs.getLong(1)); // 생성된 no를 VO에 설정
	            }
	        }

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}

	public List<CategoryVo> findAll() {
		List<CategoryVo> result = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT no, name FROM category");
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				CategoryVo vo = new CategoryVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
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
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM category WHERE no = ?")) {

			pstmt.setLong(1, no);
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}
}
