package imus.game.dung;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

public class ItemManagement {
	private ArrayList <Item> itemList;
	private Context context;
	private Display display;
	private int width;
	private Random rnd;
	//private int height;
	
	private enum item {
		DUNG,
		BUDDIHIST,
		MONEY,
		SOJU
	}
	
	int itemNum;
	
	public ItemManagement (Context _context){
		context = _context;
		display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		width = display.getWidth();
		//height = display.getHeight();
		rnd = new Random();
	}
	
	//난이도에 따른 아이템 생성 갯수 설정 
	public void generationItem(int num) {
		Random random = new Random();
		int itemLocation;
		
		for (int i = 0; i < num; i++) {
			itemNum = random.nextInt(20);	//아이템 생성 확률때문에 20까지 생성 
			if (itemNum > 3) {
				itemNum = item.DUNG.ordinal(); //나머지는 전부 DUNG
			}
			
			itemLocation = random.nextInt(width);	//랜덤 X 좌표에 아이템 배치 
			
			if (itemNum == 0){
				synchronized(this) {
					itemList.add(new Dung(context, itemLocation, 0, rnd.nextInt(4) + 4));
				}
			}
			else if(itemNum == 1){
				synchronized(this){
					itemList.add(new Buddhist(context, itemLocation, 0, rnd.nextInt(4) + 4));
				}
			}
			else if(itemNum == 2){
				synchronized(this){
				itemList.add(new Money(context, itemLocation, 0, rnd.nextInt(4) + 4));
			
				}
			}
			else if (itemNum == 3){
				synchronized(this){
				itemList.add(new Soju(context, itemLocation, 0, rnd.nextInt(4) + 4));
			
				}
			}
		}	
	}
	
	public void removeItem (int num) {
		itemList.remove(num);
	}
	
	public void itemMove(){
		//all item move
		for (Item item : itemList){
			item.move();
		}
	}
	
	public ArrayList<Item> getItemList(){
		return itemList;
	}
}
