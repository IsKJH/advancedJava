package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//sql문의 insert명령문을 실행
public class InsertTest {

	public static void main(String[] args) {
		// localhost = 127.0.0.1
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		String sql = "insert into customer values('test', '1234', '석진', '부산', sysdate())";
		try {
			// 1. 드라이버로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL 드라이버 로딩 성공!!!");
			// 2. DBMS에 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공:" + con);
			// 3. SQL문을 실행하기 위한 객체를 생성
			Statement stmt = con.createStatement();
			System.out.println("Statement객체생성=>" + stmt);
			// 4. SQL문 실행
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개 행 삽입성공!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
