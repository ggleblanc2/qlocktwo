package com.ggl.qlocktwo.controller;

import java.util.Calendar;

import javax.swing.SwingUtilities;

import com.ggl.qlocktwo.model.QlocktwoModel;
import com.ggl.qlocktwo.view.QlocktwoFrame;

public class ClockRunnable implements Runnable {

	private boolean running;

	private long sleepInterval;

	private Calendar now;

	private QlocktwoFrame frame;

	private QlocktwoModel model;

	public ClockRunnable(QlocktwoFrame frame, QlocktwoModel model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			setSleepInterval();
			now = getTime();
			setModelTime(now);
			updateGUI();
			sleep();
		}
	}

	private void setSleepInterval() {
		if (model.isTestClock()) {
			this.sleepInterval = 100L;
		} else {
			this.sleepInterval = 10000L;
		}
	}

	private Calendar getTime() {
		if (model.isTestClock()) {
			return generateFastCalendar();
		} else {
			return Calendar.getInstance();
		}
	}

	private Calendar generateFastCalendar() {
		Calendar now = Calendar.getInstance();
		int seconds = now.get(Calendar.SECOND);
		int minutes = now.get(Calendar.MINUTE);
		minutes = minutes % 24;
		now.set(Calendar.HOUR_OF_DAY, minutes);
		now.set(Calendar.MINUTE, seconds);
		return now;
	}

	private void setModelTime(Calendar now) {
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE) / 5 * 5;

		if (minute > 30)
			hour = ++hour % 12;

		model.clearClock();
		model.setItIs();

		switch (minute) {
		case 0:
			model.setZero();
			break;
		case 5:
			model.setPast();
			model.setFive();
			break;
		case 10:
			model.setPast();
			model.setTen();
			break;
		case 15:
			model.setPast();
			model.setFifteen();
			break;
		case 20:
			model.setPast();
			model.setTwenty();
			break;
		case 25:
			model.setPast();
			model.setTwentyFive();
			break;
		case 30:
			model.setPast();
			model.setThirty();
			break;
		case 35:
			model.setTo();
			model.setTwentyFive();
			break;
		case 40:
			model.setTo();
			model.setTwenty();
			break;
		case 45:
			model.setTo();
			model.setFifteen();
			break;
		case 50:
			model.setTo();
			model.setTen();
			break;
		case 55:
			model.setTo();
			model.setFive();
			break;
		}

		switch (hour) {
		case 0:
			model.setTwelveHour();
			break;
		case 1:
			model.setOneHour();
			break;
		case 2:
			model.setTwoHour();
			break;
		case 3:
			model.setThreeHour();
			break;
		case 4:
			model.setFourHour();
			break;
		case 5:
			model.setFiveHour();
			break;
		case 6:
			model.setSixHour();
			break;
		case 7:
			model.setSevenHour();
			break;
		case 8:
			model.setEightHour();
			break;
		case 9:
			model.setNineHour();
			break;
		case 10:
			model.setTenHour();
			break;
		case 11:
			model.setElevenHour();
			break;
		}
	}

	private void updateGUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.updateCharacterPanel();
				frame.updateDotPanels();
			}
		});
	}

	private void sleep() {
		try {
			Thread.sleep(sleepInterval);
		} catch (InterruptedException e) {
		}
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getHour() {
		return now.get(Calendar.HOUR);
	}

	public int getMinute() {
		return now.get(Calendar.MINUTE);
	}

}