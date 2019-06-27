package com.github.leventarican;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ContainerInfo;
import com.spotify.docker.client.messages.ExecCreation;
import com.spotify.docker.client.messages.HostConfig;
import com.spotify.docker.client.messages.PortBinding;

/**
 * levent@protonmail.com
 */
public class AppTest extends TestCase
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
     * spotify docker client example
     */
    public void testApp()
    {
        assertTrue( true );

        try {
            // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars

            System.out.println("###");
            System.out.println("the following steps can take a while...");
            System.out.println("###");

            final DockerClient docker = DefaultDockerClient.fromEnv().build();
            docker.pull("busybox");

            System.out.println("Bind container ports to host ports");
            final String[] ports = {"80", "22"};
            final Map<String, List<PortBinding>> portBindings = new HashMap<>();
            for (String port : ports) {
                List<PortBinding> hostPorts = new ArrayList<>();
                hostPorts.add(PortBinding.of("0.0.0.0", port));
                portBindings.put(port, hostPorts);
            }

            System.out.println("Bind container port 443 to an automatically allocated available host port.");
            List<PortBinding> randomPort = new ArrayList<>();
            randomPort.add(PortBinding.randomPort("0.0.0.0"));
            portBindings.put("443", randomPort);

            final HostConfig hostConfig = HostConfig.builder().portBindings(portBindings).build();

            System.out.println("Create container with exposed ports");
            final ContainerConfig containerConfig = ContainerConfig.builder()
                .hostConfig(hostConfig)
                .image("busybox").exposedPorts(ports)
                .cmd("sh", "-c", "while :; do sleep 1; done")
                .build();

            final ContainerCreation creation = docker.createContainer(containerConfig);
            final String id = creation.id();

            System.out.println("Inspect container");
            final ContainerInfo info = docker.inspectContainer(id);

            System.out.println("Start container");
            docker.startContainer(id);

            System.out.println("Exec command inside running container with attached STDOUT and STDERR");
            final String[] command = {"sh", "-c", "ls"};
            final ExecCreation execCreation = docker.execCreate(
                id, command, DockerClient.ExecCreateParam.attachStdout(),
                DockerClient.ExecCreateParam.attachStderr());
            final LogStream output = docker.execStart(execCreation.id());
            final String execOutput = output.readFully();

            System.out.println("###");
            System.out.println(execOutput);
            System.out.println("###");

            System.out.println("Kill container");
            docker.killContainer(id);

            System.out.println("Remove container");
            docker.removeContainer(id);

            System.out.println("Close the docker client");
            docker.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
