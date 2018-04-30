/**
 * @(#)Student1.java
 *
 *
 * @author 
 * @version 1.00 2018/4/26
 */

import java.io.*;
import java.util.*;

public class Student1 {

    public static void main(String [] args){
    	
    	try{
    		String fileName = "studentList.txt";
    		String line = "";
    		List<Student> studentList = new ArrayList<Student>();
			
    		 // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	
            	List <String> a = Arrays.asList(line.split(","));
            	 int id = Integer.parseInt(a.get(0));
	        	 String fname = a.get(1).toString();
	        	 double cgpa = Double.parseDouble(a.get(2));
	         
	        	 Student st = new Student(id, fname, cgpa);
	        	 studentList.add(st);
	         
            }
            
            Collections.sort(studentList, new SortName());
	       
	         for(Student st: studentList){
	         	System.out.println(st.getId() +" , "+ st.getFname()+ " , " + st.getGpa());
	         }
    	}catch(Exception e){
    		System.out.println("Exception occured during Student module:"+ e.getMessage());
    	}
        
    }
 }   
   class SortName implements Comparator<Student>
{ 
    public int compare(Student s1, Student s2) {
    	
    int compare = s1.getFname().compareTo(s2.getFname());
    //System.out.println("s1.getFname():"+s1.getFname());
    //System.out.println("s2.getFname():"+s2.getFname());
   // System.out.println("compare:"+compare);
    
    if(s1.getGpa() < s2.getGpa()){  //student 1 gpa is smaller than student 2 gpa 
    	//System.out.println("aaaaa");
        return 1;
        
    }
    else if((s1.getGpa() == s2.getGpa()) && (compare > 0))  //same gpa and name is greater
     {
     //	System.out.println("bbbbb");
        return 1;
    }
    else if((s1.getGpa() == s2.getGpa()) && (compare < 0)) //same gpa and name is smaller
     {
     //	System.out.println("ccccc");
        return 1;
    }
    else if((s1.getGpa() == s2.getGpa()) && compare == 0 && (s1.getId() > s2.getId()))  //same gpa same name but student id is greater
    {
    //	System.out.println("dddddd");
        return 1;
    }
    else
        {
        return -1;
    }
} 
} 	
    class Student
{
	   private int id;
	   private String fname;
	   private double gpa;
	   
	   public Student(int id, String fname, double gpa) {
	      super();
	      this.id = id;
	      this.fname = fname;
	      this.gpa = gpa;
	   }
	   public int getId() {
	      return id;
	   }
	   public String getFname() {
	      return fname;
	   }
	   public double getGpa() {
	      return gpa;
	   }
	}
    
