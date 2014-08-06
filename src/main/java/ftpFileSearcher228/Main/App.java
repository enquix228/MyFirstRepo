package ftpFileSearcher228.Main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class App {

	public static void main(String[] args) throws IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("ftp.mozilla.org");
		ftpClient.enterLocalPassiveMode();
		ftpClient.login("anonymous", "");
		Searcher(ftpClient, "");
	}
	
	public static void Searcher(FTPClient ftpClient, String Path)
			throws IOException {
		FTPFile[] files = ftpClient.listFiles(Path);
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
			System.out.println(files[i].getName() +"[FOLDER]" +"       Size:"  +files[i].getSize()+" bytes");
				Searcher(ftpClient,Path +"//" +files[i].getName());
			}else
			{
			if (files[i].isFile()) {
				System.out.println(files[i].getName() +"[FILE]" +"       Size:"  +files[i].getSize()+" bytes");
			}
			}
		}
	}

}
