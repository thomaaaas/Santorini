package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Plateau extends Application {

    @Override
    public void start(Stage primaryStage){
        int i = 5;
        GridPane grid = new GridPane();

        Image sol = new Image ("/imageSantorini/Sol.png",200,200,true,true);
        Image sol2 = new Image ("/imageSantorini/Sol2.png",200,200,true,true);
        Image sol3 = new Image ("/imageSantorini/Sol3.png",200,200,true,true);
        Image sol4 = new Image ("/imageSantorini/Sol4.png",200,200,true,true);

        Image base = new Image ("/imageSantorini/Maison.png",200,200,true,true);
        Image base2 = new Image ("/imageSantorini/Maison2.png",200,200,true,true);
        Image base3 = new Image ("/imageSantorini/Maison3.png",200,200,true,true);
        Image base4 = new Image ("/imageSantorini/Maison4.png",200,200,true,true);

        Image[] image = {sol, sol2, sol3, sol4};
        Image[] imageBase = {base, base2, base3, base4};

        //Creation de la grille
        for (int row = 0; row < i ; row++) {
            for (int col = 0; col < i; col++) {
                Button button = new Button();
                button.setOnAction(event -> increment());
                button.setMaxSize(200,200);
                button.setMinSize(200,200);

                //image pour les bords
                if (row == 4){
                    button.setGraphic(new ImageView(image[3]));
                }
                if (row == 0){
                    button.setGraphic(new ImageView(image[1]));
                }
                if (col == 0){
                    button.setGraphic(new ImageView(image[0]));
                    button.setOnAction(event ->  button.setGraphic(new ImageView(imageBase[0])));
                    if (increment() == 1){
                        button.setOnAction(event ->  button.setGraphic(new ImageView(imageBase[1])));
                    }
                    if (increment() == 2){
                        button.setOnAction(event ->  button.setGraphic(new ImageView(imageBase[2])));
                    }
                    if (increment() == 3){
                        button.setOnAction(event ->  button.setGraphic(new ImageView(imageBase[3])));
                    }
                }
                if (col == 4){
                    button.setGraphic(new ImageView(image[3]));
                }
                //image aléatoire au milieu
                else if (row !=4 && row != 0 && col != 0){
                    Random random = new Random();
                    button.setGraphic(new ImageView(image[random.nextInt(3)]));
                }
                grid.add(button,col,row);
            }
        }

        Scene scene = new Scene(grid, i*200, i*200);
        primaryStage.setTitle("Santorini");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public int increment() {
        int imagePlus = 0;
        return imagePlus++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
