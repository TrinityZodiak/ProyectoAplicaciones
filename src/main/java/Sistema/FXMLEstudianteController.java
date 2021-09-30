package Sistema;

import Alertas.Cambios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojos.Estudiante;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLEstudianteController implements Initializable
    {
        @FXML
        private Button btnAgregarEstudiante;

        @FXML
        private Button btnEditarEstudiante;

        @FXML
        private Button btnEliminarEstudiante;

        @FXML
        private TableView<Estudiante> tvEstudiantes;

        private ObservableList<Estudiante> Estudiantes;


        @Override
        public void initialize(URL url, ResourceBundle rb)
        {
            Estudiantes = FXCollections.observableArrayList();

        }

        @FXML
        private void clicAgregarEstudiante(ActiveEvent event)
        {
            irPantallaFormulario(true,null);
        }

        private void irPantallaFormulario(boolean isNuevo, Estudiante estudianteEditado)
        {
            try
            {
                FXMLLoader loader= new FXMLLoader(getClass().getResource("FXMLRegistroEstudiante.fxml"));
                Parent root = loader.load();

                FXMLRegistroEstudianteController controladorFormulario = loader.getController();
                controladorFormulario.inicializarCampos((Cambios) this, isNuevo, estudianteEditado);

                Scene sceneFormulario = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(sceneFormulario);
                stage.showAndWait();
            }
            catch (IOException ex)
            {
                System.out.println("Error al cargar escena: " + ex.getMessage());
            }
        }


    }
