package com.estoque;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.OutputStream;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label titulo = new Label("Cadastro de Produtos");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome do produto");

        TextField txtQtd = new TextField();
        txtQtd.setPromptText("Quantidade");

        TextField txtPreco = new TextField();
        txtPreco.setPromptText("Preço");

        Button btnSalvar = new Button("Salvar Produto");

        Label status = new Label(); // mensagem de retorno

        btnSalvar.setOnAction(e -> {
            try {
    String json = String.format(
        "{\"nome\":\"%s\", \"quantidade\":%s, \"preco\":%s}",
        txtNome.getText(),
        txtQtd.getText(),
        txtPreco.getText()
    );
    

    URL url = URI.create("http://localhost:8080/produtos").toURL(); // ← atualizado
    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
    conexao.setRequestMethod("POST");
    conexao.setRequestProperty("Content-Type", "application/json");
    conexao.setDoOutput(true);

    OutputStream os = conexao.getOutputStream();
    os.write(json.getBytes());
    os.flush();
    os.close();

    if (conexao.getResponseCode() == 200 || conexao.getResponseCode() == 201) {
        status.setText("Produto cadastrado com sucesso!");
    } else {
        status.setText("Erro ao cadastrar produto.");
    }

} catch (Exception ex) {
    status.setText("Falha ao conectar com a API.");
    ex.printStackTrace();
}
        });

        VBox layout = new VBox(10, titulo, txtNome, txtQtd, txtPreco, btnSalvar, status);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 350);
        stage.setTitle("Sistema de Estoque");
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch();
    }
}