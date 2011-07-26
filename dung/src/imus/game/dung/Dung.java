package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Dung extends Item {
	Bitmap img;
	int dw, dh;
	
	Dung(Context context, int _x, int _y, int _sy) {
		super(context, _x, _y, _sy);
		// TODO Auto-generated constructor stub
		img = BitmapFactory.decodeResource(context.getResources(), R.drawable.dung);
		dw = img.getWidth() / 2;
		dh = img.getHeight() / 2;
	}
	
	public void move ()
	{
		super.y += super.sy;
	}

}
