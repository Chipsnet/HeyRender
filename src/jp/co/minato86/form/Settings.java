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

            // 値の取得
            System.out.println(properties.getProperty("id"));
            System.out.println(properties.getProperty("password"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (isfile.exists()) {
            	JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
            	System.exit(0);
            } else {
            	JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "致命的なエラーが発生しました。\n"+ex.getMessage(), "HeyRender Error", JOptionPane.ERROR_MESSAGE);
               	System.exit(0);
            }
        } else {
        	JOptionPane.showMessageDialog(null, "設定ファイルの読み込みに失敗しました。\n削除した場合は、再ダウンロードを行ってください。", "HeyRender Error", JOptionPane.ERROR_MESSAGE);
        	System.exit(0);
        }
    }
    public void write() {
        Properties properties = new Properties();
        
        // プロパティファイルのパスを指定する
        String strpass = "settings.properties";
        
        try {
            // 書き込み
            properties.setProperty("discord", "侍aaa");
            OutputStream ostream = new FileOutputStream(strpass);
            OutputStreamWriter osw = new OutputStreamWriter(ostream, "UTF-8");
            properties.store(osw, "Comments");
            
            // 読み込み
            InputStream istream = new FileInputStream(strpass);
            InputStreamReader isr = new InputStreamReader(istream, "UTF-8");
            properties.load(isr);
            istream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}