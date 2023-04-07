package com.qst.test;

import java.util.ArrayList;
import java.util.List;

import com.qst.util.FolderTreeUtil;
import com.qst.vo.FolderInfoYYVo;

public class TreeTest {
	
	public static void main(String[] args) {
		
		List<FolderInfoYYVo> list = new ArrayList<FolderInfoYYVo>();
		FolderInfoYYVo f1 = new FolderInfoYYVo(0, null, "我的网盘");
		FolderInfoYYVo f2 = new FolderInfoYYVo(1, 0, "网盘1");
		FolderInfoYYVo f3 = new FolderInfoYYVo(2, 0, "网盘2");
		FolderInfoYYVo f4 = new FolderInfoYYVo(3, 1, "网盘11");
		FolderInfoYYVo f5 = new FolderInfoYYVo(4, 1, "网盘12");
		FolderInfoYYVo f6 = new FolderInfoYYVo(5, 2, "网盘21");
		FolderInfoYYVo f7 = new FolderInfoYYVo(6, 3, "网盘111");
		
		
		
		
		
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		list.add(f5);
		list.add(f6);
		list.add(f7);
		
		List<FolderInfoYYVo> tree = FolderTreeUtil.buildByRecursive(list);
		
	
		
	}

}
