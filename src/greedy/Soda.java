package greedy;

import java.util.ArrayList;
import java.util.HashMap;

public class Soda {
	// [5,5,10,10,20]
	// 5 ++
	// 10
	// 20
	public boolean lemonadeChange(int[] bills) {
        int[] moneyCount = new int[30];
        int sum = 0;
        for(int i = 0;i < bills.length;i++){
        	int money = bills[i];
        	if(money == 5){
        		sum += money;
        	}
        	else if(money == 10){
        		if(moneyCount[5] == 0){
        			return false;
        		}
        		else{
        			moneyCount[5]--;
        		}
        	}
        	else{
        		// need 10 + 5 || 5+5+5
        		if(moneyCount[10] == 0){
        			if(moneyCount[5] < 3){
        				return false;
        			}
        			else{
        				moneyCount[5] -= 3;
        			}
        		}
        		else if(moneyCount[10] < 1){
        			return false;
        		}
        		else{
        			moneyCount[10]--;
        			if(moneyCount[5] < 1){
        				return false;
        			}
        			else{
        				moneyCount[5]--;
        			}
        		}
        	}
        	moneyCount[money]++;
        }
        return true;
    }
	
//	[5,5,10,10,20]
	public static void main(String[] args){
		int[] bills = new int[5];
		bills[0] = 5;
		bills[1] = 5;
		bills[2] = 5;
		bills[3] = 10;
		bills[4] = 20;
		Soda soda = new Soda();
		System.out.println(soda.lemonadeChange(bills));
	}
	
}
