package imus.game.dung;

import java.util.Random;

import android.content.Context;

/*아이템 매니져를 제어하는 스레드입니다. 난이도 설정, 아이템 갯수, 아이템 등장 주기 설정은 여기서 합니다.*/

public class ItemManagementThread extends Thread {
	private ItemManagement itemManagement;
	private int itemNumber;
	private int level;
	private int itemCycle;
	private Random rnd;
	
	public ItemManagementThread (Context context, ItemManagement _itemManagement) {
		itemManagement = _itemManagement;
		itemNumber = 1;
		level = 1;		//1레벨이 처음 시작 
		itemCycle = 1;	//1초 
		rnd = new Random();
	}
	
	public void run(){
		while(true){
			try {
				this.wait(itemCycle);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			itemManagement.generationItem(rnd.nextInt(itemNumber));
		}
	}
	
	public int getLevel (){
		return level;
	}
	
	public void setLevel (int _level){
		level = _level;
		itemCycle = ((int)  ((float)(1/level))  * 1000);	// 1레벨일경우 1초에 한번 떨어지고, 2레벨일경우 0.5초 3레벨일경우 0.3초 
		itemNumber = level * 5;	// 1레벨일경우 최대 5개 2레벨일 경우 최대 10개 3레벨일 경우 최대 15개 
	}
}
