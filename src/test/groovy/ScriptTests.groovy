import static org.junit.Assert.*
import groovy.mock.interceptor.StubFor;

import org.junit.Ignore;
import org.junit.Test;

class ScriptTests {
    String base = 'src/main/groovy'
    
    @Test
    void testAdderString() {
        Binding binding = new Binding()
        binding.x = 3
        binding.y = 4
        GroovyShell shell = new GroovyShell(binding)
        shell.evaluate('z = x + y')
        assertEquals 7, binding.z
    }

    // --- Listing 3 start ---
    @Test
    void testAdder() {
        Binding binding = new Binding()
        binding.x = 3
        binding.y = 4
        GroovyShell shell = new GroovyShell(binding)
        shell.evaluate(new File("$base/adding.groovy"))
        assertEquals 7, binding.z
    }
    // --- Listing 3 end ---

    // --- Listing 4 start ---
    @Test
    void testHelloWorld() {
        Binding binding = new Binding()
        GroovyShell shell = new GroovyShell(binding)
        def content = new StringWriter()
        binding.out = new PrintWriter(content)
        shell.evaluate(new File("$base/hello_world.groovy"))
        assertEquals "Hello, World!", content.toString().trim() 
    }
    // --- Listing 4 end ---

    // --- Listing 5 start ---
    @Test
    void testHelloName() {
        Binding binding = new Binding()
        binding.name = 'Dolly'
        def content = new StringWriter()
        binding.out = new PrintWriter(content)
        GroovyShell shell = new GroovyShell(binding)
        shell.evaluate(new File("$base/hello_name.groovy"))
        assertEquals "Hello, Dolly!", content.toString().trim() 
    }
    // --- Listing 5 end ---

    // --- Listing 7 start ---
    @Test
    void testChuckNorrisOnline() {
        GroovyShell shell = new GroovyShell()
        shell.evaluate(new File("$base/chuck_norris.groovy"))
    }
    // --- Listing 7 end ---
    
    // --- Listing 8 start ---
    @Test
    void testChuckNorrisOffline() {
        def result = '''
        {
            "value" : {
                "joke" : "Chuck Norris can make a class abstract AND final"
            }
        }
        '''
   
        StubFor stub = new StubFor(URL)
        stub.demand.getText { result }
        
        stub.use {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$base/chuck_norris.groovy"))
        }
    }
    // --- Listing 8 end ---
}
