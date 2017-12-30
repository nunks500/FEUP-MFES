package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

public class WebSummitTest {
	
	public static void main(String[] args) {
    WebSummit web = new WebSummit();
    int n=0; 
    while(n !=  10) {
    System.out.println("======================");
    System.out.println("=Welcome to WebSummit=");
    System.out.println("======================");
    System.out.println("1. Create News");
    System.out.println("2. Check Journal");
    System.out.println("3. Create Showroom");
    System.out.println("4. Add Startup to Showroom");
    System.out.println("5. Add New Event to the Schedule");
    System.out.println("6. Add Attendee to a Conference");
    System.out.println("7. Check Schedule at a specific time");
    System.out.println("8. Get Number of Attendees of a Schedule");
    System.out.println("9. Get Talks given by Person X");
    System.out.println("10. Exit");
    Scanner reader = new Scanner(System.in);
    n = reader.nextInt(); 
    
    Scanner reader2,reader3,reader4,reader5,reader6,reader7,reader8,reader9,reader10,reader11;
    
    if(n == 1) {
    	System.out.println("Insert Title of News");
    	reader2 = new Scanner(System.in);
    	String n2 = reader2.nextLine();
    	System.out.println("Insert Content of News");
    	reader3 = new Scanner(System.in);
    	String n3 = reader3.nextLine();
    	System.out.println("Insert Day");
    	reader4 = new Scanner(System.in);
    	int n4 = reader4.nextInt();
    	System.out.println("Insert Month");
    	reader5 = new Scanner(System.in);
    	int n5 = reader5.nextInt();
    	System.out.println("Insert Year");
    	reader6 = new Scanner(System.in);
    	int n6 = reader6.nextInt();
    	Types.Date temp = new Types.Date(n4,n5,n6);
    	News news1 = new News(n2,n3,temp);
    	web.addNews(news1);
    	System.out.println("News inserted");
    }
    if(n == 2) {
    	System.out.println(web.getNews());
    }
    if(n == 3) {
    	System.out.println("Insert Day of Start");
    	reader4 = new Scanner(System.in);
    	int n4 = reader4.nextInt();
    	System.out.println("Insert Month of Start");
    	reader5 = new Scanner(System.in);
    	int n5 = reader5.nextInt();
    	System.out.println("Insert Year of Start");
    	reader6 = new Scanner(System.in);
    	int n6 = reader6.nextInt();
    	System.out.println("Insert Day of End");
    	reader7 = new Scanner(System.in);
    	int n7 = reader4.nextInt();
    	System.out.println("Insert Month of End");
    	reader8 = new Scanner(System.in);
    	int n8 = reader5.nextInt();
    	System.out.println("Insert Year of End");
    	reader9 = new Scanner(System.in);
    	int n9 = reader6.nextInt();
    	Types.Date temp = new Types.Date(n4,n5,n6);
    	Types.Date temp2 = new Types.Date(n7,n8,n9);
    	
    	Showroom show = new Showroom(temp,temp2);
    	web.addShowroom(show);
    	
    }
    if(n == 4) {
    	System.out.println("Insert Day of Start");
    	reader4 = new Scanner(System.in);
    	int n4 = reader4.nextInt();
    	System.out.println("Insert Month of Start");
    	reader5 = new Scanner(System.in);
    	int n5 = reader5.nextInt();
    	System.out.println("Insert Year of Start");
    	reader6 = new Scanner(System.in);
    	int n6 = reader6.nextInt();
    	Types.Date temp = new Types.Date(n4,n5,n6);
    	
    	System.out.println("Insert Name of Startup");
    	reader7 = new Scanner(System.in);
    	String n7 = reader7.nextLine();
    	System.out.println("Insert Country of Origin of Startup");
    	reader8 = new Scanner(System.in);
    	String n8 = reader8.nextLine();
    	startup star = new startup(n7,n8);
    	web.getShowroomByDate(temp).addStartupToShowroom(star);
    	System.out.println(web.getShowroomByDate(temp));
    	
    }
    if(n == 5) {
    	
    	System.out.println("Insert Speaker");
    	reader2 = new Scanner(System.in);
    	String n2 = reader2.nextLine();
    	System.out.println("Insert Title of Conference");
    	reader3 = new Scanner(System.in);
    	String n3 = reader3.nextLine();
    	Speaker speak = new Speaker(n2);
    	VDMSet speakers = SetUtil.set();
    	speakers.add(speak);
    	Conference conf = new Conference(n3,speakers);
    	System.out.println("Insert Day of Start");
    	reader4 = new Scanner(System.in);
    	int n4 = reader4.nextInt();
    	System.out.println("Insert Month of Start");
    	reader5 = new Scanner(System.in);
    	int n5 = reader5.nextInt();
    	System.out.println("Insert Year of Start");
    	reader6 = new Scanner(System.in);
    	int n6 = reader6.nextInt();
    	System.out.println("Insert Hour of Start");
    	reader7 = new Scanner(System.in);
    	int n7 = reader4.nextInt();
    	System.out.println("Insert Minute of Start");
    	reader8 = new Scanner(System.in);
    	int n8 = reader5.nextInt();
    	System.out.println("Insert Second of Start");
    	reader9 = new Scanner(System.in);
    	int n9 = reader6.nextInt();
    	
    	System.out.println("Insert Stage Name");
    	reader10 = new Scanner(System.in);
    	String n10 = reader7.nextLine();
    	System.out.println("Insert Capacity of Stage");
    	reader11 = new Scanner(System.in);
    	int n11 = reader6.nextInt();
    	
    	Stage stage = new Stage(n10,n11);
    	
    	Types.Date temp = new Types.Date(n4,n5,n6);
    	Types.Time temp2 = new Types.Time(n7,n8,n9);
    	
    	Schedule schedule = new Schedule(temp2,temp,stage,conf);
    	
    	web.addSchedule(schedule);
    	System.out.println(web.getSchedules());
    	
    	
    	
    	
    }
    
    if(n == 6) {
    	
    	System.out.println("Insert Conference Title");
    	reader4 = new Scanner(System.in);
    	String n4 = reader4.nextLine();
    	Schedule c1 = web.getConferenceWithTitle(n4);
    	System.out.println("Insert new Attendee Name");
    	reader5 = new Scanner(System.in);
    	String n5 = reader5.nextLine();
    	Attendee n1 = new Attendee(n5);
    	web.addAttendeetoConference(n1,c1);
    	System.out.println(web.getSchedules());
    	
    	
    	
    }
    if(n == 7) {
    	
    	System.out.println("Insert Day of Start");
    	reader4 = new Scanner(System.in);
    	int n4 = reader4.nextInt();
    	System.out.println("Insert Month of Start");
    	reader5 = new Scanner(System.in);
    	int n5 = reader5.nextInt();
    	System.out.println("Insert Year of Start");
    	reader6 = new Scanner(System.in);
    	int n6 = reader6.nextInt();
    	System.out.println("Insert Hour of Start");
    	reader7 = new Scanner(System.in);
    	int n7 = reader4.nextInt();
    	System.out.println("Insert Minute of Start");
    	reader8 = new Scanner(System.in);
    	int n8 = reader5.nextInt();
    	System.out.println("Insert Second of Start");
    	reader9 = new Scanner(System.in);
    	int n9 = reader6.nextInt();
    	Types.Date temp = new Types.Date(n4,n5,n6);
    	Types.Time temp2 = new Types.Time(n7,n8,n9);
    	System.out.println(web.getConferenceAt(temp, temp2));
    	
    	
    	
    }
    if(n == 8) {
    	System.out.println("Insert Conference Title");
    	reader4 = new Scanner(System.in);
    	String n4 = reader4.nextLine();
    	Schedule c1 = web.getConferenceWithTitle(n4);
    	System.out.println(c1.getConference().getAttendees());
    	
    	
    }
    if(n == 9) {
    	System.out.println("Insert Speaker Name");
    	reader4 = new Scanner(System.in);
    	String n4 = reader4.nextLine();
    	VDMSet c1 = web.getTalksByName(n4);
    	System.out.println(c1);
    	
    	
    }
    
    
    }

    
  }
}