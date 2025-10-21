package com.example.todolist;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoList extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);

        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(10));

        Label menuTitle = new Label("Tarefas");
        Button btnNewTask = new Button("New Task");
        Button btnToDo = new Button("To Do");
        Button btnDoing = new Button("Doing");
        Button btnDone = new Button("Done");
        Button btnArchived = new Button("Archived");
        Button btnCanceled = new Button("Canceled");

        menuTitle.setPrefSize(150, 50);
        menuTitle.setAlignment(Pos.CENTER);
        menuTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        btnNewTask.setPrefSize(150, 50);
        btnToDo.setPrefSize(150, 50);
        btnDoing.setPrefSize(150, 50);
        btnDone.setPrefSize(150, 50);
        btnArchived.setPrefSize(150,50);
        btnCanceled.setPrefSize(150,50);

        leftMenu.getChildren().setAll(
            menuTitle,
            btnNewTask,
            btnToDo,
            btnDoing,
            btnDone,
            btnArchived,
            btnCanceled
        );


        StackPane contentArea = new StackPane(getNewTask());

        btnNewTask.setOnAction(e -> contentArea.getChildren().setAll(getNewTask()));


        root.setLeft(leftMenu);
        root.setCenter(contentArea);


        stage.setScene(scene);
        stage.show();


    }
    private VBox searchBar(){
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        Label buscadorTarefa = new Label("Buscador de Tarefas");
        buscadorTarefa.setAlignment(Pos.CENTER);
        buscadorTarefa.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        HBox hBox = new HBox(100);
        vBox.setPadding(new Insets(10));

        TextField searchBar = new TextField();
        searchBar.setPromptText("Pesquise uma tarefa...");
        searchBar.setPrefWidth(300);
        hBox.getChildren().setAll(searchBar);
        vBox.getChildren().setAll(buscadorTarefa, hBox);
        return vBox;


    }
    private VBox getNewTask(){
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        Label novaTarefa = new Label("Nova Tarefa");
        novaTarefa.setPrefSize(150, 50);
        novaTarefa.setAlignment(Pos.CENTER);
        novaTarefa.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        vBox.getChildren().setAll(searchBar(),novaTarefa);
        return vBox;
    }
    public static void main(String[] args) {
        launch();
    }
}
