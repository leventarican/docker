package com.github.leventarican;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.spotify.docker.client.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );

        try {
            // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
            final DockerClient docker = DefaultDockerClient.fromEnv().build();
            docker.pull("busybox");
            System.out.println("log: " + docker.listImages());
        } catch (Exception e) {

        }
    }
}
