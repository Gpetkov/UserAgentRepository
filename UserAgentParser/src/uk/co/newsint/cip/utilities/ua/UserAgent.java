package uk.co.newsint.cip.utilities.ua;

import nl.bitwalker.useragentutils.DeviceType;

/**
 * This class contain info about the user agent request
 * 
 * @author Georgi Petkov
 * @since 1.0
 */
public class UserAgent
{

    public static final String UNKNOWN = DeviceType.UNKNOWN.getName();
    public static final String MOBILE = DeviceType.MOBILE.getName();
    public static final String TABLET = DeviceType.TABLET.getName();
    public static final String COMPUTER = DeviceType.COMPUTER.getName();

    // device Type (example --> TABLET)
    private String deviceType = UNKNOWN;
    // deviceMaker (example --> BlackBerry)
    private String deviceMaker = UNKNOWN;
    // device Model (example --> Bold)
    private String deviceModel = UNKNOWN;
    // device Model Version (example --> 9900)
    private String deviceModelVersion = UNKNOWN;
    // Operation system (example --> Windows)
    private String os = UNKNOWN;
    // Operation system version (example --> 5.0)
    private String osVersion = UNKNOWN;
    // Operation system maker (example --> Android maker - Google Inc.
    private String osMaker = UNKNOWN;
    // Current browser MSIE,Safari,Chrome
    private String browser = UNKNOWN;
    // Current browser version example --> 534.57.2 (Safari)
    private String browserVersion = UNKNOWN;
    // Application (example --> iPadTimesAnvil/2.7 => application = iPadTimesAnvil)
    private String application = UNKNOWN;
    // Application version (example --> iPadTimesAnvil/2.7 => applicationVersion = 2.7)
    private String applicationVersion = UNKNOWN;
    // Language (example --> English United Kingdom - "en-GB")
    private String language = UNKNOWN;

    public UserAgent()
    {
    }

