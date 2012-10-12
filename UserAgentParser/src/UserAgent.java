/**
 * 
 * @author BitMix
 * This class contain info about user agent request
 *
 */
public class UserAgent {
	// type of device
	enum DeviceType {
		SMARTPHON, TABLET, PC
		
	}
	
	DeviceType type;
	// hardware model for example BlackBerry
	private String hardware;
	//device's model for example Bold
	private String model;
	// version's model for example 9900
	private String modelVersion;
	//software platform for example java
	private String software;
	// software's version for example 5.0
	private String softwareVersion;

	public UserAgent(String mHardware, String mModel, String mModelVersion,
			String mSoftware, String mSoftwareVersion,DeviceType mType) {
		setHardware(mHardware);
		setModel(mModel);
		setModelVersion(mModel);
		setSoftware(mSoftware);
		setSoftwareVersion(mSoftwareVersion);
		setType(type);
	}

	public UserAgent() {
		this(null, null, null, null, null,null);

	}

	public UserAgent(UserAgent uap) {
		this(uap.getHardware(), uap.getModel(), uap.getModelVersion(), uap
				.getSoftware(), uap.getSoftwareVersion(),uap.getType());

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
	 
}
