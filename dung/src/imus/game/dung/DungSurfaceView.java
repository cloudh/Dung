package imus.game.dung;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public class DungSurfaceView extends SurfaceView {
	private MainThread mainThread;
	private SurfaceHolder holder;
	
	public DungSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		holder = getHolder();
		holder.addCallback(new Callback() {
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean done = true;
				while (done) {
					try {
						mainThread.itemManagementThread.join();
						mainThread.join();
						done = false;
					}
					catch(InterruptedException e){
						
					}
				}
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				mainThread.start();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
			}
		});
		
		mainThread = new MainThread (holder, context);
		setFocusable(true);
	}
}
