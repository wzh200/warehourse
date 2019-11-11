package com.example.warehouse.tool;

import java.util.HashMap;
import java.util.List;

public class Pagetool<T> {
	 int size=5;
	 int start=0;
	 
	public Page<T> pageTool(int pageIndex,int pageNumber) {
		Page<T> pagebean=new Page<T>();
		pagebean.setPageIndex(pageIndex);
		
		pagebean.setPageSize(size);
		pagebean.setPageNumber(pageNumber);
		
		double numb=pageNumber;
        Double num =Math.ceil(numb/size);//����ȡ��
        pagebean.setPageCount(num.intValue());
		
        start=(pageIndex-1)*size;
		return pagebean;
	}
	
	public HashMap<String,Object> hashMap(String name){
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("size", size);
		map.put("name", name);
		return map;
		
	}
}
