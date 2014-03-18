package lambda;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.function.Supplier;

public class CallByNameTest {
	Boolean loop() {
		return loop();
	}

	Boolean and(Supplier<Boolean> x, Supplier<Boolean> y) {
		if (x.get()) return y.get();
		else return Boolean.FALSE;
	}

	@Test
	public void testCallByName() {
		 assertFalse(and(() -> false, this::loop));
	}
}
