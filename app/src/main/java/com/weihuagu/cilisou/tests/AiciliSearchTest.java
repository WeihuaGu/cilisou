/*
 * Created By WeihuaGu (email:weihuagu_work@163.com)
 * Copyright (c) 2018
 * All right reserved.
 */

package com.weihuagu.cilisou.tests;

import com.weihuagu.cilisou.CiliInfo;
import com.weihuagu.cilisou.TorrentkittySearch;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by root on 18-1-3.
 */
public class AiciliSearchTest {

    @Test
    public void testGetSearch() throws Exception {
        AiciliSearch search=new AiciliSearch();
        List<CiliInfo> ciliList = search.getSearch("美女 无码",1);
        assertNotNull(ciliList);
        for(int i=0;i<ciliList.size();i++){
            System.out.println(ciliList.get(i).getTitle());
            System.out.println(ciliList.get(i).getMagnet());
            System.out.println(ciliList.get(i).getThunder());
            System.out.println("//////////////////////");
        }
    }
}