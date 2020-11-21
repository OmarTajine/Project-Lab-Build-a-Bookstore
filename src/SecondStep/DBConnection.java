package SecondStep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver ");
		}

		try {

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/BookStore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (SQLException e) {
			System.out.println("DataBase connection failed" + e);
		}
	}

	public void DateUse() {

		try {
			stmt = con.createStatement();
			String InsertionRequest = "INSERT INTO book(title, Author, Price, ReleaseDate) VALUES ('The Laws Of Human Nature','Robert Greene',23,'2018-10-16')";
			int EU = stmt.executeUpdate(InsertionRequest);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void DisplayBook() {

		try {
			stmt = con.createStatement();
			String SelectionRequest = "select *from book ";
			ResultSet rs = stmt.executeQuery(SelectionRequest);

			while (rs.next()) {

				System.out.println("id : " + rs.getInt("id"));
				System.out.println("Title : " + rs.getString("title"));
				System.out.println("Author : " + rs.getString("author"));
				System.out.println("Price in Dollars : " + rs.getDouble("price"));
				System.out.println("Release Date: " + rs.getDate("releaseDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
