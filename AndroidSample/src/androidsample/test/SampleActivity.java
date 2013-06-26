package androidsample.test;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleActivity extends Activity implements OnClickListener{

	private int count1 = 0, count2 = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
		Button[] bt = new Button[2];
		bt[0] = (Button)findViewById(R.id.button1); 
		bt[1] = (Button)findViewById(R.id.button2);
		for(int i=0; i<bt.length; i++){
			bt[i].setOnClickListener(this);  //このクラスで実装するからthis
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Button bt = (Button) v;
		if(v.getId() == R.id.button1) bt.setText(++count1+"���");
		else bt.setText(++count2+"回目");
	}
}
