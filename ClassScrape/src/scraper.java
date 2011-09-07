
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class scraper {

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

		// establish a connection to URL
		Document doc = Jsoup.connect(URL).get();
		Elements tdElements = doc.getElementsByTag(TD_TAG);

		// begin iterating through each td element
		Element current = null;

		for (int i = 0; i < tdElements.size(); i++) {
			current = tdElements.get(i);

			if (current.attr(CLASS_ATTRIB).equals(CLASS_ATTRIB_UNIT_NAME)) {
				unitName = current.html();
			}

			if (current.attr(CLASS_ATTRIB).equals(CLASS_ATTRIB_COURSE_NUM)) {
				courseNumbName = current.text();
			}

			if (current.attr(CLASS_ATTRIB).equals(CLASS_ATTRIB_COURSE_NAME)) {
				courseNumbName += ": " + current.html();
				courseNumbNameList.add(courseNumbName);
				courseNumbName = "";
			}

		}

		System.out.println(unitName + " courses:");
		for (int i = 0; i < courseNumbNameList.size(); i++) {
			System.out.println(courseNumbNameList.get(i));
		}

	}
	
}
