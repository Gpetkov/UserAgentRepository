package uk.co.newsint.cip.utilities.ua;
/**
 * 
 * @author BitMix This class contain info about user agent request
 * 
 */
public class UserAgent {
	// type of device
	public enum DeviceType {
		SMARTPHONE, TABLET, PC

	}

<<<<<<< HEAD:UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgent.java
=======
	public static final String UNKNOWN = null;
	
>>>>>>> c9d116599114ddbe090422c97745f22e870acbe0:UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgent.java
	DeviceType type;
	// hardware model for example BlackBerry
	private String hardware;
	// device's model for example Bold
	private String model;
	// version's model for example 9900
	private String modelVersion;
	// software platform for example java
	private String software;
	// software's version for example 5.0
	private String softwareVersion;

	// this constructor build UserAgent
	public UserAgent(String hardware, String model, String modelVersion,
			String software, String softwareVersion, DeviceType type) {
		setHardware(hardware);
		setModel(model);
		setModelVersion(modelVersion);
		setSoftware(software);
		setSoftwareVersion(softwareVersion);
		setType(type);
	}

	public UserAgent() {

	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public DeviceType getType() {
		return type;
	}

	public void setType(DeviceType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hardware == null) ? 0 : hardware.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((modelVersion == null) ? 0 : modelVersion.hashCode());
		result = prime * result
				+ ((software == null) ? 0 : software.hashCode());
		result = prime * result
				+ ((softwareVersion == null) ? 0 : softwareVersion.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (hardware == null) {
			if (other.hardware != null)
				return false;
		} else if (!hardware.equals(other.hardware))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (modelVersion == null) {
			if (other.modelVersion != null)
				return false;
		} else if (!modelVersion.equals(other.modelVersion))
			return false;
		if (software == null) {
			if (other.software != null)
				return false;
		} else if (!software.equals(other.software))
			return false;
		if (softwareVersion == null) {
			if (other.softwareVersion != null)
				return false;
		} else if (!softwareVersion.equals(other.softwareVersion))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
