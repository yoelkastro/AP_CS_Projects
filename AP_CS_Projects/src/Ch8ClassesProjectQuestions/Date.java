package Ch8ClassesProjectQuestions;

public class Date {

	int year, month, day;
	
	public Date(int year, int month, int day){
		
		this.year = year;
		this.month = month;
		this.day = day;
		this.updateDate();
		
	}
	
	public void addDays(int days){
		this.day += days;
		this.updateDate();
	}
	
	public void addWeeks(int weeks){
		this.day += weeks * 7;
		this.updateDate();
	}
	
	public int daysTo(Date other){
		return ((this.year * 360) - (other.year * 360)) + ((this.month * 30) - (other.month * 30)) + (this.day - other.day);
	}
	
	public int getDay(){
		return this.day;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public boolean isLeapYear(){
		return (((this.year % 100) % 4 == 0) && ((this.year / 100) % 4 == 0));
	}
	
	private void updateDate(){
		if(this.day > 30){
			this.month = day / 30;
			this.day = day % 30;
		}
		if(this.month > 12){
			this.year ++;
			this.month = 1;
		}
	}
	
	
	
}
