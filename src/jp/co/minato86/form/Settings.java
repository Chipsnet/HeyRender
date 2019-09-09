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
            JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
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
    	//properties読み込み
    	Properties properties = new Properties();
        String file = "settings.properties";
        File isfile = new File(file);
        
        //
        if (isfile.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                properties.load(inputStream);
                inputStream.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
               	System.exit(0);
            }
        } else {
        	try {
                OutputStream ostream = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(ostream, "UTF-8");
            	properties.setProperty("line", "");
            	properties.setProperty("discord", "");
            	properties.store(osw, "HeyRender Settings");
            	check();
        	} catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
               	System.exit(0);
            }
        }
    }
    public void write(String key, String data) {
    	
        Properties properties = new Properties();
        String strpass = "settings.properties";
        
        try {
            if (key.equals("discord")) {
            	properties.setProperty("discord", data);
            	properties.setProperty("line", load().getProperty("line"));
            	JOptionPane.showMessageDialog(null, "設定しました。", "Settings", 1);
            } else {
            	properties.setProperty("line", data);
            	properties.setProperty("discord", load().getProperty("discord"));
            	JOptionPane.showMessageDialog(null, "設定しました。", "Settings", 1);
            }
            OutputStream ostream = new FileOutputStream(strpass);
            OutputStreamWriter osw = new OutputStreamWriter(ostream, "UTF-8");
            properties.store(osw, "HeyRender Settings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}