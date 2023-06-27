package unit1.session2;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecode {

    static final String BASE_URL = "https://tinyurl.com/";
    static int counter = 0;
    static Map<String, String> encMap = new HashMap<>();
    static Map<String, String> decMap = new HashMap<>();

    static public String encode(String url){
        if(encMap.containsKey(url))
            return encMap.get(url);
        counter+=1;
        String sUrl = BASE_URL + counter;
        encMap.put(url, sUrl);
        decMap.put(sUrl, url);
        return sUrl;
    }

    static public String decode(String url){
        if(decMap.containsKey(url))
            return decMap.get(url);
        return "No such url";
    }

    public static void main(String[] args) {
        String url = "https://codepath.com/dashboard";
        String enc = encode(url);
        System.out.println(enc);
        System.out.println(decode(enc));
    }
}
