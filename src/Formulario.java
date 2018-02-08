import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {
    private JLabel jLabelNombre;
    private JLabel jLabelApellido;
    private JLabel jLabelCI;
    private JLabel jLabelEmitido;

    private JTextField jTextFieldNombre;
    private JTextField jTextFieldApellido;
    private JTextField jTextFieldCI;
    private JComboBox jComboBoxEmitido;

    private JPanel jPanelIntereses;
    private JLabel jLabelIntereses;
    private JCheckBox jCheckBoxTecnologia;
    private JCheckBox jCheckBoxMusica;
    private JCheckBox jCheckBoxDeporte;

    private JButton jButtonGuardar;
    private JDialog jDialogResult;
    private String[] errores;
    int indiceErrores;
    int numeroDeCampos;

    public Formulario() {
        super.setTitle("Formulario de Inscripcion v1.0");
        setSize(300, 700);
        setLayout(new GridLayout(6,2));

        //crear componentes
        jLabelNombre = new JLabel("Nombre: ");
        jTextFieldNombre = new JTextField(15);
        jLabelApellido = new JLabel("Apellido: ");
        jTextFieldApellido = new JTextField(15);
        jTextFieldCI = new JTextField(10);
        jLabelCI = new JLabel("CI: ");
        jLabelEmitido = new JLabel("Emitido en: ");
        jComboBoxEmitido = new JComboBox();
        jComboBoxEmitido.addItem("--Ciudad--");
        jComboBoxEmitido.addItem("Beni");
        jComboBoxEmitido.addItem("Cochabamba");
        jComboBoxEmitido.addItem("Chuquisaca");
        jComboBoxEmitido.addItem("La Paz");
        jComboBoxEmitido.addItem("Oruro");
        jComboBoxEmitido.addItem("Pando");
        jComboBoxEmitido.addItem("Potosi");
        jComboBoxEmitido.addItem("Santa Cruz");
        jComboBoxEmitido.addItem("Tarija");

        jPanelIntereses=new JPanel();
        jLabelIntereses = new JLabel("Intereses: ");
        jCheckBoxTecnologia = new JCheckBox("Tecnologia");
        jCheckBoxMusica = new JCheckBox("Musica");
        jCheckBoxDeporte = new JCheckBox("Deporte");

        jPanelIntereses.setLayout(new FlowLayout());
        jPanelIntereses.add(jLabelIntereses);
        jPanelIntereses.add(jCheckBoxTecnologia);
        jPanelIntereses.add(jCheckBoxMusica);
        jPanelIntereses.add(jCheckBoxDeporte);


        jButtonGuardar = new JButton("Guardar");
        jDialogResult = new JDialog();
        numeroDeCampos = 5;
        errores = new String[numeroDeCampos];
        indiceErrores = 0;
        //agregar componentes
        add(jLabelNombre);
        add(jTextFieldNombre);
        add(jLabelApellido);
        add(jTextFieldApellido);
        add(jLabelCI);
        add(jTextFieldCI);

        add(jLabelEmitido);
        add(jComboBoxEmitido);
        add(jPanelIntereses);

        add(jButtonGuardar);
        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = "";
                JLabel jLabelResultado;
                jDialogResult.setLayout(new BorderLayout());
                jDialogResult.setTitle("Resultado");
                jDialogResult.setSize(320, 240);
                if (validateGuardar() == true) {
                    jLabelResultado = new JLabel("Todo OK Granuja");
                } else {
                    jLabelResultado = new JLabel("MAL estos son tus errors");
                    jDialogResult.add(mostrarJPanelErrores(), BorderLayout.CENTER);
                }
                jDialogResult.add(jLabelResultado, BorderLayout.NORTH);
                jDialogResult.setVisible(true);

            }
        });
        setVisible(true);
    }

    private JPanel mostrarJPanelErrores() {
        JPanel jPanelresult;
        JLabel jLabelErrores[];
        jPanelresult = new JPanel();
        jPanelresult.setLayout(new GridLayout(indiceErrores, 1));
        jLabelErrores = new JLabel[indiceErrores];

        for (int i = 0; i < indiceErrores; i++) {
            jLabelErrores[i] = new JLabel(errores[i]);
            jPanelresult.add(jLabelErrores[i]);
            System.out.println("se añadio un error a la lista");
        }
        return jPanelresult;
    }

    private boolean validateGuardar() {
        boolean result = false;
        if (jTextFieldNombre.equals("")) {
            errores[indiceErrores++] = "Nombre vacio\n";
        }
        else
        if (jTextFieldApellido.equals("")) {
            errores[indiceErrores++] = "Apellido vacio\n";
        }
        else
        if (jTextFieldCI.equals("")) {
            errores[indiceErrores++] = "CI vacio\n";
        }
        else
        if (jTextFieldNombre.equals("")) {
            errores[indiceErrores++] = "Nombre vacio\n";
        }
        else
        if (jTextFieldNombre.equals("")) {
            errores[indiceErrores++] = "Nombre vacio\n";
        }
        else
        if (jComboBoxEmitido.getSelectedIndex() <1) {
            errores[indiceErrores++] = "Ciudad de Emision no Selecionada\n";
        }
        else {
            return true;
        }
        return result;
    }
}
