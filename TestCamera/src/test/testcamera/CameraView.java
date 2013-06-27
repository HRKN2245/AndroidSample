package test.testcamera;

import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback,
														Camera.PictureCallback {
	private SurfaceHolder mHolder;
	private Camera mCamera;
	
	public CameraView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		try{
			mCamera = Camera.open();
			mCamera.setPreviewDisplay(mHolder);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO 自動生成されたメソッド・スタブ
		mCamera.startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		mCamera.stopPreview();
		mCamera.release();
		mCamera = null;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		if(event.getAction() == MotionEvent.ACTION_DOWN)
			mCamera.takePicture(null, null, null, this);
		return true;
	}
	
	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		// TODO 自動生成されたメソッド・スタブ
		try{
			String path = Environment.getExternalStorageDirectory() +
					"/Android/data/" + System.currentTimeMillis() +".jpg";
			
			data2file(data,path);
		}catch(Exception e){}
		camera.startPreview();
	}

	private void data2file(byte[] data, String filename) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		FileOutputStream out = null;
		try{
			out = new FileOutputStream(filename);
			out.write(data);
			out.close();
		}catch(Exception e){
			if(out != null)
				out.close();
			throw e;
		}
	}
}
