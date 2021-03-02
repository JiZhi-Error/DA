package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0004J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0004J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrLong", "", "readAttrString", "readInt", "readString", "skip", "Companion", "api-handoff_release"})
public class a {
    private static final String TAG = TAG;
    public static final C1431a yhK = new C1431a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "content", "xmlContent", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "api-handoff_release"})
    /* renamed from: com.tencent.mm.plugin.handoff.b.a$a  reason: collision with other inner class name */
    public static final class C1431a {
        private C1431a() {
        }

        public /* synthetic */ C1431a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(238074);
        AppMethodBeat.o(238074);
    }

    protected static String d(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(238067);
        p.h(xmlPullParser, "parser");
        String str = "";
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            p.g(str, "parser.text");
            xmlPullParser.nextTag();
        }
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(238067);
            throw tVar;
        }
        String obj = n.trim(str).toString();
        AppMethodBeat.o(238067);
        return obj;
    }

    protected static int e(XmlPullParser xmlPullParser) {
        boolean z;
        AppMethodBeat.i(238068);
        p.h(xmlPullParser, "parser");
        String d2 = d(xmlPullParser);
        if (d2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(238068);
            return 0;
        }
        int parseInt = Integer.parseInt(d2);
        AppMethodBeat.o(238068);
        return parseInt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0031, code lost:
        if (r0 == null) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static java.lang.String d(org.xmlpull.v1.XmlPullParser r3, java.lang.String r4) {
        /*
            r2 = 238069(0x3a1f5, float:3.33606E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            java.lang.String r0 = "parser"
            kotlin.g.b.p.h(r3, r0)
            java.lang.String r0 = "name"
            kotlin.g.b.p.h(r4, r0)
            r0 = 0
            java.lang.String r0 = r3.getAttributeValue(r0, r4)
            if (r0 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x0027
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0027:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.n.n.trim(r0)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0036
        L_0x0033:
            java.lang.String r0 = ""
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.b.a.d(org.xmlpull.v1.XmlPullParser, java.lang.String):java.lang.String");
    }

    protected static int e(XmlPullParser xmlPullParser, String str) {
        boolean z;
        AppMethodBeat.i(238070);
        p.h(xmlPullParser, "parser");
        p.h(str, "name");
        String d2 = d(xmlPullParser, str);
        if (d2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(238070);
            return 0;
        }
        int parseInt = Integer.parseInt(d2);
        AppMethodBeat.o(238070);
        return parseInt;
    }

    protected static long f(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.i(238071);
        p.h(xmlPullParser, "parser");
        p.h(str, "name");
        String d2 = d(xmlPullParser, str);
        if (d2.length() == 0) {
            AppMethodBeat.o(238071);
            return 0;
        }
        long parseLong = Long.parseLong(d2);
        AppMethodBeat.o(238071);
        return parseLong;
    }

    public void c(XmlPullParser xmlPullParser) {
        String name;
        AppMethodBeat.i(238072);
        p.h(xmlPullParser, "parser");
        while (xmlPullParser.next() != 3 && xmlPullParser.getEventType() != 1) {
            if (xmlPullParser.getEventType() == 2 && (name = xmlPullParser.getName()) != null) {
                a(name, xmlPullParser);
            }
        }
        AppMethodBeat.o(238072);
    }

    /* access modifiers changed from: protected */
    public void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(238073);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        AppMethodBeat.o(238073);
    }
}
