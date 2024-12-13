package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao {
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

	public boolean insert(OrderVo vo) {
		boolean result = false;

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO orders VALUES (NULL, ?, ?, ?, ?, ?)");) {

			pstmt.setLong(1, vo.getUserNo());
			pstmt.setString(2, vo.getNumber());
			pstmt.setInt(3, vo.getPayment());
			pstmt.setString(4, vo.getShipping());
			pstmt.setString(5, vo.getStatus());
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}

	public List<OrderVo> findByUserNo(Long userNo) {
		List<OrderVo> result = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT no, number, payment, shipping, status FROM orders WHERE user_no = ?")) {

			pstmt.setLong(1, userNo);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					OrderVo vo = new OrderVo();
					vo.setNo(rs.getLong(1));
					vo.setNumber(rs.getString(2));
					vo.setPayment(rs.getInt(3));
					vo.setShipping(rs.getString(4));
					vo.setStatus(rs.getString(5));
					result.add(vo);
				}
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}

	public boolean deleteByNo(Long no) {
		boolean result = false;

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM orders WHERE no = ?")) {

			pstmt.setLong(1, no);
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return result;
	}

	public OrderVo findByNoAndUserNo(Long orderNo, Long userNo) {
		OrderVo vo = null;

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT no, number, payment, shipping, status FROM orders WHERE no = ? AND user_no = ?")) {

			pstmt.setLong(1, orderNo);
			pstmt.setLong(2, userNo);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					vo = new OrderVo();
					vo.setNo(rs.getLong(1));
					vo.setNumber(rs.getString(2));
					vo.setPayment(rs.getInt(3));
					vo.setShipping(rs.getString(4));
					vo.setStatus(rs.getString(5));
				}
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return vo;
	}

	public boolean deleteBooksByNo(Long orderNo) {
		boolean result = false;
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM order_book WHERE order_no = ?")) {

			pstmt.setLong(1, orderNo);
			result = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		return result;
	}

	public boolean insertBook(OrderBookVo vo) {
		boolean result = false;
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO order_book VALUES (NULL, ?, ?, ?, ?)");) {

			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getQuantity());
			pstmt.setInt(4, vo.getPrice());
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}

	public List<OrderBookVo> findBooksByNoAndUserNo(Long orderNo, Long userNo) {
		List<OrderBookVo> result = new ArrayList<>();
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT ob.order_no, ob.book_no, ob.quantity, ob.price, b.title "
				                   + "FROM order_book ob "
				                   + "JOIN book b ON ob.book_no = b.no "
				                   + "WHERE ob.order_no = ? AND b.user_no = ?");) {

			pstmt.setLong(1, orderNo);
			pstmt.setLong(2, userNo);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					OrderBookVo vo = new OrderBookVo();
					vo.setOrderNo(rs.getLong(1));
					vo.setBookNo(rs.getLong(2));
					vo.setQuantity(rs.getInt(3));
					vo.setPrice(rs.getInt(4));
					vo.setBookTitle(rs.getString(5));
					result.add(vo);
				}
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return result;
	}

	public String getBookTitle(Long bookNo) {
		String title = null;
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT title FROM book WHERE no = ?")) {

			pstmt.setLong(1, bookNo);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					title = rs.getString(1);
				}
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return title;
	}
}
