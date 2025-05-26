package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		StringBuffer sql = new StringBuffer();
		sql.append("select * from customer");

		try {
			// 1. 드라이버로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DBS에 접속
			Connection conn = DriverManager.getConnection(url, user, password);
			// 3. SQL문을 실행하기 위한 객체를 생성
			Statement stmt = conn.createStatement();
			// 4. SQL문 실행
			ResultSet rs = stmt.executeQuery(sql.toString());
			System.out.println("select실행결과=>" + rs);
			// 5. 실행결과 처리 - 레코드가 존재하는 동안 반복 실행
			while (rs.next()) { // 레코드가 있으면 true, 없으면 false 반환
				System.out.print(rs.getString(1) + "\t"); // 조회된 테이블에서 1번 컬럼 읽기
				System.out.print(rs.getString("pass") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getDate(5) + "\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
