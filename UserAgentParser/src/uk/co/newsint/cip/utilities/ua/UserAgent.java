package uk.co.newsint.cip.utilities.ua;
/**
 * 
 * @author BitMix This class contain info about user agent request
 * 
 */
public class UserAgent {
	// Enum for Device Types
	//public enum DeviceType {
	//	SMARTPHONE, TABLET, PC
//
	//}

	public static final String UNKNOWN = null;
	public static final String SMARTPHONE = "SMARTPHONE";
	public static final String TABLET = "TABLET";
	public static final String PC = "PC";
	
	//device Type (example --> TABLET)
	String deviceType = UNKNOWN;
	// deviceMaker (example --> BlackBerry)
	private String deviceMaker = UNKNOWN;
	// device Model (example --> Bold)
	private String deviceModel = UNKNOWN;
	// device Model Version (example --> 9900)
	private String deviceModelVersion = UNKNOWN;
	//Operation system (example --> Windows)
	private String os = UNKNOWN;
	//Operation system version (example --> 5.0)
	private String osVersion = UNKNOWN;
	//Current browser MSIE,Safari,Chrome
	private String browser = UNKNOWN;
	//Current browser version example --> 534.57.2 (Safari)
	private String browserVersion = UNKNOWN;

	
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceMaker() {
		return deviceMaker;
	}

	public void setDeviceMaker(String deviceMaker) {
		this.deviceMaker = deviceMaker;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceModelVersion() {
		return deviceModelVersion;
	}

	public void setDeviceModelVersion(String deviceModelVersion) {
		this.deviceModelVersion = deviceModelVersion;
	}

	public String getOS() {
		return os;
	}

	public void setOS(String os) {
		this.os = os;
	}

	public String getOSVersion() {
		return osVersion;
	}

	public void setOSVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	
	
	public UserAgent() {

	}
	
	public UserAgent(String deviceType, String deviceMaker, String deviceModel,
			String deviceModelVersion, String os, String osVersion,
			String browser, String browserVersion) {
		super();
		this.deviceType = deviceType;
		this.deviceMaker = deviceMaker;
		this.deviceModel = deviceModel;
		this.deviceModelVersion = deviceModelVersion;
		this.os = os;
		this.osVersion = osVersion;
		this.browser = browser;
		this.browserVersion = browserVersion;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deviceMaker == null) ? 0 : deviceMaker.hashCode());
		result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
		result = prime * result
				+ ((deviceModelVersion == null) ? 0 : deviceModelVersion.hashCode());
		result = prime * result
				+ ((os == null) ? 0 : os.hashCode());
		result = prime * result
				+ ((osVersion == null) ? 0 : osVersion.hashCode());
		result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAgent other = (UserAgent) obj;
		if (deviceMaker == null) {
			if (other.deviceMaker != null)
				return false;
		} else if (!deviceMaker.equals(other.deviceMaker))
			return false;
		if (deviceModel == null) {
			if (other.deviceModel != null)
				return false;
		} else if (!deviceModel.equals(other.deviceModel))
			return false;
		if (deviceModelVersion == null) {
			if (other.deviceModelVersion != null)
				return false;
		} else if (!deviceModelVersion.equals(other.deviceModelVersion))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (osVersion == null) {
			if (other.osVersion != null)
				return false;
		} else if (!osVersion.equals(other.osVersion))
			return false;
		if (deviceType != other.deviceType)
			return false;
		return true;
	}

	

	

}
