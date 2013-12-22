package at.ac.tuwien.mnsa.xml;

import java.util.ArrayList;
import java.util.List;

public class TestNodeAdapter extends javax.xml.bind.annotation.adapters
		.XmlAdapter<TestNode, List<Object[]>> {

	@Override
	public List<Object[]> unmarshal(TestNode testNode) throws Exception {
		ArrayList<Object[]> objects = new ArrayList<Object[]>();
		objects.add(new Object[]{testNode.getCommandAPDU(), testNode.getResponseAPDU()});
		return objects;
	}

	@Override
	public TestNode marshal(List<Object[]> objects) throws Exception {
		throw new UnsupportedOperationException();
	}
}
