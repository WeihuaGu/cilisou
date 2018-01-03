/*
 * Created By WeihuaGu (email:weihuagu_work@163.com)
 * Copyright (c) 2018
 * All right reserved.
 */

package com.weihuagu.cilisou.tests;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

import com.weihuagu.cilisou.TorrentkittySearch;
import com.weihuagu.cilisou.CiliInfo;
/**
 * Created by root on 18-1-3.
 */
public class TorrentkittySearchTest {

    /**

    @Test
    public void testgetPageNum() throws Exception {
        TorrentkittySearch search=new TorrentkittySearch();
        System.out.println(search.getPageNum("惊变"));


    }

   **/
    @Test
    public void testGetSearch() throws Exception {
        TorrentkittySearch search=new TorrentkittySearch();
        List<CiliInfo> ciliList = search.getSearch("美女");
        assertNotNull(ciliList);
        for(int i=0;i<ciliList.size();i++){
            System.out.println(ciliList.get(i).getTitle());
            System.out.println(ciliList.get(i).getMagnet());
            System.out.println(ciliList.get(i).getThunder());
            System.out.println("//////////////////////");
        }
    }


}