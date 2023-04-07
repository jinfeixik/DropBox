package com.qst.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.qst.vo.FolderInfoYYVo;

public class FolderTreeUtil {
	
	public static List<FolderInfoYYVo> bulid(List<FolderInfoYYVo> treeNodes) {
		 
        List<FolderInfoYYVo> trees = new ArrayList<FolderInfoYYVo>();
 
        for (FolderInfoYYVo treeNode : treeNodes) {
 
           /* if ("0".equals(treeNode.getpId())) {
                trees.add(treeNode);
            }*/
            
            if(treeNode.getpId() == null) {
            	System.out.println("treeNode = " +treeNode.getTitle());
            	trees.add(treeNode);
            	
            }
 
            for (FolderInfoYYVo it : treeNodes) {
                if (it.getpId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                    	
                    	treeNode.setChildren(new HashSet<FolderInfoYYVo>());
                    }
                    String path = treeNode.getTitle() +"/" + it.getTitle();
                    System.out.println("treeNode" +treeNode.getTitle() +", = treeNode " +it.getTitle());
                   System.out.println("path = " +path);
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }
 
    /**
     * 使用递归方法建树
     * @param treeNodes
     * @return
     */
    public static List<FolderInfoYYVo> buildByRecursive(List<FolderInfoYYVo> treeNodes) {
        List<FolderInfoYYVo> trees = new ArrayList<FolderInfoYYVo>();
        for (FolderInfoYYVo treeNode : treeNodes) {
            if (treeNode.getpId() == null) {
            	System.out.println("treeNode = " +treeNode.getTitle());
                trees.add(findChildren(treeNode,treeNodes));
            }
        }
        return trees;
    }
 
    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    public static FolderInfoYYVo findChildren(FolderInfoYYVo treeNode,List<FolderInfoYYVo> treeNodes) {
        for (FolderInfoYYVo it : treeNodes) {
            if(treeNode.getId().equals(it.getpId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new HashSet<FolderInfoYYVo>());
                }
                System.out.println("treeNode = " +it.getTitle());
                treeNode.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return treeNode;
    }
 

}
