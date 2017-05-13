package com.nepalitutor.DBSSEM;

import java.util.Observable;

public class Data extends Observable {

	/*
	 * This is Model part of MVC. This class is responsible for notifying the
	 * observers that the user has typed
	 */

	int Mistakes = 0;

	public void isTyped(boolean typed) {
		if (typed) {
			setChanged();
			notifyObservers();
		}
	}

}
