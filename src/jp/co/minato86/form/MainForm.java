package jp.co.minato86.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

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
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;

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
		btnNewButton.setBounds(161, 192, 91, 21);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 419, 186);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("About", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("HeyRender");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 50));
		lblNewLabel_2.setBounds(27, 25, 322, 55);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblVersionBeta = new JLabel("Version: Beta 1.0.0");
		lblVersionBeta.setBounds(27, 79, 180, 13);
		panel_2.add(lblVersionBeta);
		
		JLabel lblcMinato = new JLabel("(c) 2019 Minato86");
		lblcMinato.setBounds(27, 167, 112, 13);
		panel_2.add(lblcMinato);
		
		JLabel lblDevelopedByMinato = new JLabel("Developed by Minato86");
		lblDevelopedByMinato.setBounds(27, 190, 161, 13);
		panel_2.add(lblDevelopedByMinato);
		
		JButton btnOpensite = new JButton("OpenSite");
		btnOpensite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				String uriString = "https://minato86.me/";
				try {
					URI uri = new URI(uriString);
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOpensite.setBounds(316, 186, 91, 21);
		panel_2.add(btnOpensite);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((!textField_3.getText().equals("")) && (!textField_4.getText().equals(""))) {
				        String file = textField_3.getText()+"\\"+textField_4.getText();
				        textArea.append("[INFO] 監視を開始します\n[INFO] Filepath:"+file+"\n");
				        File isfile = new File(file);
						
				        new Thread(new Runnable() {
				            @Override
				            public void run() {
				            	
				            	int time = 0;
						        int cnt = 0;	
						        int temp = 0;
				            	
						        while (true) {
						        	if (isfile.exists()) {
						        		textArea.append("[INFO] ファイルを検出しました。容量の検証を行います\n");
						        		time += 1;
										break;
						        	} else {
						        		time += 1;
						        		textArea.append("[INFO] 監視中 - ファイルなし 経過時間:"+time+"秒\n");
						        		try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
						        	}
						        }

						        while (true) {
						        	File fileout = new File(file);
						        	if (fileout.length() == temp) {
						        		cnt += 1;
						        		temp = (int) fileout.length();
						        	} else {
						        		cnt = 0;
						        		temp = (int) fileout.length();
						        	}
						        	if (cnt < 20) {
						        		time += 1;
						        		textArea.append("[INFO] 監視中 - 容量確認 経過時間:"+time+"秒 容量:"+fileout.length()+"\n");
						        		try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
						        	} else {
						        		textArea.append("[INFO] レンダリング完了 経過時間："+time+"秒\n");
						        		textArea.append("[INFO] 通知の送信を開始します。\n");
						        		if (settings.line()) {
						        			final String USER_TOKEN = settings.load().getProperty("line");
						        			LineNotify ln = new LineNotify(USER_TOKEN);
						        			try {
												ln.notifyMe("レンダリングが完了しました！\n経過時間:"+time+"秒\nファイル名:"+textField_4.getText());
											} catch (IOException e) {
												e.printStackTrace();
											}
						        		} else {
						        			textArea.append("[INFO] LINE通知が無効なため、スキップしました\n");
						        		}
										if (settings.discord()) {
											DiscordWebhook webhook = new DiscordWebhook(settings.load().getProperty("discord"));
											webhook.addEmbed(new DiscordWebhook.EmbedObject()
										            .setTitle("HeyRender")
										            .setDescription("Rendering Completed!!")
										            .addField("Time", time+"sec", true)
													.addField("FileName", textField_4.getText(), true));
											
											try {
												webhook.execute();
												btnNewButton.setText("\u958B\u59CB");
												btnNewButton.setEnabled(true);
												textField_2.setText("\u5b8c\u4e86");
											} catch (IOException e) {
												e.printStackTrace();
											}
										} else {
											textArea.append("[INFO] Discord通知が無効なため、スキップしました\n");
										}
										textArea.append("[INFO] 通知の送信が完了しました\n");
										break;
						        	}
						        }
				            }
				        }).start();
						
						btnNewButton.setText("\u5b9f\u884c\u4e2d");
						btnNewButton.setEnabled(false);
						textField_2.setText("\u76e3\u8996\u4e2d");
						
					} else {
						JOptionPane.showMessageDialog(null, "ファイルを指定してください。", "Settings", 1);
					}
				} catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
		           	System.exit(0);
				}
			}
		});
		
	}
}
