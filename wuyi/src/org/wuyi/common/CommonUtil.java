package org.wuyi.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class CommonUtil {

	protected static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	protected static SimpleDateFormat YEAR_FORMATTER = new SimpleDateFormat("yyyy");
	protected static SimpleDateFormat MONTH_FORMATTER = new SimpleDateFormat("MM");
	
	private static String filePath = null;
	
	public static Timestamp getTimestamp()
	{
		return new Timestamp((new Date()).getTime());
	}
	
	public static Date getDate()
	{
		return formatDate(formatDate(new Date()));
	}
	
	public static String thisYear()
	{
		try
		{
			return YEAR_FORMATTER.format(new Date());
		}
		catch (Exception e)
		{
			return "";
		}
	}

	public static String thisMonth()
	{
		try
		{
			return MONTH_FORMATTER.format(new Date());
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static Date formatDate(String dateStr)
	{
		try
		{
			return DATE_FORMATTER.parse(dateStr);
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public static String formatDate(Date date)
	{
		try
		{
			return DATE_FORMATTER.format(date);
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static boolean isEmpty(String str)
	{
		if (str == null || "".equals(str.trim()))
		{
			return true;
		}
		
		return false;
	}
	
	public static String getFileExt(String fileName)
	{
		try{
			return fileName.substring(fileName.lastIndexOf("."), fileName.length()).toUpperCase();
		}
		catch (Exception e) {
			return "";
		}
	}
	
	public static String getFilePath()
	{
		if (filePath == null) {
			
			try {
				Properties property = new Properties();
				String path = new CommonUtil().getClass().getResource("/").getPath();
		        path=path.substring(1, path.indexOf("classes"));
		       
				property.load(new FileInputStream(path + "system.properties"));
				filePath = property.getProperty("upload.file_path");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return filePath;
	}
	
	public static String getFilePath(String subFolder)
	{
		return getFilePath() + subFolder;
	}
	
	public static Date dateAdd(Date baseDate, int days) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(baseDate);
        canlendar.add(Calendar.DATE, days); 
        return canlendar.getTime();
	}
}
