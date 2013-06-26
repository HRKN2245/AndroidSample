package test.activitysample;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class ActivitySampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_sample);
		Log.v("ActivitySample","onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample, menu);
		return true;
	}

	@Override
	protected void onStart() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStart();
		Log.v("ActivitySample","onStart");
	}

	@Override
	protected void onStop() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStop();
		Log.v("ActivitySample","onStop");
	}
}
