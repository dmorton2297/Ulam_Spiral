
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String [] args)
    {
        UlamSpiral spiral = new UlamSpiral();
        
        for (int i=1; i<= 2500; i++)
        {
            spiral.add(i);
        }
        
        System.out.println(spiral.toString());
        System.out.println("\n\n\n");
        
        System.out.println(spiral.primeToString());
    }
}
