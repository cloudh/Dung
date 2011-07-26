package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;

public class MainThread extends Thread {
	SurfaceHolder mHolder;	// save surfaceHolder
	int width, height;	//for view
	Bitmap imgBack;
	Dung dung;
	
	public MainThread (SurfaceHolder holder, Context context) {
		mHolder = holder;
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		
		width = display.getWidth();
		height = display.getHeight();
		
		// 배경을 view사이즈에 맞춥니다.
		imgBack = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
		imgBack = Bitmap.createScaledBitmap(imgBack, width, height, false);
		
		dung = new Dung(context, 0, 0, 4);	//임시 dung 생성 
	}
	
	public void run() {
		Canvas canvas = null;
		while (true) {
				canvas = mHolder.lockCanvas();
			try {
				synchronized (mHolder) {
					dung.move();
					canvas.drawBitmap(imgBack, 0, 0, null);
					canvas.drawBitmap(dung.img, dung.x, dung.y, null);
				}
			}
			finally{
				if (canvas != null)
					mHolder.unlockCanvasAndPost(canvas);
			}
		}
	}
}
