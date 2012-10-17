import java.util.regex.Matcher;
import java.util.regex.Pattern;



public abstract class UserAgentParser {

	public UserAgent parse(String userAgentString) {
		UserAgent ua = new UserAgent();
		String regexBB4i5 = "((?i:blackberry)+?)\\s?(\\d{2,4}?.*)/((\\d.\\d.\\d.\\d+)+)";
		String regexBB6i7 = "((?i:blackberry)+?)\\s?(\\d{2,4}?);\\s?\\w+?.\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?\\S*\\s?(?i:version/)+((\\S+)+)\\s?";
		Pattern pattern = Pattern.compile(regexBB4i5);
		Matcher match = pattern.matcher(userAgentString);
		if(match.find()) {
			ua.setType(UserAgent.DeviceType.SMARTPHONE);
			ua.setHardware(match.group(1));
			ua.setModel(match.group(2));
			ua.setModelVersion(match.group(2));
			ua.setSoftware("OS" + match.group(3).charAt(0));
			ua.setSoftwareVersion(match.group(3));
			return ua;
		}
		pattern=Pattern.compile(regexBB6i7);
		match = pattern.matcher(userAgentString);
		if(match.find()){
			ua.setType(UserAgent.DeviceType.SMARTPHONE);
			ua.setHardware(match.group(1));
			ua.setModel(match.group(2));
			ua.setModelVersion(match.group(2));
			ua.setSoftware("OS" + match.group(3).charAt(0));
			ua.setSoftwareVersion(match.group(3));
			return ua;
		}else{
			return null;
		}
		
	}

}
