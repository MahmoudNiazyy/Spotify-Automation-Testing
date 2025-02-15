package DataReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JSONreader {

    public static Object[][] ReadJsonFile(String jsonFileName , String DataType){

         Object[][] data = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/main/resources/TestData/"+jsonFileName+".json"));
          JSONArray jsonArray = (JSONArray) jsonObject.get(DataType);

          data= new Object[jsonArray.size()][1] ;

          for ( int i=0;i<jsonArray.size();i++)
          {
              HashMap<String,String> map = JsonObjectHashNap((JSONObject)jsonArray.get(i));
              data[i][0]=map;
          }

        } catch (IOException  | ParseException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    private static HashMap<String,String> JsonObjectHashNap(JSONObject jsonObject)
    {
        HashMap<String,String> x = new HashMap<>();
        jsonObject.forEach((key , value)-> x.put(key.toString(), (String) value.toString()) );

        return x;
    }
}
