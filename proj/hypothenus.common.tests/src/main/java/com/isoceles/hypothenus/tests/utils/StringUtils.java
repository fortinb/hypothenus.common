package com.isoceles.hypothenus.tests.utils;

import java.util.Random;

public class StringUtils {
	private static Random randomizer = new Random();

	public static String extractRandomWordPartial(String value, int length) {

		String[] words = value.split(" ");
		String word;
		int wordIndex = 0;
		if (words.length > 1) {
			wordIndex = randomizer.nextInt(words.length);
		}
		
		word = words[wordIndex];
		if (word.length() < length) {
			return word;
		}
		
		return word.substring(0, length);
	}
}
