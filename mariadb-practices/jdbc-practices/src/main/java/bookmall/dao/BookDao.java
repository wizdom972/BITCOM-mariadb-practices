package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;

public class BookDao {
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

	public boolean insert(BookVo vo) {
		boolean result = false;
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO book VALUES (NULL, ?, ?, ?)");) {

			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setFloat(3, vo.getCategoryNo());
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}

	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<>();
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT no, title, price, category_no FROM book");
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				BookVo vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCategoryNo(rs.getLong(4));
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
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM book WHERE no = ?")) {

			pstmt.setLong(1, no);
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}
}
