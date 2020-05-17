/*
    Author: Pavel Yadlouski (xyadlo00)
            Oleksii Korniienko (xkorni02)

    File: src/sample/MenuController.java
    Date: 04.2020
 */

package src.sample;

import src.functional.Street;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

/**
 * Controller of side menu of street.
 */
public class MenuController { //TODO we need a comments here

    private Street street;

    @FXML
    private TextField streetNameField;

    @FXML
    private AnchorPane sideMenu;

    @FXML
    private TreeView<String> info;

    @FXML
    private TextField streetLoading;

    @FXML
    private Button streetLoadingMinus;

    @FXML
    private Button streetLoadingPlus;

    @FXML
    private CheckBox streetBlock;


    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public TextField getStreetNameField() {
        return streetNameField;
    }

    public void setStreetNameField(String streetNameField) {
        this.streetNameField.setText(streetNameField);
    }

    public void setStreetBlock(Boolean streetBlock) {
        this.streetBlock.setSelected(streetBlock);
    }

    public CheckBox getStreetBlock() {
        return streetBlock;
    }

    public AnchorPane getSideMenu() {
        return sideMenu;
    }

    public TreeView<String> getInfo() {
        return info;
    }

    public TextField getStreetLoading() {
        return streetLoading;
    }

    public void setStreetLoading(String streetLoading) {
        this.streetLoading.setText(streetLoading);
    }

    public Button getStreetLoadingMinus() {
        return streetLoadingMinus;
    }

    public Button getStreetLoadingPlus() {
        return streetLoadingPlus;
    }

    @FXML
    private void loadStreet(){
        int load = Integer.parseInt(streetLoading.getText());

    }

    @FXML
    private void unloadStreet(){

    }



}
