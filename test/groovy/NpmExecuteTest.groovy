import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

class NpmExecuteTest extends PiperTestBase {

    Map dockerParameters
    List shellCalls

    @Before
    void setUp() {
        super.setUp()

        shellCalls = []
        dockerParameters = [:]

        helper.registerAllowedMethod("dockerExecute", [Map.class, Closure.class],
            { parameters, closure ->
                dockerParameters = parameters
                closure()
            })
        helper.registerAllowedMethod('sh', [String], { s -> shellCalls.add(s) })
    }

    @Test
    void testExecuteBasicNpmCommand() throws Exception {
        def script = loadScript("test/resources/pipelines/npmExecuteTest/executeBasicNpmCommand.groovy")
        script.execute()
        assertEquals('s4sdk/docker-node-browsers', dockerParameters.dockerImage)
        assertTrue(shellCalls.contains('npm install'))
    }

    @Test
    void testExecuteNpmCommandWithParameter() throws Exception {
        def script = loadScript("test/resources/pipelines/npmExecuteTest/executeNpmCommandWithParameters.groovy")
        script.execute()
        assertEquals('myNodeImage', dockerParameters.dockerImage)
        assertTrue(shellCalls.contains('npm install'))
    }
}
