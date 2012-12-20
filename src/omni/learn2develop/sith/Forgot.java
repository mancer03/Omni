package omni.learn2develop.sith;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Forgot extends Activity
{
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.forgot);
	        
	        //Initialize Buttons 
	        Button submit = (Button) findViewById(R.id.Submit);
	        final EditText emailaddress = (EditText) findViewById(R.id.txtemail);
	        
	       submit.setOnClickListener(new View.OnClickListener() 
	        {
				
				@Override
				public void onClick(View view)
				{
					//Set up android client 
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost("http://www.tgl.vacau.com/forgot.php");
					
					//
					List<NameValuePair> send = new ArrayList<NameValuePair>(1);
					send.add(new BasicNameValuePair("email", emailaddress.getText().toString() ));
					
					try {
						httppost.setEntity(new UrlEncodedFormEntity(send));
						ResponseHandler<String> responseHandler = new BasicResponseHandler();
						
						JSONObject json = new JSONObject(httpclient.execute(httppost, responseHandler));
						Toast.makeText(getBaseContext(), json.get("password").toString(), Toast.LENGTH_LONG).show();
						
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			});
	        
	        
	}
}
	 