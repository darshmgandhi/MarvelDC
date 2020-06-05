import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import java.net.HttpURLConnection;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manish
 */
public class smsotp {
public static void sendSms(long phone,String otp,String fname, int total) {
try {
String apiKey = "apikey=" + "mcRsuzN7T6w-M8aefbtxpQRz5P2no4wtHn64bL4G46";
String message = "&message=" + "Dear "+ fname + ",your One Time Password for your MarvelVSDC order amounting to Rs."+total+" is "+otp+".";
String sender = "&sender=" + "MarvelVSDC";
String numbers = "&numbers=91" + phone;
HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
String data = apiKey + numbers + message + sender;
conn.setDoOutput(true);
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
conn.getOutputStream().write(data.getBytes("UTF-8"));
final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
final StringBuffer stringBuffer = new StringBuffer();
String line;
while ((line = rd.readLine()) != null) {
System.out.print(line);	
                                       }
rd.close();
				       } 
catch (Exception e) {
System.out.print(e.getMessage());
	            }
        }
    }
