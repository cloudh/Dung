package imus.game.dung;

import android.content.Context;

public class Item {
	int x, y;	//������ ��ǥ
	int sy;		//������ ��
	
	Item (Context context, int _x, int _y, int _sy)	{
		x = _x;
		y = _y;
		sy = _sy;
	}
	
	public void move () {
		y += sy;
	}
}
