package org.younes.quiz_game;
import java.net.URL;
import java.sql.*;

public class DBConnect {
		
	public static Connection connect() {
		Connection conn = null;
        try {
            // db parameters
        	URL path = DBConnect.class.getResource("DataBase\\levelsDB.db");
            String url = "jdbc:sqlite:"+path;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
           
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());}

        return conn ;
    }
	
	public static Level getLevelData(String level_number) {
		Level leveldata = new Level();
		ResultSet rs = null;
	    String select = "SELECT * from Levels WHERE levelName = ?";
	    Connection c = connect() ;
		PreparedStatement st = null;
		
	    try {
			st = c.prepareStatement(select);
			st.setString(1, level_number);
			rs = st.executeQuery();
			
			leveldata.setId(rs.getInt("id"));
			leveldata.setLevelname(rs.getString("levelName"));
			leveldata.setPhotodir(rs.getString("photoDir"));
			leveldata.setSolution(rs.getString("solution"));
			
			// because SQLLite doesn't have true or false , numeric only , so ....
			if (rs.getInt("solved")==0) { leveldata.setSolved(false); } else {leveldata.setSolved(true);}
			
			leveldata.setAttempts(rs.getInt("attempts"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

		return leveldata ;
	}
	
	
}
