
<<<<<<< HEAD
public class UserAgentParser {

	private File file;
	public ArrayList<UserAgent> userAgents;
	public String regex = "(blackberry)+?(\\d{2,4}?.*)*?/(\\d+.\\d+.\\d*?.\\d*?)+?((profile/midp-)+?"
			+ "(\\d.\\d)+?)*?((configuration/)+?(\\w+?-\\d.\\d)+?)*?((vendorid/)+?\\d+?)*?.*?";

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public UserAgentParser(File file) {
		this.file = file;
	}

	public UserAgentParser() {
		this(null);
	}

	public void readFileLines() {
		Scanner input = null;
		try {
			input = new Scanner(getFile());
			Pattern p = Pattern.compile(regex);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				Matcher m = p.matcher(line);
				if (m.find()) {
					String userAgent = m.toString();
					parse(userAgent);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public UserAgent parse(String line) {
=======
public abstract class UserAgentParser {
	
	
	public UserAgent parse(String userAgentString){
>>>>>>> adab9c9c6d61cd08734bfd8634dab9fc0c032072
		return null;
	}

}
