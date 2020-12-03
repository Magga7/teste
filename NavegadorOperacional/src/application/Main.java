package application;
	
import gui.util.Alertas;
import gui.util.NavegarEntreTelas;
import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			gui.util.NavegarEntreTelas nav1 = new gui.util.NavegarEntreTelas();
			nav1.abrir(stage);
			NavegarEntreTelas.trocaDeTelas(1);
						
		} catch (Exception e) {
			Alertas.showAlert("ERRO CRITICO", null, "Contate o Administrador do sistema. Erro ao carregar a tela.", AlertType.ERROR);
			System.out.println(String.valueOf(e));
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
