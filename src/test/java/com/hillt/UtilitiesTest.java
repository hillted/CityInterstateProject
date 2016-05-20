package com.hillt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thill on 5/9/16.
 */
public class UtilitiesTest extends Utilities {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateAndFileDiff() throws Exception {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        createTextFile("file1.txt", "TEST-1");
        createTextFile("file2.txt", "TEST-1");
        Assert.assertTrue("Files not equal.",fileDiff("file1.txt","file2.txt"));
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @After
    public void tearDown() throws Exception {
    }
}