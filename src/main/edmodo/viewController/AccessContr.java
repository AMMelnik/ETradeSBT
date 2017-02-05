package edmodo.viewController;

import com.edmodo.model.User;
import com.edmodo.modelController.UserRec;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by pc on 29.01.2017.
 */
public class AccessContr extends ObjController {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button entry;
    @FXML
    private Button registration;
    @FXML
    private Label accessInfo;

    private UserRec userRec;
    public static User user;

    public AccessContr() {
        super();
    }

    @FXML
    void initialize() {
        login.setText("amm@gmail.com");
        password.setText("1");
    }

    @FXML
    private void clickEntryBtn() {
        accessInfo.setText("");
        userRec = new UserRec();
        if (login.getText().equals("") || password.getText().equals("")) {
            accessInfo.setText("Введите логин и пароль для доступа");
        } else {
            user = userRec.checkAccount(login.getText(), password.getText());
            if (user == null) {
                accessInfo.setText("Некорректный email или пароль");
            } else {
                super.getMain().showTradeForm();
            }
        }
    }

    @FXML
    private void clickRegBtn() {
        super.getMain().showRegistrationForm();

    }
}
