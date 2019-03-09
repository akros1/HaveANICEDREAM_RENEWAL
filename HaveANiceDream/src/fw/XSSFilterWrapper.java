package fw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSFilterWrapper extends HttpServletRequestWrapper {

	public XSSFilterWrapper(HttpServletRequest request) {
		super(request);
		
	}



	@Override
	public String getParameter(String name) {
		String string = super.getParameter(name);
		
		if (string == null){
			return null;
		}
		
		return cleanXSS(string);
	}



	@Override
	public String[] getParameterValues(String name) {
		String[] valuse = super.getParameterValues(name);

		if (valuse == null) {
			return null;
		}

		int count = valuse.length;

		String[] cleanValuse = new String[count];

		for (int i = 0; i < count; i++) {
			cleanValuse[i] = cleanXSS(valuse[i]);
		}
		
		return cleanValuse;
	}



	private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		//value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		//value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		//value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
}
