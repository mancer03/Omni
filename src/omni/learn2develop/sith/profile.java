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
import android.widget.TextView;
import android.widget.Toast;

public class profile extends Activity
{
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.profile);
	        
	        //Initialize Buttons 
	        TextView gamertag = (TextView) findViewById(R.id.txtinfo);
	        TextView fullname = (TextView) findViewById(R.id.txtinfo2);
	        TextView pnonenum = (TextView) findViewById(R.id.txtinfo3);
	        TextView platforms = (TextView) findViewById(R.id.txtinfo4);
	        TextView about = (TextView) findViewById(R.id.txtinfo5);
	        
	        
	        
	        
	}
}