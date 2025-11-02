package Easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * main
 */
public class App1 {

  public static void main(String[] args) {
	  
	  Map<Integer, Integer> m = new HashMap();
	  m.put(1, 1);
	  m.computeIfAbsent(1, k -> {return 2;});
	  
	  for(int i : m.keySet())
	  {
		  System.out.println(i);
	  }
	  
	  for(Map.Entry<Integer, Integer> entries : m.entrySet())
	  {
		  int key = entries.getKey();
		  int val = entries.getValue();
		  System.out.println("key "+key);
		  System.out.println("value "+val);
	  }
	  
	  System.out.println("hello world");
	  
		Stack<Character> st = new Stack<Character>();
		
		st.push('(');
		st.pop();
		st.empty();
		st.isEmpty();
		
		Queue<Integer> q = new PriorityQueue();
		q.add(3);
		q.poll();
		q.peek();
		q.isEmpty();
		Iterator<Integer> it  = q.iterator();
	
//		Queue<String> testQ = new PriorityQueue<String>(Comparator.comparing( o -> o.hashCode())		
	  if(IsValidString("bba b c b abb"))
	  {
		  System.out.println("Valid");
	  }
	  else
	  {
		  System.out.println("Invalid");
	  } 	  
  }
  
  static boolean IsValidString(String s)
  {
	  if(s == null)
	  {
		  return false;
	  }
	  
	  int low = 0;
	  int high = s.length()-1;
	  
	  while(low<high)
	  {
		  if(s.charAt(low) == ' ')
		  {
			  low++;
		  }
		  
		  if(s.charAt(high) == ' ')
		  {
			  high--;
		  }
		  
		  if(s.charAt(low) != s.charAt(high))
		  {
			  return false;
		  }
		  low++;
		  high--;
	  }
	  
	  return true;
//	  String reverse="";
//	  for(int i=0; i<s.length(); i++)
//	  {
//		  reverse = s.charAt(i) + reverse;
//	  }
//	  System.out.println("Reverse: "+reverse);
//	  
//	  for(int i=0; i<s.length(); i++)
//	  {
//		  if(s.charAt(i) != reverse.charAt(i))
//		  {
//			  return false;
//		  }
//	  }	  
//	  return true;
  }
}