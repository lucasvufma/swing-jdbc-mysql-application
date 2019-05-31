package annotationpackages;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Coluna {
	String nome();
	int pos();

}
