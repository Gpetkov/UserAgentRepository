
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UserAgentParser {

	public UserAgent parse(String userAgentString) throws UserAgentParseException {
		UserAgent ua = new UserAgent();
		String regexBB4i5 = "((?i:blackberry)+?)\\s?(\\d{2,4}?.?)/((\\d+.\\d+.\\d+.\\d+)+)";
		String regexBB6i7 = "((?i:blackberry)+?)\\s?(\\d{2,4}?);\\s?\\w+?.\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?(?i:version/)+((\\S+)+)\\s?";
		String regexBBPlayBook = "((?i:playbook)+?);\\s?.;\\s?(\\w+\\s+\\w*\\s?\\w*\\s?)+((\\d+.\\d+.\\d+)+)";
		String regexWinPhon = "((?i:windows phone os)+?)\\s?(\\d.\\d)+.\\s?\\w*.?\\w*.?\\w*[;]?\\s?\\w*.?\\w*.?\\w*[;]?\\s?(\\w+).\\s?((\\w+\\s?\\w*[-]?\\s?\\w*)+?).";
		Pattern pattern = Pattern.compile(regexBB4i5);
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
		pattern = Pattern.compile(regexBB6i7);
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
		pattern = Pattern.compile(regexBBPlayBook);
		match = pattern.matcher(userAgentString);
		if (match.find()) {
			ua.setType(UserAgent.DeviceType.TABLET);
			ua.setHardware("BlackBerry");
			ua.setModel(match.group(1));
			ua.setModelVersion(match.group(1));
			ua.setSoftware(match.group(2));
			ua.setSoftwareVersion(match.group(3));
			return ua;
<<<<<<< HEAD
		} else {
			throw new UserAgentParseException("UA not found!");
=======
		}
		pattern = Pattern.compile(regexWinPhon);
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
		else {
			throw new ParseException("UA not found!");
>>>>>>> b3e3364ad8ed1a967a1f46d389c37f13ac4678ae
		}

	}

}
