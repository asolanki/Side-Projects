

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class main {

	public static void main(String[] args) throws IOException {
		
		final String URL = "http://rabi.phys.virginia.edu/mySIS/CS2/page.php?Semester=1118&Type=Group&Group=CompSci";
		final String TD_TAG = "td";
		final String CLASS_ATTRIB = "class";
		final String CLASS_ATTRIB_UNIT_NAME = "UnitName";
		final String CLASS_ATTRIB_COURSE_NUM = "CourseNum";
		final String CLASS_ATTRIB_COURSE_NAME = "CourseName";
		
		String unitName = "";
		ArrayList<String> courseNumbNameList = new ArrayList<String>();
		String courseNumbName = "";
		
		Document doc = Jsoup.connect(URL).get();
		Elements tdElements = doc.getElementsByTag(TD_TAG);
		
		Element current = null;
		
		
		for (int i = 0; i < tdElements.size(); i++) {
			current = tdElements.get(i);
			if (current.attr(CLASS_ATTRIB) == CLASS_ATTRIB_UNIT_NAME) {
				System.out.println(current.attr(CLASS_ATTRIB));
			}
			
		
		}
		
	}
	
}



