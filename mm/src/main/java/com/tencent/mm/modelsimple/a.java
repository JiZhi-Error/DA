package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* access modifiers changed from: package-private */
public final class a {
    a() {
    }

    public static BindWordingContent Py(String str) {
        AppMethodBeat.i(134148);
        BindWordingContent bindWordingContent = new BindWordingContent("", "");
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    str2 = newPullParser.getName();
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        String trim = text.trim();
                        if (!str2.equalsIgnoreCase("title")) {
                            if (!str2.equalsIgnoreCase("text")) {
                                if (str2.equalsIgnoreCase("type")) {
                                    try {
                                        bindWordingContent.jiW = Integer.valueOf(trim);
                                        break;
                                    } catch (Exception e2) {
                                        bindWordingContent.jiW = 0;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                bindWordingContent.content = trim;
                                break;
                            }
                        } else {
                            bindWordingContent.title = trim;
                            break;
                        }
                    }
            }
        }
        AppMethodBeat.o(134148);
        return bindWordingContent;
    }
}
