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
    public Properties load() {
    	Properties properties = new Properties();
        String file = "settings.properties";
        try {
        	InputStream inputStream = new FileInputStream(file);
        	properties.load(inputStream);
        	inputStream.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "�v���I�ȃG���[���������܂����B\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
           	System.exit(0);
        }
		return properties;
    }
    public boolean discord() {
        if (load().getProperty("discord").equals("")) {
        	return false;
        } else {
        	return true;
        }
    }
    public boolean line() {
        if (load().getProperty("line").equals("")) {
        	return false;
        } else {
        	return true;
        }
    }
    public void check() {
    	Properties properties = new Properties();
        String file = "settings.properties";
        File isfile = new File(file);
        
        if (isfile.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                properties.load(inputStream);
                inputStream.close();


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