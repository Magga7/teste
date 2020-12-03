package gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;

import gui.util.NavegarEntreTelas;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AttController {

    @FXML
    private JFXButton btnIniciar;

    @FXML
    private JFXButton btnCancelar;
    
    @FXML
    private JFXButton btnFechar;
    
    @FXML
    private JFXButton btnMinimizar;
    
    @FXML
    private WebView webDown;
    
    @FXML
    private WebEngine webDownEngine;
    
    @FXML
    private JFXProgressBar progressBar;
    
    
    
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
    
    @FXML
    void End(MouseEvent event) {
    	NavegarEntreTelas.trocaDeTelas(2);
    }

    @FXML
    void Start(MouseEvent event) throws MalformedURLException, IOException {
    	
    	
    	File arquivoZip = new File("C://Vikstar//Indigo.zip");
    	HttpURLConnection url = null;
    	InputStream inStream = null;
    	FileOutputStream fileOutputStream = null;

    	try {

    	    // conecta ao host para realizar o download do arquivo
    	    url = (HttpURLConnection) new URL("http://172.16.16.140:60201/UPDATE/indigo/INDIGO_RCPT.exe").openConnection(); 
    	    url.setDoInput(true); // configura a conexao para aceitar o recebimento de dados
    	    url.connect(); // efetiva a conexao ao localhost

    	    inStream = url.getInputStream();
    	    fileOutputStream  = new FileOutputStream(arquivoZip); // abre um fluxo para gravar os dados no disco

    	    byte[] buffer = new byte[4096];
    	    int bytesLidos = 0;

    	    while ((bytesLidos = inStream.read(buffer, 0, buffer.length)) > 0) {
    	        fileOutputStream.write(buffer, 0, bytesLidos);
    	        fileOutputStream.flush();
    	    }

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    } finally {
    	        if (url != null)
    	            url.disconnect();
    	        if (inStream != null)
    	            inStream.close();
    	        if (fileOutputStream != null)
    	            fileOutputStream.close();
    	    }
    	
    	NavegarEntreTelas.trocaDeTelas(2);
    	}
    }

