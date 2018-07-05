/*
 * As per the instructions in the brief, here is what I did differently to last time:
       - I added synchronization to the methods.
       - I changed the way the update method works, so that the user doens't have to 
         give both the old and current definitions of the word being updated. 
 */
package WebDictionaryPackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Singleton;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

//Specifying the data persists and then 'base' URL for the methods in the service
@Singleton
@Path("dictionary")
public class DictionaryResource {

    @Context
    private UriInfo context;
    private ConcurrentHashMap<String, String> dictList = new ConcurrentHashMap<>();

    //Empty constructor for the client to use.
    public DictionaryResource() {
    }

    /**
     * Getting all the words and their definitions
     * Using @GET because GET request to the URI above, so just 'point' a web browser that URI and 
     * a list of all the words currently stored (in JSON) format) is returned.
     * @return 
     */
    @GET
    @Produces("application/json")
    public JsonArray getWords() {
        ConcurrentHashMap<String, String> clonelist;
        synchronized (dictList) {
            clonelist = new ConcurrentHashMap<String, String>(dictList);
        }
        //Creating a JSON array
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        //Looping over data, adding each element at a time
        for (Map.Entry<String, String> elem : clonelist.entrySet()) {
            if (elem != null) {
                //Adding each stored word into the array
                arrayBuilder.add(Json.createObjectBuilder().
                        add("word", elem.getKey()).
                        add("definition", elem.getValue()));
            }
        }
        //Returning the JSON aray
        return arrayBuilder.build();
    }

    /**
     * Returns a single word from its definition
     * Uses @GET
     * @param word
     * @return
     * @throws NotFoundException 
     */
    @GET
    //Uses a path parameter to specify the key
    @Path("{word}")
    @Produces("application/json")
    public JsonObject getDefinition(@PathParam("word") String word)
            throws NotFoundException {
        synchronized (dictList) {
            if (!dictList.containsKey(word)) {
                throw new NotFoundException();
            } else {
                JsonObjectBuilder builder = Json.createObjectBuilder().
                        add("word", word).
                        add("definition", dictList.get(word));
                return builder.build();
            }
        }
    }

    /**
     * Checks the methods work by giving the response 'Okay'.
     * @return 
     */
    @GET
    @Path("/ping/respond") 
    @Produces("text/plain")
    //Method that says "I'm working"
    public String getPing() {
        return ("Okay");
    }

    /**
     * Deleting a book from the Concurrent Hash Map
     * Using @DELETE 
     * @param word
     * @throws NotFoundException 
     */
    @DELETE
    @Path("{word}")
    public void deleteWord(@PathParam("word") String word)
            throws NotFoundException {
        //Changes everything to lowercase, so there are no issues with case sensitivity
        String entry = word.toLowerCase();
        synchronized (dictList) {
            if (!dictList.containsKey(word)) {
                throw new NotFoundException();
            } else {
                dictList.remove(word);
            }
        }
    }
    //Throws a 404/Not Found is the definition isn't present

 
     /** 
     * Adding words to the Concurrent Hash Map
     * Using @POST
     * Two methods are needed, as one is for the client and one is for the webpage.
     * @param word
     * @param definition 
     */ 
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void addWord(@FormParam("word") String word, @FormParam("definition") String definition) {
        //Changes everything to lowercase, so there are no issues with case sensitivity
        //String entry = word.toLowerCase();
        dictList.putIfAbsent(word, definition);
    }

    /**
     * Adding words to the Concurrent Hash Map  
     * Accepts a JSON object as a parameter,and extracts the data labelled with 
     * 'word' and 'definition' 
     * Using @POST 
     * Two methods are needed, as one is for the client and one is for the webpage.
     * @param entry 
     */
    @POST
    @Consumes("application/json")
    public void addWord(JsonObject entry) {
        String word = entry.getJsonString("word").getString();
        String definition = entry.getJsonString("definition").getString();
        dictList.putIfAbsent(word, definition);
    }

    /**
     * Updating a word - need two; one for the webpage, one for the client
     * Using @PUT 
     * @param entry 
     */
    @PUT
    @Consumes("application/json")
    public void updateWord(JsonObject entry) {
        String word = entry.getJsonString("word").getString();
            String definition = entry.getJsonString("definition").getString();
            dictList.replace(word, definition);
        }

    /**
     * Updating a word - need two; one for the webpage, one for the client
     * Using @PUT 
     * @param word
     * @param definition 
     */
    @PUT
    @Consumes("application/x-www-form-urlencoded")
    public void updateWord(@FormParam("word") String word, @FormParam("definition") String definition) {
        
            //Changes everything to lowercase, so there are no issues with case sensitivity
            String entry = word.toLowerCase();
            dictList.replace(word, definition);
        
    }
}
