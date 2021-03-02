package com.tencent.mm.emoji.b;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0004J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0004J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/model/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrString", "readInt", "readString", "skip", "Companion", "plugin-emojisdk_release"})
public class a {
    private static final String TAG = TAG;
    public static final C0319a gWU = new C0319a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/model/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.b.a$a  reason: collision with other inner class name */
    public static final class C0319a {
        private C0319a() {
        }

        public /* synthetic */ C0319a(byte b2) {
            this();
        }

        public static void a(String str, a aVar) {
            InputStream inputStream = null;
            AppMethodBeat.i(199908);
            p.h(str, "filePath");
            p.h(aVar, "xmlContent");
            try {
                inputStream = s.openRead(str);
                XmlPullParser newPullParser = Xml.newPullParser();
                p.g(newPullParser, "Xml.newPullParser()");
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                newPullParser.setInput(inputStream, null);
                newPullParser.nextTag();
                aVar.c(newPullParser);
                if (inputStream != null) {
                    inputStream.close();
                    AppMethodBeat.o(199908);
                    return;
                }
                AppMethodBeat.o(199908);
            } catch (Exception e2) {
                Log.printErrStackTrace(a.TAG, e2, "safeParse error", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                    AppMethodBeat.o(199908);
                    return;
                }
                AppMethodBeat.o(199908);
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.o(199908);
                throw th;
            }
        }
    }

    static {
        AppMethodBeat.i(105500);
        AppMethodBeat.o(105500);
    }

    protected static String d(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(105493);
        p.h(xmlPullParser, "parser");
        String str = "";
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            p.g(str, "parser.text");
            xmlPullParser.nextTag();
        }
        AppMethodBeat.o(105493);
        return str;
    }

    protected static int e(XmlPullParser xmlPullParser) {
        boolean z;
        AppMethodBeat.i(105494);
        p.h(xmlPullParser, "parser");
        String d2 = d(xmlPullParser);
        if (d2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(105494);
            return 0;
        }
        int parseInt = Integer.parseInt(d2);
        AppMethodBeat.o(105494);
        return parseInt;
    }

    protected static String d(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.i(105495);
        p.h(xmlPullParser, "parser");
        p.h(str, "name");
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            attributeValue = "";
        }
        AppMethodBeat.o(105495);
        return attributeValue;
    }

    protected static int e(XmlPullParser xmlPullParser, String str) {
        boolean z;
        AppMethodBeat.i(105496);
        p.h(xmlPullParser, "parser");
        p.h(str, "name");
        String d2 = d(xmlPullParser, str);
        if (d2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(105496);
            return 0;
        }
        int parseInt = Integer.parseInt(d2);
        AppMethodBeat.o(105496);
        return parseInt;
    }

    protected static void skip(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(105497);
        p.h(xmlPullParser, "parser");
        if (xmlPullParser.getEventType() != 2) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(105497);
            throw illegalStateException;
        }
        int i2 = 1;
        while (i2 != 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i2++;
                    break;
                case 3:
                    i2--;
                    break;
            }
        }
        AppMethodBeat.o(105497);
    }

    public void c(XmlPullParser xmlPullParser) {
        String name;
        AppMethodBeat.i(105498);
        p.h(xmlPullParser, "parser");
        while (xmlPullParser.next() != 3 && xmlPullParser.getEventType() != 1) {
            if (xmlPullParser.getEventType() == 2 && (name = xmlPullParser.getName()) != null) {
                a(name, xmlPullParser);
            }
        }
        AppMethodBeat.o(105498);
    }

    /* access modifiers changed from: protected */
    public void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(105499);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        AppMethodBeat.o(105499);
    }
}
