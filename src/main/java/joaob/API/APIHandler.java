package joaob.API;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIHandler {

    private static final String API_LINK = "https://pokeapi.co/api/v2/pokemon/";
    private String CURRENT_URL;
    private String data;
    
    public APIHandler(int id){
        CURRENT_URL = API_LINK+id;
    }

    public void loadData(){
        try {
            URL url = new URL(CURRENT_URL); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                data+=output;
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }

    public String getData() {
        return data;
    }

    public void saveToFile(String filename) throws IOException{

            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(filename+".dat"));
            file.writeObject(data);
            file.flush();
            file.close();

    }


}
