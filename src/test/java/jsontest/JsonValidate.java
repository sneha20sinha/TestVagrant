package jsontest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonValidate {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		try {
		JSONParser jsonparser = new JSONParser(); //this object used to parse jsondata to json file
		FileReader reader = new FileReader(".\\jsonfiles\\TeamRCB.JSON"); // to read or load file.
		Object obj = jsonparser.parse(reader); //parsing jsondata from the file.
		
		 //Converting JavaObject to JsonObject
		JSONObject teamRCB = (JSONObject)obj;
		
		JSONArray array = (JSONArray) teamRCB.get("player");
		
		int foreignpalyercount =0;
		int wickerkeepercount=0;
		for(int i=0; i<array.size();i++)
		{
		JSONObject player =	(JSONObject) array.get(i);
		
		//test to validate that the team has only 4foreign players	
		if(!(player.get("country").equals("India")))
		{
			foreignpalyercount++;
		}
		
		//test to validate that there is at least one wicket keeper
		if((player.get("role").equals("Wicket-keeper")))
		{
			wickerkeepercount++;
		}
		}
		System.out.println("Foreign Players count : "+foreignpalyercount);
		System.out.println("Wicket keeper count : "+wickerkeepercount);
	}
		catch(Exception e)
		{
			System.out.println("Validation not correct" +e.getMessage());
		}
	}
	

}
