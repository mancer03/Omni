package omni.learn2develop.sith;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MediaActivity extends TabActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	/** TabHost will have Tabs */
	TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

	/** TabSpec used to create a new tab.
	* By using TabSpec only we can able to setContent to the tab.
	* By using TabSpec setIndicator() we can set name to tab. */

	/** tid1 is firstTabSpec Id. Its used to access outside. */
	TabSpec firstTabSpec = tabHost.newTabSpec("tid1");
	TabSpec secondTabSpec = tabHost.newTabSpec("tid1");

	/** TabSpec setIndicator() is used to set name for the tab. */
	/** TabSpec setContent() is used to set content for a particular tab. */
	firstTabSpec.setIndicator("First Tab Name").setContent(new Intent(this,FirstTab.class));
	secondTabSpec.setIndicator("Second Tab Name").setContent(new Intent(this,SecondTab.class));

	/** Add tabSpec to the TabHost to display. */
	tabHost.addTab(firstTabSpec);
	tabHost.addTab(secondTabSpec);

	}
}
