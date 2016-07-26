package com.weihuagu.cilisou.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.weihuagu.cilisou.BtanySearch;

import junit.framework.TestCase;

public class BtanySearchTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testGetSearch(){
		BtanySearch search=new BtanySearch();
		assertNotNull(search.getSearch("sex"));
	}

}
