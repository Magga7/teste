package gui.util;



import org.controlsfx.control.Notifications;

import javafx.beans.property.ObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alertas {
	
	
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
		ObjectProperty<ButtonType> Re = alert.resultProperty();
		System.out.println(Re);
		
	}
	
	public static void showNotificaçãoLogin(String Titulo, String Text) {
		Notifications.create()
	       .title(Titulo)
	       .text(Text)
	       .position(Pos.TOP_RIGHT)
	       .hideAfter(javafx.util.Duration.seconds(5))
	       .darkStyle()
	       .show();
	}
	
	public static void showNotificação(String Titulo, String Text) {
		Notifications.create()
	       .title(Titulo)
	       .text(Text)
	       .position(Pos.TOP_RIGHT)
	       .hideAfter(javafx.util.Duration.seconds(5))
	       .darkStyle()
	      /* .onAction(new EventHandler() {
				public void handle(ActionEvent a) {
					
				}
				})
	       */
	       .show();
	}
	
	
	
	
}
