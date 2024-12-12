package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEx01 {
	public static void main(String[] args) {
		insert("기획1팀");
		insert("기획2팀");
	}

	public static boolean insert(String departmentName) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.0.123:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			System.out.println("연결 성공");

			stmt = conn.createStatement();

			String sql = "insert into department values(null, '" + departmentName + "')";
			int count = stmt.executeUpdate(sql);
			
			result = count == 0;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
