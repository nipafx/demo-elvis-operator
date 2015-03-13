package org.codefx.lab.elvis;

import java.util.function.Function;

/**
 * Utility class with static methods which allow null safe chaining of functions.
 */
public class Elvis {

	public static <T1, T2> T2 applyNullCoalescing(T1 target, Function<T1, T2> f) {
		if (target == null)
			return null;

		return f.apply(target);
	}

	public static <T1, T2, T3> T3 applyNullCoalescing(T1 target, Function<T1, T2> f1, Function<T2, T3> f2) {
		return applyNullCoalescing(applyNullCoalescing(target, f1), f2);
	}

	public static <T1, T2, T3, T4> T4 applyNullCoalescing(T1 target,
			Function<T1, T2> f1, Function<T2, T3> f2, Function<T3, T4> f3) {
		return applyNullCoalescing(applyNullCoalescing(target, f1, f2), f3);
	}

	public static <T1, T2, T3, T4, T5> T5 applyNullCoalescing(T1 target,
			Function<T1, T2> f1, Function<T2, T3> f2, Function<T3, T4> f3, Function<T4, T5> f4) {
		return applyNullCoalescing(applyNullCoalescing(target, f1, f2, f3), f4);
	}

}
