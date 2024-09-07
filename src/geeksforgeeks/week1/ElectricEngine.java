package geeksforgeeks.week1;

public class ElectricEngine extends EngineDetails implements Engine {

    @Override
    public void start() {
        System.out.println ( "Starting Electric Engine" );
        // Code to start Electric Engine
        System.out.println ( "Electric Engine Started" );
    }

    @Override
    public void stop() {
        System.out.println ( "Stopping Petrol Engine" );
        // Code to start Electric Engine
        System.out.println ( "Stopping Engine Started" );
    }

}
