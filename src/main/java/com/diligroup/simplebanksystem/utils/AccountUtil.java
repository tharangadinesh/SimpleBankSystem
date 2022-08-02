package com.diligroup.simplebanksystem.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AccountUtil {

	public static String generateRandomAccountNumber() {
		int m = (int) Math.pow(10, 5 - 1);
		return String.valueOf(m + new Random().nextInt(9 * m));
	}

}
