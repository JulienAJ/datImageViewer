package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

public class DatabaseHandler
{
	private static String tableName = "Tags";
	private static String databaseFile = "jdbc:sqlite:tags.db";
	private static Connection con = null;

	private static void initConnection()
	{
		if(null == con)
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection(databaseFile);

				Statement statement = con.createStatement();
				statement.setQueryTimeout(10);

				statement.executeUpdate("create table if not exists " + tableName + " (path text primary key, tags text)");
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
				closeConnection();
			}
		}
	}

	public static void closeConnection()
	{
		try
		{
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static String getTags(String path)
	{
		String tags = null;
		try
		{
			initConnection();

			PreparedStatement request = con.prepareStatement("select tags from " + tableName + " where path=?");
			request.setString(1, path);
			request.setQueryTimeout(10);
			ResultSet result = request.executeQuery();

			if(result.next())
				tags = result.getString("tags");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

		if(tags == null)
			return null;

		return tags;
	}

	public static void setTags(String path, String tagsList)
	{
		try
		{
			initConnection();
			PreparedStatement statement = con.prepareStatement("insert or replace into " + tableName + " (path, tags) values(?, ?)");
			statement.setString(1, path);
			statement.setString(2, tagsList);
			statement.setQueryTimeout(10);
			statement.executeUpdate();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static boolean changePath(String oldPath, String newPath)
	{
		String tagsList = getTags(oldPath);
		boolean okay = false;
		try
		{
			initConnection();
			PreparedStatement statement = con.prepareStatement("delete from " + tableName + " where path=?");
			statement.setString(1, oldPath);
			statement.setQueryTimeout(10);
			statement.executeUpdate();

			okay = true;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			okay = false;
		}

		if(okay)
		{
			setTags(newPath, tagsList);
			return true;
		}
		setTags(oldPath, tagsList);
		return false;
	}

	public static Map<String, String> search(String searchKey)
	{
		Map<String, String> resultsMap = new HashMap<String, String>();
		String name = null;
		String tags = null;
		try
		{
			initConnection();

			PreparedStatement request = con.prepareStatement("select * from " + tableName + " where tags LIKE ?");
			request.setString(1, '%' + searchKey + '%');
			request.setQueryTimeout(10);
			ResultSet result = request.executeQuery();

			while(result.next())
			{
				name = result.getString("path");
				tags = result.getString("tags");
				resultsMap.put(name, tags);
			}

		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

		return resultsMap;
	}
}
