package lambda;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;

public class StreamOfInts {


	@Test
	public void testStreamOfInts() {
		Stream<Integer> intStream = Stream.generate(from(1));
		List<Integer> upto20 = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		Predicate<Integer> p = (i -> isDivisibleOverRange(i, upto20));
		Optional<Integer> o = intStream.filter(p).findFirst();
		o.ifPresent(i -> System.out.println("Found: " + i));
	}

	private Supplier<Integer> from(Integer i) {
		AtomicInteger counter = new AtomicInteger(0);
		return () ->  counter.incrementAndGet();
	}

	private boolean isDivisibleOverRange(Integer n, List<Integer> l) {
		return l.stream().allMatch(i -> n % i == 0);
	}
}
