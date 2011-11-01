// --- Listing 6 start ---
import groovy.json.JsonSlurper

def url = 'http://api.icndb.com/jokes/random'
result = url.toURL().text
def json = new JsonSlurper().parseText(result)
def joke = json?.value?.joke
assert joke
println joke
// --- Listing 6 end ---