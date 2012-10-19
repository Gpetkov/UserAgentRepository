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
	private static final String REGEX_BB_6_AND_7 = "((?i:blackberry)+?)\\s?(\\d{2,4}?);\\s?\\w+?.\\s?[\\S*\\s?]+?(?i:version/)+((\\S+)+)\\s?";

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
	private static final String REGEX_WIN_PHONE = "((?i:msie)\\s?)?(\\d+.\\d+)?.\\s?((?i:windows phone os)+?)\\s?(\\d.\\d)+.\\s?\\w*.?\\w*.?\\w*[;]?\\s?\\w*.?\\w*.?\\w*[;]?\\s?(\\w+).\\s?((\\w+\\s?\\w*[-]?\\s?\\w*)+?).";

	/**
	 * regex for finding iOS User Agents(doesn't catch iOS 1.X) example:
	 * Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_2_1 like Mac OS X; sv-se)
	 * AppleWebKit/533.17.9 (KHTML, like Gecko) Mobile/8C148a
	 */
	private static final String REGEX_iOS = "((?i:iphone|ipod|ipad)\\s?\\w*)+?;\\s?(?i)u?.?\\s?[\\w*?\\s?]*?((\\d_\\d_?\\d*)+?)\\s?[\\S*\\s?]*?\\w*[-]?\\w*";

	/**
	 * regex for finding PC Microsoft IE User Agents example: Mozilla/4.0
	 * (compatible; MSIE 8.0; Windows NT 6.1; Win64; x64; Trident/4.0; .NET CLR
	 * 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC
	 * 6.0; HPDTDF; Tablet PC 2.0; .NET4.0C)
	 */
	private static final String REGEX_PC_WIN_IE = "((?i:msie)+?)\\s?(\\d.\\d)+?;?\\s?(\\w+\\s?\\w+)+?\\s?((\\d.\\d)+?);?";

	/**
	 * regex for finding PC Windows User Agents example: Mozilla/5.0 (Windows NT
	 * 6.0; WOW64; rv:11.0) Gecko/20100101 Firefox/11.0,platform,unknown
	 */
	private static final String REGEX_PC_WIN = "((?i:windows)\\s?\\w*)+?\\s?(\\d.\\d)+?.[\\s?\\S*]+?((?i:chrome|firefox|iron|Comodo_Dragon|Maxthon|safari|RockMelt))\\s?/\\s?((\\d+.\\d+[\\.]?\\d*[\\.]?\\d*)+)";

	/**
	 * regex for finding PC MAC User Agents example: "Mozilla/5.0 (Macintosh; U;
	 * Intel Mac OS X 10_6_8; hu_hu) AppleWebKit/534.46 (KHTML, like Gecko)
	 * Version/5.0.5 Safari/534.46,platform,unknown
	 */
	private static final String REGEX_PC_MAC = "((?i:mac os)\\s?(?i:x)?)+?\\s?(\\d+.?\\d*[\\._]?\\d*)+?.?\\s?\\w*[-]?\\w*[\\s?\\S*]*?((?i:firefox|safari|chrome|NetNewsWire|iron|RockMelt|camino))\\s?/\\s?((\\d+[\\.]?\\d*[\\.]?\\d*)+?)";

	/**
	 * regex for finding PC MAC OmniWeb browser User Agents example: Mozilla/5.0
	 * (Macintosh; U; Intel Mac OS X 10_4_11; en-US)
	 * AppleWebKit/533.21.1+(KHTML, like Gecko, Safari/533.19.4) Version/5.11.1
	 * OmniWeb/622.18.0,platform,unknown
	 */
	private static final String REGEX_PC_MAC_OMNIWEB = "((?i:mac os)\\s?(?i:x)?)+?\\s?(\\d+.?\\d*[\\._]?\\d*)+?.?\\s?\\w*[-]?\\w*[\\s?\\S*]*?((?i:OmniWeb))\\s?/\\s?((\\d+[\\.]?\\d*[\\.]?\\d*)+?)";

	/**
	 * regex for finding PCOpera browser User Agents example:Opera/9.80
	 * (Windows NT 6.1; WOW64; U; fi) Presto/2.10.289 Version/12.02
	 */
	private static final String REGEX_PC_OPERA = "((?i:opera)+)/(\\d+.\\d+)+[\\s?\\S*]+?((?i:windows\\s?nt)|(?i:mac\\s?os\\s?x))+?\\s?((\\d+.?\\d*[_\\.]?\\d*)+?)";

	/**
	 * Parses a String into an {@link UserAgent} object.
	 * 
	 * @param userAgentString
	 *            User Agent String to be parsed
	 * @throws UserAgentParseException
	 *             When the userAgentString is not found as a User Agent String
	 * @return UserAgent object
	 */
	public UserAgent parse(String userAgentString)
			throws UserAgentParseException {
		UserAgent ua = new UserAgent();
		if (userAgentString == null) {
			throw new UserAgentParseException("UA not found!");
		}
		Pattern pattern = Pattern.compile(REGEX_BB_4_AND_5);
		Matcher match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.SMARTPHONE);
			ua.setDeviceMaker(match.group(1));
			ua.setDeviceModel(match.group(2));
			ua.setDeviceModelVersion(match.group(2));
			ua.setOS("OS" + match.group(3).charAt(0));
			ua.setOSVersion(match.group(3));
			return ua;
		}
		pattern = Pattern.compile(REGEX_BB_6_AND_7);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.SMARTPHONE);
			ua.setDeviceMaker(match.group(1));
			ua.setDeviceModel(match.group(2));
			ua.setDeviceModelVersion(match.group(2));
			ua.setOS("OS" + match.group(3).charAt(0));
			ua.setOSVersion(match.group(3));
			return ua;
		}
		pattern = Pattern.compile(REGEX_BB_PLAYBOOK);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.TABLET);
			ua.setDeviceMaker("BlackBerry");
			ua.setDeviceModel(match.group(1));
			ua.setDeviceModelVersion(match.group(1));
			ua.setOS(match.group(2));
			ua.setOSVersion(match.group(3));
			return ua;
		}
		pattern = Pattern.compile(REGEX_WIN_PHONE);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.SMARTPHONE);
			ua.setDeviceMaker(match.group(5));
			ua.setDeviceModel(match.group(6));
			ua.setDeviceModelVersion(match.group(6));
			ua.setOS(match.group(3));
			ua.setOSVersion(match.group(4));
			ua.setBrowser(match.group(1));
			ua.setBrowserVersion(match.group(2));
			return ua;
		}
		pattern = Pattern.compile(REGEX_iOS);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			if (match.group(1).equalsIgnoreCase("ipad")) {
				ua.setDeviceType(UserAgent.TABLET);
			} else {
				ua.setDeviceType(UserAgent.SMARTPHONE);
			}
			ua.setDeviceMaker("Apple");
			ua.setDeviceModel(match.group(1));
			ua.setDeviceModelVersion(match.group(1));
			ua.setOS("iOS");
			ua.setOSVersion(match.group(2).replaceAll("_", "."));
			return ua;
		}
		pattern = Pattern.compile(REGEX_PC_WIN_IE);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.PC);
			ua.setDeviceMaker(UserAgent.UNKNOWN);
			ua.setBrowser(match.group(1));
			ua.setBrowserVersion(match.group(2));
			ua.setOS(match.group(3));
			ua.setOSVersion(match.group(4));
			return ua;
		}
		pattern = Pattern.compile(REGEX_PC_WIN);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.PC);
			ua.setDeviceMaker(UserAgent.UNKNOWN);
			ua.setBrowser(match.group(3));
			ua.setBrowserVersion(match.group(4));
			ua.setOS(match.group(1));
			ua.setOSVersion(match.group(2));
			return ua;
		}
		pattern = Pattern.compile(REGEX_PC_MAC);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.PC);
			ua.setDeviceMaker("Apple");
			ua.setBrowser(match.group(3));
			ua.setBrowserVersion(match.group(4));
			ua.setOS(match.group(1));
			ua.setOSVersion(match.group(2).replaceAll("_", "."));
			return ua;
		}
		pattern = Pattern.compile(REGEX_PC_MAC_OMNIWEB);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.PC);
			ua.setDeviceMaker("Apple");
			ua.setBrowser(match.group(3));
			ua.setBrowserVersion(match.group(4));
			ua.setOS(match.group(1));
			ua.setOSVersion(match.group(2).replaceAll("_", "."));
			return ua;
		}
		pattern = Pattern.compile(REGEX_PC_OPERA);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setDeviceType(UserAgent.PC);
			ua.setDeviceMaker(UserAgent.UNKNOWN);
			ua.setBrowser(match.group(1));
			ua.setBrowserVersion(match.group(2));
			ua.setOS(match.group(3));
			ua.setOSVersion(match.group(4));
			return ua;
		} else {
			throw new UserAgentParseException("UA not found!");

		}

	}

}
