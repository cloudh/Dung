package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Item {
	int x, y;	//������ ��ǥ
	int sy;		//������ ��
	Bitmap img;	//������ �̹���
	
	Item (Context context, int _x, int _y, int _sy)	{
		x = _x;
		y = _y;
		sy = _sy;
	}
	
	public void move () {
		y += sy;
	}
}
