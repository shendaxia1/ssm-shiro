package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.shen.model.TuiGuang;

public class Csv {
	public static List<TuiGuang> readCsv(String file) throws ParseException {
		File csv = new File(file);  // CSV文件路径
		List<TuiGuang> list = new ArrayList<TuiGuang>();
	    BufferedReader br = null;
	    int count = 0;
	    try
	    {
	        br = new BufferedReader(new FileReader(csv));
	    } catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    String line = "";
	    String everyLine = "";
	    try {
	            List<String> allString = new ArrayList<>();
	            while ((line = br.readLine()) != null)  //读取到的内容给line变量
	            {
	            	count++;
	            	if(count==1) {
	            		continue;
	            	}
	                everyLine = line;
	                String[] tt = everyLine.split(",");
	                String curData = tt[1]+" 01:02:01";
	                int a = Integer.parseInt(tt[3]);
	                int b = Integer.parseInt(tt[4]);
	                Double c = Double.parseDouble(tt[5]);
	                Double d = Double.parseDouble(tt[6]);
	                String rate = tt[7].replace("%", "");
	                Double e = Double.parseDouble(rate);
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//这里的格式要跟上面表示日期的字符串里面一样
	                Date utilDate = sdf.parse(curData);
	                TuiGuang tuiguang = new TuiGuang();
	                String UU = UUID.randomUUID().toString();
	                tuiguang.setId(UU);
	                tuiguang.setPa_name(tt[0]);
	                tuiguang.setPa_data(utilDate);
	                tuiguang.setPa_plan(tt[2]);
	                tuiguang.setPa_show(a);
	                tuiguang.setPa_click(b);
	                tuiguang.setPa_payamount(c);
	                tuiguang.setPa_avage(d);
	                tuiguang.setPa_click_rate(e);
	                tuiguang.setPa_login("aaa");
	                tuiguang.setPa_wx("bbb");
	                list.add(tuiguang);
	               
	            }
	         
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }finally {
	    	try {
	    		br.close();
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	    }
		return list;
		
	}
	
	public static void deleteFile(String file) {
		File delFile = new File(file);
        if(delFile.isFile() && delFile.exists()) {
            delFile.delete();
            
            
        }
    }
	

}
