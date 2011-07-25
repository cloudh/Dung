package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Item {
	int x, y;	//아이템 좌표
	int sy;		//아이템 속
	Bitmap img;	//아이템 이미지
	
	Item (Context context, int _x, int _y, int _sy)	{
		x = _x;
		y = _y;
		sy = _sy;
	}
	
	public void move () {
		y += sy;
	}
}
