package test.receiversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EventReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context co, Intent in) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Log.v("EventReceiver", in.getAction());
	}

}
