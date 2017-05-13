package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayPanel extends JPanel {

	/**
	 * This is view part
	 */
	private static final long serialVersionUID = 1L;

	UnicodeConverter conv = new UnicodeConverter();

	JTextArea text;
	JScrollPane scroll;
	String[] lesson = {
			"काठ्माण्डु युनिभर्सिती",
			"दक्षिण एसियामा नै राजनीतीमा सबैभन्दा बढी महिला सहभागिता रहेको देश नेपाल हो | • ...२०१४ फिफा विश्वकप ब्राजिलमा आयोजना हुँदैछ । • ...संयुक्त्त राष्ट्र संघको स्थापना २४ अक्टुबर १९४५ मा भएको थियो । • ...नेपालमा ३९१५ गाविस तथा १३० नगरपालिका छन ।(७२ नगरपालिका २०७१ बैशाख २६ गते थप गरिएको ) • ...नेपालमा १८५ प्रकारका माछा पाइन्छन् | • ...माछा संरक्षण केन्द्र पोखरामा छ | • ...नेपालमा ९८ प्रकारका सर्प पाइन्छन् | • ...मेचे जातिको पुरोहितलाई देउसी भनिन्छ | • ...विश्व खाद्य संगठनले २०११ मा निकालेको तथ्याङ्क अनुसार मुटु सम्बन्धि रोगको कारणबाट मात्र ७०००००० मानिसको मृत्यु भएको थियो । • ...विश्वकी पहिलो चलचित्र अभिनेत्री मार्गरेट हग्स हुन । • ....भालुको दाँत ४२ वटा हुन्छन । • ...२०१३ मा फिफा बर्ष खेलाडी हुने व्यक्ति क्रिष्टियानो रोनाल्डो हुन । • ...झिङ्गे माछाको रगत रङ्गहिन हुन्छ तर जब यो बाहिर आउँछ अक्सिजनले यसलाई निलो बनाइदिन्छ । • ...विश्वको सबैभन्दा लामो नदी नाइल नदीको लम्बाई ६६५० किलोमिटर छ । • ...विश्वको सबैभन्दा अग्लो स्थानमा रहेको तिलिचो तालको आकार अंग्रेजी अक्षर जस्तो छ। • ...हवाइयन वर्णमालामा जम्मा १२ वटा मात्र अक्षर छन । • ...अमेरिकन राष्ट्रपति बाराक ओबामाको जन्म ४ अगस्ट १९६१ मा भएको थियो । • ...मैथली भाषा विश्वमा बढि बोलिने भाषा मध्य २६औं स्थानमा छ। • ...उँटको दुध जम्दैन वा फाट्दैन । • ...जुका सबैभन्दा बढी प्रजाति भएको जीव हो। ",
			"दिपेश" };

	public DisplayPanel() {
		text = new JTextArea();
		scroll = new JScrollPane(text);
		scroll.setBackground(Color.white);
		scroll.setPreferredSize(new Dimension(750, 200));
		text.setEditable(false);
		text.setLineWrap(true);
		text.setText(lesson[0]);
		add(scroll);

	}

}
