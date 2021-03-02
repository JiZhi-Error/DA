package com.tencent.mm.sdk.platformtools;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* access modifiers changed from: package-private */
@Deprecated
public class XmlUtils {
    XmlUtils() {
    }

    public static final void writeMapXml(Map<String, Object> map, OutputStream outputStream) {
        AppMethodBeat.i(215455);
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, ProtocolPackage.ServerEncoding);
        newSerializer.startDocument(null, Boolean.TRUE);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(map, null, newSerializer);
        newSerializer.endDocument();
        AppMethodBeat.o(215455);
    }

    public static final void writeListXml(List<Object> list, OutputStream outputStream) {
        AppMethodBeat.i(215456);
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, ProtocolPackage.ServerEncoding);
        newSerializer.startDocument(null, Boolean.TRUE);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(list, null, newSerializer);
        newSerializer.endDocument();
        AppMethodBeat.o(215456);
    }

    public static final void writeMapXml(Map<String, Object> map, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(156354);
        if (map == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(156354);
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            writeValueXml(entry.getValue(), entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, "map");
        AppMethodBeat.o(156354);
    }

    public static final void writeListXml(List<Object> list, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(156355);
        if (list == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(156355);
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            writeValueXml(list.get(i2), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "list");
        AppMethodBeat.o(156355);
    }

    public static final void writeSetXml(Set<Object> set, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(156356);
        if (set == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(156356);
            return;
        }
        xmlSerializer.startTag(null, "set");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Object obj : set) {
            writeValueXml(obj, null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "set");
        AppMethodBeat.o(156356);
    }

    public static final void writeByteArrayXml(byte[] bArr, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(156357);
        if (bArr == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(156357);
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = bArr.length;
        xmlSerializer.attribute(null, "num", Integer.toString(length));
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 >> 4;
            sb.append(i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i3 = b2 & 255;
            sb.append(i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
        }
        xmlSerializer.text(sb.toString());
        xmlSerializer.endTag(null, "byte-array");
        AppMethodBeat.o(156357);
    }

    public static final void writeIntArrayXml(int[] iArr, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(156358);
        if (iArr == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(156358);
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = iArr.length;
        xmlSerializer.attribute(null, "num", Integer.toString(length));
        for (int i2 : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Integer.toString(i2));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
        AppMethodBeat.o(156358);
    }

    public static final void writeValueXml(Object obj, String str, XmlSerializer xmlSerializer) {
        String str2;
        AppMethodBeat.i(156359);
        if (obj == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(156359);
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
            AppMethodBeat.o(156359);
        } else {
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = DownloadSetting.TYPE_BOOLEAN;
            } else if (obj instanceof byte[]) {
                writeByteArrayXml((byte[]) obj, str, xmlSerializer);
                AppMethodBeat.o(156359);
                return;
            } else if (obj instanceof int[]) {
                writeIntArrayXml((int[]) obj, str, xmlSerializer);
                AppMethodBeat.o(156359);
                return;
            } else if (obj instanceof Map) {
                writeMapXml((Map) obj, str, xmlSerializer);
                AppMethodBeat.o(156359);
                return;
            } else if (obj instanceof List) {
                writeListXml((List) obj, str, xmlSerializer);
                AppMethodBeat.o(156359);
                return;
            } else if (obj instanceof Set) {
                writeSetXml((Set) obj, str, xmlSerializer);
                AppMethodBeat.o(156359);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag(null, "string");
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, "string");
                AppMethodBeat.o(156359);
                return;
            } else {
                RuntimeException runtimeException = new RuntimeException("writeValueXml: unable to write value ".concat(String.valueOf(obj)));
                AppMethodBeat.o(156359);
                throw runtimeException;
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.attribute(null, "value", obj.toString());
            xmlSerializer.endTag(null, str2);
            AppMethodBeat.o(156359);
        }
    }

    public static final HashMap<String, Object> readMapXml(InputStream inputStream) {
        AppMethodBeat.i(215457);
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        HashMap<String, Object> hashMap = (HashMap) readValueXml(newPullParser, new String[1]);
        AppMethodBeat.o(215457);
        return hashMap;
    }

    public static final ArrayList<Object> readListXml(InputStream inputStream) {
        AppMethodBeat.i(215458);
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        ArrayList<Object> arrayList = (ArrayList) readValueXml(newPullParser, new String[1]);
        AppMethodBeat.o(215458);
        return arrayList;
    }

    public static final HashSet<Object> readSetXml(InputStream inputStream) {
        AppMethodBeat.i(215459);
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        HashSet<Object> hashSet = (HashSet) readValueXml(newPullParser, new String[1]);
        AppMethodBeat.o(215459);
        return hashSet;
    }

    public static final HashMap<String, Object> readThisMapXml(XmlPullParser xmlPullParser, String str, String[] strArr) {
        AppMethodBeat.i(156360);
        HashMap<String, Object> hashMap = new HashMap<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object readThisValueXml = readThisValueXml(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], readThisValueXml);
                } else {
                    XmlPullParserException xmlPullParserException = new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                    AppMethodBeat.o(156360);
                    throw xmlPullParserException;
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    AppMethodBeat.o(156360);
                    return hashMap;
                }
                XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(156360);
                throw xmlPullParserException2;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        XmlPullParserException xmlPullParserException3 = new XmlPullParserException("Document ended before " + str + " end tag");
        AppMethodBeat.o(156360);
        throw xmlPullParserException3;
    }

    public static final ArrayList<Object> readThisListXml(XmlPullParser xmlPullParser, String str, String[] strArr) {
        AppMethodBeat.i(156361);
        ArrayList<Object> arrayList = new ArrayList<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(readThisValueXml(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    AppMethodBeat.o(156361);
                    return arrayList;
                }
                XmlPullParserException xmlPullParserException = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(156361);
                throw xmlPullParserException;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Document ended before " + str + " end tag");
        AppMethodBeat.o(156361);
        throw xmlPullParserException2;
    }

    public static final HashSet<Object> readThisSetXml(XmlPullParser xmlPullParser, String str, String[] strArr) {
        AppMethodBeat.i(156362);
        HashSet<Object> hashSet = new HashSet<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(readThisValueXml(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    AppMethodBeat.o(156362);
                    return hashSet;
                }
                XmlPullParserException xmlPullParserException = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(156362);
                throw xmlPullParserException;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Document ended before " + str + " end tag");
        AppMethodBeat.o(156362);
        throw xmlPullParserException2;
    }

    public static final int[] readThisIntArrayXml(XmlPullParser xmlPullParser, String str, String[] strArr) {
        AppMethodBeat.i(215460);
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"))];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            iArr[i2] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException e2) {
                            XmlPullParserException xmlPullParserException = new XmlPullParserException("Need value attribute in item");
                            AppMethodBeat.o(215460);
                            throw xmlPullParserException;
                        } catch (NumberFormatException e3) {
                            XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Not a number in value attribute in item");
                            AppMethodBeat.o(215460);
                            throw xmlPullParserException2;
                        }
                    } else {
                        XmlPullParserException xmlPullParserException3 = new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                        AppMethodBeat.o(215460);
                        throw xmlPullParserException3;
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        AppMethodBeat.o(215460);
                        return iArr;
                    } else if (xmlPullParser.getName().equals("item")) {
                        i2++;
                    } else {
                        XmlPullParserException xmlPullParserException4 = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                        AppMethodBeat.o(215460);
                        throw xmlPullParserException4;
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            XmlPullParserException xmlPullParserException5 = new XmlPullParserException("Document ended before " + str + " end tag");
            AppMethodBeat.o(215460);
            throw xmlPullParserException5;
        } catch (NullPointerException e4) {
            XmlPullParserException xmlPullParserException6 = new XmlPullParserException("Need num attribute in byte-array");
            AppMethodBeat.o(215460);
            throw xmlPullParserException6;
        } catch (NumberFormatException e5) {
            XmlPullParserException xmlPullParserException7 = new XmlPullParserException("Not a number in num attribute in byte-array");
            AppMethodBeat.o(215460);
            throw xmlPullParserException7;
        }
    }

    public static final Object readValueXml(XmlPullParser xmlPullParser, String[] strArr) {
        AppMethodBeat.i(156364);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                XmlPullParserException xmlPullParserException = new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(156364);
                throw xmlPullParserException;
            } else if (eventType == 4) {
                XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
                AppMethodBeat.o(156364);
                throw xmlPullParserException2;
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    XmlPullParserException xmlPullParserException3 = new XmlPullParserException("Unexpected end of document");
                    AppMethodBeat.o(156364);
                    throw xmlPullParserException3;
                }
            }
        }
        Object readThisValueXml = readThisValueXml(xmlPullParser, strArr);
        AppMethodBeat.o(156364);
        return readThisValueXml;
    }

    private static final Object readThisValueXml(XmlPullParser xmlPullParser, String[] strArr) {
        int next;
        Object obj = null;
        AppMethodBeat.i(156365);
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals(BuildConfig.COMMAND)) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Unexpected end of document in <string>");
                        AppMethodBeat.o(156365);
                        throw xmlPullParserException;
                    } else if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            AppMethodBeat.o(156365);
                            return str;
                        }
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                        AppMethodBeat.o(156365);
                        throw xmlPullParserException2;
                    } else if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        XmlPullParserException xmlPullParserException3 = new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                        AppMethodBeat.o(156365);
                        throw xmlPullParserException3;
                    }
                }
            } else if (name.equals("int")) {
                obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            } else if (name.equals("long")) {
                obj = Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("float")) {
                obj = Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("double")) {
                obj = Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals(DownloadSetting.TYPE_BOOLEAN)) {
                obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("int-array")) {
                xmlPullParser.next();
                int[] readThisIntArrayXml = readThisIntArrayXml(xmlPullParser, "int-array", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(156365);
                return readThisIntArrayXml;
            } else if (name.equals("map")) {
                xmlPullParser.next();
                HashMap<String, Object> readThisMapXml = readThisMapXml(xmlPullParser, "map", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(156365);
                return readThisMapXml;
            } else if (name.equals("list")) {
                xmlPullParser.next();
                ArrayList<Object> readThisListXml = readThisListXml(xmlPullParser, "list", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(156365);
                return readThisListXml;
            } else if (name.equals("set")) {
                xmlPullParser.next();
                HashSet<Object> readThisSetXml = readThisSetXml(xmlPullParser, "set", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(156365);
                return readThisSetXml;
            } else {
                XmlPullParserException xmlPullParserException4 = new XmlPullParserException("Unknown tag: ".concat(String.valueOf(name)));
                AppMethodBeat.o(156365);
                throw xmlPullParserException4;
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                XmlPullParserException xmlPullParserException5 = new XmlPullParserException("Unexpected end of document in <" + name + ">");
                AppMethodBeat.o(156365);
                throw xmlPullParserException5;
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    AppMethodBeat.o(156365);
                    return obj;
                }
                XmlPullParserException xmlPullParserException6 = new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
                AppMethodBeat.o(156365);
                throw xmlPullParserException6;
            } else if (next == 4) {
                XmlPullParserException xmlPullParserException7 = new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
                AppMethodBeat.o(156365);
                throw xmlPullParserException7;
            }
        } while (next != 2);
        XmlPullParserException xmlPullParserException8 = new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
        AppMethodBeat.o(156365);
        throw xmlPullParserException8;
    }
}
