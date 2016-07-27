package com.weihuagu.cilisou.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.weihuagu.cilisou.BtanySearch;
import com.weihuagu.cilisou.CiliInfo;

import junit.framework.TestCase;

public class BtanySearchTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testGetSearch(){
		BtanySearch search=new BtanySearch();
		List<CiliInfo> ciliList = search.getSearch("无码 美女");
		assertNotNull(ciliList);
		for(int i=0;i<ciliList.size();i++){
			System.out.println(ciliList.get(i).getTitle());
			System.out.println(ciliList.get(i).getMagnet());
			System.out.println(ciliList.get(i).getThunder());
			System.out.println("//////////////////////");
		}
	}

}
