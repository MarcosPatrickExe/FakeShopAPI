// import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;


public interface Vehicles {

       abstract void accelerate(  Integer acceleration  );

       abstract String speed(  final Integer speed  );


       interface Car{
              void goToBacking( );
       }

        interface AirPlaine{
               void fly( );
        }
}

