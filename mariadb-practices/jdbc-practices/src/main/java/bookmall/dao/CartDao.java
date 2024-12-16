package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao {
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

	public boolean insert(CartVo vo) {
		boolean result = false;

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO cart(user_no, book_no, quantity) VALUES (?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);) {

			pstmt.setLong(1, vo.getUserNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getQuantity());
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

	public List<CartVo> findByUserNo(Long userNo) {
		List<CartVo> result = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT c.user_no, c.book_no, c.quantity, b.title "
						+ "FROM cart c " + "JOIN book b ON c.book_no = b.no " + "WHERE c.user_no = ?")) {

			pstmt.setLong(1, userNo);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					CartVo vo = new CartVo();

					vo.setUserNo(rs.getLong(1));
					vo.setBookNo(rs.getLong(2));
					vo.setQuantity(rs.getInt(3));
					vo.setBookTitle(rs.getString(4));
					result.add(vo);
				}
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}

	public boolean deleteByUserNoAndBookNo(Long userNo, Long bookNo) {
		boolean result = false;

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM cart WHERE user_no = ? AND book_no = ?")) {

			pstmt.setLong(1, userNo);
			pstmt.setLong(2, bookNo);
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}
}
