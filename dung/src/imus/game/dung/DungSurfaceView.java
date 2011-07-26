package imus.game.dung;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public class DungSurfaceView extends SurfaceView implements Callback {
	MainThread mThread;
	SurfaceHolder mHolder;
	
	public DungSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		mHolder = holder;
		mThread = new MainThread (holder, context);
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mThread.start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		boolean done = true;
		while (done) {
			try {
				mThread.join();
				done = false;
			}
			catch(InterruptedException e){
				
			}
		}
	}

}
