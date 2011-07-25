package imus.game.dung;

import android.content.Context;
import android.graphics.Bitmap;

public class Score {
	public int x, y;
	public Bitmap imgScore;
	
	private Bitmap fonts[] = new Bitmap[10];
	private int loop = 0;
	
	public Score (Context context, int _x, int _y, int _score) {
		x = _x;
		y = _y;
	}
	
	public void MakeScore (int _score) {
		String score = "" + _score;
		int length = score.length();
	}
}
