package hackerrank.algorithm;

import java.util.ArrayList;

/**
 * 
 * [Facebook Question]
 * 
 * Pretty print a json object using proper indentation.
 * 
 * Every inner brace should increase one indentation to the following lines.
 * Every close brace should decrease one indentation to the same line and the
 * following lines. The indents can be increased with an additional ‘\t’
 * 
 * @author Ray LI
 * @date Nov 23, 2017
 * @contact ray@daocha.me
 */
public class PrettyJson {
	
	public static String indend_symbol = "    ";
	
	public static void main(String[] args) {
		ArrayList<String> lines = prettyJSON("{\"data\": [{\"name\": \"page_views_total\",\"period\": \"day\",\"values\": [{\"value\": 0,\"end_time\": \"2017-11-19T08:00:00+0000\"},{\"value\": 0,\"end_time\": \"2017-11-20T08:00:00+0000\"}],\"title\": \"Daily Total views count per Page\",\"description\": \"Daily: Total views count per Page\",\"id\": \"2022660741300318/insights/page_views_total/day\"},{\"name\": \"page_views_total\",\"period\": \"week\",\"values\": [{\"value\": 19,\"end_time\": \"2017-11-19T08:00:00+0000\"},{\"value\": 19,\"end_time\": \"2017-11-20T08:00:00+0000\"}],\"title\": \"Weekly Total views count per Page\",\"description\": \"Weekly: Total views count per Page\",\"id\": \"2022660741300318/insights/page_views_total/week\"},{\"name\": \"page_views_total\",\"period\": \"days_28\",\"values\": [{\"value\": 19,\"end_time\": \"2017-11-19T08:00:00+0000\"},{\"value\": 19,\"end_time\": \"2017-11-20T08:00:00+0000\"}],\"title\": \"28 Days Total views count per Page\",\"description\": \"28 Days: Total views count per Page\",\"id\": \"2022660741300318/insights/page_views_total/days_28\"},{\"name\": \"page_views_logged_in_total\",\"period\": \"day\",\"values\": [{\"value\": 0,\"end_time\": \"2017-11-19T08:00:00+0000\"},{\"value\": 0,\"end_time\": \"2017-11-20T08:00:00+0000\"}],\"title\": \"Daily Total logged-in views count per Page\",\"description\": \"Daily: Total logged-in views count per Page\",\"id\": \"2022660741300318/insights/page_views_logged_in_total/day\"},{\"name\": \"page_views_logged_in_total\",\"period\": \"week\",\"values\": [{\"value\": 8,\"end_time\": \"2017-11-19T08:00:00+0000\"},{\"value\": 8,\"end_time\": \"2017-11-20T08:00:00+0000\"}],\"title\": \"Weekly Total logged-in views count per Page\",\"description\": \"Weekly: Total logged-in views count per Page\",\"id\": \"2022660741300318/insights/page_views_logged_in_total/week\"},{\"name\": \"page_views_logged_in_total\",\"period\": \"days_28\",\"values\": [{\"value\": 8,\"end_time\": \"2017-11-19T08:00:00+0000\"},{\"value\": 8,\"end_time\": \"2017-11-20T08:00:00+0000\"}],\"title\": \"28 Days Total logged-in views count per Page\",\"description\": \"28 Days: Total logged-in views count per Page\",\"id\": \"2022660741300318/insights/page_views_logged_in_total/days_28\"}],\"paging\": {\"previous\": \"https://graph.facebook.com/v2.11/2022660741300318/insights?access_token=EAACEdEose0cBAGhJSAKJ8ddOIEUEQyg6W95H1L6cQwWg5MidEfmC5KKml4ZCgkMBNLnyTsTa08ZCcgvKq1cYXCPEPIrx2Q2qXycuPY89N9n1NT4JDM3dCiP5OBJLobx3TvcDaW1xjccu4VqqDds64oS6VhaepUrV3KnfRtvpqLQlZBoZBTRWEayZBvmhAn2M9XMiZCZCraMHQZDZD&pretty=0&metric=page_views_total%2Cpage_views_logged_in_total&since=1510819200&until=1510992000\",\"next\": \"https://graph.facebook.com/v2.11/2022660741300318/insights?access_token=EAACEdEose0cBAGhJSAKJ8ddOIEUEQyg6W95H1L6cQwWg5MidEfmC5KKml4ZCgkMBNLnyTsTa08ZCcgvKq1cYXCPEPIrx2Q2qXycuPY89N9n1NT4JDM3dCiP5OBJLobx3TvcDaW1xjccu4VqqDds64oS6VhaepUrV3KnfRtvpqLQlZBoZBTRWEayZBvmhAn2M9XMiZCZCraMHQZDZD&pretty=0&metric=page_views_total%2Cpage_views_logged_in_total&since=1511164800&until=1511337600\"}}");
		for(String line : lines) {
			System.out.println(line);
		}
	}
	
	public static ArrayList<String> prettyJSON(String a) {
		int level = 0;
		String rowString = "";
		ArrayList<String> prettyString = new ArrayList<String>();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (c == '[' || c == '{') {
				if (!rowString.isEmpty()) {
					prettyString.add(rowString);
					rowString = "";
				}
				String indend = "";
				for (int n = 0; n < level; n++) {
					indend += indend_symbol;
				}
				rowString += indend;
				rowString += c;
				level++;
			} else if (c == ']' || c == '}') {
				level--;
				if (!rowString.isEmpty()) {
					prettyString.add(rowString);
					rowString = "";
				}

				String indend = "";
				for (int n = 0; n < level; n++) {
					indend += indend_symbol;
				}
				rowString += indend;

				rowString += c;

				if (i + 1 < a.length() && a.charAt(i + 1) == ',') {
					continue;
				}

			} else if (c == ',') {
				rowString += c;
			} else {
				if (rowString.isEmpty()) {
					String indend = "";
					for (int n = 0; n < level; n++) {
						indend += indend_symbol;
					}
					rowString += indend;
				}
				rowString += c;
				continue;
			}

			prettyString.add(rowString);
			rowString = "";

		}
		return prettyString;
	}
}
