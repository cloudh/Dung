package imus.game.dung;

import android.content.Context;

public class Item {
	int x, y;	//아이템 좌표
	int sy;		//아이템 속
	
	Item (Context context, int _x, int _y, int _sy)	{
		x = _x;
		y = _y;
		sy = _sy;
	}
	
	public void move () {
		y += sy;
	}
}
