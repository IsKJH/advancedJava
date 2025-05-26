package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnectionTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			// 1. 드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공!!");
			// 2. 연결
			Connection con = DriverManager.getConnection(url, user, password);
			// 상위타입으로 선언했지만(con) 실제 실행되는 것은 상속받은 하위클래스의 Connection객체가 리턴
			System.out.println("연결성공!!" + con);
			Statement stmt = con.createStatement();
			System.out.println("Statement객체생성=>" + stmt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
