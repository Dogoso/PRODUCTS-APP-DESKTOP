package com.doglab.main;

import javax.swing.JFrame;

import com.doglab.view.ViewSwing;

public class Main {

	public static void main(String[] args) {
		ViewSwing view = new ViewSwing();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
