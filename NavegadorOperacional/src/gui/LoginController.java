package gui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import gui.util.NavegarEntreTelas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable{

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXPasswordField pssUser;

	@FXML
	private JFXButton btnEntrar;
	
	@FXML
	private JFXButton btnFechar;
	
	
	//Bloco de ações basicas de navegação
	@FXML
	private Stage stage;
	double x = 0;
	double y = 0;

	private PrintWriter pw;
	
	@FXML
	void drag(MouseEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setX(event.getScreenX() - x);
		stage.setY(event.getScreenY() - y);
	}

	@FXML
	void pressed(MouseEvent event) {
		x = event.getSceneX();
		y = event.getSceneY();
	}
	
	@FXML
	void fechar(MouseEvent event) {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}

	//Fim Bloco de ações basicas de navegação
	
	@FXML
	void Entrar(MouseEvent event){
		
		FileWriter fw;
		try {
			fw = new FileWriter("c:\\Vikstar\\usuario.txt");
			pw = new PrintWriter(fw);
			pw.println("Usuario: " + txtUser.getText());
			pw.println("Senha: " + pssUser.getText());
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		NavegarEntreTelas.trocaDeTelas(2);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}


}
