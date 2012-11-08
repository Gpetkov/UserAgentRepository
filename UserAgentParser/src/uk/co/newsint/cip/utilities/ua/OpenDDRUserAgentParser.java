package uk.co.newsint.cip.utilities.ua;

import java.io.IOException;
import java.util.Properties;

import org.openddr.simpleapi.oddr.ODDRService;
import org.openddr.simpleapi.oddr.model.ODDRHTTPEvidence;
import org.w3c.ddr.simple.Evidence;
import org.w3c.ddr.simple.PropertyRef;
import org.w3c.ddr.simple.PropertyValue;
import org.w3c.ddr.simple.PropertyValues;
import org.w3c.ddr.simple.Service;
import org.w3c.ddr.simple.ServiceFactory;
import org.w3c.ddr.simple.exception.InitializationException;
import org.w3c.ddr.simple.exception.NameException;
import org.w3c.ddr.simple.exception.ValueException;

/**
 * This is User Agent parser implementation that utilizes OpenDDR hosted at http://www.openddr.org/
 * 
 * @author Georgi Petkov
 * @since 1.0
 */
public class OpenDDRUserAgentParser extends UserAgentParser
{
    private final String DESKTOP = "desktop";
    private Service identificationService = null;
    private Properties initializationProperties = new Properties();

    public OpenDDRUserAgentParser()
    {
        try
        {
            initializationProperties.load(OpenDDRUserAgentParser.class.getClassLoader().getResourceAsStream("oddr.properties"));
            this.identificationService = ServiceFactory.newService("org.openddr.simpleapi.oddr.ODDRService",
                    initializationProperties.getProperty(ODDRService.ODDR_VOCABULARY_IRI), initializationProperties);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InitializationException e)
        {
            e.printStackTrace();
        }
        catch (NameException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public UserAgent parse(String userAgentString)
    {
        UserAgent resultUserAgent = new UserAgent();
        try
        {
            // Definition the library's properties
            PropertyRef vendorRef;
            PropertyRef modelRef;
            PropertyRef displayWidthRef;
            PropertyRef displayHeightRef;
            PropertyRef isTabletRef;
            PropertyRef deviceOsRef;
            // Initialize the library's properties
            vendorRef = identificationService.newPropertyRef("vendor");
            modelRef = identificationService.newPropertyRef("model");
            displayWidthRef = identificationService.newPropertyRef("displayWidth");
            displayHeightRef = identificationService.newPropertyRef("displayHeight");
            isTabletRef = identificationService.newPropertyRef("is_tablet");
            deviceOsRef = identificationService.newPropertyRef("device_os");
            // Add in array
            PropertyRef[] propertyRefs = new PropertyRef[] { vendorRef, modelRef, displayWidthRef, displayHeightRef, isTabletRef,
                    deviceOsRef };
            // Create evidence
            Evidence e = new ODDRHTTPEvidence();
            // Initialize the evidence
            e.put("User-Agent", userAgentString);
            // Retrieve the data
            PropertyValues propertyValues = identificationService.getPropertyValues(e, propertyRefs);
            PropertyValue vendor = propertyValues.getValue(vendorRef);
            PropertyValue model = propertyValues.getValue(modelRef);
            PropertyValue displayWidth = propertyValues.getValue(displayWidthRef);
            PropertyValue displayHeight = propertyValues.getValue(displayHeightRef);
            PropertyValue isTablet = propertyValues.getValue(isTabletRef);
            PropertyValue deviceOs = propertyValues.getValue(deviceOsRef);
            // Initialize UserAgentProperties
            if (vendor.exists())
            {
                resultUserAgent.setDeviceMaker(vendor.getString().equalsIgnoreCase(this.DESKTOP) ? UserAgent.UNKNOWN : vendor
                        .getString());
            }
            if (model.exists())
            {
                resultUserAgent.setDeviceModel(model.getString().equalsIgnoreCase(this.DESKTOP) ? UserAgent.COMPUTER : model
                        .getString());
            }
            if (displayWidth.exists())
            {
                resultUserAgent.setDisplayWidth(vendor.getString().equalsIgnoreCase(this.DESKTOP) ? UserAgent.UNKNOWN
                        : displayWidth.getString());
            }
            if (displayHeight.exists())
            {
                resultUserAgent.setDisplayHeight(vendor.getString().equalsIgnoreCase(this.DESKTOP) ? UserAgent.UNKNOWN
                        : displayHeight.getString());
            }
            if (displayWidth.exists() && displayHeight.exists())
            {
                resultUserAgent.setDisplayResolution(vendor.getString().equalsIgnoreCase(this.DESKTOP) ? UserAgent.UNKNOWN
                        : (displayWidth.getString() + " x " + displayHeight.getString()));
            }
            if (deviceOs.exists() && deviceOs.getString().equalsIgnoreCase("Android") && isTablet.exists())
            {
                resultUserAgent.setDeviceType(isTablet.getBoolean() ? UserAgent.TABLET : UserAgent.MOBILE);
            }
        }
        catch (NameException e)
        {
            e.printStackTrace();
        }
        catch (ValueException e)
        {
            e.printStackTrace();
        }
        return resultUserAgent;
    }
}
