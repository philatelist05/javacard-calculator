package at.ac.tuwien.mnsa.xml;

import at.ac.tuwien.mnsa.xml.tag.TestTag;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.List;

public class TestTagAdapter extends XmlAdapter<TestTag, List<Object[]>> {

	private final ArrayList<Object[]> objects;

	public TestTagAdapter() {
		objects = new ArrayList<Object[]>();
	}

	@Override
	public List<Object[]> unmarshal(TestTag testTag) throws Exception {
		objects.add(new Object[]{testTag.getCommandAPDU(), testTag.getResponseAPDU()});
		return objects;
	}

	@Override
	public TestTag marshal(List<Object[]> objects) throws Exception {
		throw new UnsupportedOperationException();
	}
}
