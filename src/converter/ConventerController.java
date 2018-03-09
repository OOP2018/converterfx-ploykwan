package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 * 
 * @author kwankaew
 *
 */
public class ConventerController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	ComboBox<Length> unitbox1;
	@FXML
	ComboBox<Length> unitbox2;
	@FXML
	Button convertButton;
	@FXML
	Button clearButton;

	/**
	 * JavaFX calls the initialize() method of your controller when it creates the
	 * UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {
		// This is for testing
		System.out.println("Running initialize");
		if (unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0); // select an item to show
		}
		if (unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(1); // select an item to show
		}
	}

	/**
	 * Convert a distance from one unit to another.
	 * @param event happened when user click convert button.
	 */
	public void handleConvert(ActionEvent event) {
		String text1 = textfield1.getText().trim();
		String text2 = textfield2.getText().trim();
		Length unit1 = unitbox1.getValue();
		Length unit2 = unitbox2.getValue();
		
		if (text1 != null && text2.isEmpty()) {
			try {
				double num = Double.parseDouble(text1);
				double answer = (unit2.getValue() / unit1.getValue()) * num;
				textfield2.setText(answer+"");
				System.out.printf("%.4g %s = %.4g %s\n",num,unit1,answer,unit2);
			} catch (NumberFormatException ex) {
				textfield1.setText("invalid number.");
				System.out.println("invalid number.");
			}
		} else if (text2 != null && text1.isEmpty()) {
			try {
				double num = Double.parseDouble(text2);
				double answer = (unit1.getValue() / unit2.getValue() ) * num;
				textfield1.setText(answer+"");
				System.out.printf("%.4g %s = %.4g %s\n",num,unit2,answer,unit1);
			} catch (NumberFormatException ex) {
				textfield2.setText("invalid number.");
				System.out.println("invalid number.");
			}
		}
	}

	/**
	 * Clear the boxes for do the new one.
	 * @param event happened when user click clear button.
	 */
	public void handleClear(ActionEvent event) {
		textfield1.setText(null);
		textfield2.setText(null);
		textfield1.clear();
		textfield2.clear();
	}
}
