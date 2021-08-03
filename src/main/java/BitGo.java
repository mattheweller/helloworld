import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class BitGo {
    public static void main(String[] args) throws UnirestException {
        System.out.println("hello world");
        HttpResponse<String> response = Unirest.get("http://localhost:3080/api/v2/ping")
                .asString();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

//        Producess the following:
//        ```
//        hello world
//        {
//            "status": "service is ok!",
//                "environment": "BitGo Testnet",
//                "configEnv": "testnet"
//        }
//        ```
    }


}
