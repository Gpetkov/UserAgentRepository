 CIP 39 User Agent Parser
====================

The project is for parsing User Agent String to User Agent Object

###There is a [UserAgent](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgent.java) class with eight properties
-
<p>* deviceType         
<p>* deviceMaker        
<p>* deviceModel          
<p>* deviceModelVersion  
<p>* os                   
<p>* osVersion 
<p>* browser 
<p>* browserVersion 

--

###And four Parsing classes:
-
####[UserAgentParser](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgentParser.java): base abstract class for all parser classes

#####[UserAgentUtilsParser](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/UserAgentUtilsParser.java): extends UserAgentParser and use [UserAgentUtils](http://user-agent-utils.java.net/) - library to parse the UAString to an UAObject

#####[RegexpUserAgentParser:](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/RegexpUserAgentParser.java) extends UserAgentParser and use our own RegEx to parse the UAString to an UAObject

#####[CompositeUserAgentParser:](https://github.com/Gpetkov/UserAgentRepository/blob/master/UserAgentParser/src/uk/co/newsint/cip/utilities/ua/CompositeUserAgentParser.java) extends UserAgentParser and this combines the above two classes for more efficiency#
 
###### All tree classes @Override parse(String userAgentString) method
--

### EXAMPLE
--
<p>*String userAgentString="BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301";*<p>
<p>*UserAgentParser userAgentParser = new CompositeUserAgentParser();*<p>
<p>*UserAgent userAgent=userAgentParser.parse(userAgentString);*<p>
<p>*userAgent.getDeviceType();--------------->MOBILE*<p>
<p>*userAgent.getDeviceMaker();-------------->BlackBerry*<p>
<p>*userAgent.getDeviceModel();-------------->8520*<p>
<p>*userAgent.getDeviceModelVersion();------->8520*<p>
<p>*userAgent.getOS();----------------------->BlackBerry*<p>
<p>*userAgent.getOSVersion();---------------->4.6.1.314*<p>
<p>*userAgent.getBrowser();------------------>BlackBerry*<p>
<p>*userAgent.getBrowserVersion();----------->UNKNOWN*<p>

--
