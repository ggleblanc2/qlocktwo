package com.ggl.qlocktwo.view;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.ggl.qlocktwo.controller.ClockRunnable;
import com.ggl.qlocktwo.model.QlocktwoModel;

public class QlocktwoFrame {

	private ClockRunnable clockRunnable;

	private JFrame frame;

	private QlocktwoMenuBar qlocktwoMenuBar;

	private QlocktwoModel model;

	private QlocktwoPanel qlocktwoPanel;

	public QlocktwoFrame(QlocktwoModel model) {
		this.model = model;
		createPartControl();
	}

	private void createPartControl() {
		frame = new JFrame("Qlocktwo");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setIconImage(getFrameImage());
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				exitProcedure();
			}
		});

		qlocktwoMenuBar = new QlocktwoMenuBar(this, model);
		frame.setJMenuBar(qlocktwoMenuBar.getMenuBar());

		qlocktwoPanel = new QlocktwoPanel(model);
		frame.add(qlocktwoPanel.getPanel());

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		clockRunnable = new ClockRunnable(this, model);
		new Thread(clockRunnable).start();
	}

	public void exitProcedure() {
		clockRunnable.setRunning(false);
		frame.dispose();
		System.exit(0);
	}

	public Image getFrameImage() {
		Image image = null;
		try {
			image = ImageIO.read(getClass().getResource("/clock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void repaintQlocktwoPanel() {
		qlocktwoPanel.repaint();
	}

	public void updateCharacterPanel() {
		qlocktwoPanel.updateCharacterPanel();
	}

	public void updateDotPanels() {
		qlocktwoPanel.updateDotPanels(clockRunnable.getMinute());
	}

}