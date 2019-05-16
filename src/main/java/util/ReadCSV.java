package util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.Arrays;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;


public class ReadCSV {
	public static void readCSV(String csvFilePath) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(new File(csvFilePath)));
			// CSVReader csvReader = new CSVReader(new InputStreamReader(in,"GBK"));
			CSVReader csvReader = new CSVReader(new InputStreamReader(in, "GBK"), CSVParser.DEFAULT_SEPARATOR,
			CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 1);
			String[] strs;
			while ((strs = csvReader.readNext()) != null) {
			System.out.println(Arrays.deepToString(strs));
			}
			csvReader.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
			
		
		
	}

}
