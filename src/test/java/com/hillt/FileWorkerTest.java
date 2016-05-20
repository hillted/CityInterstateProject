package com.hillt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thill on 5/9/16.
 */
public class FileWorkerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFileWorkerParseAndCreateValidOutput() throws Exception {
        FileWorker cw = new FileWorker();
        Utilities utils = new Utilities();
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertTrue("City files not equal.",utils.fileDiff(cw.gCityOutputFilename,"src/main/resources/"+cw.gCityOutputFilename));
        Assert.assertTrue("Interstate files not equal.",utils.fileDiff(cw.gInterstateOutputFilename,"src/main/resources/"+cw.gInterstateOutputFilename));
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @After
    public void tearDown() throws Exception {
    }
}