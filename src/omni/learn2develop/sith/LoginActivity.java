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

public class LoginActivity extends Activity
{
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        
	        //Initialize Buttons 
	        Button register = (Button) findViewById(R.id.register);
	        Button login = (Button) findViewById(R.id.LoginButton);
	        Button forgot = (Button) findViewById(R.id.forgot);
	        
	        //Initialize edit text objects 
	        final EditText username = (EditText) findViewById(R.id.Username);
	        final EditText password = (EditText) findViewById(R.id.Password);
	        
	        final Intent o = new Intent(this, Register.class);
	        final Intent p = new Intent(this, Forgot.class);
	        final Intent q = new Intent(this, profile.class);
	        
	        register.setOnClickListener(new View.OnClickListener()
	        {
				public void onClick(View v ) 
				{
					startActivity(o);
				}
	        });
	        
	        forgot.setOnClickListener(new View.OnClickListener()
	        {
				public void onClick(View v ) 
				{
					startActivity(p);
				}
	        });
	        login.setOnClickListener(new View.OnClickListener()
	        {
				public void onClick(View v ) 
				{
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost("http://www.tgl.vacau.com/login.php");
					
					String userSend = username.getText().toString();
					String passSend = password.getText().toString();
					List<NameValuePair> loginInfo = new ArrayList<NameValuePair>(1);
					loginInfo.add(new BasicNameValuePair("username",userSend));
					loginInfo.add(new BasicNameValuePair("password",passSend));
					
					
					try {
						httppost.setEntity(new UrlEncodedFormEntity(loginInfo));
						ResponseHandler<String> responseHandler = new BasicResponseHandler();
						JSONObject json = new JSONObject(httpclient.execute(httppost, responseHandler));
						
						
						String userGet = json.get("username").toString();
						String passwordGet = json.get("password").toString();
						//Toast.makeText(getBaseContext(), json.get("username").toString() + json.get("password").toString(), Toast.LENGTH_LONG).show();
						
						if(userGet.equals(userSend) && passwordGet.equals(passSend)) 
						{
							startActivity(q);
							
						}
						else
						{
							Toast.makeText(getBaseContext(), "Wrong Username or Password", Toast.LENGTH_LONG).show();
						}
						
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
					
					//startActivity(q);
				}
	        });
	}
}
	 
