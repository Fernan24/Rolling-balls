import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Sorting{
/**
 * This Function sorts the arryalist by the hisghest score in increasing order
 * @param list list to be sorted
 * @param focusIndex the element of the string you want to sort the list relative to 
 * @return sorted list
 */
	public static ArrayList<String> sortByHighestScore(ArrayList<String> list, int focusIndex){
		for(int i=list.size();i>0;i--){
			for(int j=0;j<list.size()-1;j++){
				String line1=list.get(j);
				String[] linediv1=line1.split(" ");
				String line2= list.get(j+1);
				String[] linediv2= line2.split(" ");
				if(Integer.parseInt(linediv1[focusIndex])>Integer.parseInt(linediv2[focusIndex])){
					Collections.swap(list, j, j+1);
				}	
			}
		}
		return list;
	}
	/**
	 * Sorts the list of games played in decreasing date order
	 * @param list list to be sorted
	 * @return sorted list
	 */
	public static ArrayList<String> sortByDate(ArrayList<String>list){
		ArrayList<String> newlist= new ArrayList<String>();
		for (int i=list.size()-1;i>=0;i-- ) {
			newlist.add(list.get(i));
		}
		
		return newlist;
	}
	/**
	 * Sorts the list of usernames and highscores by increasing alphabetical order
	 * @param list list to be sorted
	 * @return sorted list
	 */	
	public static ArrayList<String> sortByUserName(ArrayList<String> list){
		Collections.sort(list);
		return list;
	}
	/**
	 * This method sorts the list by the date of the highscore
	 * @param list list to be sorted
	 * @param focusIndex index of element to be compared to sort
	 * @return sorted list
	 */
	public static ArrayList<String> sortByHSDate(ArrayList<String> list, int focusIndex){
		for(int i=list.size();i>0;i--){
			for(int j=0;j<list.size()-1;j++){
				String line1=list.get(j);
				String[] linediv1=line1.split(" ");
				String line2= list.get(j+1);
				String[] linediv2= line2.split(" ");
				if(Date.parse(linediv1[focusIndex])<Date.parse(linediv2[focusIndex])){
					Collections.swap(list, j, j+1);
				}	
			}
		}
		return list;
	}
	
	
	
	

	
	
}
