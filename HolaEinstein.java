package primervideojavafx;


import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javafx.util.Duration;

public class HolaEinstein extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        String message
                = "Bienvenidos al mundo de JavaFx "
                + "donde podreis tomaros un cafe "
                + "mientras aprendeis este nuevo "
                + "tipo de programacion "
                + "basada en Java y dedicada a crear aplicaciones RIA";
        // Referencia al control tipo Text
        Text textRef = new Text(message);
        textRef.setLayoutY(25);
        textRef.setTextOrigin(VPos.TOP);
        textRef.setTextAlignment(TextAlignment.JUSTIFY);
        textRef.setWrappingWidth(400);
        textRef.setFill(Color.rgb(187, 195, 107));
        textRef.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));
        // Proporciona un comportamiento para el Text de desplazamiento animado
        TranslateTransition transTransition = new TranslateTransition(new Duration(10000), textRef);
        transTransition.setToY(-190);
        transTransition.setInterpolator(Interpolator.LINEAR);
        transTransition.setCycleCount(Timeline.INDEFINITE);
        // Crea una ImageView conteniendo una Image
        Image image = new Image("https://github.com/serlavio/HelloWorldJavaFx/raw/master/cafeEinstein3.png");
        ImageView imageView = new ImageView(image);
        // Creamos un Group para contener el Text
        Group textGroup = new Group(textRef);
        textGroup.setLayoutX(50);
        textGroup.setLayoutY(115);
        textGroup.setClip(new Rectangle(480, 60));
        // Combinamos la ImageView and Group de Text mediante otro Group
        Group root = new Group(imageView, textGroup);
        Scene scene = new Scene(root, 516, 516);
        stage.setScene(scene);
        stage.setTitle("Hola Einstein");
        stage.show();
        // Aqui empieza la animacion el texto        
        transTransition.play();
        
    }
}
