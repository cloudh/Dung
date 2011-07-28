package imus.game.dung;

import java.util.Timer;
import java.util.TimerTask;

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
	ItemManagement itemManagement;
	ItemManagementThread itemManagementThread;
	
	public MainThread (SurfaceHolder holder, Context context) {
		mHolder = holder;
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		
		width = display.getWidth();
		height = display.getHeight();
		
		// 배경을 view사이즈에 맞춥니다.
		imgBack = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
		imgBack = Bitmap.createScaledBitmap(imgBack, width, height, false);
		itemManagement = new ItemManagement(context);
		itemManagementThread = new ItemManagementThread(context, itemManagement);
//		itemManagementThread.start();
	}
	
	public void run() {
		Canvas canvas = null;
		
		Timer timer = new Timer(true);
		timer.
		
		while (true) {
			canvas = mHolder.lockCanvas();
			
			try {
				itemManagement.itemMove();
				canvas.drawBitmap(imgBack, 0, 0, null);
				for (Item item : itemManagement.getItemList()){
					canvas.drawBitmap(item.img, item.x, item.y, null);
				}
			}
			finally{
				if (canvas != null)
					mHolder.unlockCanvasAndPost(canvas);
			}
		}
	}
}
