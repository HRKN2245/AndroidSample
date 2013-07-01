package jp.recognize.scenery.android;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * CameraのPreview表示をするViewです。
 * 
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback, AutoFocusCallback {
	private final String TAG = CameraPreview.class.getSimpleName();
	private Camera camera;
	private PictureCallback pictureCallback;

	public CameraPreview(Context aContext, PictureCallback pictureCallback) {
		super(aContext);

		this.pictureCallback = pictureCallback;
		getHolder().addCallback(this);
		getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
		Log.d(TAG, "surfaceChanged");

		if (camera == null) {
			return;
		}

		camera.startPreview();
	}

	public void surfaceCreated(SurfaceHolder surfaceHolder) {
		Log.d(TAG, "surfaceCreated");

		try {
			camera = Camera.open();
			Parameters parameters = camera.getParameters();
			Size previewSize = max(parameters.getSupportedPreviewSizes());
			parameters.setPreviewSize(previewSize.width, previewSize.height);
			camera.setParameters(parameters);

			camera.setPreviewDisplay(surfaceHolder);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Size max(List<Size> supportedPreviewSizes) {
		Log.d(TAG, "supported preview size");
		int maxArea = Integer.MIN_VALUE;
		Size maxSize = null;
		for (Size size : supportedPreviewSizes) {
			int area = size.width * size.height;
			if (maxArea < area) {
				maxArea = area;
				maxSize = size;
			}
		}

		return maxSize;
	}

	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		Log.d(TAG, "surfaceDestroyed");
		releaseCamera();
	}

	public void releaseCamera() {
		if (camera == null) {
			return;
		}

		camera.setPreviewCallback(null);
		camera.stopPreview();
		camera.release();
		camera = null;
	}

	public void onAutoFocus(boolean success, Camera camera) {
		if (!success) {
			return;
		}

		camera.takePicture(null, null, pictureCallback);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		camera.autoFocus(this);
		return super.onTouchEvent(event);
	}
}