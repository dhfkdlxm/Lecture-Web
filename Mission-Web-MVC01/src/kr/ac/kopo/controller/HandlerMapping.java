package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		this("C:\\Users\\Hwany\\Documents\\GitHub\\Lecture-Web\\Mission-Web-MVC01\\bean.properties");//경로가 안들어왔을때, 최소한의 경로를 잡아 주는것(생성자 재호출)
	}
	
	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		Properties prop = new Properties();
		try {
//			InputStream is = new FileInputStream("C:\\Users\\Hwany\\Documents\\GitHub\\Lecture-Web\\Mission-Web-MVC01\\bean.properties");
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);
			//prop.getProperty("/board/list.do");
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
				
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * mappings.put("/board/list.do", new BoardListController());
		 * mappings.put("/board/writeForm.do", new WriteFormController());
		 * mappings.put("/board/detail.do", new BoardDetailController());
		 */
		 
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
	/*
	 * public static void main(String[] args) { try { Class<?> clz =
	 * Class.forName("kr.ac.kopo.controller.BoardListController");
	 * BoardListController list = (BoardListController)clz.newInstance();
	 * list.handleRequest(null, null); } catch (Exception e) { e.printStackTrace();
	 * } }
	 */
	
	
}
