import com.sun.deploy.net.HttpResponse;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMain
{
	List<String> textList = new ArrayList();

	public static String test = "Welcome to" + "${resources.name}!";
	public void addText(String text) {
		textList.add(text);
	}

	public List getTextList() {
		return this.textList;
	}
	public static void main(String[] arg){
		System.out.println(TestMain.test);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet( "https://holidays.flydubai.com/en/utils/cityairportmapping?v=1" );
		request.addHeader( "Content-Type", "application/json" );
		request.addHeader( "Accept", "application/json, text/plain, */*" );
		request.addHeader( "Accept-Language", "en-US" );
		request.addHeader( "Connection", "keep-alive" );

		try
		{
			HttpResponse response = httpClient.execute( request );
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}
}
