package test.servicedsample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CalledService extends Service{

	@Override
	public void onCreate() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Log.v("CalledService","onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Log.v("CalledService","onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Log.v("CalledService","onDestroy");
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

}