    public UserAgent(String deviceType, String deviceMaker, String deviceModel, String deviceModelVersion, String os,
            String osVersion, String osMaker, String browser, String browserVersion, String application, String applicationVersion,
            String language)
    {
        this.deviceType = deviceType;
        this.deviceMaker = deviceMaker;
        this.deviceModel = deviceModel;
        this.deviceModelVersion = deviceModelVersion;
        this.os = os;
        this.osVersion = osVersion;
        this.osMaker = osMaker;
        this.browser = browser;
        this.browserVersion = browserVersion;
        this.application = application;
        this.applicationVersion = applicationVersion;
        this.language = language;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((application == null) ? 0 : application.hashCode());
        result = prime * result + ((applicationVersion == null) ? 0 : applicationVersion.hashCode());
        result = prime * result + ((browser == null) ? 0 : browser.hashCode());
        result = prime * result + ((browserVersion == null) ? 0 : browserVersion.hashCode());
        result = prime * result + ((deviceMaker == null) ? 0 : deviceMaker.hashCode());
        result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
        result = prime * result + ((deviceModelVersion == null) ? 0 : deviceModelVersion.hashCode());
        result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        result = prime * result + ((osMaker == null) ? 0 : osMaker.hashCode());
        result = prime * result + ((osVersion == null) ? 0 : osVersion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserAgent other = (UserAgent) obj;
        if (application == null)
        {
            if (other.application != null)
                return false;
        }
        else if (!application.equals(other.application))
            return false;
        if (applicationVersion == null)
        {
            if (other.applicationVersion != null)
                return false;
        }
        else if (!applicationVersion.equals(other.applicationVersion))
            return false;
        if (browser == null)
        {
            if (other.browser != null)
                return false;
        }
        else if (!browser.equals(other.browser))
            return false;
        if (browserVersion == null)
        {
            if (other.browserVersion != null)
                return false;
        }
        else if (!browserVersion.equals(other.browserVersion))
            return false;
        if (deviceMaker == null)
        {
            if (other.deviceMaker != null)
                return false;
        }
        else if (!deviceMaker.equals(other.deviceMaker))
            return false;
        if (deviceModel == null)
        {
            if (other.deviceModel != null)
                return false;
        }
        else if (!deviceModel.equals(other.deviceModel))
            return false;
        if (deviceModelVersion == null)
        {
            if (other.deviceModelVersion != null)
                return false;
        }
        else if (!deviceModelVersion.equals(other.deviceModelVersion))
            return false;
        if (deviceType == null)
        {
            if (other.deviceType != null)
                return false;
        }
        else if (!deviceType.equals(other.deviceType))
            return false;
        if (language == null)
        {
            if (other.language != null)
                return false;
        }
        else if (!language.equals(other.language))
            return false;
        if (os == null)
        {
            if (other.os != null)
                return false;
        }
        else if (!os.equals(other.os))
            return false;
        if (osMaker == null)
        {
            if (other.osMaker != null)
                return false;
        }
        else if (!osMaker.equals(other.osMaker))
            return false;
        if (osVersion == null)
        {
            if (other.osVersion != null)
                return false;
        }
        else if (!osVersion.equals(other.osVersion))
            return false;
        return true;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceMaker()
    {
        return deviceMaker;
    }

    public void setDeviceMaker(String deviceMaker)
    {
        this.deviceMaker = deviceMaker;
    }

    public String getDeviceModel()
    {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel)
    {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModelVersion()
    {
        return deviceModelVersion;
    }

    public void setDeviceModelVersion(String deviceModelVersion)
    {
        this.deviceModelVersion = deviceModelVersion;
    }

    public String getOS()
    {
        return os;
    }

    public void setOS(String os)
    {
        this.os = os;
    }

    public String getOSVersion()
    {
        return osVersion;
    }

    public void setOSVersion(String osVersion)
    {
        this.osVersion = osVersion;
    }

    public String getOSMaker()
    {
        return osMaker;
    }

    public void setOSMaker(String osMaker)
    {
        this.osMaker = osMaker;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getBrowserVersion()
    {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion)
    {
        this.browserVersion = browserVersion;
    }

    public String getApplication()
    {
        return application;
    }

    public void setApplication(String application)
    {
        this.application = application;
    }

    public String getApplicationVersion()
    {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion)
    {
        this.applicationVersion = applicationVersion;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    /**
     * Merge User Agents
     * 
     * @param UserAgent
     */
    public void merge(UserAgent currentUserAgent)
    {
        if (UserAgent.UNKNOWN.equals(this.getDeviceType()))
            this.setDeviceType(currentUserAgent.getDeviceType());
        if (UserAgent.UNKNOWN.equals(this.getDeviceMaker()))
            this.setDeviceMaker(currentUserAgent.getDeviceMaker());
        if (UserAgent.UNKNOWN.equals(this.getDeviceModel()))
            this.setDeviceModel(currentUserAgent.getDeviceModel());
        if (UserAgent.UNKNOWN.equals(this.getDeviceModelVersion()))
            this.setDeviceModelVersion(currentUserAgent.getDeviceModelVersion());
        if (UserAgent.UNKNOWN.equals(this.getOS()))
            this.setOS(currentUserAgent.getOS());
        if (UserAgent.UNKNOWN.equals(this.getOSVersion()))
            this.setOSVersion(currentUserAgent.getOSVersion());
        if (UserAgent.UNKNOWN.equals(this.getOSMaker()))
            this.setOSMaker(currentUserAgent.getOSMaker());
        if (UserAgent.UNKNOWN.equals(this.getBrowser()))
            this.setBrowser(currentUserAgent.getBrowser());
        if (UserAgent.UNKNOWN.equals(this.getBrowserVersion()))
            this.setBrowserVersion(currentUserAgent.getBrowserVersion());
        if (UserAgent.UNKNOWN.equals(this.getApplication()))
            this.setApplication(currentUserAgent.getApplication());
        if (UserAgent.UNKNOWN.equals(this.getApplicationVersion()))
            this.setApplicationVersion(currentUserAgent.getApplicationVersion());
        if (UserAgent.UNKNOWN.equals(this.getLanguage()))
            this.setLanguage(currentUserAgent.getLanguage());
    }
}
