package sample;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends Application {

    ArrayList<Soitjad> soitjadArray = new ArrayList<Soitjad>();
    ArrayList<Button> buttons = new ArrayList<Button>();
    ArrayList<Text> texts = new ArrayList<Text>();
    Text kokkuValue;
    Text popValue;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane grid = new GridPane();

        String[] suunad = new String[]{"Paldiski", "Tabasalu", "Mustamae", "Kesklinn"};

        for (int i = 0; i < 4; i++) {
            Soitjad s = new Soitjad(suunad[i], 0);
            soitjadArray.add(i, s);

            Button btn = new Button(suunad[i]);
            buttons.add(i, btn);
            listenToClick(i);
            grid.add(btn,0,i);

            Text txt = new Text();
            texts.add(i, txt);
            grid.add(txt,1,i);
        }

        Text kokku = new Text("Kokku");
        grid.add(kokku,0,soitjadArray.size()+1);
        kokkuValue = new Text();
        grid.add(kokkuValue,1,soitjadArray.size()+1);

        Text pop = new Text("Populaarseim");
        grid.add(pop,0,soitjadArray.size()+2);
        popValue = new Text();
        grid.add(popValue,1,soitjadArray.size()+2);

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void listenToClick(int i) {
        buttons.get(i).setOnAction((event) -> {
            Soitjad s = soitjadArray.get(i);
            s.incrementHulk();
            texts.get(i).setText(Integer.toString(s.getHulk()));
            kokkuValue.setText(Integer.toString(getSUM()));
            popValue.setText(getPop());

        });
    }

    public int getSUM() {
        int s = 0;

        for (int i = 0; i < 4; i++) {
            s = s + soitjadArray.get(i).getHulk();
        }
        return s;
    }

    public String getPop() {
        String pop = "";
        int max = 0;

        for (int i = 0; i < 4; i++) {
            int k = soitjadArray.get(i).getHulk();

            if (k > max) {
                max = k;
                pop = soitjadArray.get(i).getSuund();
            }
        }

        return pop;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
