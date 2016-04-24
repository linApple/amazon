package getEmail.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {
	public static void main(String[] args) throws IOException {
		String sUrl = "https://www.amazon.com/";
		StringBuilder sbR = new StringBuilder();
		URL url1 = new URL(sUrl);
		HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
		connection1.setDoOutput(true);
		connection1.setReadTimeout(10 * 1000);
		connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(connection1.getInputStream()));
		String line1 = br1.readLine();
		while (line1 != null) {
			sbR.append(line1);
			line1 = br1.readLine();
		}
		
		System.out.println("start");
		Document doc = Jsoup.parse(sbR.toString());
		Element ele=doc.getElementById("nav-tools");
		System.out.println(ele.child(0).attr("href"));
		System.out.println("end");


	}
}
