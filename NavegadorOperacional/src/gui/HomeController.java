package gui;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;



import com.jfoenix.controls.JFXButton;

import gui.util.NavegarEntreTelas;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HomeController implements Initializable {


    @FXML
    private WebView webSV;
    @FXML
    private WebView webNAC;
    
    @FXML
    private WebEngine webSvEngine;
    
    @FXML
    private WebEngine webNACEngine;
    
    @FXML
    private Text btnFechar;
    @FXML
    private JFXButton btnMinimizar;
    @FXML
    private JFXButton btnAtt;

    //Bloco de ações basicas de navegação
	@FXML
	private Stage stage;
	double x = 0;
	double y = 0;
	
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

	void min(MouseEvent event) {
		Stage stage = (Stage) btnMinimizar.getScene().getWindow();
		stage.setIconified(true);
	}
    //FIM Bloco de ações basicas de navegação
	
	//Fazendo Login
	public void loginSv (Event t) {
		 webSvEngine.getLoadWorker().stateProperty().addListener(
		         new ChangeListener<State>() {
		        	 
		               public void changed(ObservableValue ov, State oldState, State newState) {
		               if (newState == State.SUCCEEDED) {
		                      webEngine.executeScript(
		                            "function login(user){"
		                          + " var usernameField = document.getElementById(\"identifierId\");"
		                          + " usernameField.value = user;"
		                          + " var sButton = document.getElementById(\"identifierNext\");"
		                          + " sButton.click();"
		                          + "}"
		                          + "login('myusername');"
		                       );
		                }
		        }
		    });
		 
		    Thread loginSv = new Thread(() -> {
		            try {
		                Thread.sleep(5000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		            Platform.runLater( () -> {
		                webSvEngine.executeScript(
		                    "function login(pass){"
		                            + " var passwordField = document.getElementById(\"password\");"
		                            + " passwordField.value = pass;"
		                            + " var sButton = document.getElementById(\"passwordNext\");"
		                            + " sButton.click();"
		                            + "}"
		                            + "login('mypassword');"
		             );
		         });
		    });
		    
		    loginSv.start();
		
	}
	public void loginNAC (Event t) {
		webNACEngine.getLoadWorker().stateProperty().addListener(
		         new ChangeListener<State>() {
		        	 
		               public void changed(ObservableValue ov, State oldState, State newState) {
		               if (newState == State.SUCCEEDED) {
		            	   	webNACEngine.executeScript(
		                            "function login(user){"
		                          + " var usernameField = document.getElementById(\"identifierId\");"
		                          + " usernameField.value = user;"
		                          + " var sButton = document.getElementById(\"identifierNext\");"
		                          + " sButton.click();"
		                          + "}"
		                          + "login('myusername');"
		                       );
		                }
		        }
		    });
		 
		    Thread loginSv = new Thread(() -> {
		            try {
		                Thread.sleep(5000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		            Platform.runLater( () -> {
		            	webNACEngine.executeScript(
		                    "function login(pass){"
		                            + " var passwordField = document.getElementById(\"password\");"
		                            + " passwordField.value = pass;"
		                            + " var sButton = document.getElementById(\"passwordNext\");"
		                            + " sButton.click();"
		                            + "}"
		                            + "login('mypassword');"
		             );
		         });
		    });
		    
		    loginSv.start();
		
	}
	
	@FXML
	public void TelaAtt(MouseEvent event) {
		
		NavegarEntreTelas.trocaDeTelas(3);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		webSvEngine = webSV.getEngine();
		webNACEngine = webNAC.getEngine();
		
		webSvEngine.load("http:/supervirtual.vikstarsp.br/");
		webSV.setContextMenuEnabled(false);
		
		
		webNACEngine.load("http://nac.vikstarsp.br/palitador.php");
		webNAC.setContextMenuEnabled(false);
		
	}
    
    
}
