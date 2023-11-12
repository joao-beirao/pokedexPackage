package joaob;
import joaob.API.*;

public class App 
{
    private static final int ID = 1;
    public static void main( String[] args )
    {
        try{

            APIHandler API_HANDLER = new APIHandler(ID);

            API_HANDLER.loadData();

            System.out.println(API_HANDLER.getData());
            
            API_HANDLER.saveToFile(Integer.toString(ID));


        }catch(Exception e){
            System.out.println(e);
        }


    }
}
