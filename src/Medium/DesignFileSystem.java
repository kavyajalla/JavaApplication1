package Medium;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
	
	Map<String, Integer> map;

	public DesignFileSystem() {
		map = new HashMap<>();
		map.put("", -1); //root path
	}

	public boolean createPath(String path, int value) {
		if(map.containsKey(path))
		{
			return false;
		}
		
		int index = path.lastIndexOf('/');
		if(map.containsKey(path.substring(0, index)) != true)
		{
			return false;
		}
		
		map.put(path, value);
		return true;
	}

	public int get(String path) {
		return map.get(path);
	}
	
}

/**
 * 1166 – Design File System 
 * Medium
 * You need to design a file system that supports two operations:

1. createPath(String path, int value)

Creates a new path and assigns it a value.

Returns true if the operation is successful, otherwise false.

Rules:

The path always starts with '/' and consists of multiple parts (e.g. "/a/b").

Each part of the path must already exist except for the last one.

For example, to create "/a/b", path "/a" must already exist.

You cannot create the same path twice.

Return false if:

The parent path doesn’t exist, or

The path already exists.

2. get(String path)

Returns the value associated with the given path.

Returns -1 if the path doesn’t exist.
*/

class FileSystemPractice{
	Map<String, Integer> paths;
	public FileSystemPractice() {
		paths = new HashMap<String, Integer>();
		paths.put("", -1);
	}
	
	boolean createPath(String path, int value)
	{
		char c = path.charAt(0);
		if(c != '/')
		{
			return false;
		}
		int lastIndex = path.lastIndexOf('/');
		if(!paths.containsKey(path.substring(0, lastIndex)))
		{
			return false;
		}
		if(paths.containsKey(path))
		{
			return false;
		}
		paths.put(path, value);
		return true;
	}
	
	int get(String path)
	{
		return paths.get(path);
	}
}
