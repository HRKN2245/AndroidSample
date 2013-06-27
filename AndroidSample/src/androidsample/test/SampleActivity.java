package androidsample.test;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;

public class SampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
		ListView lv = (ListView)findViewById(R.id.listView1);
		String[] str = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		AdapterSample ad =
				new AdapterSample(this, android.R.layout.simple_list_item_1,str);
		lv.setAdapter(ad);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample, menu);
		return true;
	}
}
