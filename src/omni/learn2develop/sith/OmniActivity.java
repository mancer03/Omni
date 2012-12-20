package omni.learn2develop.sith;

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
import android.widget.ProgressBar;

public class OmniActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        //Enter button:
        Button enter = (Button) findViewById(R.id.btnEnter);
        
        //Intent for Login Activity 
      final Intent o = new Intent(this, LoginActivity.class);
        //Intent o = new Intent(this, LoginActivity.class);
				//startActivity(o);
        
        enter.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View view)
			{
				
				startActivity(o);
			}
		});
    }
}