package at.ac.tuwien.mnsa.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement(name = "Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootNode {
	@XmlElement(name = "Test")
	@XmlJavaTypeAdapter(TestNodeAdapter.class)
	private List<Object[]> objects;

	public List<Object[]> getObjects() {
		return objects;
	}
}
