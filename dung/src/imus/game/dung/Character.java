package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Character {
	Bitmap img;
	int x, y;	//캐릭터 좌표
	int sx;	//캐릭터 속도
	
	//생성자 상대적인 캐릭터 크기와, 좌표 설정
	Character (Context context, int x, int y) {
		
	}
	
	public void move () {
		x += sx;
	}
}
