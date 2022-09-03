package org.younes.quiz_game;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;


public class DBConnect {
	 
	public static Connection connect() {
		Connection conn = null;

        try {
            // db parameters
        	URL path = DBConnect.class.getResource("DataBase\\levelsDB.db");
            String url = "jdbc:sqlite:"+path;
            
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            if (conn != null ) {System.out.println("Connection to SQLite has been established.");}
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());}
        
        
        return conn ;
         
    }
	
	public static boolean[] getLevelsolved() {
		boolean[] arr = new boolean[36];
	    String select = "SELECT solved from Levels ";
	    Connection c = connect() ;
		PreparedStatement st = null;
		Arrays.fill(arr,true);
		
        try {
			st = c.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			
			for (int i = 0 ; i <arr.length ; i++) {
				if (rs.next()) {
					if(rs.getInt("solved")==1) arr[i] = false ;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return arr; 
	}
	
	public static Level getLevelData(String level_name) {
		Level leveldata = new Level();
		ResultSet rs = null;
	    String select = "SELECT * from Levels WHERE levelName = ?";
	    Connection c = connect() ;
		PreparedStatement st = null;
		
		
	    try {
			st = c.prepareStatement(select);
			st.setString(1, level_name);
			rs = st.executeQuery();
			
			leveldata.setId(rs.getInt("id"));
			leveldata.setLevelname(rs.getString("levelName"));
			leveldata.setPhotodir(rs.getString("photoDir"));
			leveldata.setSolution(rs.getString("solution"));
			
			// because SQLLite doesn't have true or false , numeric only , so ....
			if (rs.getInt("solved")==0) { leveldata.setSolved(false); } else {leveldata.setSolved(true);}
			
			leveldata.setAttempts(rs.getInt("attempts"));

		    st.close();
	        c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

		return leveldata ;
	}
	
	public static void updateSolved(int level_id) {
		
		 String update = "UPDATE Levels SET solved = 1 WHERE id = ?";
		 Connection c = connect() ;
		 PreparedStatement st = null;

		 
			 try {
				st = c.prepareStatement(update);
				 st.setInt(1, level_id);
				 st.executeUpdate();
				 System.out.println("\n ["+level_id+"]------------------------ updateSolved = 1");
				 
				 st.close();
				 c.close();;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
	}
	
	public static void updateAttempts(int level_id) {
		
		 String update = "UPDATE Levels SET attempts = attempts+1 WHERE id = ?";
		 Connection c = connect() ;
		 PreparedStatement st = null;
		  

			 try {
				st = c.prepareStatement(update);
				 st.setInt(1, level_id);
				 st.executeUpdate();
				 System.out.println("\n ["+level_id +"]------------------------ updateAttempts +1");

				 
				 printDatabase();
				    st.close();
				    c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void printDatabase() {
		Connection c = connect() ;
		PreparedStatement st = null;
		
        System.out.println("\n ===============================-- ");
        try {
			st = c.prepareStatement("SELECT * FROM Levels;");
			ResultSet rs = st.executeQuery();
			
			  while ( rs.next() ) {
			     int id = rs.getInt("id");
			     String  levelName = rs.getString("levelName");
			     String photoDir  = rs.getString("photoDir");
			     String  solution = rs.getString("solution");
			     int solved = rs.getInt("solved");
			     int attempts = rs.getInt("attempts");
			     
			     System.out.println( "id        = " + id );
			     System.out.println( "levelName = " + levelName );
			     System.out.println( "photoDir  = " + photoDir );
			     System.out.println( "solution  = " + solution );
			     System.out.println( "solved    = " + solved );
			     System.out.println( "attempts  = " + attempts );
			     System.out.println();
			  }
			  
			 System.out.println("\n =============================== ");

			  rs.close();
			  st.close();
			  c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}

	public static void resetInitial() {
		Connection c = connect();
		PreparedStatement st = null;
		String sql = "UPDATE Levels SET solved = 0 , attempts = 0";


		try {
			st = c.prepareStatement(sql);
			st.executeUpdate();

			st.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static int[] getStatic(){
		
		Connection c = connect();
		PreparedStatement st = null;
		ResultSet rs = null;
		int[] resarray = new int[5];
		String sql0 = "SELECT count(solved) as res FROM Levels WHERE solved=1" ;
		String sql1 = "SELECT count(attempts) as res FROM Levels WHERE attempts=1";
		String sql2 = "SELECT count(attempts) as res FROM Levels WHERE attempts=2";
		String sql3 = "SELECT count(attempts) as res FROM Levels WHERE attempts>=3";
		String sql4 = "SELECT sum(attempts) as res FROM Levels";
		
		try {
			st = c.prepareStatement(sql0);
			rs = st.executeQuery();
			resarray[0] = rs.getInt("res"); 
			
			st = c.prepareStatement(sql1);
			rs = st.executeQuery();
			resarray[1] = rs.getInt("res"); 
			
			st = c.prepareStatement(sql2);
			rs = st.executeQuery();
			resarray[2] = rs.getInt("res"); 
			
			st = c.prepareStatement(sql3);
			rs = st.executeQuery();
			resarray[3] = rs.getInt("res"); 
			
			st = c.prepareStatement(sql4);
			rs = st.executeQuery();
			resarray[4] = rs.getInt("res"); 
			
			st.close();
			rs.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return resarray;
	}
}
