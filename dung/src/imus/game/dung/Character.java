package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Character {
	Bitmap img;
	int x, y;	//ĳ���� ��ǥ
	int sx;	//ĳ���� �ӵ�
	
	//������ ������� ĳ���� ũ���, ��ǥ ����
	Character (Context context, int x, int y) {
		
	}
	
	public void move () {
		x += sx;
	}
}
