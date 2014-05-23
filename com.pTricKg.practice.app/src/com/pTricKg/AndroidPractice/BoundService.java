package com.pTricKg.AndroidPractice;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BoundService extends Service {
	
	//we have to publish an IBinder to clients:
	private final IBinder binder = new LocalBinder();
	private String[] answer = {
			"It is certain",
			"It is decidedly so",
			"Yes - definitely",
			"You may rely on it",
			"As I see it, yes",
			"Most likely",
			"Outlook good",
			"Yes",
			"Signs point to yes",
			"Reply hazy, try again",
			"Ask again later",
			"Better not tell you now",
			"Cannot predict now",
			"Concentrate and ask again",
			"Don't count on it",
			"My reply is no",
			"My sources say no",
			"Outlook not so good",
			"Very doubtful",
	};
	private final Random randomGenerator = new Random();
	
	/**  
	 * Class passed back to the client activity.
	 */
	public class LocalBinder extends Binder {
		BoundService getService() {
			return BoundService.this; // returns itself allows other activities to use methods within
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return binder;
	}

	// Add method
	public int add(int a, int b) {
		return a + b;
	}
	
	//available to the client process:
	public String getAnswer() {
		int msgIndex = randomGenerator.nextInt(20);
		return answer[msgIndex];
	}
	// Not using yet
//	public Timer setTimer() {
//		
//		return null;
//		
//	}

}
