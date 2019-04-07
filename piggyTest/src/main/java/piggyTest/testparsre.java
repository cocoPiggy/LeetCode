package piggyTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;

public class testparsre {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		
		
		
		LinkedHashMap<String, Integer> map=new LinkedHashMap<>();
		map.put("name",4);
		map.put("field",5);
		map.put("ddd",3);
		FixedWidthFields lengths = new FixedWidthFields(map);

		// creates the default settings for a fixed width parser
		FixedWidthParserSettings settings = new FixedWidthParserSettings(lengths);

		// sets the character used for padding unwritten spaces in the file
		//settings.getFormat().setPadding('_');
		//settings.getFormat().setLineSeparator("\n");

		// creates a fixed-width parser with the given settings
		FixedWidthParser parser = new FixedWidthParser(settings);

		// parses all rows in one go.
	    Record allRows = parser.parseRecord("aaaabbbbbccc");
	    Map<String,String> map2=new HashMap<>();
	    map2=allRows.toFieldMap();
		System.out.println(map2);
		
		BeanListProcessor<testBean> rowProcessor = new BeanListProcessor<testBean>(testBean.class);

		FixedWidthParserSettings parserSettings2 = new FixedWidthParserSettings();
		//parserSettings.getFormat().setLineSeparator("\n");
		parserSettings2.setProcessor(rowProcessor);
		parserSettings2.setNumberOfRecordsToRead(1);
		
		FixedWidthParser parser2 = new FixedWidthParser(parserSettings2);
		parser2.parse(new StringReader("111122223\n33"));
		List<testBean> beans = rowProcessor.getBeans();
		for(testBean a:beans)
		System.out.println(a);
		
		BeanWriterProcessor<testBean> rowWriterProcessor = new BeanWriterProcessor<testBean>(testBean.class);
		FixedWidthWriterSettings fwws = new FixedWidthWriterSettings();
		fwws.setRowWriterProcessor(rowWriterProcessor);
		StringWriter writer = new StringWriter();
		new FixedWidthWriter(writer, fwws).processRecordsAndClose(beans);
		System.out.println(writer.toString());
	}

	public Reader getReader(String relativePath) throws FileNotFoundException {
		try {
			return new InputStreamReader(new FileInputStream(new File(relativePath)), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Unable to read input", e);
		}
	}

}
