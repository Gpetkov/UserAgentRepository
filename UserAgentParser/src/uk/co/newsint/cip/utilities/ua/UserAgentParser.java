package uk.co.newsint.cip.utilities.ua;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BitMix
 * 
 */

public class UserAgentParser {

	/**
	 * regex for finding BlackBerry OS version 4 and 5 User Agents example:
	 * BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1
	 * VendorID/301
	 */
	private static final String REGEX_BB_4_AND_5 = "((?i:blackberry)+?)\\s?(\\d{2,4}?.?)/((\\d+.\\d+.\\d+.\\d+)+)";

	/**
	 * regex for finding BlackBerry OS version 6 and 7 User Agents example:
	 * Mozilla/5.0 (BlackBerry; U; BlackBerry 9360; ar) AppleWebKit/534.11+
	 * (KHTML, like Gecko) Version/7.0.0.353 Mobile Safari/534.11+
	 */
	private static final String REGEX_BB_6_AND_7 = "((?i:blackberry)+?)\\s?(\\d{2,4}?);\\s?\\w+?.\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?(?i:version/)+((\\S+)+)\\s?";

	/**
	 * regex for finding BlackBerry PlayBook User Agents example: Mozilla/5.0
	 * (PlayBook; U; Android 2.3.3; en-gb; PlayBook Build/2.0.1.30)
	 * AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1
	 */
	private static final String REGEX_BB_PLAYBOOK = "((?i:playbook)+?);\\s?.;\\s?(\\w+\\s+\\w*\\s?\\w*\\s?)+((\\d+.\\d+.\\d+)+)";

	/**
	 * regex for finding Windows Phone OS User Agents example: Mozilla/5.0
	 * (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0;
	 * HTC; HD7 T9292)
	 */
	private static final String REGEX_WIN_PHONE = "((?i:windows phone os)+?)\\s?(\\d.\\d)+.\\s?\\w*.?\\w*.?\\w*[;]?\\s?\\w*.?\\w*.?\\w*[;]?\\s?(\\w+).\\s?((\\w+\\s?\\w*[-]?\\s?\\w*)+?).";

	/**
	 * regex for finding iOS User Agents(doesn't catch iOS 1.X) example:
	 * Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_2_1 like Mac OS X; sv-se)
	 * AppleWebKit/533.17.9 (KHTML, like Gecko) Mobile/8C148a
	 */
	private static final String REGEX_iOS = "((?i:iphone|ipod|ipad)\\s?\\w*)+?;\\s?(?i)u?.?\\s?\\w*?\\s?\\w*\\s?\\w*\\s?((\\d.\\d.?\\d*)+?)\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\w*[-]?\\w*";

	/**
	 * Parses a String into an {@link UserAgent} object.
	 * 
	 * @param userAgentString
	 *            User Agent String to be parsed
	 * @throws ParseException
	 *             When the userAgentString is not found as a User Agent String
	 * @return UserAgent object
	 */
	public UserAgent parse(String userAgentString) throws UserAgentParseException {
		UserAgent ua = new UserAgent();
		Pattern pattern = Pattern.compile(REGEX_BB_4_AND_5);
		Matcher match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setType(UserAgent.DeviceType.SMARTPHONE);
			ua.setHardware(match.group(1));
			ua.setModel(match.group(2));
			ua.setModelVersion(match.group(2));
			ua.setSoftware("OS" + match.group(3).charAt(0));
			ua.setSoftwareVersion(match.group(3));
			return ua;
		}
		pattern = Pattern.compile(REGEX_BB_6_AND_7);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setType(UserAgent.DeviceType.SMARTPHONE);
			ua.setHardware(match.group(1));
			ua.setModel(match.group(2));
			ua.setModelVersion(match.group(2));
			ua.setSoftware("OS" + match.group(3).charAt(0));
			ua.setSoftwareVersion(match.group(3));
			return ua;
		}
		pattern = Pattern.compile(REGEX_BB_PLAYBOOK);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setType(UserAgent.DeviceType.TABLET);
			ua.setHardware("BlackBerry");
			ua.setModel(match.group(1));
			ua.setModelVersion(match.group(1));
			ua.setSoftware(match.group(2));
			ua.setSoftwareVersion(match.group(3));
			return ua;
		}
		pattern = Pattern.compile(REGEX_WIN_PHONE);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setType(UserAgent.DeviceType.SMARTPHONE);
			ua.setHardware(match.group(3));
			ua.setModel(match.group(4));
			ua.setModelVersion(match.group(4));
			ua.setSoftware(match.group(1));
			ua.setSoftwareVersion(match.group(2));
			return ua;
		}
		pattern = Pattern.compile(REGEX_iOS);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			if (match.group(1).equalsIgnoreCase("ipad")) {
				ua.setType(UserAgent.DeviceType.TABLET);
			} else {
				ua.setType(UserAgent.DeviceType.SMARTPHONE);
			}
			ua.setHardware("Apple");
			ua.setModel(match.group(1));
			ua.setModelVersion(match.group(1));
			ua.setSoftware("iOS");
			ua.setSoftwareVersion(match.group(2).replaceAll("_", "."));
			return ua;
		} else {
			throw new UserAgentParseException("UA not found!");

		}

	}

}
