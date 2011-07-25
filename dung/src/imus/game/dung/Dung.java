package imus.game.dung;

import android.content.Context;

public class Dung extends Item {
	int id;
	
	Dung(Context context, int _x, int _y, int _sy) {
		super(context, _x, _y, _sy);
		// TODO Auto-generated constructor stub
		id = 0;
	}
	
	public void move ()
	{
		super.x = super.sy;
	}

}
