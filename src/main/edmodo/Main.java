package edmodo;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.modelController.BidRec;
import com.edmodo.viewController.ObjController;
import com.edmodo.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by pc on 29.01.2017.
 */
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("E-Trade v1.2.0");
        initRootLayout();
        showAccessForm();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareToShow(String pathToFXML) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(pathToFXML));
            AnchorPane window = loader.load();
            rootLayout.setCenter(window);
            ObjController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAccessForm() {
        prepareToShow("/view/AccessView.fxml");
    }

    public void showRegistrationForm() {
        prepareToShow("/view/RegistrationView.fxml");
    }

    public void showTradeForm() {
        prepareToShow("/view/TradeView.fxml");
    }

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Application.launch(args);
      /* User user1 = new User("xxx@xxx.ru", "2", "Miha", "Ivanov");
        Item item1 = new Item("milk", "1L Milk Bottle", user1);
        Bid bid1 = new Bid();
        bid1.setUser(user1);
        bid1.setItem(item1);
        BidRec bidRec = new BidRec();
        bidRec.addRecord(4, user1, item1 , bid1);*/
    }
}
