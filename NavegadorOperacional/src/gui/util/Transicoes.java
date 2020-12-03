package gui.util;

import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class Transicoes {
	
	public void fade() {
		FadeTransition transition = new FadeTransition(
		Duration.millis(3000));
		transition.setFromValue(0.0);
		transition.setToValue(1.0);
		transition.play();
		}
	 
}
