package joaob;
import joaob.API.*;

public class App 
{
    public static void main( String[] args )
    {

        APIHandler API_HANDLER = new APIHandler(1);

        API_HANDLER.loadData();

        System.out.println(API_HANDLER.getData());
    }
}
