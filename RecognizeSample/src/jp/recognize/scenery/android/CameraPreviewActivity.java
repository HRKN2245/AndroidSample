package jp.recognize.scenery.android;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.widget.Toast;

public class CameraPreviewActivity extends Activity {
	public static final String PICTURE_FILENAME = "image.jpg";
	public static final String RESULT_PICTURE_DATASIZE = "RESULT_PICTURE_SIZE";
	private CameraPreview cameraPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cameraPreview = new CameraPreview(this, new PictureCallback() {
			public void onPictureTaken(byte[] data, Camera camera) {
				FileOutputStream fileOutputStream = null;
				BufferedOutputStream bufferedOutputStream = null;
				try {
					fileOutputStream = openFileOutput(PICTURE_FILENAME, MODE_PRIVATE);
					bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
					bufferedOutputStream.write(data);
					cameraPreview.releaseCamera();
					Intent intent = new Intent();
					intent.putExtra(RESULT_PICTURE_DATASIZE, data.length);
					setResult(Activity.RESULT_OK, intent);
				} catch (IOException e) {
					setResult(Activity.RESULT_CANCELED);
				} finally {
					Utils.closeSilently(bufferedOutputStream);
					Utils.closeSilently(fileOutputStream);
				}

				finish();
			}
		});

		setContentView(cameraPreview);
		Toast.makeText(this, "画面をタップして撮影してください。", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		cameraPreview.releaseCamera();
	}

	@Override
	protected void onStop() {
		super.onStop();
		cameraPreview.releaseCamera();
	}

	@Override
	protected void onPause() {
		super.onPause();
		cameraPreview.releaseCamera();
	}
}