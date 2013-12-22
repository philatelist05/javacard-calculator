package at.ac.tuwien.mnsa.javacard;

import at.ac.tuwien.mnsa.xml.RootNode;
import org.testng.annotations.DataProvider;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.util.Iterator;

public class APDUDataProvider {
	@DataProvider(name = "APDUDataProvider")
	public static Iterator<Object[]> createData()
			throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance(RootNode.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Schema schema = createSchema();
		unmarshaller.setSchema(schema);
		RootNode node = (RootNode) unmarshaller.unmarshal(getResource
				("testdata.xml"));
		return node.getObjects().iterator();
	}

	private static Schema createSchema() throws SAXException {
		InputStream resourceStream = getResource("testdata.xsd");
		StreamSource source = new StreamSource(resourceStream);
		SchemaFactory factory =
				SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		return factory.newSchema(source);
	}

	private static InputStream getResource(String url) {
		return ClassLoader.getSystemClassLoader().getResourceAsStream(url);
	}
}
