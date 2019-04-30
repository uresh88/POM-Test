import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.*;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.ssl.TrustStrategy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.net.ssl.*;

import static org.apache.http.conn.ssl.SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

public class Main
{


	public static void main(String arg[]){
		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = "https://holidays.flydubai.com/en/utils/cityairportmapping?v=1" ;
		HttpGet request = new HttpGet( "https://holidays.flydubai.com/en/utils/cityairportmapping?v=1" );
		request.addHeader( "Content-Type", "application/json" );
		request.addHeader( "Accept", "application/json, text/plain, */*" );
		request.addHeader( "Accept-Language", "en-US" );
		request.addHeader( "Connection", "keep-alive" );
		request.setHeader("Cache-Control", "no-cache");
//		request.setHeader("Pragma", "no-cache"); // HTTP 1.0.

		int socketTimeout = 25000;
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout( socketTimeout )
				.setConnectTimeout( socketTimeout )
				.setConnectionRequestTimeout( socketTimeout )
				.build();
		request.setConfig( requestConfig );

		try
		{
//			HttpResponse response = httpClient.execute( request );

			CloseableHttpClient httpClient7
					= HttpClients.custom()
					.setSSLHostnameVerifier(new NoopHostnameVerifier())
					.build();
			HttpComponentsClientHttpRequestFactory requestFactory
					= new HttpComponentsClientHttpRequestFactory();
			requestFactory.setHttpClient(httpClient7);

//			ResponseEntity<String> response
//					= new RestTemplate(requestFactory).exchange(
//					url, HttpMethod.GET, null, String.class);

			Connection.Response resp = Jsoup.connect(url) //
					.timeout(20000) //
					.method(Connection.Method.GET) //
					.execute();

			CloseableHttpClient httpClientt = HttpClients.createDefault();
			HttpGet getMethod = new HttpGet(url);
//			HttpResponse response = httpClientt.execute(getMethod);


			ResponseHandler<String> handler = new BasicResponseHandler();
//			String body = handler.handleResponse( response );
//
//			JSONArray jsonArray = new JSONArray( body );
//			for ( int i = 0; i < jsonArray.length(); i++ )
//			{
//				JSONObject result = ( JSONObject ) jsonArray.get( i );
//				if ( result != null )
//				{
//					System.out.println(result.toString());
//				}
//			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
