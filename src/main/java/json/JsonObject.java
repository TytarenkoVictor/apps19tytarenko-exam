package json;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private List<JsonPair> jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = new ArrayList<>(Arrays.asList(jsonPairs));
    }

    private JsonObject(List<JsonPair> jsonPairs) {
        this.jsonPairs = jsonPairs;
    }

    @Override
    public String toJson() {
        String res = "{" + StringUtils.join(jsonPairs.stream().map(pair -> pair.key + ": " + pair.value.toJson()).collect(Collectors.toList()), ", ") + "}";
        return res;
    }

    public void add(JsonPair jsonPair) {
        for (int i = 0; i < jsonPairs.size(); i++) {
            if (jsonPairs.get(i).key.equals(jsonPair.key)) {
                jsonPairs.set(i, jsonPair);
                return;
            }
        }
        jsonPairs.add(jsonPair);
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        return new JsonObject(jsonPairs.stream().filter(jp -> Arrays.asList(names).contains(jp.key)).collect(Collectors.toList()));
    }
}



