import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/my_db";
		String id = "root";
		String password = "root";

		// MySql JDBC Driver 적재(load) 과정 : DB 사용이 필요한 프로젝트에서 접속 전 1회
		// 1. 프로젝트 구성에서 jdbc 드라이버 jar 외부 라이브러리 참조 구성 필요
		try {
			// 2. 적재할 드라이버 명칭 확인
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을수 없습니다. 외부 라이브러리 참조를 확인하세요.");
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("데이터 베이스에 연결 성공");
		} catch (SQLException e) {
			System.out.println("연결 실패. 주소, 아이디, 비밀번호를 확인해주세요.");
		} finally {
			if (conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
