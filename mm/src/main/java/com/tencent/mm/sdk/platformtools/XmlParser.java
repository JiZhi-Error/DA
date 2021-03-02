package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlParser {
    private static final String TAG = "MicroMsg.SDK.XmlParser";
    private static ThreadLocal<XmlPullParser> threadLocalPool = new ThreadLocal<>();

    public static Map<String, String> parseXml(String str, String str2, String str3) {
        Map<String, String> map = null;
        AppMethodBeat.i(230438);
        int indexOf = str == null ? -1 : str.indexOf("<".concat(String.valueOf(str2)));
        if (indexOf < 0) {
            Log.e(TAG, "can not find the tag <%s>", str2);
            AppMethodBeat.o(230438);
        } else {
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            try {
                map = new MMXmlPullParser(str, str2, str3).parse();
                AppMethodBeat.o(230438);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "[ %s ]", str);
                AppMethodBeat.o(230438);
            }
        }
        return map;
    }

    public static String getCDataWrapper(String str) {
        AppMethodBeat.i(168848);
        String format = String.format("<![CDATA[%s]]>", str);
        AppMethodBeat.o(168848);
        return format;
    }

    public static String nodeToString(Node node) {
        AppMethodBeat.i(158005);
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e2) {
            Log.e(TAG, "nodeToString: %s", e2.getMessage());
        }
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(158005);
        return stringWriter2;
    }

    static {
        AppMethodBeat.i(158006);
        AppMethodBeat.o(158006);
    }

    /* access modifiers changed from: package-private */
    public static class MMXmlPullParser {
        private Map<Integer, Integer> countMap;
        private StringBuilder pathSB = new StringBuilder();
        private Map<String, String> result;
        private String rootTag;
        private XmlPullParser xmlParser;

        public MMXmlPullParser(String str, String str2, String str3) {
            AppMethodBeat.i(230433);
            this.rootTag = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) XmlParser.threadLocalPool.get();
            this.xmlParser = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal threadLocal = XmlParser.threadLocalPool;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.xmlParser = newPullParser;
                threadLocal.set(newPullParser);
            }
            this.xmlParser.setInput(new StringReader(str));
            this.countMap = new HashMap();
            this.result = new HashMap();
            AppMethodBeat.o(230433);
        }

        public Map<String, String> parse() {
            AppMethodBeat.i(230434);
            int eventType = this.xmlParser.getEventType();
            while (eventType != 1) {
                eventType = this.xmlParser.next();
                if (eventType == 2) {
                    handleStartElement();
                } else if (eventType == 4) {
                    handleElementContent();
                } else if (eventType == 3) {
                    handleEndElement();
                    if (this.pathSB.length() == 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            Map<String, String> map = this.result;
            AppMethodBeat.o(230434);
            return map;
        }

        private void handleStartElement() {
            String str;
            AppMethodBeat.i(230435);
            this.pathSB.append('.').append(this.xmlParser.getName());
            String sb = this.pathSB.toString();
            int hashCode = sb.hashCode();
            Integer num = this.countMap.get(Integer.valueOf(hashCode));
            if (num != null) {
                Integer valueOf = Integer.valueOf(num.intValue() + 1);
                this.pathSB.append(valueOf);
                this.countMap.put(Integer.valueOf(hashCode), valueOf);
                str = sb + valueOf;
            } else {
                this.countMap.put(Integer.valueOf(hashCode), 0);
                str = sb;
            }
            this.result.put(str, "");
            for (int i2 = 0; i2 < this.xmlParser.getAttributeCount(); i2++) {
                this.result.put(str + ".$" + this.xmlParser.getAttributeName(i2), this.xmlParser.getAttributeValue(i2));
            }
            AppMethodBeat.o(230435);
        }

        private void handleElementContent() {
            AppMethodBeat.i(230436);
            String text = this.xmlParser.getText();
            if (text != null) {
                this.result.put(this.pathSB.toString(), text);
            }
            AppMethodBeat.o(230436);
        }

        private void handleEndElement() {
            AppMethodBeat.i(230437);
            this.pathSB = this.pathSB.delete(this.pathSB.lastIndexOf("."), this.pathSB.length());
            AppMethodBeat.o(230437);
        }
    }
}
