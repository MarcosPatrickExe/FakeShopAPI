// import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

// ====== FILE FOR DECLARATION INTERFACES =========

public interface Vehicle {

       abstract void accelerate(  Integer acceleration  );

       abstract String speed(  final Integer speed  );


       interface Car{
              void goToBacking( );
       }

        interface AirPlaine{
               void fly( );
        }
}

