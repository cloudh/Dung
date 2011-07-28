package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Item {
	Bitmap img;	//아이템 이미지 
	int x, y;	//아이템 좌표
	int sy;		//아이템 속
	int dw, dh; //아이템 중심점 
	
	Item (Context context,Bitmap img, int _x, int _y, int _sy)	{
		x = _x;
		y = _y;
		sy = _sy;
		dw = img.getWidth() / 2;
		dh = img.getHeight() / 2;
	}
	
	public void move () {
		y += sy;
	}
}
