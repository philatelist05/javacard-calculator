package at.ac.tuwien.mnsa.javacard;

import org.testng.annotations.DataProvider;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class APDUDataProvider {
	@DataProvider(name = "APDUDataProvider")
	public static Iterator<Object[]> createData() throws Exception {
		InputStream resource = getResource("testdata.xml");

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			SAXParser saxParser = factory.newSAXParser();
			List<Object[]> list = new ArrayList<Object[]>();
			saxParser.parse(resource, new SAXContentHandler(list));
			return list.iterator();
		} finally {
			resource.close();
		}
	}

	private static InputStream getResource(String url) {
		return ClassLoader.getSystemClassLoader().getResourceAsStream(url);
	}
}
