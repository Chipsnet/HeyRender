package jp.co.minato86.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings settings = new Settings();
					settings.check();
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {
		Settings settings = new Settings();
		setTitle("HeyRender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(2, 0, 432, 261);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Settings", null, panel, null);
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Discord Webhook:");
		lblNewLabel.setBounds(12, 10, 169, 13);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		if (settings.discord()) {
			textField.setText("\u6709\u52b9");
		} else {
			textField.setText("\u7121\u52B9");
		}
		textField.setBounds(135, 7, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLineNotify = new JLabel("LINE Notify:");
		lblLineNotify.setBounds(12, 33, 219, 13);
		panel.add(lblLineNotify);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		if (settings.line()) {
			textField_1.setText("\u6709\u52b9");
		} else {
			textField_1.setText("\u7121\u52B9");
		}
		textField_1.setBounds(135, 30, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u8A2D\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (settings.discord()) {
					settings.write();
					textField_1.setText("\u6709\u52b9");
				} else {
					settings.write();
					textField_1.setText("\u7121\u52B9");
				}
			}
		});
		button.setBounds(243, 6, 91, 21);
		panel.add(button);
		
		JButton button_1 = new JButton("\u8A2D\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(243, 29, 91, 21);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Console", null, panel_1, null);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 427, 201);
		panel_1.add(list);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 211, 81, 13);
		panel_1.add(lblStatus);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("\u5F85\u6A5F\u4E2D");
		textField_2.setBounds(52, 208, 96, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u958B\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setText(((button.getText()).equals("\u5b9f\u884c\u4e2d"))?"\u958B\u59CB":"\u5b9f\u884c\u4e2d");
				btnNewButton.setEnabled(false);
				textField_2.setText("\u76e3\u8996\u4e2d");
			}
		});
		btnNewButton.setBounds(160, 207, 91, 21);
		panel_1.add(btnNewButton);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
