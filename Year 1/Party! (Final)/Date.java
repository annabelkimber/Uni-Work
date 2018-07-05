/**
 * Used to store the date in day, month and year as integers.
 * 
 * @author Alistair
 * @version 1.0
 */
public class Date {
	
	private int year;
	private int month;
	private int day;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * @return the date in the British format of day/month/year
	 */
	public String getBritishDateString() {
		return day + "/" + month + "/" + year;
	}
	
	@Override
	public String toString() {
		return getBritishDateString();
	}
	
}
