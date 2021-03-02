package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public final class y {
    public static boolean b(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.i(93247);
        if (!b(xmlPullParser) || !xmlPullParser.getName().equals(str)) {
            AppMethodBeat.o(93247);
            return false;
        }
        AppMethodBeat.o(93247);
        return true;
    }

    private static boolean b(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(93248);
        if (xmlPullParser.getEventType() == 2) {
            AppMethodBeat.o(93248);
            return true;
        }
        AppMethodBeat.o(93248);
        return false;
    }

    public static String c(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.i(93249);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if (str.equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                AppMethodBeat.o(93249);
                return attributeValue;
            }
        }
        AppMethodBeat.o(93249);
        return null;
    }
}
