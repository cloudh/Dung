package imus.game.dung;

import java.util.Random;

import android.content.Context;

/*������ �Ŵ����� �����ϴ� �������Դϴ�. ���̵� ����, ������ ����, ������ ���� �ֱ� ������ ���⼭ �մϴ�.*/

public class ItemManagementThread extends Thread {
	private ItemManagement itemManagement;
	private int itemNumber;
	private int level;
	private int itemCycle;
	private Random rnd;
	
	public ItemManagementThread (Context context, ItemManagement _itemManagement) {
		itemManagement = _itemManagement;
		itemNumber = 1;
		level = 1;		//1������ ó�� ���� 
		itemCycle = 1;	//1�� 
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
		itemCycle = ((int)  ((float)(1/level))  * 1000);	// 1�����ϰ�� 1�ʿ� �ѹ� ��������, 2�����ϰ�� 0.5�� 3�����ϰ�� 0.3�� 
		itemNumber = level * 5;	// 1�����ϰ�� �ִ� 5�� 2������ ��� �ִ� 10�� 3������ ��� �ִ� 15�� 
	}
}
