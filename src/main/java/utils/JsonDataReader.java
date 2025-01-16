package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public static JSONObject readJson(String filePath) {
        JSONObject jsonObject = null;
        try {
            // Parse the JSON file
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static AddressDataHelper getAddressData(String filePath) {
        AddressDataHelper address = new AddressDataHelper();
        try {
            JSONObject addressData = readJson(filePath);

            if (addressData != null) {
                address.setCountry((String) addressData.get("country"));
                address.setFullName((String) addressData.get("fullName"));
                address.setPhoneNumber((String) addressData.get("phoneNumber"));
                address.setStreetName((String) addressData.get("streetName"));
                address.setBuildingNameOrNumber((String) addressData.get("buildingNameOrNumber"));
                address.setCity((String) addressData.get("city"));
                address.setArea((String) addressData.get("area"));
            } else {
                throw new RuntimeException("JSON data is null or could not be parsed.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON file: " + e.getMessage());
        }
        return address;
    }
}
