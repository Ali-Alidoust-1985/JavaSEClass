package product;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class App extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("views/product.fxml")));
        primaryStage.setTitle("Pharmacy");
        primaryStage.show();
        }
    }
