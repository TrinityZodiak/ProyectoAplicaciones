package Sistema;

import Alertas.Cambios;
import DB.ConexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pojos.Estudiante;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

    public class FXMLRegistroEstudianteController implements Initializable
    {

        private Cambios Notificacion;
        private Estudiante estudianteEditado;
        private ObservableList<Estudiante> Estudiantes;
        private boolean isNuevo;


        @Override
        public void initialize(URL location, ResourceBundle resources)
        {

        }

        public void inicializarCampos(Cambios notificacion, boolean isNuevo, Estudiante estudianteEditado)
        {
            this.Notificacion= notificacion;
            this.isNuevo = isNuevo;
            this.estudianteEditado = estudianteEditado;

            if(!isNuevo)
            {

            }
        }

        @FXML
        private void clicGuardarAcademia(ActionEvent event)
        {
            boolean Valido = true;
            String mensajeValidacion = "";
            Estudiante estudianteNuevo = new Estudiante();

            estudianteNuevo.setPrimer_nom(tfPrimerNombre.getText());
            estudianteNuevo.setPrimer_ape(tfPrimerApellido.getText());
                if(tfSeg_nom.getText().equals(null) || tfSeg_nom.getText().equals(""))
                {
                    estudianteNuevo.setSeg_nom("");
                }
                else
                {
                    estudianteNuevo.setSeg_nom(tfSegundoNombre.getText());
                }

                if(tfSeg_ape.getText().equals(null) || tfSeg_ape.getText().equals(""))
                {
                    estudianteNuevo.setSeg_ape("");
                }
                else
                {
                    estudianteNuevo.setSeg_ape(tfSeg_ape.getText());
                }


            if(!isNuevo){
                estudianteNuevo.setIdEstudiante(estudianteEditado.getIdEstudiante());
            }
            if(estudianteNuevo.getPrimer_nom().isEmpty())
            {
                Valido = false;
                mensajeValidacion = mensajeValidacion + "\n -No puede dejar el campo nombre vacio, ingrese uno \n";
            }
            if(estudianteNuevo.getPrimer_ape().isEmpty())
            {
                Valido = false;
                mensajeValidacion = mensajeValidacion + "\n -No puede dejar el campo primer appelido vacio, ingrese uno \n";
            }

            if(Valido)
            {
                GuardarEstudiante(estudianteNuevo);
            }
            else
            {

            }
        }

        private void GuardarEstudiante(Estudiante estudianteNuevo)
        {
            Connection conn = ConexionDB.AbrirConexion();
            if(conn != null)
            {
                try
                {
                    String mensaje = "";
                    int resultado;

                    if(isNuevo)
                    {

                        String Query = "INSERT INTO academia (primer_nom,seg_nom,primer_ape,seg_ape) VALUES (?,?,?,?)";
                        PreparedStatement ps = conn.prepareStatement(Query);
                        ps.setString(1, estudianteNuevo.getPrimer_nom());
                        ps.setString(2, estudianteNuevo.getSeg_nom());
                        ps.setString(3, estudianteNuevo.getPrimer_ape());
                        ps.setString(4, estudianteNuevo.getSeg_ape());

                        resultado = ps.executeUpdate();

                        mensaje = "Estudiante registrado con exito...";

                    }
                    else
                    {

                        String Query = "UPDATE Estudiante SET primer_nom = ?, seg_nom = ?,primer_ape = ?, seg_ape = ? WHERE idEstudiante = ? ";
                        PreparedStatement ps = conn.prepareStatement(Query);
                        ps.setString(1, estudianteNuevo.getPrimer_nom());
                        ps.setString(2, estudianteNuevo.getSeg_nom());
                        ps.setString(3, estudianteNuevo.getPrimer_ape());
                        ps.setString(4, estudianteNuevo.getSeg_ape());
                        ps.setInt(5, estudianteNuevo.getIdEstudiante());

                        resultado = ps.executeUpdate();
                        mensaje = "Estudiante editado con exito...";

                    }

                    if(resultado>0)
                    {

                    }
                    else
                    {

                    }
                }
                catch(SQLException ex)
                {

                }
                finally
                {
                    try
                    {
                        conn.close();
                    }
                    catch(SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
            else
            {

            }
        }
    }

