package sample.ControllerPages;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Model.Master;
import sample.Model.Model;
import sample.Model.ModelModel;
import sample.Model.ModelStandart;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static sample.Model.ModelStandart.tryParseInt;

public class ModelController {
    @FXML
    private TextField newNameModel;
    @FXML
    private TextField newMaterialModel;
    @FXML
    private TextField newPriceModel;
    @FXML
    private ImageView newPictureModel;

    private Stage dialogStageModel;
    private Model model;

    public void setDialogStageModel(Stage dialogStageModel) {
        this.dialogStageModel = dialogStageModel;
    }
    public void onClickBackModel(ActionEvent actionEvent) {
        dialogStageModel.close();
    }

    private ModelModel modelModel  = new ModelModel();
    public void setModel (Model model)  throws IOException {

        this.model = model;

        newNameModel.setText(model.getNameModel());
        newMaterialModel.setText(model.getMaterialModel());
        newPriceModel.setText(String.valueOf(model.getPriceModel()));

        newPictureModel.setImage(setImageByRelativePath(model.getPictureModel()));
    }

    private File file = null;
    ModelStandart modelStandart = new ModelStandart();

    public void onClickDonload(ActionEvent actionEvent) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");

        file = fileChooser.showOpenDialog(dialogStageModel);

        if (file != null) {

            Image img = new Image(file.toURI().toString());
            newPictureModel.setImage(img);
        }
    }

    public void onClickAddModel(ActionEvent actionEvent) {

        if(file != null
            && tryParseInt(newPriceModel.getText())
            && newMaterialModel.getText() != ""
            && newNameModel.getText() != "") {

            this.model = new Model();

            this.model.setNameModel(newNameModel.getText());
            this.model.setMaterialModel(newMaterialModel.getText());
            this.model.setPriceModel(Integer.valueOf(newPriceModel.getText()));
            file = сopyAbsoluteFilesToRelativeFiles(file);
            this.model.setPictureModel("./File/" + file.getName());

            modelModel.addModel(model);
            dialogStageModel.close();

        } else {
            modelStandart.ShowAlert("Данные введены не коректно");
        }
    }

    public void onClickEditedModel(ActionEvent actionEvent) {

        if( tryParseInt(newPriceModel.getText())
            && newMaterialModel.getText() != ""
            && newNameModel.getText() != "") {

            this.model.setNameModel(newNameModel.getText());
            this.model.setMaterialModel(newMaterialModel.getText());
            this.model.setPriceModel(Integer.valueOf(newPriceModel.getText()));
            if(file != null) {
                file = сopyAbsoluteFilesToRelativeFiles(file);
                this.model.setPictureModel("./File/" + file.getName());
            }

            modelModel.editModel(model);
            dialogStageModel.close();

        } else {
            modelStandart.ShowAlert("Данные введены не коректно");
        }
    }

    public Image setImageByRelativePath(String relativePath) throws IOException {
        File file = new File(relativePath);
        BufferedImage image = ImageIO.read(file);
        Image resultImage = SwingFXUtils.toFXImage(image, null );
        return resultImage;
    }
    public  File сopyAbsoluteFilesToRelativeFiles(File absoluteFiles) {

        try {

            Files.copy(absoluteFiles.toPath(), Path.of("./File/" + absoluteFiles.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new File("./File/" + absoluteFiles.getName());
    }
}
