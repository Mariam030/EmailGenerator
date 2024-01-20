package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField alternateEmailField;
    private ComboBox<String> departmentComboBox;
    private Label passwordLabel;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Email Application");

        // Create GUI components
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label alternateEmailLabel = new Label("Alternate Email:");
        Label departmentLabel = new Label("Department:");
        Label passwordDisplayLabel = new Label("Generated Password:");

        firstNameField = new TextField();
        lastNameField = new TextField();
        alternateEmailField = new TextField();

        ObservableList<String> departments =
                FXCollections.observableArrayList("Sales", "Development", "Accounting", "None");
        departmentComboBox = new ComboBox<>(departments);
        departmentComboBox.setValue("None");

        passwordLabel = new Label();
        resultLabel = new Label();

        Button generateEmailButton = new Button("Generate Email");
        generateEmailButton.setOnAction(e -> generateEmail());

        // Create layout
        GridPane grid = new GridPane();
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(alternateEmailLabel, 0, 2);
        grid.add(alternateEmailField, 1, 2);
        grid.add(departmentLabel, 0, 3);
        grid.add(departmentComboBox, 1, 3);
        grid.add(generateEmailButton, 0, 4);
        grid.add(passwordDisplayLabel, 0, 5);
        grid.add(passwordLabel, 1, 5);
        grid.add(resultLabel, 0, 6, 2, 1);

        // Create Scene
        Scene scene = new Scene(grid, 400, 300);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void generateEmail() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String alternateEmail = alternateEmailField.getText();
        String department = departmentComboBox.getValue();

        Email email = new Email(firstName, lastName);
        email.setAlternateEmail(alternateEmail);
        email.setDepartment(department);
        String em1 = email.getFirstName().toLowerCase() + "." + email.getLastName().toLowerCase() + "@" + email.getDepartment() + "." + email.getCompantSuffix();
        // Set the generated password to the label
        email.setEmail(em1);
        passwordLabel.setText(email.getPassword());

        // Set the result label with the email information
        resultLabel.setText(email.showInfo());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
