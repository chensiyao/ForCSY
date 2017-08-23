package com.csy.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.List;

public abstract class StringUtils
{

	public StringUtils()
	{
	}

	public static boolean isNull(String s)
	{
		return ObjectUtils.isNull(s);
	}

	public static boolean notNull(String s)
	{
		return ObjectUtils.notNull(s);
	}

	public static String nullSafe(String s)
	{
		return (String) ObjectUtils.nullSafe(s, "");
	}

	public static boolean isEmpty(String s)
	{
		return s == null || s.isEmpty();
	}

	public static boolean isTrimEmpty(String s)
	{
		return s == null || s.trim().isEmpty();
	}

	public static boolean notEmpty(String s)
	{
		return !isEmpty(s);
	}

	public static boolean notTrimEmpty(String s)
	{
		return !isTrimEmpty(s);
	}

	public static boolean equals(String s1, String s2)
	{
		if (s1 == null)
			return s2 == null;
		else
			return s1.equals(s2);
	}

	public static boolean equalsIgnoreCase(String s1, String s2)
	{
		if (s1 == null)
			return s2 == null;
		else
			return s1.equalsIgnoreCase(s2);
	}

	public static String replace(String string, String oldString,
			String newString)
	{
		if (string == null)
			return "";
		int i = 0;
		if ((i = string.indexOf(oldString, i)) >= 0)
		{
			char string2[] = string.toCharArray();
			char newString2[] = newString.toCharArray();
			StringBuilder buf = new StringBuilder(string2.length);
			buf.append(string2, 0, i).append(newString2);
			int oldStrLength = oldString.length();
			i += oldStrLength;
			int j;
			for (j = i; (i = string.indexOf(oldString, i)) > 0; j = i)
			{
				buf.append(string2, j, i - j).append(newString2);
				i += oldStrLength;
			}

			return buf.append(string2, j, string2.length - j).toString();
		} else
		{
			return string;
		}
	}

	public static String replace(String string, String oldString,
			String newString, int count[])
	{
		if (string == null)
			return "";
		int i = 0;
		if ((i = string.indexOf(oldString, i)) >= 0)
		{
			char string2[] = string.toCharArray();
			char newString2[] = newString.toCharArray();
			StringBuilder buf = new StringBuilder(string2.length);
			buf.append(string2, 0, i).append(newString2);
			int counter = 1;
			int oldStrLength = oldString.length();
			i += oldStrLength;
			int j;
			for (j = i; (i = string.indexOf(oldString, i)) > 0; j = i)
			{
				counter++;
				buf.append(string2, j, i - j).append(newString2);
				i += oldStrLength;
			}

			count[0] = counter;
			buf.append(string2, j, string2.length - j);
			return buf.toString();
		} else
		{
			return string;
		}
	}

	public static String replaceIgnoreCase(String string, String oldString,
			String newString)
	{
		if (string == null)
			return "";
		String lcString = string.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcString.indexOf(lcOldString, i)) >= 0)
		{
			char string2[] = string.toCharArray();
			char newString2[] = newString.toCharArray();
			StringBuilder buf = new StringBuilder(string2.length);
			buf.append(string2, 0, i).append(newString2);
			int oldStrLength = oldString.length();
			i += oldStrLength;
			int j;
			for (j = i; (i = lcString.indexOf(lcOldString, i)) > 0; j = i)
			{
				buf.append(string2, j, i - j).append(newString2);
				i += oldStrLength;
			}

			return buf.append(string2, j, string2.length - j).toString();
		} else
		{
			return string;
		}
	}

	public static String replaceIgnoreCase(String string, String oldString,
			String newString, int count[])
	{
		if (string == null)
			return "";
		String lcString = string.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcString.indexOf(lcOldString, i)) >= 0)
		{
			char string2[] = string.toCharArray();
			char newString2[] = newString.toCharArray();
			StringBuilder buf = new StringBuilder(string2.length);
			buf.append(string2, 0, i).append(newString2);
			int counter = 1;
			int oldStrLength = oldString.length();
			i += oldStrLength;
			int j;
			for (j = i; (i = lcString.indexOf(lcOldString, i)) > 0; j = i)
			{
				counter++;
				buf.append(string2, j, i - j).append(newString2);
				i += oldStrLength;
			}

			count[0] = counter;
			buf.append(string2, j, string2.length - j);
			return buf.toString();
		} else
		{
			return string;
		}
	}

	public static int strLength(String s, String charsetName)
	{
		if (isEmpty(s))
			return 0;
		try
		{
			return s.getBytes(charsetName).length;
		} catch (UnsupportedEncodingException e)
		{
			return s.getBytes().length;
		}
	}

	public static String md5(String s)
	{
		byte digests[] = null;
		MessageDigest messageDigest = null;
		try
		{
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(s.getBytes());
			digests = messageDigest.digest();
		} catch (Exception exception)
		{
		}
		StringBuffer buf = new StringBuffer();
		for (int offset = 0; offset < digests.length; offset++)
		{
			int digest = digests[offset];
			if (digest < 0)
				digest += 256;
			if (digest < 16)
				buf.append("0");
			buf.append(Integer.toHexString(digest));
		}

		return buf.toString();
	}

	public static boolean hasChineseCharset(String s)
	{
		if (s != null)
		{
			for (int i = 0; i < s.length(); i++)
				if (s.codePointAt(i) >= 256)
					return true;

		}
		return false;
	}

	public static String b2q(String str)
	{
		str = nullSafe(str);
		if (str.indexOf("\"") != -1 || str.indexOf("'") != -1)
		{
			int isq = 0;
			int idq = 0;
			for (int i = 0; i < str.length(); i++)
				if (str.charAt(i) == '\'')
				{
					if (++isq % 2 == 0)
						str = str.replaceFirst("'", "\u2019");
					else
						str = str.replaceFirst("'", "\u2018");
				} else if (str.charAt(i) == '"')
					if (++idq % 2 == 0)
						str = str.replaceFirst("\"", "\u201D");
					else
						str = str.replaceFirst("\"", "\u201C");

		}
		return str;
	}
	
	public static String join(List<String> list){
		return org.apache.commons.lang.StringUtils.join(list, ',');
	} 
}
