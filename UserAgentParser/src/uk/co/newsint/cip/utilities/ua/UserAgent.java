package uk.co.newsint.cip.utilities.ua;
/**
 * 
 * @author BitMix This class contain info about user agent request
 * 
 */
public class UserAgent {
	// Enum for Device Types
	public enum DeviceType {
		SMARTPHONE, TABLET, PC

	}

	public static final String UNKNOWN = null;

	DeviceType deviceType;
	// deviceMaker (example --> BlackBerry)
	private String deviceMaker;
	// device Model (example --> Bold)
	private String deviceModel;
	// device Model Version (example --> 9900)
	private String deviceModelVersion;
	//Operation system (example --> Windows)
	private String os;
	//Operation system version (example --> 5.0)
	private String osVersion;
	//Current browser MSIE,Safari,Chrome
	private String browser;
	//Current browser version example --> 534.57.2 (Safari)
	private String browserVersion;

	
	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType type) {
		this.deviceType = type;
	}
	public String getDeviceMaker() {
		return deviceMaker;
	}

	public void setDeviceMaker(String hardware) {
		this.deviceMaker = hardware;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String model) {
		this.deviceModel = model;
	}

	public String getDeviceModelVersion() {
		return deviceModelVersion;
	}

	public void setDeviceModelVersion(String modelVersion) {
		this.deviceModelVersion = modelVersion;
	}

	public String getOS() {
		return os;
	}

	public void setOS(String software) {
		this.os = software;
	}

	public String getOSVersion() {
		return osVersion;
	}

	public void setOSVersion(String softwareVersion) {
		this.osVersion = softwareVersion;
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
	public UserAgent(String hardware, String model, String modelVersion,
			String software, String softwareVersion, DeviceType type) {
		setDeviceMaker(hardware);
		setDeviceModel(model);
		setDeviceModelVersion(modelVersion);
		setOS(software);
		setOSVersion(softwareVersion);
		setDeviceType(type);
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
