package com.speakingfish.common.sort.topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import org.junit.Test;

import static com.speakingfish.common.sort.topological.TopologicalResult.*;
import static org.junit.Assert.assertEquals;

public class TestSort {
	
	public static final BiFunction<Integer, Integer, TopologicalResult> TOPOLOGICAL_COMPARATOR_INTEGER
	= (a, b) -> {
        if(a == b) return Same;
		if(a + 1 == b) return Before;
		if(b + 1 == a) return After ;
		return Unknown;
	}; 
	
	@Test
	public void testNumbers1() {
		List<Integer> src = new ArrayList<>(List.of(5,4,3,2,1));
		
		List<Integer> expected = new ArrayList<>(src);
		Collections.sort(expected);
		
		src = Sort.inplaceSort(src, TOPOLOGICAL_COMPARATOR_INTEGER);
		
		assertEquals(expected, src);
	}

}
