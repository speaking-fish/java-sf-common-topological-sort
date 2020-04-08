package com.speakingfish.common.sort.topological;

import java.util.List;
import java.util.function.BiFunction;

import static com.speakingfish.common.sort.topological.TopologicalResult.*;

public class Sort {

	/**
	 * Very slow, but inplace topological sort
	 * @param <T>
	 * @param <C>
	 * @param container
	 * @param comparator
	 * @return
	 */
	public static <T, C extends List<T>> C inplaceSort(C container, BiFunction<T, T, TopologicalResult> comparator) {
		final int size = container.size();
		boolean changed = false;
		do {
			for(int i = 0; i < size - 1; ++i) {
				final T e = container.get(i);
				for(int j = i + 1; j < size; ++j) {
					final T test = container.get(j);
					final TopologicalResult result = comparator.apply(e,  test);
					if(After == result) {
						container.remove(j);
						container.add(i, test);
						++i;
						changed = true;
						break;
					}
				}
			}
		} while(!changed);
		return container;
	}

}
