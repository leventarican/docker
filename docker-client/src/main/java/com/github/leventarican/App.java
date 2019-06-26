package com.github.leventarican;

import com.spotify.docker.client.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
            final DockerClient docker = DefaultDockerClient.fromEnv().build();
            System.out.println("log: " + docker);
        } catch (Exception e) {

        }
    }
}
