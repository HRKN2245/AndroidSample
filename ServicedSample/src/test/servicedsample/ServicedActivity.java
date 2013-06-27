package test.servicedsample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServicedActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_serviced);
		Button[] bt = new Button[2];
		bt[0] = (Button)findViewById(R.id.button1);
		bt[1] = (Button)findViewById(R.id.button2);
		for(int i=0; i<bt.length; i++){
			bt[i].setOnClickListener(this);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.serviced, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = new Intent(getApplicationContext(), CalledService.class);
		if(v.getId() == R.id.button1)
			startService(intent);
		else
			stopService(intent);
		
	}

}
