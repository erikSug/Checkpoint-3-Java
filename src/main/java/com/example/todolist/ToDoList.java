package com.example.todolist;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        btnToDo.setOnAction(e -> contentArea.getChildren().setAll(getTarefa()));

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

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));

        TextField searchBar = new TextField();
        searchBar.setPromptText("Pesquise uma tarefa...");
        searchBar.setPrefWidth(300);
        searchBar.setMaxWidth(300);

        Button btnFiltrar = new Button("Filtrar");
        btnFiltrar.setPrefSize(50, 15);

        hBox.getChildren().setAll(searchBar, btnFiltrar);
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


        Label tituloTarefa = new Label("Titulo da Tarefa");
        tituloTarefa.setAlignment(Pos.CENTER);
        tituloTarefa.setFont(Font.font("Verdana",20));

        TextField tfTituloTarefa = new TextField();
        tfTituloTarefa.setPromptText("Digite o nome da tarefa");
        tfTituloTarefa.setPrefWidth(300);
        tfTituloTarefa.setMaxWidth(300);


        Label nomeProjeto = new Label("Nome do projeto");
        nomeProjeto.setAlignment(Pos.CENTER);
        nomeProjeto.setFont(Font.font("Verdana",20));

        TextField tfNomeProjeto= new TextField();
        tfNomeProjeto.setPromptText("Digite o nome do projeto...");
        tfNomeProjeto.setPrefWidth(300);
        tfNomeProjeto.setMaxWidth(300);


        Label prioridade = new Label("Prioridade");
        prioridade.setAlignment(Pos.CENTER);
        prioridade.setFont(Font.font("Verdana",20));

        ComboBox<String> cbPriority = new ComboBox();
        cbPriority.getItems().addAll("BAIXA", "MÉDIA", "ALTA");
        cbPriority.setPromptText("Defina a prioridade desta tarefa...");
        cbPriority.setPrefWidth(300);


        Label date = new Label("Data");
        date.setAlignment(Pos.CENTER);
        date.setFont(Font.font("Verdana",20));

        DatePicker dpData = new DatePicker();
        dpData.setPromptText("Data do registro da tarefa...");
        dpData.setPrefWidth(300);
        dpData.setMaxWidth(300);


        Label responsible = new Label("Responsável");
        responsible.setAlignment(Pos.CENTER);
        responsible.setFont(Font.font("Verdana",20));

        TextField tfResponsible = new TextField();
        tfResponsible.setPromptText("Defina o responsável pela tarefa...");
        tfResponsible.setPrefWidth(300);
        tfResponsible.setMaxWidth(300);


        Button btnToDo = new Button("To Do");
        btnToDo.setPrefSize(150,50);
        btnToDo.setOnAction(e -> showAlert("Sucesso", "Tarefa Adicionada (Simulação)!"));

        vBox.getChildren().setAll(
                searchBar(),
                novaTarefa,
                tituloTarefa,
                tfTituloTarefa,
                nomeProjeto,
                tfNomeProjeto,
                prioridade,
                cbPriority,
                date,
                dpData,
                responsible,
                tfResponsible,
                btnToDo
        );


        return vBox;
    }
    private VBox getTarefa(){
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().setAll(
                searchBar(),
                getTable()
        );
        return vBox;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private TableView<String> getTable() {
        TableView<String> tableView = new TableView<>();
        TableColumn<String, String> column = new TableColumn<>("Lista de Amigos (Simulação)");
        tableView.getColumns().add(column);
        tableView.getItems().addAll("Carlos", "Henrique", "Marco");
        return tableView;
    }
    public static void main(String[] args) {
        launch();
    }
}
