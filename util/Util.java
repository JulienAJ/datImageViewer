package util;

import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class Util
{
	public static boolean isImage(File f)
	{
		String fpath = f.getAbsolutePath();
		int dot = fpath.lastIndexOf('.');
		String extension = fpath.substring(dot + 1).toLowerCase();
		if(extension.equals("jpg") || extension.equals("jpeg")
				|| extension.equals("gif") || extension.equals("bmp")
				|| extension.equals("png"))
		{
			return true;
		}
		return false;
	}

	public static String basename(String path)
	{
		String[] complete = path.split(System.getProperty("file.separator"));
		return complete[complete.length - 1];
	}

	public static String listToString(List<String> list)
	{
		String result = null;
		if(list == null)
			return null;
		int size = list.size();
		for(int i = 0; i < size; ++i)
		{
			if(result == null)
				result = list.get(i);

			else
				result = result + ';' + (list.get(i));
		}
		return result;
	}

	public static List<String> stringToList(String tags)
	{
		if(tags == null)
			return null;

		List<String> result = new LinkedList<String>();
		String[] tagstab = tags.split(";");
		int size = tagstab.length;
		for(int i = 0; i < size; ++i)
		{
			result.add(tagstab[i]);
		}

		return result;
	}

	public static String repFromImg(String imagePath)
	{
		//String img = basename(imagePath);
		//String[] dirs = imagePath.split(System.getProperty("file.separator"));
		//String ret = ;
		//for(String dir : dirs)
		//{
		//	if(!dir.equals(img))
		//	{
		//		ret += dir;
		//		ret += System.getProperty("file.separator");
		//	}
		//}
		//return ret;
		return imagePath.replace(basename(imagePath), "");
	}
}
