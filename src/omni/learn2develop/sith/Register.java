package omni.learn2develop.sith;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;



public class Register extends Activity{
	
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.register);
	             
	      //---get the Register button---
	        Button btn = (Button) findViewById(R.id.Registerbtn);
	        
	        //EditText fields 
	        final EditText fname = (EditText) findViewById(R.id.txtComments);
	        final EditText lname = (EditText) findViewById(R.id.txtComments2);
	        final EditText emailaddress = (EditText) findViewById(R.id.txtComments3);
	        final EditText user = (EditText) findViewById(R.id.txtComments4);
	        final EditText pass = (EditText) findViewById(R.id.txtComments5);
	        
	        
	        
	        	
	        btn.setOnClickListener(new View.OnClickListener() 	
	        {
				public void onClick(View v ) 
				{
					
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost("http://www.tgl.vacau.com/test.php");

					//This is the data to send
					String MyName = fname.getText().toString(); //any data to send

					try {
					// Add your data
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
					nameValuePairs.add(new BasicNameValuePair("fname", fname.getText().toString() ));
					nameValuePairs.add(new BasicNameValuePair("lname", lname.getText().toString() ));
					nameValuePairs.add(new BasicNameValuePair("email", emailaddress.getText().toString() ));
					nameValuePairs.add(new BasicNameValuePair("username", user.getText().toString() ));
					nameValuePairs.add(new BasicNameValuePair("password", pass.getText().toString() ));
					
					

					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					
					
					//Reset data fields 
					fname.setText("");
					lname.setText("");
					emailaddress.setText("");
					user.setText("");
					pass.setText("");
					
					

					// Execute HTTP Post Request
					ResponseHandler<String> responseHandler = new BasicResponseHandler();
					
					//Initialize JSON Object from response
					//String response = httpclient.execute(httppost, responseHandler);
					JSONObject json = new JSONObject(httpclient.execute(httppost, responseHandler));
					
					//This is the response from a php application
					//String reverseString = response;
					Toast.makeText(getBaseContext(), json.get("fname").toString() + " " + json.get("lname").toString() + " " + json.get("email").toString() + " " + json.get("gamertag").toString(),
							Toast.LENGTH_LONG).show();

					} catch (ClientProtocolException e) {
					
					// TODO Auto-generated catch block
					} catch (IOException e) {
					
					// TODO Auto-generated catch block
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}});
	 }}

	        
	        
	 
	 


	 
	 
	