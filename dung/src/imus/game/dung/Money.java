package imus.game.dung;

import android.content.Context;
import android.graphics.BitmapFactory;

public class Money extends Item {

	Money(Context context, int _x, int _y, int _sy) {
		super(context,BitmapFactory.decodeResource(context.getResources(), R.drawable.money), _x, _y, _sy);
		// TODO Auto-generated constructor stub
	}
	
	public void move ()
	{
		super.y += super.sy;
	}
}
