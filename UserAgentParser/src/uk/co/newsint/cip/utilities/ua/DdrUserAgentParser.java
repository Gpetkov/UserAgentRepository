package uk.co.newsint.cip.utilities.ua;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
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
public class DdrUserAgentParser extends UserAgentParser
{
    private Service identificationService = null;
    private Properties initializationProperties = new Properties();

    public DdrUserAgentParser()
    {
        try
        {
            initializationProperties.load(DdrUserAgentParser.class.getClassLoader().getResourceAsStream("oddr.properties"));
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
        // Service identificationService = null;
        // Properties initializationProperties = new Properties();
        try
        {
            // initializationProperties.load(DdrUserAgentParser.class.getClassLoader().getResourceAsStream("oddr.properties"));

            // identificationService = ServiceFactory.newService("org.openddr.simpleapi.oddr.ODDRService",
            // initializationProperties.getProperty(ODDRService.ODDR_VOCABULARY_IRI), initializationProperties);

            // Initialize the library's properties
            PropertyRef vendorRef;
            PropertyRef modelRef;
            PropertyRef displayWidthRef;
            PropertyRef displayHeightRef;
            PropertyRef isTabletRef;
            PropertyRef deviceOsRef;

            vendorRef = identificationService.newPropertyRef("vendor");
            modelRef = identificationService.newPropertyRef("model");
            displayWidthRef = identificationService.newPropertyRef("displayWidth");
            displayHeightRef = identificationService.newPropertyRef("displayHeight");
            isTabletRef = identificationService.newPropertyRef("is_tablet");
            deviceOsRef = identificationService.newPropertyRef("device_os");

            PropertyRef[] propertyRefs = new PropertyRef[] { vendorRef, modelRef, displayWidthRef, displayHeightRef, isTabletRef,
                    deviceOsRef };
            Evidence e = new ODDRHTTPEvidence();
            e.put("User-Agent", userAgentString);
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
                resultUserAgent.setDeviceMaker(vendor.getString().equalsIgnoreCase("desktop") ? UserAgent.UNKNOWN : vendor.getString());
            }
            if (model.exists())
            {
                resultUserAgent.setDeviceModel(model.getString().equalsIgnoreCase("desktop") ? UserAgent.COMPUTER : model.getString());
            }
            if (displayWidth.exists())
            {
                resultUserAgent.setDisplayWidth(vendor.getString().equalsIgnoreCase("desktop") ? UserAgent.UNKNOWN : displayWidth.getString());
            }
            if (displayHeight.exists())
            {
                resultUserAgent.setDisplayHeight(vendor.getString().equalsIgnoreCase("desktop") ? UserAgent.UNKNOWN : displayHeight.getString());
            }
            if (displayWidth.exists() && displayHeight.exists())
            {
                resultUserAgent.setDisplayResolution(vendor.getString().equalsIgnoreCase("desktop") ? UserAgent.UNKNOWN : (displayWidth.getString() + " x " + displayHeight.getString()));
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

    public static void main(String args[]) throws FileNotFoundException, IOException, URISyntaxException, InitializationException,
            NameException, ValueException
    {
        // InputStream in = new FileInputStream("C:\\Users\\BitMix\\workspace\\TestDDRSECOND\\resources\\coreVocabulary.xml");
        // Reader r = new InputStreamReader(in);
        System.out.println("Initialize filter");
        Service identificationService = null;
        Properties initializationProperties = new Properties();
        // initializationProperties.load(new FileReader(new
        // File(Main.class.getClassLoader().getResource("oddr.properties").toURI())));
        initializationProperties.load(DdrUserAgentParser.class.getClassLoader().getResourceAsStream("oddr.properties"));
        identificationService = ServiceFactory.newService("org.openddr.simpleapi.oddr.ODDRService",
                initializationProperties.getProperty(ODDRService.ODDR_VOCABULARY_IRI), initializationProperties);
        // for(int i = 0; i < 100; i++){
        PropertyRef vendorRef;
        PropertyRef modelRef;
        PropertyRef displayWidthRef;
        PropertyRef displayHeightRef;
        // PropertyRef operatingSystemRef;
        // operatingSystemRef = identificationService.newPropertyRef("operatingSystem");
        PropertyRef deviceOsRef;
        deviceOsRef = identificationService.newPropertyRef("device_os");

        PropertyRef deviceOsVersionRef;
        deviceOsVersionRef = identificationService.newPropertyRef("device_os_version");

        PropertyRef mobileBrowserRef;
        mobileBrowserRef = identificationService.newPropertyRef("mobile_browser");

        PropertyRef mobileBrowserVersionRef;
        mobileBrowserVersionRef = identificationService.newPropertyRef("mobile_browser_version");

        PropertyRef physicalscreenWidthRef;
        physicalscreenWidthRef = identificationService.newPropertyRef("physical_screen_width");

        PropertyRef isTabletRef;
        isTabletRef = identificationService.newPropertyRef("is_tablet");

        PropertyRef marketNameRef;
        marketNameRef = identificationService.newPropertyRef("marketing_name");

        vendorRef = identificationService.newPropertyRef("vendor");
        modelRef = identificationService.newPropertyRef("model");
        displayWidthRef = identificationService.newPropertyRef("displayWidth");
        displayHeightRef = identificationService.newPropertyRef("displayHeight");

        PropertyRef[] propertyRefs = new PropertyRef[] { vendorRef, modelRef, displayWidthRef, displayHeightRef, deviceOsRef,
                mobileBrowserRef, mobileBrowserVersionRef, deviceOsVersionRef, physicalscreenWidthRef, isTabletRef, marketNameRef };
        Evidence e = new ODDRHTTPEvidence();
        e.put("User-Agent",
                "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-us) AppleWebKit/533.21.1 (KHTML, like Gecko) Version/5.0.5 Safari/533.21.1");
        PropertyValues propertyValues = identificationService.getPropertyValues(e, propertyRefs);
        PropertyValue vendor = propertyValues.getValue(vendorRef);
        PropertyValue model = propertyValues.getValue(modelRef);
        PropertyValue displayWidth = propertyValues.getValue(displayWidthRef);
        PropertyValue displayHeight = propertyValues.getValue(displayHeightRef);
        PropertyValue deviceOs = propertyValues.getValue(deviceOsRef);
        PropertyValue deviceOsVersion = propertyValues.getValue(deviceOsRef);
        //PropertyValue mobileBrowser = propertyValues.getValue(mobileBrowserRef);
        //PropertyValue mobileBrowserVersion = propertyValues.getValue(mobileBrowserVersionRef);
        PropertyValue physicalScreenWidth = propertyValues.getValue(physicalscreenWidthRef);
        PropertyValue isTablet = propertyValues.getValue(isTabletRef);
        PropertyValue marketingName = propertyValues.getValue(marketNameRef);
        if (vendor.exists() && model.exists() && displayWidth.exists() && displayHeight.exists() || physicalScreenWidth.exists())
        {
            System.out.println(vendor.getString());
            System.out.println(model.getString());
            if (marketingName.exists())
            {
                System.out.println(marketingName.getString());
            }
            System.out.println(displayWidth.getInteger());
            System.out.println(displayHeight.getInteger());
            System.out.printf("device os: %s\n", deviceOs.getString());
            System.out.printf("device os version: %s\n", deviceOsVersion.getString());
            System.out.printf("device os version: %s\n", deviceOsVersion.getString());
            // System.out.printf("mobile browser: %s\n", mobileBrowser.getString());
            // System.out.printf("mobile browser version: %s\n",mobileBrowserVersion.getString());
            // System.out.printf("Physical screen width: %s\n", physicalScreenWidth.getString());
            if (!isTablet.exists())
            {
                System.out.printf("isTablet: %s\n", isTablet.getBoolean());
            }
            else
            {
                System.out.printf("isTablet: property doesn't exists\n");
            }

            System.out.println("-----------------");
        }
    }

}
