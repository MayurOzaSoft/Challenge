package com.study.june.week3;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * 
 * Validate IP Address
 * 
 * Write a function to check whether an input string is a valid IPv4 address or
 * IPv6 address or neither.
 * 
 * IPv4 addresses are canonically represented in dot-decimal notation, which
 * consists of four decimal numbers, each ranging from 0 to 255, separated by
 * dots ("."), e.g.,172.16.254.1;
 * 
 * Besides, leading zeros in the IPv4 is invalid. For example, the address
 * 172.16.254.01 is invalid.
 * 
 * IPv6 addresses are represented as eight groups of four hexadecimal digits,
 * each group representing 16 bits. The groups are separated by colons (":").
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and
 * some low-case characters in the address to upper-case ones, so
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading
 * zeros and using upper cases).
 * 
 * However, we don't replace a consecutive group of zero value with a single
 * empty group using two consecutive colons (::) to pursue simplicity. For
 * example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * 
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the
 * address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * 
 * Note: You may assume there is no extra space or special characters in the
 * input string.
 * 
 * 1. Input: "172.16.254.1"
 * 
 * Output: "IPv4"
 * 
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * 
 * 2. Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 
 * Output: "IPv6"
 * 
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * 
 * 3. Input: "256.256.256.256"
 * 
 * Output: "Neither"
 * 
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution16 {

	String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
	Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

	String chunkIPv6 = "([0-9a-fA-F]{1,4})";
	Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

	public String validIPAddress_regex(String IP) {
		if (pattenIPv4.matcher(IP).matches())
			return "IPv4";
		return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
	}

	public String validIPAddress_lib(String IP) {
		try {
			return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
		} catch (Exception e) {
		}
		return "Neither";
	}

	public String validIPAddress(String IP) {

		if (IP == null || IP.length() == 0) {
			return "Neither";
		}

		String[] parts_4 = IP.split("\\.");
		String[] parts_6 = IP.split(":");

		if (IP.charAt(IP.length() - 1) != '.' && parts_4.length == 4 && parts_6.length == 1) {

			for (String part : parts_4) {
				if (part.length() > 3 || part.length() == 0 || part.length() > 1 && part.charAt(0) == '0') {
					return "Neither";
				}
				int val = 0;
				for (int i = 0; i < part.length(); i++) {
					char c = part.charAt(i);
					if (c < '0' || c > '9') {
						return "Neither";
					}
					val = val * 10 + c - '0';

				}
				if (val > 255) {
					return "Neither";
				}
			}

			return "IPv4";

		} else if (IP.charAt(IP.length() - 1) != ':' && parts_6.length == 8 && parts_4.length == 1) {

			for (String part : parts_6) {
				if (part.length() > 4 || part.length() == 0) {
					return "Neither";
				}
				for (int i = 0; i < part.length(); i++) {
					char c = part.charAt(i);
					if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F')) {
						return "Neither";
					}
				}
			}

			return "IPv6";

		}

		return "Neither";
	}
}