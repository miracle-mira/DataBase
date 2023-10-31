package database;

import java.sql.*;
import java.util.Scanner;

public class Test {
	
	
	public static void main(String args[])
	{
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://10.211.55.10:4567/madang","mira","0323");
		
		
		/*데이터 삽입*/
		/*
		int bookid = 21;
        String bookname = "달러구트의 꿈백화점";
        String publisher = "북닻";
        int price = 15000;
        
        String insertQuery = "INSERT INTO Book (bookid, bookname, publisher, price) VALUES (?, ?, ?, ?)";
        
        // PreparedStatement 생성
        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

        // 파라미터 값 설정
        preparedStatement.setInt(1, bookid);
        preparedStatement.setString(2, bookname);
        preparedStatement.setString(3, publisher);
        preparedStatement.setInt(4, price);

        // INSERT 문 실행
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("데이터가 성공적으로 삽입되었습니다.");
        }
        
        //출력 
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery("SELECT * FROM Book"); 
        while(rs.next())
        	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)); 
		*/
        
		
		/*데이터 삭제*/
		/*
		//삭제할 데이터의 조건
        int bookidToDelete = 21;

        // SQL DELETE 문
        String deleteQuery = "DELETE FROM Book WHERE bookid = ?";

        // PreparedStatement 생성
        PreparedStatement preparedStatement =con.prepareStatement(deleteQuery);

        // 파라미터 값 설정
        preparedStatement.setInt(1, bookidToDelete);

        // DELETE 문 실행
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("데이터가 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
        
        //출력 
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery("SELECT * FROM Book"); 
        while(rs.next())
        	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)); 
        */
		
		
		//데이터 검색 
		Scanner scanner = new Scanner(System.in);

        System.out.print("검색할 도서 이름을 입력하세요: ");
        String booknameToSearch = scanner.nextLine();

        // SQL SELECT 문
        String selectQuery = "SELECT * FROM Book WHERE bookname = ?";

        // PreparedStatement 생성
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
        preparedStatement.setString(1, booknameToSearch);

        // SELECT 문 실행
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int bookid = resultSet.getInt("bookid");
            String bookname = resultSet.getString("bookname");
            String publisher = resultSet.getString("publisher");
            int price = resultSet.getInt("price");

            System.out.println("도서를 찾았습니다:");
            System.out.println("bookid: " + bookid + ", bookname: " + bookname + ", publisher: " + publisher + ", price: " + price);
        } else {
            System.out.println("데이터를 찾을 수 없음");
        }
        
        preparedStatement.close();
		con.close();
		
		
	}catch(Exception e){
		System.out.println(e);
	}
	}
	
}
