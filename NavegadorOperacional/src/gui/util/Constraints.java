package gui.util;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

public class Constraints {

	public static void setTextFieldInteger(JFXTextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldMaxLength(JFXTextField txtUser, int max) {
		txtUser.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txtUser.setText(oldValue);
			}
		});
	}

	public static void setTextFieldDouble(JFXTextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldMaxLengthSenha(JFXPasswordField senha, int max) {
		senha.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				senha.setText(oldValue);
			}
		});
	}
}