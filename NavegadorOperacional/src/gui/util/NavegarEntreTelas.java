//Autor Matheus_Gabryel(MAGGA)

package gui.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NavegarEntreTelas{
	
	private static Scene sceneTelaLogin, sceneTelaHome, sceneTelaAtt, sceneTelaInstrutor, sceneTelaTreino, sceneTelaCatraca;
	private static Stage primaryStage;
	
	
	public void abrir(Stage stage) throws IOException {
		
		//Carregando os arquivos FXML
		FXMLLoader TelaLogin = new FXMLLoader(getClass().getResource("/gui/TelaLogin.fxml"));
		FXMLLoader TelaHome = new FXMLLoader(getClass().getResource("/gui/TelaHome.fxml"));
		FXMLLoader TelaAtt = new FXMLLoader(getClass().getResource("/gui/TelaAtt.fxml"));
		primaryStage = stage;
				
		//Associando os Parent com os arquivos ja carregados 
		Parent parentTelaLogin = TelaLogin.load();
		Parent parentTelaHome = TelaHome.load();
		Parent parentTelaAtt = TelaAtt.load();
		
		//Setando as cenas
		sceneTelaLogin = new Scene(parentTelaLogin);
		sceneTelaLogin.setFill(Color.TRANSPARENT);
		
		sceneTelaHome= new Scene(parentTelaHome);
		sceneTelaHome.setFill(Color.TRANSPARENT);
		
		sceneTelaAtt = new Scene(parentTelaAtt);
		sceneTelaAtt.setFill(Color.TRANSPARENT);
		//FIM
		
		//Definindo titulo e transparencia
		primaryStage.setTitle("Vikstar");
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		//Apresentando a tela
		primaryStage.show();
		
		
		
	}
	
	public static void trocaDeTelas(int opcao){
		
		//Criando switch para alternar entre as telas
		
		switch(opcao) {
		case 1 : 
			primaryStage.setScene(sceneTelaLogin);
			
			break;
		case 2 : 
			primaryStage.setScene(sceneTelaHome);
			//primaryStage.setMaximized(true);
			break;
	
		case 3 : 
			primaryStage.setScene(sceneTelaAtt);
			break;
		
		case 4 : 
			primaryStage.setScene(sceneTelaInstrutor);
			break;
		
		case 5 : 
			primaryStage.setScene(sceneTelaTreino);
			break;
		
		case 6 : 
			primaryStage.setScene(sceneTelaCatraca);
			break;
			
		}
	}
	
}
	
