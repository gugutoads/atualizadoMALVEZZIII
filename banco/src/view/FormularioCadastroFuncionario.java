package view;

import controller.BancoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCadastroFuncionario extends JFrame {
    private BancoController bancoController;

    public FormularioCadastroFuncionario(BancoController bancoController) {
        this.bancoController = bancoController;

        setTitle("Cadastro de Funcionario");
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelNome = new JLabel("Nome:");
        JTextField tfNome = new JTextField(15);
        JLabel labelCargo = new JLabel("Cargo:");
        JTextField tfCargo = new JTextField(15);

        panel.add(labelNome);
        panel.add(tfNome);
        panel.add(labelCargo);
        panel.add(tfCargo);

        JButton btnCadastrar = new JButton("Cadastrar");

        panel.add(btnCadastrar);

        // Ação para cadastrar um novo funcionário
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tfNome.getText().trim();
                String cargo = tfCargo.getText().trim();

                if (nome.isEmpty() || cargo.isEmpty()) {
                    JOptionPane.showMessageDialog(FormularioCadastroFuncionario.this, "Nome e Cargo devem ser preenchidos.");
                    return;
                }

                // Chama o controlador para cadastrar o funcionário
                bancoController.cadastrarFuncionario(nome, cargo);

                JOptionPane.showMessageDialog(FormularioCadastroFuncionario.this, "Funcionário cadastrado com sucesso!");
                dispose(); // Fecha a janela de cadastro
            }
        });

        setVisible(true); // Torna a janela visível
    }
}
