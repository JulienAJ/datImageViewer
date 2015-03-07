package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DatabaseHandler
{
	private static String tableName = "Tags";
	private static String databaseFile = "jdbc:sqlite:tags.db";
	private static Connection con = null;

	private static Connection getConnection()
	{
		if(null == con)
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:tags.db");

				Statement statement = con.createStatement();
				statement.setQueryTimeout(10);

				statement.executeUpdate("create table if not exists Tags (path text primary key, tags text)");
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
				closeConnection();
			}
		}
		return con;
	}

	private static void closeConnection()
	{
		try
		{
			if(con != null)
				con.close();
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static List<String> getTags(String path)
	{
		List<String> tagsList = null;
		String tags = null;
		try
		{
			Connection connection = getConnection();
			PreparedStatement request = connection.prepareStatement("select tags from Tags where path = \"" + path + "\"");
			request.setQueryTimeout(10);
			ResultSet result = request.executeQuery();

			if(result.next())
				tags = result.getString("tags");

			closeConnection();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

		if(tags == null)
			return null;

		String[] tagsTab = tags.split(";");
		tagsList = new ArrayList<String>();
		for(String tag : tagsTab)
			tagsList.add(tag);

		return tagsList;
	}

	public static void setTags(String path, List<String> tagsList)
	{
		String tagsString = "";

		int size = tagsList.size();
		for(int i = 0; i < size; ++i)
			tagsString += (tagsList.get(i) + ';');
		try
		{
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("insert or replace into Tags (path, tags) values(\""
					+ path + "\", \"" + tagsString + "\")");
			statement.setQueryTimeout(10);
			statement.executeUpdate();

			closeConnection();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static boolean changePath(String oldPath, String newPath)
	{
		List<String> tagsList = getTags(oldPath);
		boolean okay = false;
		try
		{
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from Tags where path = \""+ oldPath + "\"");
			statement.setQueryTimeout(10);
			statement.executeUpdate();

			closeConnection();
			okay = true;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}

		if(okay)
		{
			setTags(newPath, tagsList);
			return true;
		}
		return false;
	}
}
