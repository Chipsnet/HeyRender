package jp.co.minato86.form;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
public class Settings {
    public void load() {

        Properties properties = new Properties();

        String file = "sample.properties";
        File isfile = new File(file);
        try {
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            inputStream.close();

            // �l�̎擾
            System.out.println(properties.getProperty("id"));
            System.out.println(properties.getProperty("password"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (isfile.exists()) {
            	JOptionPane.showMessageDialog(null, "�v���I�ȃG���[���������܂����B\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
            	System.exit(0);
            } else {
            	JOptionPane.showMessageDialog(null, "�v���I�ȃG���[���������܂����B\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
            	System.exit(0);
            }
        }
    }
    public boolean discord() {
    	Properties properties = new Properties();
        String file = "settings.properties";
        try {
        	InputStream inputStream = new FileInputStream(file);
        	properties.load(inputStream);
        	inputStream.close();
        	
        	if (properties.getProperty("discord").equals("")) {
        		return false;
        	} else {
        		return true;
        	}
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "�v���I�ȃG���[���������܂����B\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
           	System.exit(0);
        }
		return false;
    }
    public boolean line() {
    	Properties properties = new Properties();
        String file = "settings.properties";
        try {
        	InputStream inputStream = new FileInputStream(file);
        	properties.load(inputStream);
        	inputStream.close();
        	
        	if (properties.getProperty("line").equals("")) {
        		return false;
        	} else {
        		return true;
        	}
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "�v���I�ȃG���[���������܂����B\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
           	System.exit(0);
        }
		return false;
    }
    public void check() {
    	System.out.print("OK");
    	Properties properties = new Properties();
        String file = "settings.properties";
        File isfile = new File(file);
        
        if (isfile.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                properties.load(inputStream);
                inputStream.close();

                System.out.println(properties.getProperty("line"));
                System.out.println(properties.getProperty("discord"));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "�v���I�ȃG���[���������܂����B\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
               	System.exit(0);
            }
        } else {
        	JOptionPane.showMessageDialog(null, "�ݒ�t�@�C���̓ǂݍ��݂Ɏ��s���܂����B\n�폜�����ꍇ�́A�ă_�E�����[�h���s���Ă��������B", "HeyRender Error", JOptionPane.ERROR_MESSAGE);
        	System.exit(0);
        }
    }
    public void write() {
        Properties properties = new Properties();
        
        // �v���p�e�B�t�@�C���̃p�X���w�肷��
        String strpass = "settings.properties";
        
        try {
            // ��������
            properties.setProperty("discord", "��aaa");
            OutputStream ostream = new FileOutputStream(strpass);
            OutputStreamWriter osw = new OutputStreamWriter(ostream, "UTF-8");
            properties.store(osw, "Comments");
            
            // �ǂݍ���
            InputStream istream = new FileInputStream(strpass);
            InputStreamReader isr = new InputStreamReader(istream, "UTF-8");
            properties.load(isr);
            istream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}