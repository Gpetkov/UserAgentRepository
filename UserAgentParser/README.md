##CIP 39 User Agent Parser

The project is for parsing User Agent String to User Agent Object

###There is a [UserAgent](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgent.java) class with eight properties

 *	deviceType         
 *	deviceMaker        
 *	deviceModel          
 *	deviceModelVersion  
 *	os                   
 *	osVersion 
 *	browser 
 *	browserVersion 


###And four Parsing classes:

######[UserAgentParser](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgentParser.java): base abstract class for all parser classes

######[UserAgentUtilsParser](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgentUtilsParser.java): extends UserAgentParser and use [UserAgentUtils](http://user-agent-utils.java.net/) - library to parse the UAString to an UAObject

######[RegexpUserAgentParser:](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/RegexpUserAgentParser.java) extends UserAgentParser and use our own RegEx to parse the UAString to an UAObject

######[CompositeUserAgentParser:](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/CompositeUserAgentParser.java) extends UserAgentParser and this combines the above two classes for more efficiency#
 
All tree classes @Override parse(String userAgentString) method


### EXAMPLE

	String userAgentString="BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301";*<p>
	UserAgentParser userAgentParser = new CompositeUserAgentParser();*<p>
	UserAgent userAgent=userAgentParser.parse(userAgentString);*<p>
	userAgent.getDeviceType();--------------->MOBILE*<p>
	userAgent.getDeviceMaker();-------------->BlackBerry*<p>
	userAgent.getDeviceModel();-------------->8520*<p>
	userAgent.getDeviceModelVersion();------->8520*<p>
	userAgent.getOS();----------------------->BlackBerry*<p>
	userAgent.getOSVersion();---------------->4.6.1.314*<p>
	userAgent.getBrowser();------------------>BlackBerry*<p>
	userAgent.getBrowserVersion();----------->UNKNOWN*<p>
