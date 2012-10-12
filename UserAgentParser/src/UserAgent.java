


public class UserAgent {
enum type {
			SMARTPHON, TABLET, PS
		}

		private String hardware;
		private String model;
		private String modelVersion;
		private String software;
		private String softwareVersion;

		public UserAgent(String mHardware, String mModel,
				String mModelVersion, String mSoftware, String mSoftwareVersion) {
			setHardware(mHardware);
			setModel(mModel);
			setModelVersion(mModel);
			setSoftware(mSoftware);
			setSoftwareVersion(mSoftwareVersion);

		}

		public UserAgent() {
			this(null, null, null, null, null);

		}

		public UserAgent(UserAgent uap) {
			this(uap.getHardware(), uap.getModel(), uap.getModelVersion(), uap
					.getSoftware(), uap.getSoftwareVersion());

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



}
