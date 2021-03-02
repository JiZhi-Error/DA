package com.google.android.exoplayer2.f.e;

import android.text.Layout;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.i.y;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends b {
    private static final Pattern bCH = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern bCI = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern bCJ = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern bCK = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C0110a bCL = new C0110a(30.0f, 1, 1);
    private final XmlPullParserFactory bCM;

    @Override // com.google.android.exoplayer2.f.b
    public final /* synthetic */ d b(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(92846);
        e i3 = i(bArr, i2);
        AppMethodBeat.o(92846);
        return i3;
    }

    static {
        AppMethodBeat.i(92847);
        AppMethodBeat.o(92847);
    }

    public a() {
        super("TtmlDecoder");
        AppMethodBeat.i(92838);
        try {
            this.bCM = XmlPullParserFactory.newInstance();
            this.bCM.setNamespaceAware(true);
            AppMethodBeat.o(92838);
        } catch (XmlPullParserException e2) {
            RuntimeException runtimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
            AppMethodBeat.o(92838);
            throw runtimeException;
        }
    }

    private e i(byte[] bArr, int i2) {
        int i3;
        e eVar;
        C0110a aVar;
        boolean z;
        int i4;
        float f2;
        int i5;
        int i6;
        AppMethodBeat.i(92839);
        try {
            XmlPullParser newPullParser = this.bCM.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new c());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), null);
            e eVar2 = null;
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            C0110a aVar2 = bCL;
            int i7 = eventType;
            int i8 = 0;
            while (i7 != 1) {
                b bVar = (b) linkedList.peekLast();
                if (i8 == 0) {
                    String name = newPullParser.getName();
                    if (i7 == 2) {
                        if ("tt".equals(name)) {
                            String attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
                            if (attributeValue != null) {
                                i4 = Integer.parseInt(attributeValue);
                            } else {
                                i4 = 30;
                            }
                            String attributeValue2 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
                            if (attributeValue2 != null) {
                                String[] split = attributeValue2.split(" ");
                                if (split.length != 2) {
                                    f fVar = new f("frameRateMultiplier doesn't have 2 parts");
                                    AppMethodBeat.o(92839);
                                    throw fVar;
                                }
                                f2 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
                            } else {
                                f2 = 1.0f;
                            }
                            int i9 = bCL.bCO;
                            String attributeValue3 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
                            if (attributeValue3 != null) {
                                i5 = Integer.parseInt(attributeValue3);
                            } else {
                                i5 = i9;
                            }
                            int i10 = bCL.tickRate;
                            String attributeValue4 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
                            if (attributeValue4 != null) {
                                i6 = Integer.parseInt(attributeValue4);
                            } else {
                                i6 = i10;
                            }
                            aVar = new C0110a(f2 * ((float) i4), i5, i6);
                        } else {
                            aVar = aVar2;
                        }
                        if (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("smpte:image") || name.equals("smpte:data") || name.equals("smpte:information")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            new StringBuilder("Ignoring unsupported tag: ").append(newPullParser.getName());
                            aVar2 = aVar;
                            i3 = i8 + 1;
                        } else if ("head".equals(name)) {
                            a(newPullParser, hashMap, hashMap2);
                            aVar2 = aVar;
                            i3 = i8;
                        } else {
                            try {
                                b a2 = a(newPullParser, bVar, hashMap2, aVar);
                                linkedList.addLast(a2);
                                if (bVar != null) {
                                    bVar.a(a2);
                                }
                                aVar2 = aVar;
                                i3 = i8;
                            } catch (f e2) {
                                aVar2 = aVar;
                                i3 = i8 + 1;
                            }
                        }
                    } else if (i7 == 4) {
                        bVar.a(new b(null, newPullParser.getText().replaceAll(APLogFileUtil.SEPARATOR_LINE, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, ""));
                        i3 = i8;
                    } else {
                        if (i7 == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                eVar = new e((b) linkedList.getLast(), hashMap, hashMap2);
                            } else {
                                eVar = eVar2;
                            }
                            linkedList.removeLast();
                        } else {
                            eVar = eVar2;
                        }
                        i3 = i8;
                        eVar2 = eVar;
                    }
                } else if (i7 == 2) {
                    i3 = i8 + 1;
                } else if (i7 == 3) {
                    i3 = i8 - 1;
                } else {
                    i3 = i8;
                }
                newPullParser.next();
                i7 = newPullParser.getEventType();
                i8 = i3;
            }
            AppMethodBeat.o(92839);
            return eVar2;
        } catch (XmlPullParserException e3) {
            f fVar2 = new f("Unable to decode source", e3);
            AppMethodBeat.o(92839);
            throw fVar2;
        } catch (IOException e4) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected error when reading input.", e4);
            AppMethodBeat.o(92839);
            throw illegalStateException;
        }
    }

    private static Map<String, d> a(XmlPullParser xmlPullParser, Map<String, d> map, Map<String, c> map2) {
        c a2;
        boolean z;
        AppMethodBeat.i(92840);
        do {
            xmlPullParser.next();
            if (y.b(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                String c2 = y.c(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                d a3 = a(xmlPullParser, new d());
                if (c2 != null) {
                    for (String str : c2.split("\\s+")) {
                        a3.b(map.get(str));
                    }
                }
                if (a3.id != null) {
                    map.put(a3.id, a3);
                }
            } else if (y.b(xmlPullParser, "region") && (a2 = a(xmlPullParser)) != null) {
                map2.put(a2.id, a2);
            }
            if (!(xmlPullParser.getEventType() == 3) || !xmlPullParser.getName().equals("head")) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
        } while (!z);
        AppMethodBeat.o(92840);
        return map;
    }

    private static c a(XmlPullParser xmlPullParser) {
        int i2 = 1;
        AppMethodBeat.i(92841);
        String c2 = y.c(xmlPullParser, "id");
        if (c2 == null) {
            AppMethodBeat.o(92841);
            return null;
        }
        String c3 = y.c(xmlPullParser, FirebaseAnalytics.b.ORIGIN);
        if (c3 != null) {
            Matcher matcher = bCK.matcher(c3);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String c4 = y.c(xmlPullParser, "extent");
                    if (c4 != null) {
                        Matcher matcher2 = bCK.matcher(c4);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String c5 = y.c(xmlPullParser, "displayAlign");
                                if (c5 != null) {
                                    String bH = x.bH(c5);
                                    char c6 = 65535;
                                    switch (bH.hashCode()) {
                                        case -1364013995:
                                            if (bH.equals("center")) {
                                                c6 = 0;
                                                break;
                                            }
                                            break;
                                        case 92734940:
                                            if (bH.equals("after")) {
                                                c6 = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c6) {
                                        case 0:
                                            parseFloat2 += parseFloat4 / 2.0f;
                                            break;
                                        case 1:
                                            i2 = 2;
                                            parseFloat2 += parseFloat4;
                                            break;
                                    }
                                    c cVar = new c(c2, parseFloat, parseFloat2, 0, i2, parseFloat3);
                                    AppMethodBeat.o(92841);
                                    return cVar;
                                }
                                i2 = 0;
                                c cVar2 = new c(c2, parseFloat, parseFloat2, 0, i2, parseFloat3);
                                AppMethodBeat.o(92841);
                                return cVar2;
                            } catch (NumberFormatException e2) {
                                AppMethodBeat.o(92841);
                                return null;
                            }
                        } else {
                            AppMethodBeat.o(92841);
                            return null;
                        }
                    } else {
                        AppMethodBeat.o(92841);
                        return null;
                    }
                } catch (NumberFormatException e3) {
                    AppMethodBeat.o(92841);
                    return null;
                }
            } else {
                AppMethodBeat.o(92841);
                return null;
            }
        } else {
            AppMethodBeat.o(92841);
            return null;
        }
    }

    private static d a(XmlPullParser xmlPullParser, d dVar) {
        Matcher matcher;
        AppMethodBeat.i(92842);
        int attributeCount = xmlPullParser.getAttributeCount();
        d dVar2 = dVar;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            char c2 = 65535;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        dVar2 = a(dVar2);
                        dVar2.id = attributeValue;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    dVar2 = a(dVar2);
                    try {
                        dVar2.eT(e.bv(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        break;
                    }
                case 2:
                    dVar2 = a(dVar2);
                    try {
                        dVar2.eS(e.bv(attributeValue));
                        break;
                    } catch (IllegalArgumentException e3) {
                        break;
                    }
                case 3:
                    d a2 = a(dVar2);
                    com.google.android.exoplayer2.i.a.checkState(a2.bDd == null);
                    a2.fontFamily = attributeValue;
                    dVar2 = a2;
                    break;
                case 4:
                    try {
                        dVar2 = a(dVar2);
                        String[] split = attributeValue.split("\\s+");
                        if (split.length == 1) {
                            matcher = bCJ.matcher(attributeValue);
                        } else if (split.length == 2) {
                            matcher = bCJ.matcher(split[1]);
                        } else {
                            f fVar = new f("Invalid number of entries for fontSize: " + split.length + ".");
                            AppMethodBeat.o(92842);
                            throw fVar;
                        }
                        if (matcher.matches()) {
                            String group = matcher.group(3);
                            char c3 = 65535;
                            switch (group.hashCode()) {
                                case 37:
                                    if (group.equals("%")) {
                                        c3 = 2;
                                        break;
                                    }
                                    break;
                                case 3240:
                                    if (group.equals(UserDataStore.EMAIL)) {
                                        c3 = 1;
                                        break;
                                    }
                                    break;
                                case 3592:
                                    if (group.equals("px")) {
                                        c3 = 0;
                                        break;
                                    }
                                    break;
                            }
                            switch (c3) {
                                case 0:
                                    dVar2.bDc = 1;
                                    break;
                                case 1:
                                    dVar2.bDc = 2;
                                    break;
                                case 2:
                                    dVar2.bDc = 3;
                                    break;
                                default:
                                    f fVar2 = new f("Invalid unit for fontSize: '" + group + "'.");
                                    AppMethodBeat.o(92842);
                                    throw fVar2;
                            }
                            dVar2.fontSize = Float.valueOf(matcher.group(1)).floatValue();
                            break;
                        } else {
                            f fVar3 = new f("Invalid expression for fontSize: '" + attributeValue + "'.");
                            AppMethodBeat.o(92842);
                            throw fVar3;
                        }
                    } catch (f e4) {
                        break;
                    }
                case 5:
                    d a3 = a(dVar2);
                    boolean equalsIgnoreCase = "bold".equalsIgnoreCase(attributeValue);
                    com.google.android.exoplayer2.i.a.checkState(a3.bDd == null);
                    a3.bDa = equalsIgnoreCase ? 1 : 0;
                    dVar2 = a3;
                    break;
                case 6:
                    d a4 = a(dVar2);
                    boolean equalsIgnoreCase2 = "italic".equalsIgnoreCase(attributeValue);
                    com.google.android.exoplayer2.i.a.checkState(a4.bDd == null);
                    a4.bDb = equalsIgnoreCase2 ? 1 : 0;
                    dVar2 = a4;
                    break;
                case 7:
                    String bH = x.bH(attributeValue);
                    char c4 = 65535;
                    switch (bH.hashCode()) {
                        case -1364013995:
                            if (bH.equals("center")) {
                                c4 = 4;
                                break;
                            }
                            break;
                        case 100571:
                            if (bH.equals("end")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case 3317767:
                            if (bH.equals("left")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case 108511772:
                            if (bH.equals("right")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (bH.equals("start")) {
                                c4 = 1;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            dVar2 = a(dVar2);
                            dVar2.bDe = Layout.Alignment.ALIGN_NORMAL;
                            continue;
                        case 1:
                            dVar2 = a(dVar2);
                            dVar2.bDe = Layout.Alignment.ALIGN_NORMAL;
                            continue;
                        case 2:
                            dVar2 = a(dVar2);
                            dVar2.bDe = Layout.Alignment.ALIGN_OPPOSITE;
                            continue;
                        case 3:
                            dVar2 = a(dVar2);
                            dVar2.bDe = Layout.Alignment.ALIGN_OPPOSITE;
                            continue;
                        case 4:
                            dVar2 = a(dVar2);
                            dVar2.bDe = Layout.Alignment.ALIGN_CENTER;
                            continue;
                    }
                case '\b':
                    String bH2 = x.bH(attributeValue);
                    char c5 = 65535;
                    switch (bH2.hashCode()) {
                        case -1461280213:
                            if (bH2.equals("nounderline")) {
                                c5 = 3;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (bH2.equals("underline")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case 913457136:
                            if (bH2.equals("nolinethrough")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (bH2.equals("linethrough")) {
                                c5 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            dVar2 = a(dVar2).aU(true);
                            continue;
                        case 1:
                            dVar2 = a(dVar2).aU(false);
                            continue;
                        case 2:
                            dVar2 = a(dVar2).aV(true);
                            continue;
                        case 3:
                            dVar2 = a(dVar2).aV(false);
                            continue;
                    }
            }
        }
        AppMethodBeat.o(92842);
        return dVar2;
    }

    private static d a(d dVar) {
        AppMethodBeat.i(92843);
        if (dVar == null) {
            d dVar2 = new d();
            AppMethodBeat.o(92843);
            return dVar2;
        }
        AppMethodBeat.o(92843);
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.f.e.b a(org.xmlpull.v1.XmlPullParser r17, com.google.android.exoplayer2.f.e.b r18, java.util.Map<java.lang.String, com.google.android.exoplayer2.f.e.c> r19, com.google.android.exoplayer2.f.e.a.C0110a r20) {
        /*
        // Method dump skipped, instructions count: 308
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.e.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.f.e.b, java.util.Map, com.google.android.exoplayer2.f.e.a$a):com.google.android.exoplayer2.f.e.b");
    }

    private static long a(String str, C0110a aVar) {
        double d2;
        double d3 = 0.0d;
        AppMethodBeat.i(92845);
        Matcher matcher = bCH.matcher(str);
        if (matcher.matches()) {
            double parseLong = ((double) Long.parseLong(matcher.group(3))) + ((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60));
            String group = matcher.group(4);
            double parseDouble = parseLong + (group != null ? Double.parseDouble(group) : 0.0d);
            String group2 = matcher.group(5);
            if (group2 != null) {
                d2 = (double) (((float) Long.parseLong(group2)) / aVar.bCN);
            } else {
                d2 = 0.0d;
            }
            double d4 = d2 + parseDouble;
            String group3 = matcher.group(6);
            if (group3 != null) {
                d3 = (((double) Long.parseLong(group3)) / ((double) aVar.bCO)) / ((double) aVar.bCN);
            }
            long j2 = (long) ((d4 + d3) * 1000000.0d);
            AppMethodBeat.o(92845);
            return j2;
        }
        Matcher matcher2 = bCI.matcher(str);
        if (matcher2.matches()) {
            double parseDouble2 = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            char c2 = 65535;
            switch (group4.hashCode()) {
                case 102:
                    if (group4.equals("f")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group4.equals("h")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group4.equals("m")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group4.equals("s")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group4.equals("t")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group4.equals(LocaleUtil.MALAY)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    parseDouble2 *= 3600.0d;
                    break;
                case 1:
                    parseDouble2 *= 60.0d;
                    break;
                case 3:
                    parseDouble2 /= 1000.0d;
                    break;
                case 4:
                    parseDouble2 /= (double) aVar.bCN;
                    break;
                case 5:
                    parseDouble2 /= (double) aVar.tickRate;
                    break;
            }
            long j3 = (long) (parseDouble2 * 1000000.0d);
            AppMethodBeat.o(92845);
            return j3;
        }
        f fVar = new f("Malformed time expression: ".concat(String.valueOf(str)));
        AppMethodBeat.o(92845);
        throw fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.f.e.a$a  reason: collision with other inner class name */
    public static final class C0110a {
        final float bCN;
        final int bCO;
        final int tickRate;

        C0110a(float f2, int i2, int i3) {
            this.bCN = f2;
            this.bCO = i2;
            this.tickRate = i3;
        }
    }
}
