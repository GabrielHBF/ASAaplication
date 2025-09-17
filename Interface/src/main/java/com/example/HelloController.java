package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Verificação;
import model.comandoSql;

import static model.Verificação.verifica;

public class HelloController {
    @FXML
    private CheckBox acceptTerms;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private Hyperlink forgotLink;

    @FXML
    private TextField loginEmail;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private ImageView logoImagefootter;

    @FXML
    private TextField regEmail;

    @FXML
    private TextField regName;

    @FXML
    private PasswordField regPassword;

    @FXML
    private PasswordField regPasswordConfirm;

    @FXML
    private CheckBox rememberMe;


    @FXML
    public void logar() {

        Verificação verificação = new Verificação();
        verificação.Verificação(loginEmail.getText(),loginPassword.getText());

        if(verifica){
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) btnLogin.getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Email ou senha incorretos!");
        }
    }

    public void cadastrar(){
        if(regPassword.getText().equals(regPasswordConfirm.getText())){

        comandoSql insert = new comandoSql();

            if(!(insert.selectComand(regEmail.getText()))) {

                if(acceptTerms.isSelected()) {

                    insert.insertComand(regName.getText(), regEmail.getText(), regPassword.getText());

                }else {
                    System.out.println("Aceite os termos pra prosseguir");
                }

            }else {
                System.out.println("Email ja sendo utilizado!");
            }

        }else {
            System.out.println("As senhas não correspondem!");
        }
    }



}
