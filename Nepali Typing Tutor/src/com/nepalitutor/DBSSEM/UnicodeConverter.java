package com.nepalitutor.DBSSEM;

import java.util.ArrayList;

public class UnicodeConverter {

	ArrayList<String> roman;
	String mappingString = " 0123456789VM:\u0904HA[{fFZ\u090C\u090D\u090E]}\u0911"
			+ "\u0912OWkKgG<CcjJYqQxXNtTdDn\u0929pPbBmyr\u0931lL"
			+ "\u0934vSzsh`~aiIuUR\u0944\u0945\u0946eE\u0949"
			+ "\u094Aow/\u094E\u094F\\\u0951|\u0953\u0954\u0958\u0959";

	String traditional = " \u0966\u0967\u0968\u0969\u096A\u096B\u096C\u096D\u096E\u096F"
			+ "\u0950\u0964\u0964\u0904\u091D\u0906\u0964\u0943\u093E\u0901\u0964\u090C\u090D\u090E\u0947\u0948\u0911"
			+ "\u0912\u0907\u0964\u092A\u092B\u0928\u0964\u0919\u090B\u0905\u0935\u094B\u0964\u0964\u0964\u0939\u0964\u0964"
			+ "\u0924\u0964\u092E\u0964\u0932\u0929\u0909\u090F\u0926\u094C\u0903\u0925\u091A\u0931\u093F\u0940"
			+ "\u0934\u0916\u0964\u0936\u0915\u091C\u091E\u0965\u092C\u0937\u0964\u0917\u090A\u0964\u0944\u0945\u0946\u092D\u0910\u0949"
			+ "\u094A\u092F\u0927\u0930\u094E\u094F\u094D\u0951|\u0953\u0954\u0958\u0959";

	public UnicodeConverter() {
		prepareVector();
	}

	public String[] toRoman(String str[]) {
		String[] formattedStr = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			String temp = str[i];
			if (mappingString.indexOf(temp) == -1) {
				formattedStr[i] = temp;
			} else {
				int index = mappingString.indexOf(temp);
				formattedStr[i] = roman.get(index);
			}
		}
		return formattedStr;
	}

	public String toRoman(String str) {
		String formattedStr = "";
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (mappingString.indexOf(temp) == -1) {
				formattedStr += temp;
			} else {
				int index = mappingString.indexOf(temp);
				formattedStr += roman.get(index);
			}
		}
		return formattedStr;
	}

	public String[] toTraditional(String str[]) {
		String[] formattedStr = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			String temp = str[i];
			if (mappingString.indexOf(temp) == -1) {
				formattedStr[i] = temp;
			} else {
				int index = mappingString.indexOf(temp);
				formattedStr[i] = Character.toString(traditional.charAt(index));
			}
		}
		return formattedStr;
	}

	public String toTraditional(String str) {
		String formattedStr = "";
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (mappingString.indexOf(temp) == -1) {
				formattedStr += temp;
			} else {
				int index = mappingString.indexOf(temp);
				formattedStr += traditional.charAt(index);
			}
		}
		return formattedStr;
	}

	public void prepareVector() {
		roman = new ArrayList<String>();
		roman.add(" "); // space
		roman.add("\u0966"); // ०
		roman.add("\u0967"); // १
		roman.add("\u0968"); // २
		roman.add("\u0969"); // ३
		roman.add("\u096A"); // ४
		roman.add("\u096B"); // ५
		roman.add("\u096C"); // ६
		roman.add("\u096D"); // ७
		roman.add("\u096E"); // ८
		roman.add("\u096F"); // ९
		roman.add("\u0901"); // …
		roman.add("\u0902");
		roman.add("\u0903");
		roman.add("\u0904");
		roman.add("\u0905"); // a
		roman.add("\u0906"); // aa
		roman.add("\u0907"); // i
		roman.add("\u0908"); // ii
		roman.add("\u0909"); // u
		roman.add("\u090A"); // U
		roman.add("\u090B"); // vocalic R (ri)
		roman.add("\u090C"); // vocalic L (lri)
		roman.add("\u090D"); // candra E
		roman.add("\u090E"); // short E
		roman.add("\u090F"); // E
		roman.add("\u0910"); // AI
		roman.add("\u0911"); // candra o
		roman.add("\u0912"); // short o
		roman.add("\u0913"); // O
		roman.add("\u0914"); // AU
		roman.add("\u0915"); // ka
		roman.add("\u0916"); // kha
		roman.add("\u0917"); // ga
		roman.add("\u0918"); // gha
		roman.add("\u0919"); // nga
		roman.add("\u091A"); // cha
		roman.add("\u091B"); // chha
		roman.add("\u091C"); // ja
		roman.add("\u091D"); // jha
		roman.add("\u091E"); // nya
		roman.add("\u091F"); // tta
		roman.add("\u0920"); // ttha
		roman.add("\u0921"); // dda
		roman.add("\u0922"); // ddha
		roman.add("\u0923"); // nna
		roman.add("\u0924"); // ta
		roman.add("\u0925"); // tha
		roman.add("\u0926"); // da
		roman.add("\u0927"); // dha
		roman.add("\u0928"); // na
		roman.add("\u0929"); // nna
		roman.add("\u092A"); // pa
		roman.add("\u092B"); // pha
		roman.add("\u092C"); // ba
		roman.add("\u092D"); // bha
		roman.add("\u092E"); // ma
		roman.add("\u092F"); // ya
		roman.add("\u0930"); // ra
		roman.add("\u0931"); // rra
		roman.add("\u0932"); // la
		roman.add("\u0933"); // lla
		roman.add("\u0934"); // llla
		roman.add("\u0935");
		roman.add("\u0936");
		roman.add("\u0937");
		roman.add("\u0938");
		roman.add("\u0939");
		roman.add("\u093C");
		roman.add("\u093D");
		roman.add("\u093E");
		roman.add("\u093F");
		roman.add("\u0940");
		roman.add("\u0941");
		roman.add("\u0942");
		roman.add("\u0943");
		roman.add("\u0944");
		roman.add("\u0945");
		roman.add("\u0946");
		roman.add("\u0947");
		roman.add("\u0948");
		roman.add("\u0949");
		roman.add("\u094A");
		roman.add("\u094B");
		roman.add("\u094C");
		roman.add("\u094D");
		roman.add("\u094E");
		roman.add("\u094F");
		roman.add("\u0950");
		roman.add("\u0951");
		roman.add("\u0952");
		roman.add("\u0953");
		roman.add("\u0954");
		roman.add("\u0958");
		roman.add("\u0959");
	}
}
