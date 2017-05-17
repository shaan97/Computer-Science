import javax.swing.*;

public class GUIExample1{
	public static void main(String[] args){

		Date today = new Date(2015,4,5);

		String yearString = JOptionPane.showInputDialog(null, "Year of birth?");
		int year = Integer.parseInt(yearString);

		String monthString = JOptionPane.showInputDialog(null, "Month?");
		int month = Integer.parseInt(monthString);

		String dayString = JOptionPane.showInputDialog(null, "Day?");
		int day = Integer.parseInt(dayString);

		Date birth = new Date(year, month, day);

		JOptionPane.showMessageDialog(null, "You have been alive for " + birth.daysTo(today) + " days!");
	}

}