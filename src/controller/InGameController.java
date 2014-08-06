package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import stages.Stage;
import view.InGamePanel;
import view.TimeLabelView;
import model.GameObject;

/**
 * @author furkan
 *
 */

public class InGameController implements ActionListener{
	
	private InGamePanel panel;
	private Stage stage;
	private TimeLabelView view;
	private int min;
	private int sec;
	private int ms;

	public InGameController(InGamePanel inGamePanel, Stage st, TimeLabelView view)
	{
		stage = st;
		this.panel = inGamePanel;
		this.view = view;
		min = 0;
		sec = 0;
		ms = 0;
	}
	
	// Add object
	public void addObject(GameObject obj)
	{
		stage.getWorldController();
		WorldController.addObject(obj);
	}
	
	// Simulates the world and checks for required conditions
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		boolean isMainReplaced = false;
		float timeStep = 1.0f / 30.f;
		int velocityIterations = 6;
		int positionIterations = 2;
		stage.getWorldController().getWorld().step(timeStep, velocityIterations, positionIterations);
		
		// Controls positions and angles of objects
		for (GameObject obj: stage.getWorldController().getObjects()) {
			obj.rotate(obj.body.getAngle());
			obj.setPos(obj.body.getPosition());
			if ( obj.isMain() && !obj.isInside())
				isMainReplaced = true;

		}
		// Destroy objects outside of the screen
		stage.destroyOutside();
		
		// add listeners to new main ball
		if (isMainReplaced){
			panel.addMouseListener(new controller.BallController(panel.getStage().getMainBall()));
			panel.addKeyListener(new controller.KeyboardController(panel.getStage().getMainBall()));
		}


		// Checks finish condition		
		if(stage.getFlag().isFinished(stage.getMainBall().getPos()))
			panel.won();
		
		// Checks if main ball captured by launcher
		if(stage.haveLauncher() != null ) {
				if(stage.haveLauncher().isCaptured(stage.getMainBall().getPos())){
					panel.pause();
					panel.launch();
				}
		}
		
		//update the time view
		if( !view.isPaused()) {
			incrementTime();
			view.setTime(min, sec);
		}
		
		// Repaint screen
		panel.repaint();
	}
	
	public void incrementTime() {
		//increment second and then check if necessary to increment label
		ms += 1;

		if ( ms == 60) {
			sec++;
			ms = 0;
		}
		if (sec == 60){
			min++;
			sec = 0;
		}
	}
	
	public void resetTime() {
		min = 0;
		sec = 0;
	}
	

}
