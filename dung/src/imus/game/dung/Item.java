package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Item {
	Bitmap img;	//������ �̹��� 
	int x, y;	//������ ��ǥ
	int sy;		//������ ��
	int dw, dh; //������ �߽��� 
	
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
