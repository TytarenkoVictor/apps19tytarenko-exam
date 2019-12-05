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

    @Override
    public String toJson() {
        String res = "{" + StringUtils.join(jsonPairs.stream().map(pair -> pair.key + ": " + pair.value.toJson()).collect(Collectors.toList()), ", ") + "}";
        return res;
    }

    public void add(JsonPair jsonPair) {
        this.jsonPairs.add(jsonPair);
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}



