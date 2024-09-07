package geeksforgeeks.week1;

public class PetrolEngine implements Engine {

    @Override
    public void start() {
        System.out.println ( "Starting Petrol Engine" );
        // Code to start Electric Engine
        System.out.println ( "Petrol Engine Started" );
    }

    @Override
    public void stop() {
        System.out.println ( "Stopping Petrol Engine" );
        // Code to start Electric Engine
        System.out.println ( "Stopping Engine Started" );
    }

}
