package test.eventsample;
//わあい
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;

public class EventActivity extends Activity implements OnLongClickListener,
														OnClickListener{

	int count1 = 0, count2 = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		Button bt = (Button)findViewById(R.id.button1);
		//ボタンにイベントリスナーを追加する。
		bt.setOnClickListener(this);
		bt.setOnLongClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Button bt = (Button)v;
		bt.setText("クリックした回数"+(++count1));
		if(count1 > 10) bt.setEnabled(false);
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Button bt = (Button)v;
		bt.setText("ロングクリックした回数"+(++count2));
		return false;
	}

}
