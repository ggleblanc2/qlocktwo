package com.ggl.qlocktwo;

import javax.swing.SwingUtilities;

import com.ggl.qlocktwo.model.QlocktwoModel;
import com.ggl.qlocktwo.view.QlocktwoFrame;

public class Qlocktwo implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Qlocktwo());
	}

	@Override
	public void run() {
		new QlocktwoFrame(new QlocktwoModel());
	}

}