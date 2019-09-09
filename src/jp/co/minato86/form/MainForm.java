package jp.co.minato86.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.File;

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
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
					JFrame frame = new JFrame();
					int option = JOptionPane.showConfirmDialog(frame, "設定を削除しますか？", "Setting", 0);
				    if (option == JOptionPane.YES_OPTION){
				    	settings.write("discord", "");
				    	textField.setText("\u7121\u52B9");
				    }
				} else {
					JFrame frame = new JFrame();
					String data = JOptionPane.showInputDialog(frame, "DiscordのWebhookURLを入力してください。");
					if (data == null) {
						JOptionPane.showMessageDialog(null, "キャンセルしました。", "Settings", 1);
					} else if (data.equals("")) { 
						JOptionPane.showMessageDialog(null, "キャンセルしました。", "Settings", 1);
					} else {
						settings.write("discord", data);
						textField.setText("\u6709\u52b9");
					}	
				}
			}
		});
		button.setBounds(243, 6, 91, 21);
		panel.add(button);
		
		JButton button_1 = new JButton("\u8A2D\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (settings.line()) {
					JFrame frame = new JFrame();
					int option = JOptionPane.showConfirmDialog(frame, "設定を削除しますか？", "Setting", 0);
				    if (option == JOptionPane.YES_OPTION){
				    	settings.write("line", "");
				    	textField_1.setText("\u7121\u52B9");
				    }
				} else {
					JFrame frame = new JFrame();
					String data = JOptionPane.showInputDialog(frame, "LINE NotifyのTokenを入力してください。");
					if (data == null) {
						JOptionPane.showMessageDialog(null, "キャンセルしました。", "Settings", 1);
					} else if (data.equals("")) { 
						JOptionPane.showMessageDialog(null, "キャンセルしました。", "Settings", 1);
					} else {
						settings.write("line", data);
						textField_1.setText("\u6709\u52b9");
					}	
				}
			}
		});
		button_1.setBounds(243, 29, 91, 21);
		panel.add(button_1);
		
		JLabel label = new JLabel("\u30D5\u30A1\u30A4\u30EB\u306E\u9078\u629E");
		label.setBounds(12, 68, 110, 13);
		panel.add(label);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(22, 114, 288, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u30D5\u30A9\u30EB\u30C0\u306E\u5834\u6240");
		lblNewLabel_1.setBounds(22, 91, 110, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("選択");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame();
				
			    JFileChooser filechooser = new JFileChooser();
			    filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			    int selected = filechooser.showOpenDialog(frame);
			    if (selected == JFileChooser.APPROVE_OPTION){
			      File file = filechooser.getSelectedFile();
			      textField_3.setText(file.getAbsolutePath());
			    }
			}
		});
		btnNewButton_1.setBounds(322, 113, 85, 21);
		panel.add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("\u30D5\u30A1\u30A4\u30EB\u540D");
		label_1.setBounds(22, 157, 176, 13);
		panel.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(22, 180, 385, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Console", null, panel_1, null);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 427, 186);
		panel_1.add(list);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 196, 81, 13);
		panel_1.add(lblStatus);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("\u5F85\u6A5F\u4E2D");
		textField_2.setBounds(52, 193, 96, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u958B\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DiscordWebhook webhook = new DiscordWebhook(settings.load().getProperty("discord"));
					webhook.addEmbed(new DiscordWebhook.EmbedObject()
				            .setTitle("HeyRender")
				            .setDescription("Rendering Completed!!")
				            .addField("Time", "5sec", true)
							.addField("FileName", "unchi.mp4", true));
					webhook.execute();
				} catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
		           	System.exit(0);
				}
				btnNewButton.setText(((button.getText()).equals("\u5b9f\u884c\u4e2d"))?"\u958B\u59CB":"\u5b9f\u884c\u4e2d");
				btnNewButton.setEnabled(false);
				textField_2.setText("\u76e3\u8996\u4e2d");
			}
		});
		btnNewButton.setBounds(161, 192, 91, 21);
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
