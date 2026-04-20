package ec.edu.upse.FEF.controlador;

import ec.edu.upse.FEF.general.EquipoService;
import ec.edu.upse.FEF.modelo.Equipo;
import ec.edu.upse.FEF.modelo.EstadoEquipo;
import ec.edu.upse.FEF.modelo.PosicionJugador;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrincipalController {

    private final EquipoService equipoService = new EquipoService();

    @FXML
    private TextField txtNombreEquipo;
    @FXML
    private TextField txtCiudad;
    @FXML
    private ComboBox<EstadoEquipo> cbEstado;

    @FXML
    private ComboBox<Equipo> cbEquipoUtilero;
    @FXML
    private TextField txtCiUtilero;
    @FXML
    private TextField txtNombreUtilero;
    @FXML
    private TextField txtOcupacionUtilero;

    @FXML
    private ComboBox<Equipo> cbEquipoDirectivo;
    @FXML
    private TextField txtCiDirectivo;
    @FXML
    private TextField txtNombreDirectivo;
    @FXML
    private TextField txtCargoDirectivo;

    @FXML
    private ComboBox<Equipo> cbEquipoTecnico;
    @FXML
    private TextField txtCiTecnico;
    @FXML
    private TextField txtNombreTecnico;
    @FXML
    private TextField txtNacionalidadTecnico;
    @FXML
    private TextField txtCargoTecnico;

    @FXML
    private ComboBox<Equipo> cbEquipoJugador;
    @FXML
    private TextField txtCiJugador;
    @FXML
    private TextField txtNombreJugador;
    @FXML
    private ComboBox<PosicionJugador> cbPosicionJugador;
    @FXML
    private TextField txtEdadJugador;
    @FXML
    private TextField txtPesoJugador;

    @FXML
    private ComboBox<Equipo> cbEquipoResumen;
    @FXML
    private TextArea taResumen;

    @FXML
    public void initialize() {
        cbEstado.getItems().setAll(EstadoEquipo.values());
        cbPosicionJugador.getItems().setAll(PosicionJugador.values());
    }

    @FXML
    private void registrarEquipo() {
        try {
            equipoService.registrarEquipo(
                    txtNombreEquipo.getText(),
                    txtCiudad.getText(),
                    cbEstado.getValue()
            );
            refrescarCombosEquipo();
            limpiarEquipo();
            mostrarInfo("Equipo registrado correctamente");
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarUtilero() {
        try {
            equipoService.registrarUtilero(
                    cbEquipoUtilero.getValue(),
                    txtCiUtilero.getText(),
                    txtNombreUtilero.getText(),
                    txtOcupacionUtilero.getText()
            );
            limpiarUtilero();
            mostrarInfo("Utilero registrado correctamente");
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarDirectivo() {
        try {
            equipoService.registrarDirectivo(
                    cbEquipoDirectivo.getValue(),
                    txtCiDirectivo.getText(),
                    txtNombreDirectivo.getText(),
                    txtCargoDirectivo.getText()
            );
            limpiarDirectivo();
            mostrarInfo("Directivo registrado correctamente");
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarTecnico() {
        try {
            equipoService.registrarTecnico(
                    cbEquipoTecnico.getValue(),
                    txtCiTecnico.getText(),
                    txtNombreTecnico.getText(),
                    txtNacionalidadTecnico.getText(),
                    txtCargoTecnico.getText()
            );
            limpiarTecnico();
            mostrarInfo("Tecnico registrado correctamente");
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarJugador() {
        try {
            int edad = Integer.parseInt(txtEdadJugador.getText().trim());
            double peso = Double.parseDouble(txtPesoJugador.getText().trim());

            equipoService.registrarJugador(
                    cbEquipoJugador.getValue(),
                    txtCiJugador.getText(),
                    txtNombreJugador.getText(),
                    cbPosicionJugador.getValue(),
                    edad,
                    peso
            );
            limpiarJugador();
            mostrarInfo("Jugador registrado correctamente");
        } catch (NumberFormatException e) {
            mostrarError("Edad y peso deben ser valores numericos validos");
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void cargarResumenEquipo() {
        Equipo equipo = cbEquipoResumen.getValue();
        if (equipo == null) {
            mostrarError("Seleccione un equipo para ver el resumen");
            return;
        }
        taResumen.setText(equipoService.construirResumen(equipo));
    }

    @FXML
    private void cargarNominaCompletaEquipo() {
        Equipo equipo = cbEquipoResumen.getValue();
        if (equipo == null) {
            mostrarError("Seleccione un equipo para listar la nomina completa");
            return;
        }
        taResumen.setText(equipoService.construirNominaCompleta(equipo));
    }

    private void refrescarCombosEquipo() {
        cbEquipoUtilero.getItems().setAll(equipoService.listarEquipos());
        cbEquipoDirectivo.getItems().setAll(equipoService.listarEquipos());
        cbEquipoTecnico.getItems().setAll(equipoService.listarEquipos());
        cbEquipoJugador.getItems().setAll(equipoService.listarEquipos());
        cbEquipoResumen.getItems().setAll(equipoService.listarEquipos());
    }

    private void limpiarEquipo() {
        txtNombreEquipo.clear();
        txtCiudad.clear();
        cbEstado.getSelectionModel().clearSelection();
    }

    private void limpiarUtilero() {
        txtCiUtilero.clear();
        txtNombreUtilero.clear();
        txtOcupacionUtilero.clear();
    }

    private void limpiarDirectivo() {
        txtCiDirectivo.clear();
        txtNombreDirectivo.clear();
        txtCargoDirectivo.clear();
    }

    private void limpiarTecnico() {
        txtCiTecnico.clear();
        txtNombreTecnico.clear();
        txtNacionalidadTecnico.clear();
        txtCargoTecnico.clear();
    }

    private void limpiarJugador() {
        txtCiJugador.clear();
        txtNombreJugador.clear();
        txtEdadJugador.clear();
        txtPesoJugador.clear();
        cbPosicionJugador.getSelectionModel().clearSelection();
    }

    private void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

