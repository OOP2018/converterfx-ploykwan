package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConventerController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	Button convertButton;
	@FXML
	Button clearButton;
	
	
	/**
	 * Convert a distance from one unit to another.
	 * 
	 */
	public void handleConvert(ActionEvent event) {
		String text = textfield1.getText().trim();
		System.out.printf("--- %.4g\n",text);
		
	}
}
