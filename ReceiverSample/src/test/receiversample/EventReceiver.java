package test.receiversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EventReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context co, Intent in) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("EventReceiver", in.getAction());
	}

}
