package com.a.a;

import android.graphics.Matrix;
import android.support.constraint.ConstraintLayout;
import android.util.Xml;
import com.a.a.b;
import com.a.a.f;
import com.a.a.h;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* access modifiers changed from: package-private */
public final class l {
    private h aTM = null;
    private h.aj aTN = null;
    private boolean aTO = false;
    private int aTP;
    private boolean aTQ = false;
    private g aTR = null;
    private StringBuilder aTS = null;
    private boolean aTT = false;
    private StringBuilder aTU = null;

    l() {
    }

    /* access modifiers changed from: package-private */
    public enum g {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;
        
        private static final Map<String, g> aNT = new HashMap();

        public static g valueOf(String str) {
            AppMethodBeat.i(206669);
            g gVar = (g) Enum.valueOf(g.class, str);
            AppMethodBeat.o(206669);
            return gVar;
        }

        static {
            AppMethodBeat.i(206671);
            g[] values = values();
            for (g gVar : values) {
                if (gVar == SWITCH) {
                    aNT.put("switch", gVar);
                } else if (gVar != UNSUPPORTED) {
                    aNT.put(gVar.name(), gVar);
                }
            }
            AppMethodBeat.o(206671);
        }

        public static g aN(String str) {
            AppMethodBeat.i(206670);
            g gVar = aNT.get(str);
            if (gVar != null) {
                AppMethodBeat.o(206670);
                return gVar;
            }
            g gVar2 = UNSUPPORTED;
            AppMethodBeat.o(206670);
            return gVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public enum f {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;
        
        private static final Map<String, f> aNT = new HashMap();

        public static f valueOf(String str) {
            AppMethodBeat.i(206665);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(206665);
            return fVar;
        }

        static {
            AppMethodBeat.i(206667);
            f[] values = values();
            for (f fVar : values) {
                if (fVar == CLASS) {
                    aNT.put("class", fVar);
                } else if (fVar != UNSUPPORTED) {
                    aNT.put(fVar.name().replace('_', '-'), fVar);
                }
            }
            AppMethodBeat.o(206667);
        }

        public static f aM(String str) {
            AppMethodBeat.i(206666);
            f fVar = aNT.get(str);
            if (fVar != null) {
                AppMethodBeat.o(206666);
                return fVar;
            }
            f fVar2 = UNSUPPORTED;
            AppMethodBeat.o(206666);
            return fVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        private static final Map<String, Integer> aTY;

        static {
            AppMethodBeat.i(206654);
            HashMap hashMap = new HashMap(47);
            aTY = hashMap;
            hashMap.put("aliceblue", -984833);
            aTY.put("antiquewhite", -332841);
            aTY.put("aqua", -16711681);
            aTY.put("aquamarine", -8388652);
            aTY.put("azure", -983041);
            aTY.put("beige", -657956);
            aTY.put("bisque", -6972);
            aTY.put("black", Integer.valueOf((int) WebView.NIGHT_MODE_COLOR));
            aTY.put("blanchedalmond", -5171);
            aTY.put("blue", -16776961);
            aTY.put("blueviolet", -7722014);
            aTY.put("brown", -5952982);
            aTY.put("burlywood", -2180985);
            aTY.put("cadetblue", -10510688);
            aTY.put("chartreuse", -8388864);
            aTY.put("chocolate", -2987746);
            aTY.put("coral", -32944);
            aTY.put("cornflowerblue", -10185235);
            aTY.put("cornsilk", -1828);
            aTY.put("crimson", -2354116);
            aTY.put("cyan", -16711681);
            aTY.put("darkblue", -16777077);
            aTY.put("darkcyan", -16741493);
            aTY.put("darkgoldenrod", -4684277);
            aTY.put("darkgray", -5658199);
            aTY.put("darkgreen", -16751616);
            aTY.put("darkgrey", -5658199);
            aTY.put("darkkhaki", -4343957);
            aTY.put("darkmagenta", -7667573);
            aTY.put("darkolivegreen", -11179217);
            aTY.put("darkorange", -29696);
            aTY.put("darkorchid", -6737204);
            aTY.put("darkred", -7667712);
            aTY.put("darksalmon", -1468806);
            aTY.put("darkseagreen", -7357297);
            aTY.put("darkslateblue", -12042869);
            aTY.put("darkslategray", -13676721);
            aTY.put("darkslategrey", -13676721);
            aTY.put("darkturquoise", -16724271);
            aTY.put("darkviolet", -7077677);
            aTY.put("deeppink", -60269);
            aTY.put("deepskyblue", -16728065);
            aTY.put("dimgray", -9868951);
            aTY.put("dimgrey", -9868951);
            aTY.put("dodgerblue", -14774017);
            aTY.put("firebrick", -5103070);
            aTY.put("floralwhite", -1296);
            aTY.put("forestgreen", -14513374);
            aTY.put("fuchsia", -65281);
            aTY.put("gainsboro", -2302756);
            aTY.put("ghostwhite", -460545);
            aTY.put("gold", -10496);
            aTY.put("goldenrod", -2448096);
            aTY.put("gray", -8355712);
            aTY.put("green", -16744448);
            aTY.put("greenyellow", -5374161);
            aTY.put("grey", -8355712);
            aTY.put("honeydew", -983056);
            aTY.put("hotpink", -38476);
            aTY.put("indianred", -3318692);
            aTY.put("indigo", -11861886);
            aTY.put("ivory", -16);
            aTY.put("khaki", -989556);
            aTY.put("lavender", -1644806);
            aTY.put("lavenderblush", -3851);
            aTY.put("lawngreen", -8586240);
            aTY.put("lemonchiffon", -1331);
            aTY.put("lightblue", -5383962);
            aTY.put("lightcoral", -1015680);
            aTY.put("lightcyan", -2031617);
            aTY.put("lightgoldenrodyellow", -329006);
            aTY.put("lightgray", -2894893);
            aTY.put("lightgreen", -7278960);
            aTY.put("lightgrey", -2894893);
            aTY.put("lightpink", -18751);
            aTY.put("lightsalmon", -24454);
            aTY.put("lightseagreen", -14634326);
            aTY.put("lightskyblue", -7876870);
            aTY.put("lightslategray", -8943463);
            aTY.put("lightslategrey", -8943463);
            aTY.put("lightsteelblue", -5192482);
            aTY.put("lightyellow", -32);
            aTY.put("lime", -16711936);
            aTY.put("limegreen", -13447886);
            aTY.put("linen", -331546);
            aTY.put("magenta", -65281);
            aTY.put("maroon", -8388608);
            aTY.put("mediumaquamarine", -10039894);
            aTY.put("mediumblue", -16777011);
            aTY.put("mediumorchid", -4565549);
            aTY.put("mediumpurple", -7114533);
            aTY.put("mediumseagreen", -12799119);
            aTY.put("mediumslateblue", -8689426);
            aTY.put("mediumspringgreen", -16713062);
            aTY.put("mediumturquoise", -12004916);
            aTY.put("mediumvioletred", -3730043);
            aTY.put("midnightblue", -15132304);
            aTY.put("mintcream", -655366);
            aTY.put("mistyrose", -6943);
            aTY.put("moccasin", -6987);
            aTY.put("navajowhite", -8531);
            aTY.put("navy", -16777088);
            aTY.put("oldlace", -133658);
            aTY.put("olive", -8355840);
            aTY.put("olivedrab", -9728477);
            aTY.put("orange", -23296);
            aTY.put("orangered", -47872);
            aTY.put("orchid", -2461482);
            aTY.put("palegoldenrod", -1120086);
            aTY.put("palegreen", -6751336);
            aTY.put("paleturquoise", -5247250);
            aTY.put("palevioletred", -2396013);
            aTY.put("papayawhip", -4139);
            aTY.put("peachpuff", -9543);
            aTY.put("peru", -3308225);
            aTY.put("pink", -16181);
            aTY.put("plum", -2252579);
            aTY.put("powderblue", -5185306);
            aTY.put("purple", -8388480);
            aTY.put("rebeccapurple", -10079335);
            aTY.put("red", -65536);
            aTY.put("rosybrown", -4419697);
            aTY.put("royalblue", -12490271);
            aTY.put("saddlebrown", -7650029);
            aTY.put("salmon", -360334);
            aTY.put("sandybrown", -744352);
            aTY.put("seagreen", -13726889);
            aTY.put("seashell", -2578);
            aTY.put("sienna", -6270419);
            aTY.put("silver", -4144960);
            aTY.put("skyblue", -7876885);
            aTY.put("slateblue", -9807155);
            aTY.put("slategray", -9404272);
            aTY.put("slategrey", -9404272);
            aTY.put("snow", -1286);
            aTY.put("springgreen", -16711809);
            aTY.put("steelblue", -12156236);
            aTY.put("tan", -2968436);
            aTY.put("teal", -16744320);
            aTY.put("thistle", -2572328);
            aTY.put("tomato", -40121);
            aTY.put("turquoise", -12525360);
            aTY.put("violet", -1146130);
            aTY.put("wheat", -663885);
            aTY.put("white", -1);
            aTY.put("whitesmoke", -657931);
            aTY.put("yellow", -256);
            aTY.put("yellowgreen", -6632142);
            aTY.put("transparent", 0);
            AppMethodBeat.o(206654);
        }

        static Integer aK(String str) {
            AppMethodBeat.i(206653);
            Integer num = aTY.get(str);
            AppMethodBeat.o(206653);
            return num;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        private static final Map<String, h.p> aTZ;

        static {
            AppMethodBeat.i(206656);
            HashMap hashMap = new HashMap(9);
            aTZ = hashMap;
            hashMap.put("xx-small", new h.p(0.694f, h.bd.pt));
            aTZ.put("x-small", new h.p(0.833f, h.bd.pt));
            aTZ.put("small", new h.p(10.0f, h.bd.pt));
            aTZ.put(FirebaseAnalytics.b.MEDIUM, new h.p(12.0f, h.bd.pt));
            aTZ.put("large", new h.p(14.4f, h.bd.pt));
            aTZ.put("x-large", new h.p(17.3f, h.bd.pt));
            aTZ.put("xx-large", new h.p(20.7f, h.bd.pt));
            aTZ.put("smaller", new h.p(83.33f, h.bd.percent));
            aTZ.put("larger", new h.p(120.0f, h.bd.percent));
            AppMethodBeat.o(206656);
        }

        static h.p aL(String str) {
            AppMethodBeat.i(206655);
            h.p pVar = aTZ.get(str);
            AppMethodBeat.o(206655);
            return pVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        private static final Map<String, Integer> aUa;

        static {
            AppMethodBeat.i(206658);
            HashMap hashMap = new HashMap(13);
            aUa = hashMap;
            hashMap.put("normal", 400);
            aUa.put("bold", 700);
            aUa.put("bolder", 1);
            aUa.put("lighter", -1);
            aUa.put("100", 100);
            aUa.put("200", 200);
            aUa.put("300", 300);
            aUa.put("400", 400);
            aUa.put("500", 500);
            aUa.put("600", 600);
            aUa.put("700", 700);
            aUa.put("800", 800);
            aUa.put("900", Integer.valueOf((int) TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR));
            AppMethodBeat.o(206658);
        }

        static Integer aK(String str) {
            AppMethodBeat.i(206657);
            Integer num = aUa.get(str);
            AppMethodBeat.o(206657);
            return num;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final Map<String, f.a> aTX;

        static {
            AppMethodBeat.i(206652);
            HashMap hashMap = new HashMap(10);
            aTX = hashMap;
            hashMap.put("none", f.a.none);
            aTX.put("xMinYMin", f.a.xMinYMin);
            aTX.put("xMidYMin", f.a.xMidYMin);
            aTX.put("xMaxYMin", f.a.xMaxYMin);
            aTX.put("xMinYMid", f.a.xMinYMid);
            aTX.put("xMidYMid", f.a.xMidYMid);
            aTX.put("xMaxYMid", f.a.xMaxYMid);
            aTX.put("xMinYMax", f.a.xMinYMax);
            aTX.put("xMidYMax", f.a.xMidYMax);
            aTX.put("xMaxYMax", f.a.xMaxYMax);
            AppMethodBeat.o(206652);
        }

        static f.a aJ(String str) {
            AppMethodBeat.i(206651);
            f.a aVar = aTX.get(str);
            AppMethodBeat.o(206651);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final h a(InputStream inputStream, boolean z) {
        InputStream inputStream2;
        h hVar;
        InputStream inputStream3;
        AppMethodBeat.i(206701);
        if (!inputStream.markSupported()) {
            inputStream2 = new BufferedInputStream(inputStream);
        } else {
            inputStream2 = inputStream;
        }
        try {
            inputStream2.mark(3);
            int read = inputStream2.read() + (inputStream2.read() << 8);
            inputStream2.reset();
            if (read == 35615) {
                inputStream3 = new BufferedInputStream(new GZIPInputStream(inputStream2));
            } else {
                inputStream3 = inputStream2;
            }
            inputStream2 = inputStream3;
        } catch (IOException e2) {
        }
        if (z) {
            try {
                inputStream2.mark(4096);
                byte[] bArr = new byte[4096];
                String str = new String(bArr, 0, inputStream2.read(bArr));
                inputStream2.reset();
                if (str.indexOf("<!ENTITY ") >= 0) {
                    try {
                        SAXParserFactory newInstance = SAXParserFactory.newInstance();
                        newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
                        newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
                        XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
                        e eVar = new e(this, (byte) 0);
                        xMLReader.setContentHandler(eVar);
                        xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", eVar);
                        xMLReader.parse(new InputSource(inputStream2));
                        hVar = this.aTM;
                        try {
                            inputStream2.close();
                        } catch (IOException e3) {
                        }
                        AppMethodBeat.o(206701);
                        return hVar;
                    } catch (ParserConfigurationException e4) {
                        k kVar = new k("XML parser problem", e4);
                        AppMethodBeat.o(206701);
                        throw kVar;
                    } catch (SAXException e5) {
                        k kVar2 = new k("SVG parse error", e5);
                        AppMethodBeat.o(206701);
                        throw kVar2;
                    } catch (IOException e6) {
                        k kVar3 = new k("Stream error", e6);
                        AppMethodBeat.o(206701);
                        throw kVar3;
                    }
                }
            } catch (IOException e7) {
                g(inputStream2);
                hVar = this.aTM;
                try {
                    inputStream2.close();
                } catch (IOException e8) {
                }
                AppMethodBeat.o(206701);
            } catch (Throwable th) {
                try {
                    inputStream2.close();
                } catch (IOException e9) {
                }
                AppMethodBeat.o(206701);
                throw th;
            }
        }
        g(inputStream2);
        hVar = this.aTM;
        try {
            inputStream2.close();
        } catch (IOException e10) {
        }
        AppMethodBeat.o(206701);
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public class i implements Attributes {
        private XmlPullParser aWB;

        public i(XmlPullParser xmlPullParser) {
            this.aWB = xmlPullParser;
        }

        public final int getLength() {
            AppMethodBeat.i(206696);
            int attributeCount = this.aWB.getAttributeCount();
            AppMethodBeat.o(206696);
            return attributeCount;
        }

        public final String getURI(int i2) {
            AppMethodBeat.i(206697);
            String attributeNamespace = this.aWB.getAttributeNamespace(i2);
            AppMethodBeat.o(206697);
            return attributeNamespace;
        }

        public final String getLocalName(int i2) {
            AppMethodBeat.i(206698);
            String attributeName = this.aWB.getAttributeName(i2);
            AppMethodBeat.o(206698);
            return attributeName;
        }

        public final String getQName(int i2) {
            AppMethodBeat.i(206699);
            String attributeName = this.aWB.getAttributeName(i2);
            if (this.aWB.getAttributePrefix(i2) != null) {
                attributeName = this.aWB.getAttributePrefix(i2) + ':' + attributeName;
            }
            AppMethodBeat.o(206699);
            return attributeName;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(int i2) {
            AppMethodBeat.i(206700);
            String attributeValue = this.aWB.getAttributeValue(i2);
            AppMethodBeat.o(206700);
            return attributeValue;
        }

        @Override // org.xml.sax.Attributes
        public final String getType(int i2) {
            return null;
        }

        public final int getIndex(String str, String str2) {
            return -1;
        }

        public final int getIndex(String str) {
            return -1;
        }

        public final String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getType(String str) {
            return null;
        }

        public final String getValue(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String str) {
            return null;
        }
    }

    private void g(InputStream inputStream) {
        AppMethodBeat.i(206702);
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            i iVar = new i(newPullParser);
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            newPullParser.setInput(inputStream, null);
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                switch (eventType) {
                    case 0:
                        startDocument();
                        break;
                    case 2:
                        String name = newPullParser.getName();
                        if (newPullParser.getPrefix() != null) {
                            name = newPullParser.getPrefix() + ':' + name;
                        }
                        startElement(newPullParser.getNamespace(), newPullParser.getName(), name, iVar);
                        break;
                    case 3:
                        String name2 = newPullParser.getName();
                        if (newPullParser.getPrefix() != null) {
                            name2 = newPullParser.getPrefix() + ':' + name2;
                        }
                        endElement(newPullParser.getNamespace(), newPullParser.getName(), name2);
                        break;
                    case 4:
                        int[] iArr = new int[2];
                        char[] textCharacters = newPullParser.getTextCharacters(iArr);
                        int i2 = iArr[0];
                        int i3 = iArr[1];
                        if (!this.aTO) {
                            if (!this.aTQ) {
                                if (!this.aTT) {
                                    if (this.aTN instanceof h.ay) {
                                        ad(new String(textCharacters, i2, i3));
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    if (this.aTU == null) {
                                        this.aTU = new StringBuilder(i3);
                                    }
                                    this.aTU.append(textCharacters, i2, i3);
                                    break;
                                }
                            } else {
                                if (this.aTS == null) {
                                    this.aTS = new StringBuilder(i3);
                                }
                                this.aTS.append(textCharacters, i2, i3);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 5:
                        text(newPullParser.getText());
                        break;
                    case 8:
                        h hVar = new h(newPullParser.getText());
                        b(hVar.nextToken(), a(hVar));
                        break;
                }
            }
            AppMethodBeat.o(206702);
        } catch (XmlPullParserException e2) {
            k kVar = new k("XML parser problem", e2);
            AppMethodBeat.o(206702);
            throw kVar;
        } catch (IOException e3) {
            k kVar2 = new k("Stream error", e3);
            AppMethodBeat.o(206702);
            throw kVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends DefaultHandler2 {
        private e() {
        }

        /* synthetic */ e(l lVar, byte b2) {
            this();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startDocument() {
            AppMethodBeat.i(206659);
            l.this.startDocument();
            AppMethodBeat.o(206659);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startElement(String str, String str2, String str3, Attributes attributes) {
            AppMethodBeat.i(206660);
            l.this.startElement(str, str2, str3, attributes);
            AppMethodBeat.o(206660);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void characters(char[] cArr, int i2, int i3) {
            AppMethodBeat.i(206661);
            l.this.text(new String(cArr, i2, i3));
            AppMethodBeat.o(206661);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endElement(String str, String str2, String str3) {
            AppMethodBeat.i(206662);
            l.this.endElement(str, str2, str3);
            AppMethodBeat.o(206662);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endDocument() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void processingInstruction(String str, String str2) {
            AppMethodBeat.i(206663);
            l.b(str, l.a(new h(str2)));
            AppMethodBeat.o(206663);
        }
    }

    /* access modifiers changed from: package-private */
    public final void startDocument() {
        AppMethodBeat.i(206703);
        this.aTM = new h();
        AppMethodBeat.o(206703);
    }

    /* access modifiers changed from: package-private */
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        AppMethodBeat.i(206704);
        if (this.aTO) {
            this.aTP++;
            AppMethodBeat.o(206704);
        } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            g aN = g.aN(str2);
            switch (aN) {
                case svg:
                    a(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case g:
                    b(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case defs:
                    c(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case a:
                    d(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case use:
                    e(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case path:
                    g(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case rect:
                    h(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case circle:
                    i(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case ellipse:
                    j(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case line:
                    k(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case polyline:
                    l(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case polygon:
                    m(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case text:
                    n(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case tspan:
                    o(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case tref:
                    p(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case SWITCH:
                    q(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case symbol:
                    r(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case marker:
                    s(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case linearGradient:
                    t(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case radialGradient:
                    u(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case stop:
                    v(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case title:
                case desc:
                    this.aTQ = true;
                    this.aTR = aN;
                    AppMethodBeat.o(206704);
                    return;
                case clipPath:
                    x(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case textPath:
                    y(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case pattern:
                    z(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case image:
                    f(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case view:
                    A(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case mask:
                    B(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case style:
                    C(attributes);
                    AppMethodBeat.o(206704);
                    return;
                case solidColor:
                    w(attributes);
                    AppMethodBeat.o(206704);
                    return;
                default:
                    this.aTO = true;
                    this.aTP = 1;
                    AppMethodBeat.o(206704);
                    return;
            }
        } else {
            AppMethodBeat.o(206704);
        }
    }

    /* access modifiers changed from: package-private */
    public final void text(String str) {
        AppMethodBeat.i(206705);
        if (this.aTO) {
            AppMethodBeat.o(206705);
        } else if (this.aTQ) {
            if (this.aTS == null) {
                this.aTS = new StringBuilder(str.length());
            }
            this.aTS.append(str);
            AppMethodBeat.o(206705);
        } else if (this.aTT) {
            if (this.aTU == null) {
                this.aTU = new StringBuilder(str.length());
            }
            this.aTU.append(str);
            AppMethodBeat.o(206705);
        } else {
            if (this.aTN instanceof h.ay) {
                ad(str);
            }
            AppMethodBeat.o(206705);
        }
    }

    private void ad(String str) {
        AppMethodBeat.i(206706);
        h.ah ahVar = (h.ah) this.aTN;
        int size = ahVar.aQz.size();
        h.an anVar = size == 0 ? null : ahVar.aQz.get(size - 1);
        if (anVar instanceof h.bc) {
            h.bc bcVar = (h.bc) anVar;
            bcVar.text += str;
            AppMethodBeat.o(206706);
            return;
        }
        this.aTN.a(new h.bc(str));
        AppMethodBeat.o(206706);
    }

    /* access modifiers changed from: package-private */
    public final void endElement(String str, String str2, String str3) {
        AppMethodBeat.i(206707);
        if (this.aTO) {
            int i2 = this.aTP - 1;
            this.aTP = i2;
            if (i2 == 0) {
                this.aTO = false;
            }
            AppMethodBeat.o(206707);
        } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            switch (g.aN(str2)) {
                case svg:
                case g:
                case defs:
                case a:
                case use:
                case text:
                case tspan:
                case SWITCH:
                case symbol:
                case marker:
                case linearGradient:
                case radialGradient:
                case stop:
                case clipPath:
                case textPath:
                case pattern:
                case image:
                case view:
                case mask:
                case solidColor:
                    if (this.aTN != null) {
                        this.aTN = ((h.an) this.aTN).aSP;
                        break;
                    } else {
                        k kVar = new k(String.format("Unbalanced end element </%s> found", str2));
                        AppMethodBeat.o(206707);
                        throw kVar;
                    }
                case title:
                case desc:
                    this.aTQ = false;
                    if (this.aTS != null) {
                        if (this.aTR == g.title) {
                            this.aTM.title = this.aTS.toString();
                        } else if (this.aTR == g.desc) {
                            this.aTM.desc = this.aTS.toString();
                        }
                        this.aTS.setLength(0);
                    }
                    AppMethodBeat.o(206707);
                    return;
                case style:
                    if (this.aTU != null) {
                        this.aTT = false;
                        aI(this.aTU.toString());
                        this.aTU.setLength(0);
                        AppMethodBeat.o(206707);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(206707);
        } else {
            AppMethodBeat.o(206707);
        }
    }

    static void b(String str, Map<String, String> map) {
        AppMethodBeat.i(206708);
        if (str.equals("xml-stylesheet") && h.qQ() != null) {
            if (map.get("type") != null && !"text/css".equals(map.get("type"))) {
                AppMethodBeat.o(206708);
                return;
            } else if (map.get("alternate") != null && !"no".equals(map.get("alternate"))) {
                AppMethodBeat.o(206708);
                return;
            } else if (map.get(ShareConstants.WEB_DIALOG_PARAM_HREF) != null) {
                h.qQ();
                AppMethodBeat.o(206708);
                return;
            }
        }
        AppMethodBeat.o(206708);
    }

    static Map<String, String> a(h hVar) {
        AppMethodBeat.i(206709);
        HashMap hashMap = new HashMap();
        hVar.rs();
        String c2 = hVar.c('=');
        while (c2 != null) {
            hVar.b('=');
            hashMap.put(c2, hVar.rE());
            hVar.rs();
            c2 = hVar.c('=');
        }
        AppMethodBeat.o(206709);
        return hashMap;
    }

    private void a(Attributes attributes) {
        AppMethodBeat.i(206710);
        h.af afVar = new h.af();
        afVar.aSO = this.aTM;
        afVar.aSP = this.aTN;
        a((h.al) afVar, attributes);
        b(afVar, attributes);
        a((h.ag) afVar, attributes);
        a((h.ar) afVar, attributes);
        a(afVar, attributes);
        if (this.aTN == null) {
            this.aTM.aQf = afVar;
        } else {
            this.aTN.a(afVar);
        }
        this.aTN = afVar;
        AppMethodBeat.o(206710);
    }

    private static void a(h.af afVar, Attributes attributes) {
        AppMethodBeat.i(206711);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x:
                    afVar.aQH = ag(trim);
                    break;
                case y:
                    afVar.aQI = ag(trim);
                    break;
                case width:
                    afVar.aQJ = ag(trim);
                    if (!afVar.aQJ.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <svg> element. width cannot be negative");
                        AppMethodBeat.o(206711);
                        throw kVar;
                    }
                case height:
                    afVar.aQK = ag(trim);
                    if (!afVar.aQK.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <svg> element. height cannot be negative");
                        AppMethodBeat.o(206711);
                        throw kVar2;
                    }
                case version:
                    afVar.version = trim;
                    break;
            }
        }
        AppMethodBeat.o(206711);
    }

    private void b(Attributes attributes) {
        AppMethodBeat.i(206712);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206712);
            throw kVar;
        }
        h.m mVar = new h.m();
        mVar.aSO = this.aTM;
        mVar.aSP = this.aTN;
        a((h.al) mVar, attributes);
        b(mVar, attributes);
        a((h.n) mVar, attributes);
        a((h.ag) mVar, attributes);
        this.aTN.a(mVar);
        this.aTN = mVar;
        AppMethodBeat.o(206712);
    }

    private void c(Attributes attributes) {
        AppMethodBeat.i(206713);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206713);
            throw kVar;
        }
        h.C0058h hVar = new h.C0058h();
        hVar.aSO = this.aTM;
        hVar.aSP = this.aTN;
        a((h.al) hVar, attributes);
        b(hVar, attributes);
        a((h.n) hVar, attributes);
        this.aTN.a(hVar);
        this.aTN = hVar;
        AppMethodBeat.o(206713);
    }

    private void d(Attributes attributes) {
        AppMethodBeat.i(206714);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206714);
            throw kVar;
        }
        h.a aVar = new h.a();
        aVar.aSO = this.aTM;
        aVar.aSP = this.aTN;
        a((h.al) aVar, attributes);
        b(aVar, attributes);
        a((h.n) aVar, attributes);
        a((h.ag) aVar, attributes);
        a(aVar, attributes);
        this.aTN.a(aVar);
        this.aTN = aVar;
        AppMethodBeat.o(206714);
    }

    private static void a(h.a aVar, Attributes attributes) {
        AppMethodBeat.i(206715);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        aVar.aQk = trim;
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(206715);
    }

    private void e(Attributes attributes) {
        AppMethodBeat.i(206716);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206716);
            throw kVar;
        }
        h.be beVar = new h.be();
        beVar.aSO = this.aTM;
        beVar.aSP = this.aTN;
        a((h.al) beVar, attributes);
        b(beVar, attributes);
        a((h.n) beVar, attributes);
        a((h.ag) beVar, attributes);
        a(beVar, attributes);
        this.aTN.a(beVar);
        this.aTN = beVar;
        AppMethodBeat.o(206716);
    }

    private static void a(h.be beVar, Attributes attributes) {
        AppMethodBeat.i(206717);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x:
                    beVar.aQH = ag(trim);
                    break;
                case y:
                    beVar.aQI = ag(trim);
                    break;
                case width:
                    beVar.aQJ = ag(trim);
                    if (!beVar.aQJ.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <use> element. width cannot be negative");
                        AppMethodBeat.o(206717);
                        throw kVar;
                    }
                case height:
                    beVar.aQK = ag(trim);
                    if (!beVar.aQK.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <use> element. height cannot be negative");
                        AppMethodBeat.o(206717);
                        throw kVar2;
                    }
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        beVar.aQk = trim;
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(206717);
    }

    private void f(Attributes attributes) {
        AppMethodBeat.i(206718);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206718);
            throw kVar;
        }
        h.o oVar = new h.o();
        oVar.aSO = this.aTM;
        oVar.aSP = this.aTN;
        a((h.al) oVar, attributes);
        b(oVar, attributes);
        a((h.n) oVar, attributes);
        a((h.ag) oVar, attributes);
        a(oVar, attributes);
        this.aTN.a(oVar);
        this.aTN = oVar;
        AppMethodBeat.o(206718);
    }

    private static void a(h.o oVar, Attributes attributes) {
        AppMethodBeat.i(206719);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x:
                    oVar.aQH = ag(trim);
                    break;
                case y:
                    oVar.aQI = ag(trim);
                    break;
                case width:
                    oVar.aQJ = ag(trim);
                    if (!oVar.aQJ.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <use> element. width cannot be negative");
                        AppMethodBeat.o(206719);
                        throw kVar;
                    }
                case height:
                    oVar.aQK = ag(trim);
                    if (!oVar.aQK.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <use> element. height cannot be negative");
                        AppMethodBeat.o(206719);
                        throw kVar2;
                    }
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        oVar.aQk = trim;
                        break;
                    }
                    break;
                case preserveAspectRatio:
                    a((h.ap) oVar, trim);
                    break;
            }
        }
        AppMethodBeat.o(206719);
    }

    private void g(Attributes attributes) {
        AppMethodBeat.i(206720);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206720);
            throw kVar;
        }
        h.v vVar = new h.v();
        vVar.aSO = this.aTM;
        vVar.aSP = this.aTN;
        a((h.al) vVar, attributes);
        b(vVar, attributes);
        a((h.n) vVar, attributes);
        a((h.ag) vVar, attributes);
        a(vVar, attributes);
        this.aTN.a(vVar);
        AppMethodBeat.o(206720);
    }

    private static void a(h.v vVar, Attributes attributes) {
        AppMethodBeat.i(206721);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case d:
                    vVar.aQZ = aD(trim);
                    break;
                case pathLength:
                    vVar.aRa = Float.valueOf(parseFloat(trim));
                    if (vVar.aRa.floatValue() >= 0.0f) {
                        break;
                    } else {
                        k kVar = new k("Invalid <path> element. pathLength cannot be negative");
                        AppMethodBeat.o(206721);
                        throw kVar;
                    }
            }
        }
        AppMethodBeat.o(206721);
    }

    private void h(Attributes attributes) {
        AppMethodBeat.i(206722);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206722);
            throw kVar;
        }
        h.ab abVar = new h.ab();
        abVar.aSO = this.aTM;
        abVar.aSP = this.aTN;
        a((h.al) abVar, attributes);
        b(abVar, attributes);
        a((h.n) abVar, attributes);
        a((h.ag) abVar, attributes);
        a(abVar, attributes);
        this.aTN.a(abVar);
        AppMethodBeat.o(206722);
    }

    private static void a(h.ab abVar, Attributes attributes) {
        AppMethodBeat.i(206723);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x:
                    abVar.aQH = ag(trim);
                    break;
                case y:
                    abVar.aQI = ag(trim);
                    break;
                case width:
                    abVar.aQJ = ag(trim);
                    if (!abVar.aQJ.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <rect> element. width cannot be negative");
                        AppMethodBeat.o(206723);
                        throw kVar;
                    }
                case height:
                    abVar.aQK = ag(trim);
                    if (!abVar.aQK.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <rect> element. height cannot be negative");
                        AppMethodBeat.o(206723);
                        throw kVar2;
                    }
                case rx:
                    abVar.aQx = ag(trim);
                    if (!abVar.aQx.isNegative()) {
                        break;
                    } else {
                        k kVar3 = new k("Invalid <rect> element. rx cannot be negative");
                        AppMethodBeat.o(206723);
                        throw kVar3;
                    }
                case ry:
                    abVar.aQy = ag(trim);
                    if (!abVar.aQy.isNegative()) {
                        break;
                    } else {
                        k kVar4 = new k("Invalid <rect> element. ry cannot be negative");
                        AppMethodBeat.o(206723);
                        throw kVar4;
                    }
            }
        }
        AppMethodBeat.o(206723);
    }

    private void i(Attributes attributes) {
        AppMethodBeat.i(206724);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206724);
            throw kVar;
        }
        h.d dVar = new h.d();
        dVar.aSO = this.aTM;
        dVar.aSP = this.aTN;
        a((h.al) dVar, attributes);
        b(dVar, attributes);
        a((h.n) dVar, attributes);
        a((h.ag) dVar, attributes);
        a(dVar, attributes);
        this.aTN.a(dVar);
        AppMethodBeat.o(206724);
    }

    private static void a(h.d dVar, Attributes attributes) {
        AppMethodBeat.i(206725);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case cx:
                    dVar.aQp = ag(trim);
                    break;
                case cy:
                    dVar.aQq = ag(trim);
                    break;
                case r:
                    dVar.aQr = ag(trim);
                    if (!dVar.aQr.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <circle> element. r cannot be negative");
                        AppMethodBeat.o(206725);
                        throw kVar;
                    }
            }
        }
        AppMethodBeat.o(206725);
    }

    private void j(Attributes attributes) {
        AppMethodBeat.i(206726);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206726);
            throw kVar;
        }
        h.i iVar = new h.i();
        iVar.aSO = this.aTM;
        iVar.aSP = this.aTN;
        a((h.al) iVar, attributes);
        b(iVar, attributes);
        a((h.n) iVar, attributes);
        a((h.ag) iVar, attributes);
        a(iVar, attributes);
        this.aTN.a(iVar);
        AppMethodBeat.o(206726);
    }

    private static void a(h.i iVar, Attributes attributes) {
        AppMethodBeat.i(206727);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case rx:
                    iVar.aQx = ag(trim);
                    if (!iVar.aQx.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <ellipse> element. rx cannot be negative");
                        AppMethodBeat.o(206727);
                        throw kVar;
                    }
                case ry:
                    iVar.aQy = ag(trim);
                    if (!iVar.aQy.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <ellipse> element. ry cannot be negative");
                        AppMethodBeat.o(206727);
                        throw kVar2;
                    }
                case cx:
                    iVar.aQp = ag(trim);
                    break;
                case cy:
                    iVar.aQq = ag(trim);
                    break;
            }
        }
        AppMethodBeat.o(206727);
    }

    private void k(Attributes attributes) {
        AppMethodBeat.i(206728);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206728);
            throw kVar;
        }
        h.q qVar = new h.q();
        qVar.aSO = this.aTM;
        qVar.aSP = this.aTN;
        a((h.al) qVar, attributes);
        b(qVar, attributes);
        a((h.n) qVar, attributes);
        a((h.ag) qVar, attributes);
        a(qVar, attributes);
        this.aTN.a(qVar);
        AppMethodBeat.o(206728);
    }

    private static void a(h.q qVar, Attributes attributes) {
        AppMethodBeat.i(206729);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x1:
                    qVar.aQM = ag(trim);
                    break;
                case y1:
                    qVar.aQN = ag(trim);
                    break;
                case x2:
                    qVar.aQO = ag(trim);
                    break;
                case y2:
                    qVar.aQP = ag(trim);
                    break;
            }
        }
        AppMethodBeat.o(206729);
    }

    private void l(Attributes attributes) {
        AppMethodBeat.i(206730);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206730);
            throw kVar;
        }
        h.z zVar = new h.z();
        zVar.aSO = this.aTM;
        zVar.aSP = this.aTN;
        a((h.al) zVar, attributes);
        b(zVar, attributes);
        a((h.n) zVar, attributes);
        a((h.ag) zVar, attributes);
        a(zVar, attributes, "polyline");
        this.aTN.a(zVar);
        AppMethodBeat.o(206730);
    }

    private static void a(h.z zVar, Attributes attributes, String str) {
        AppMethodBeat.i(206731);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (f.aM(attributes.getLocalName(i2)) == f.points) {
                h hVar = new h(attributes.getValue(i2));
                ArrayList<Float> arrayList = new ArrayList();
                hVar.rs();
                while (!hVar.empty()) {
                    float nextFloat = hVar.nextFloat();
                    if (Float.isNaN(nextFloat)) {
                        k kVar = new k("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                        AppMethodBeat.o(206731);
                        throw kVar;
                    }
                    hVar.rt();
                    float nextFloat2 = hVar.nextFloat();
                    if (Float.isNaN(nextFloat2)) {
                        k kVar2 = new k("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        AppMethodBeat.o(206731);
                        throw kVar2;
                    }
                    hVar.rt();
                    arrayList.add(Float.valueOf(nextFloat));
                    arrayList.add(Float.valueOf(nextFloat2));
                }
                zVar.points = new float[arrayList.size()];
                int i3 = 0;
                for (Float f2 : arrayList) {
                    zVar.points[i3] = f2.floatValue();
                    i3++;
                }
            }
        }
        AppMethodBeat.o(206731);
    }

    private void m(Attributes attributes) {
        AppMethodBeat.i(206732);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206732);
            throw kVar;
        }
        h.aa aaVar = new h.aa();
        aaVar.aSO = this.aTM;
        aaVar.aSP = this.aTN;
        a((h.al) aaVar, attributes);
        b(aaVar, attributes);
        a((h.n) aaVar, attributes);
        a((h.ag) aaVar, attributes);
        a(aaVar, attributes, "polygon");
        this.aTN.a(aaVar);
        AppMethodBeat.o(206732);
    }

    private void n(Attributes attributes) {
        AppMethodBeat.i(206733);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206733);
            throw kVar;
        }
        h.aw awVar = new h.aw();
        awVar.aSO = this.aTM;
        awVar.aSP = this.aTN;
        a((h.al) awVar, attributes);
        b(awVar, attributes);
        a((h.n) awVar, attributes);
        a((h.ag) awVar, attributes);
        a((h.ba) awVar, attributes);
        this.aTN.a(awVar);
        this.aTN = awVar;
        AppMethodBeat.o(206733);
    }

    private static void a(h.ba baVar, Attributes attributes) {
        AppMethodBeat.i(206734);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x:
                    baVar.aSU = ah(trim);
                    break;
                case y:
                    baVar.aSV = ah(trim);
                    break;
                case dx:
                    baVar.aSW = ah(trim);
                    break;
                case dy:
                    baVar.aSX = ah(trim);
                    break;
            }
        }
        AppMethodBeat.o(206734);
    }

    private void o(Attributes attributes) {
        AppMethodBeat.i(206735);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206735);
            throw kVar;
        } else if (!(this.aTN instanceof h.ay)) {
            k kVar2 = new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
            AppMethodBeat.o(206735);
            throw kVar2;
        } else {
            h.av avVar = new h.av();
            avVar.aSO = this.aTM;
            avVar.aSP = this.aTN;
            a((h.al) avVar, attributes);
            b(avVar, attributes);
            a((h.ag) avVar, attributes);
            a((h.ba) avVar, attributes);
            this.aTN.a(avVar);
            this.aTN = avVar;
            if (avVar.aSP instanceof h.bb) {
                avVar.aSS = (h.bb) avVar.aSP;
                AppMethodBeat.o(206735);
                return;
            }
            avVar.aSS = ((h.ax) avVar.aSP).ra();
            AppMethodBeat.o(206735);
        }
    }

    private void p(Attributes attributes) {
        AppMethodBeat.i(206736);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206736);
            throw kVar;
        } else if (!(this.aTN instanceof h.ay)) {
            k kVar2 = new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
            AppMethodBeat.o(206736);
            throw kVar2;
        } else {
            h.au auVar = new h.au();
            auVar.aSO = this.aTM;
            auVar.aSP = this.aTN;
            a((h.al) auVar, attributes);
            b(auVar, attributes);
            a((h.ag) auVar, attributes);
            a(auVar, attributes);
            this.aTN.a(auVar);
            if (auVar.aSP instanceof h.bb) {
                auVar.aSS = (h.bb) auVar.aSP;
                AppMethodBeat.o(206736);
                return;
            }
            auVar.aSS = ((h.ax) auVar.aSP).ra();
            AppMethodBeat.o(206736);
        }
    }

    private static void a(h.au auVar, Attributes attributes) {
        AppMethodBeat.i(206737);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        auVar.aQk = trim;
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(206737);
    }

    private void q(Attributes attributes) {
        AppMethodBeat.i(206738);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206738);
            throw kVar;
        }
        h.as asVar = new h.as();
        asVar.aSO = this.aTM;
        asVar.aSP = this.aTN;
        a((h.al) asVar, attributes);
        b(asVar, attributes);
        a((h.n) asVar, attributes);
        a((h.ag) asVar, attributes);
        this.aTN.a(asVar);
        this.aTN = asVar;
        AppMethodBeat.o(206738);
    }

    private static void a(h.ag agVar, Attributes attributes) {
        AppMethodBeat.i(206739);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case requiredFeatures:
                    agVar.b(aE(trim));
                    break;
                case requiredExtensions:
                    agVar.ab(trim);
                    break;
                case systemLanguage:
                    agVar.c(aF(trim));
                    break;
                case requiredFormats:
                    agVar.d(aG(trim));
                    break;
                case requiredFonts:
                    List<String> ap = ap(trim);
                    agVar.e(ap != null ? new HashSet(ap) : new HashSet(0));
                    break;
            }
        }
        AppMethodBeat.o(206739);
    }

    private void r(Attributes attributes) {
        AppMethodBeat.i(206740);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206740);
            throw kVar;
        }
        h.at atVar = new h.at();
        atVar.aSO = this.aTM;
        atVar.aSP = this.aTN;
        a((h.al) atVar, attributes);
        b(atVar, attributes);
        a((h.ag) atVar, attributes);
        a((h.ar) atVar, attributes);
        this.aTN.a(atVar);
        this.aTN = atVar;
        AppMethodBeat.o(206740);
    }

    private void s(Attributes attributes) {
        AppMethodBeat.i(206741);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206741);
            throw kVar;
        }
        h.r rVar = new h.r();
        rVar.aSO = this.aTM;
        rVar.aSP = this.aTN;
        a((h.al) rVar, attributes);
        b(rVar, attributes);
        a((h.ag) rVar, attributes);
        a((h.ar) rVar, attributes);
        a(rVar, attributes);
        this.aTN.a(rVar);
        this.aTN = rVar;
        AppMethodBeat.o(206741);
    }

    private static void a(h.r rVar, Attributes attributes) {
        AppMethodBeat.i(206742);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case refX:
                    rVar.aQR = ag(trim);
                    break;
                case refY:
                    rVar.aQS = ag(trim);
                    break;
                case markerWidth:
                    rVar.aQT = ag(trim);
                    if (!rVar.aQT.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <marker> element. markerWidth cannot be negative");
                        AppMethodBeat.o(206742);
                        throw kVar;
                    }
                case markerHeight:
                    rVar.aQU = ag(trim);
                    if (!rVar.aQU.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <marker> element. markerHeight cannot be negative");
                        AppMethodBeat.o(206742);
                        throw kVar2;
                    }
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        rVar.aQQ = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        rVar.aQQ = true;
                        break;
                    } else {
                        k kVar3 = new k("Invalid value for attribute markerUnits");
                        AppMethodBeat.o(206742);
                        throw kVar3;
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        rVar.aQV = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        rVar.aQV = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
        AppMethodBeat.o(206742);
    }

    private void t(Attributes attributes) {
        AppMethodBeat.i(206743);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206743);
            throw kVar;
        }
        h.am amVar = new h.am();
        amVar.aSO = this.aTM;
        amVar.aSP = this.aTN;
        a((h.al) amVar, attributes);
        b(amVar, attributes);
        a((h.j) amVar, attributes);
        a(amVar, attributes);
        this.aTN.a(amVar);
        this.aTN = amVar;
        AppMethodBeat.o(206743);
    }

    private static void a(h.j jVar, Attributes attributes) {
        AppMethodBeat.i(206744);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        jVar.aQk = trim;
                        break;
                    }
                case gradientUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        jVar.aQA = Boolean.FALSE;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        jVar.aQA = Boolean.TRUE;
                        break;
                    } else {
                        k kVar = new k("Invalid value for attribute gradientUnits");
                        AppMethodBeat.o(206744);
                        throw kVar;
                    }
                case gradientTransform:
                    jVar.aQB = af(trim);
                    break;
                case spreadMethod:
                    try {
                        jVar.aQC = h.k.valueOf(trim);
                        break;
                    } catch (IllegalArgumentException e2) {
                        k kVar2 = new k("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                        AppMethodBeat.o(206744);
                        throw kVar2;
                    }
            }
        }
        AppMethodBeat.o(206744);
    }

    private static void a(h.am amVar, Attributes attributes) {
        AppMethodBeat.i(206745);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x1:
                    amVar.aQM = ag(trim);
                    break;
                case y1:
                    amVar.aQN = ag(trim);
                    break;
                case x2:
                    amVar.aQO = ag(trim);
                    break;
                case y2:
                    amVar.aQP = ag(trim);
                    break;
            }
        }
        AppMethodBeat.o(206745);
    }

    private void u(Attributes attributes) {
        AppMethodBeat.i(206746);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206746);
            throw kVar;
        }
        h.aq aqVar = new h.aq();
        aqVar.aSO = this.aTM;
        aqVar.aSP = this.aTN;
        a((h.al) aqVar, attributes);
        b(aqVar, attributes);
        a((h.j) aqVar, attributes);
        a(aqVar, attributes);
        this.aTN.a(aqVar);
        this.aTN = aqVar;
        AppMethodBeat.o(206746);
    }

    private static void a(h.aq aqVar, Attributes attributes) {
        AppMethodBeat.i(206747);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case cx:
                    aqVar.aQp = ag(trim);
                    break;
                case cy:
                    aqVar.aQq = ag(trim);
                    break;
                case r:
                    aqVar.aQr = ag(trim);
                    if (!aqVar.aQr.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <radialGradient> element. r cannot be negative");
                        AppMethodBeat.o(206747);
                        throw kVar;
                    }
                case fx:
                    aqVar.aSQ = ag(trim);
                    break;
                case fy:
                    aqVar.aSR = ag(trim);
                    break;
            }
        }
        AppMethodBeat.o(206747);
    }

    private void v(Attributes attributes) {
        AppMethodBeat.i(206748);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206748);
            throw kVar;
        } else if (!(this.aTN instanceof h.j)) {
            k kVar2 = new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
            AppMethodBeat.o(206748);
            throw kVar2;
        } else {
            h.ad adVar = new h.ad();
            adVar.aSO = this.aTM;
            adVar.aSP = this.aTN;
            a((h.al) adVar, attributes);
            b(adVar, attributes);
            a(adVar, attributes);
            this.aTN.a(adVar);
            this.aTN = adVar;
            AppMethodBeat.o(206748);
        }
    }

    private static void a(h.ad adVar, Attributes attributes) {
        AppMethodBeat.i(206749);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case offset:
                    adVar.aRi = ae(trim);
                    break;
            }
        }
        AppMethodBeat.o(206749);
    }

    private static Float ae(String str) {
        boolean z;
        float f2 = 0.0f;
        AppMethodBeat.i(206750);
        if (str.length() == 0) {
            k kVar = new k("Invalid offset value in <stop> (empty string)");
            AppMethodBeat.o(206750);
            throw kVar;
        }
        int length = str.length();
        if (str.charAt(str.length() - 1) == '%') {
            length--;
            z = true;
        } else {
            z = false;
        }
        try {
            float g2 = g(str, length);
            if (z) {
                g2 /= 100.0f;
            }
            if (g2 >= 0.0f) {
                f2 = g2 > 100.0f ? 100.0f : g2;
            }
            Float valueOf = Float.valueOf(f2);
            AppMethodBeat.o(206750);
            return valueOf;
        } catch (NumberFormatException e2) {
            k kVar2 = new k("Invalid offset value in <stop>: ".concat(String.valueOf(str)), e2);
            AppMethodBeat.o(206750);
            throw kVar2;
        }
    }

    private void w(Attributes attributes) {
        AppMethodBeat.i(206751);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206751);
            throw kVar;
        }
        h.ac acVar = new h.ac();
        acVar.aSO = this.aTM;
        acVar.aSP = this.aTN;
        a(acVar, attributes);
        b(acVar, attributes);
        this.aTN.a(acVar);
        this.aTN = acVar;
        AppMethodBeat.o(206751);
    }

    private void x(Attributes attributes) {
        AppMethodBeat.i(206752);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206752);
            throw kVar;
        }
        h.e eVar = new h.e();
        eVar.aSO = this.aTM;
        eVar.aSP = this.aTN;
        a((h.al) eVar, attributes);
        b(eVar, attributes);
        a((h.n) eVar, attributes);
        a((h.ag) eVar, attributes);
        a(eVar, attributes);
        this.aTN.a(eVar);
        this.aTN = eVar;
        AppMethodBeat.o(206752);
    }

    private static void a(h.e eVar, Attributes attributes) {
        AppMethodBeat.i(206753);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        eVar.aQs = Boolean.FALSE;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        eVar.aQs = Boolean.TRUE;
                        break;
                    } else {
                        k kVar = new k("Invalid value for attribute clipPathUnits");
                        AppMethodBeat.o(206753);
                        throw kVar;
                    }
            }
        }
        AppMethodBeat.o(206753);
    }

    private void y(Attributes attributes) {
        AppMethodBeat.i(206754);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206754);
            throw kVar;
        }
        h.az azVar = new h.az();
        azVar.aSO = this.aTM;
        azVar.aSP = this.aTN;
        a((h.al) azVar, attributes);
        b(azVar, attributes);
        a((h.ag) azVar, attributes);
        a(azVar, attributes);
        this.aTN.a(azVar);
        this.aTN = azVar;
        if (azVar.aSP instanceof h.bb) {
            azVar.aSS = (h.bb) azVar.aSP;
            AppMethodBeat.o(206754);
            return;
        }
        azVar.aSS = ((h.ax) azVar.aSP).ra();
        AppMethodBeat.o(206754);
    }

    private static void a(h.az azVar, Attributes attributes) {
        AppMethodBeat.i(206755);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        azVar.aQk = trim;
                        break;
                    }
                    break;
                case startOffset:
                    azVar.aST = ag(trim);
                    break;
            }
        }
        AppMethodBeat.o(206755);
    }

    private void z(Attributes attributes) {
        AppMethodBeat.i(206756);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206756);
            throw kVar;
        }
        h.y yVar = new h.y();
        yVar.aSO = this.aTM;
        yVar.aSP = this.aTN;
        a((h.al) yVar, attributes);
        b(yVar, attributes);
        a((h.ag) yVar, attributes);
        a((h.ar) yVar, attributes);
        a(yVar, attributes);
        this.aTN.a(yVar);
        this.aTN = yVar;
        AppMethodBeat.o(206756);
    }

    private static void a(h.y yVar, Attributes attributes) {
        AppMethodBeat.i(206757);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.aTW[f.aM(attributes.getLocalName(i2)).ordinal()]) {
                case 1:
                    yVar.aQH = ag(trim);
                    break;
                case 2:
                    yVar.aQI = ag(trim);
                    break;
                case 3:
                    yVar.aQJ = ag(trim);
                    if (!yVar.aQJ.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <pattern> element. width cannot be negative");
                        AppMethodBeat.o(206757);
                        throw kVar;
                    }
                case 4:
                    yVar.aQK = ag(trim);
                    if (!yVar.aQK.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <pattern> element. height cannot be negative");
                        AppMethodBeat.o(206757);
                        throw kVar2;
                    }
                case 6:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        yVar.aQk = trim;
                        break;
                    }
                case 40:
                    if ("objectBoundingBox".equals(trim)) {
                        yVar.aRf = Boolean.FALSE;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        yVar.aRf = Boolean.TRUE;
                        break;
                    } else {
                        k kVar3 = new k("Invalid value for attribute patternUnits");
                        AppMethodBeat.o(206757);
                        throw kVar3;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    if ("objectBoundingBox".equals(trim)) {
                        yVar.aRg = Boolean.FALSE;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        yVar.aRg = Boolean.TRUE;
                        break;
                    } else {
                        k kVar4 = new k("Invalid value for attribute patternContentUnits");
                        AppMethodBeat.o(206757);
                        throw kVar4;
                    }
                case 42:
                    yVar.aRh = af(trim);
                    break;
            }
        }
        AppMethodBeat.o(206757);
    }

    private void A(Attributes attributes) {
        AppMethodBeat.i(206758);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206758);
            throw kVar;
        }
        h.bf bfVar = new h.bf();
        bfVar.aSO = this.aTM;
        bfVar.aSP = this.aTN;
        a((h.al) bfVar, attributes);
        a((h.ag) bfVar, attributes);
        a((h.ar) bfVar, attributes);
        this.aTN.a(bfVar);
        this.aTN = bfVar;
        AppMethodBeat.o(206758);
    }

    private void B(Attributes attributes) {
        AppMethodBeat.i(206759);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206759);
            throw kVar;
        }
        h.s sVar = new h.s();
        sVar.aSO = this.aTM;
        sVar.aSP = this.aTN;
        a((h.al) sVar, attributes);
        b(sVar, attributes);
        a((h.ag) sVar, attributes);
        a(sVar, attributes);
        this.aTN.a(sVar);
        this.aTN = sVar;
        AppMethodBeat.o(206759);
    }

    private static void a(h.s sVar, Attributes attributes) {
        AppMethodBeat.i(206760);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case x:
                    sVar.aQH = ag(trim);
                    break;
                case y:
                    sVar.aQI = ag(trim);
                    break;
                case width:
                    sVar.aQJ = ag(trim);
                    if (!sVar.aQJ.isNegative()) {
                        break;
                    } else {
                        k kVar = new k("Invalid <mask> element. width cannot be negative");
                        AppMethodBeat.o(206760);
                        throw kVar;
                    }
                case height:
                    sVar.aQK = ag(trim);
                    if (!sVar.aQK.isNegative()) {
                        break;
                    } else {
                        k kVar2 = new k("Invalid <mask> element. height cannot be negative");
                        AppMethodBeat.o(206760);
                        throw kVar2;
                    }
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        sVar.aQW = Boolean.FALSE;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        sVar.aQW = Boolean.TRUE;
                        break;
                    } else {
                        k kVar3 = new k("Invalid value for attribute maskUnits");
                        AppMethodBeat.o(206760);
                        throw kVar3;
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        sVar.aQX = Boolean.FALSE;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        sVar.aQX = Boolean.TRUE;
                        break;
                    } else {
                        k kVar4 = new k("Invalid value for attribute maskContentUnits");
                        AppMethodBeat.o(206760);
                        throw kVar4;
                    }
            }
        }
        AppMethodBeat.o(206760);
    }

    /* access modifiers changed from: package-private */
    public static class h {
        private e aWA = new e();
        String aWy;
        int aWz = 0;
        int position = 0;

        h(String str) {
            AppMethodBeat.i(206672);
            this.aWy = str.trim();
            this.aWz = this.aWy.length();
            AppMethodBeat.o(206672);
        }

        /* access modifiers changed from: package-private */
        public final boolean empty() {
            return this.position == this.aWz;
        }

        static boolean isWhitespace(int i2) {
            return i2 == 32 || i2 == 10 || i2 == 13 || i2 == 9;
        }

        /* access modifiers changed from: package-private */
        public final void rs() {
            AppMethodBeat.i(206673);
            while (this.position < this.aWz && isWhitespace(this.aWy.charAt(this.position))) {
                this.position++;
            }
            AppMethodBeat.o(206673);
        }

        static boolean dw(int i2) {
            return i2 == 10 || i2 == 13;
        }

        /* access modifiers changed from: package-private */
        public final boolean rt() {
            AppMethodBeat.i(206674);
            rs();
            if (this.position == this.aWz) {
                AppMethodBeat.o(206674);
                return false;
            } else if (this.aWy.charAt(this.position) != ',') {
                AppMethodBeat.o(206674);
                return false;
            } else {
                this.position++;
                rs();
                AppMethodBeat.o(206674);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final float nextFloat() {
            AppMethodBeat.i(206675);
            float f2 = this.aWA.f(this.aWy, this.position, this.aWz);
            if (!Float.isNaN(f2)) {
                this.position = this.aWA.pos;
            }
            AppMethodBeat.o(206675);
            return f2;
        }

        /* access modifiers changed from: package-private */
        public final float ru() {
            AppMethodBeat.i(206676);
            rt();
            float f2 = this.aWA.f(this.aWy, this.position, this.aWz);
            if (!Float.isNaN(f2)) {
                this.position = this.aWA.pos;
            }
            AppMethodBeat.o(206676);
            return f2;
        }

        /* access modifiers changed from: package-private */
        public final float U(float f2) {
            AppMethodBeat.i(206677);
            if (Float.isNaN(f2)) {
                AppMethodBeat.o(206677);
                return Float.NaN;
            }
            rt();
            float nextFloat = nextFloat();
            AppMethodBeat.o(206677);
            return nextFloat;
        }

        /* access modifiers changed from: package-private */
        public final float a(Boolean bool) {
            AppMethodBeat.i(206678);
            if (bool == null) {
                AppMethodBeat.o(206678);
                return Float.NaN;
            }
            rt();
            float nextFloat = nextFloat();
            AppMethodBeat.o(206678);
            return nextFloat;
        }

        /* access modifiers changed from: package-private */
        public final Integer rv() {
            AppMethodBeat.i(206679);
            if (this.position == this.aWz) {
                AppMethodBeat.o(206679);
                return null;
            }
            String str = this.aWy;
            int i2 = this.position;
            this.position = i2 + 1;
            Integer valueOf = Integer.valueOf(str.charAt(i2));
            AppMethodBeat.o(206679);
            return valueOf;
        }

        /* access modifiers changed from: package-private */
        public final h.p rw() {
            AppMethodBeat.i(206680);
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                AppMethodBeat.o(206680);
                return null;
            }
            h.bd rC = rC();
            if (rC == null) {
                h.p pVar = new h.p(nextFloat, h.bd.px);
                AppMethodBeat.o(206680);
                return pVar;
            }
            h.p pVar2 = new h.p(nextFloat, rC);
            AppMethodBeat.o(206680);
            return pVar2;
        }

        private Boolean rx() {
            AppMethodBeat.i(206681);
            if (this.position == this.aWz) {
                AppMethodBeat.o(206681);
                return null;
            }
            char charAt = this.aWy.charAt(this.position);
            if (charAt == '0' || charAt == '1') {
                this.position++;
                Boolean valueOf = Boolean.valueOf(charAt == '1');
                AppMethodBeat.o(206681);
                return valueOf;
            }
            AppMethodBeat.o(206681);
            return null;
        }

        /* access modifiers changed from: package-private */
        public final Boolean ab(Object obj) {
            AppMethodBeat.i(206682);
            if (obj == null) {
                AppMethodBeat.o(206682);
                return null;
            }
            rt();
            Boolean rx2 = rx();
            AppMethodBeat.o(206682);
            return rx2;
        }

        /* access modifiers changed from: package-private */
        public final boolean b(char c2) {
            AppMethodBeat.i(206683);
            boolean z = this.position < this.aWz && this.aWy.charAt(this.position) == c2;
            if (z) {
                this.position++;
            }
            AppMethodBeat.o(206683);
            return z;
        }

        /* access modifiers changed from: package-private */
        public final boolean aO(String str) {
            AppMethodBeat.i(206684);
            int length = str.length();
            boolean z = this.position <= this.aWz - length && this.aWy.substring(this.position, this.position + length).equals(str);
            if (z) {
                this.position = length + this.position;
            }
            AppMethodBeat.o(206684);
            return z;
        }

        /* access modifiers changed from: package-private */
        public final int ry() {
            AppMethodBeat.i(206685);
            if (this.position == this.aWz) {
                AppMethodBeat.o(206685);
                return -1;
            }
            this.position++;
            if (this.position < this.aWz) {
                char charAt = this.aWy.charAt(this.position);
                AppMethodBeat.o(206685);
                return charAt;
            }
            AppMethodBeat.o(206685);
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final String nextToken() {
            AppMethodBeat.i(261723);
            String a2 = a(' ', false);
            AppMethodBeat.o(261723);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final String c(char c2) {
            AppMethodBeat.i(206687);
            String a2 = a(c2, false);
            AppMethodBeat.o(206687);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final String a(char c2, boolean z) {
            AppMethodBeat.i(206688);
            if (empty()) {
                AppMethodBeat.o(206688);
                return null;
            }
            char charAt = this.aWy.charAt(this.position);
            if ((z || !isWhitespace(charAt)) && charAt != c2) {
                int i2 = this.position;
                int ry = ry();
                while (ry != -1 && ry != c2 && (z || !isWhitespace(ry))) {
                    ry = ry();
                }
                String substring = this.aWy.substring(i2, this.position);
                AppMethodBeat.o(206688);
                return substring;
            }
            AppMethodBeat.o(206688);
            return null;
        }

        /* access modifiers changed from: package-private */
        public final String rz() {
            AppMethodBeat.i(206689);
            if (empty()) {
                AppMethodBeat.o(206689);
                return null;
            }
            int i2 = this.position;
            char charAt = this.aWy.charAt(this.position);
            if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
                this.position = i2;
                AppMethodBeat.o(206689);
                return null;
            }
            int ry = ry();
            while (true) {
                if ((ry < 65 || ry > 90) && (ry < 97 || ry > 122)) {
                    String substring = this.aWy.substring(i2, this.position);
                    AppMethodBeat.o(206689);
                } else {
                    ry = ry();
                }
            }
            String substring2 = this.aWy.substring(i2, this.position);
            AppMethodBeat.o(206689);
            return substring2;
        }

        /* access modifiers changed from: package-private */
        public final String rA() {
            AppMethodBeat.i(206690);
            if (empty()) {
                AppMethodBeat.o(206690);
                return null;
            }
            int i2 = this.position;
            int charAt = this.aWy.charAt(this.position);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    int i3 = this.position;
                } else {
                    charAt = ry();
                }
            }
            int i32 = this.position;
            while (isWhitespace(charAt)) {
                charAt = ry();
            }
            if (charAt == 40) {
                this.position++;
                String substring = this.aWy.substring(i2, i32);
                AppMethodBeat.o(206690);
                return substring;
            }
            this.position = i2;
            AppMethodBeat.o(206690);
            return null;
        }

        /* access modifiers changed from: package-private */
        public final String rB() {
            AppMethodBeat.i(206691);
            int i2 = this.position;
            while (!empty() && !isWhitespace(this.aWy.charAt(this.position))) {
                this.position++;
            }
            String substring = this.aWy.substring(i2, this.position);
            this.position = i2;
            AppMethodBeat.o(206691);
            return substring;
        }

        /* access modifiers changed from: package-private */
        public final h.bd rC() {
            AppMethodBeat.i(206692);
            if (empty()) {
                AppMethodBeat.o(206692);
                return null;
            } else if (this.aWy.charAt(this.position) == '%') {
                this.position++;
                h.bd bdVar = h.bd.percent;
                AppMethodBeat.o(206692);
                return bdVar;
            } else if (this.position > this.aWz - 2) {
                AppMethodBeat.o(206692);
                return null;
            } else {
                try {
                    h.bd valueOf = h.bd.valueOf(this.aWy.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                    this.position += 2;
                    AppMethodBeat.o(206692);
                    return valueOf;
                } catch (IllegalArgumentException e2) {
                    AppMethodBeat.o(206692);
                    return null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean rD() {
            AppMethodBeat.i(206693);
            if (this.position == this.aWz) {
                AppMethodBeat.o(206693);
                return false;
            }
            char charAt = this.aWy.charAt(this.position);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                AppMethodBeat.o(206693);
                return false;
            }
            AppMethodBeat.o(206693);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final String rE() {
            int ry;
            AppMethodBeat.i(206694);
            if (empty()) {
                AppMethodBeat.o(206694);
                return null;
            }
            int i2 = this.position;
            char charAt = this.aWy.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                do {
                    ry = ry();
                    if (ry == -1) {
                        break;
                    }
                } while (ry != charAt);
                if (ry == -1) {
                    this.position = i2;
                    AppMethodBeat.o(206694);
                    return null;
                }
                this.position++;
                String substring = this.aWy.substring(i2 + 1, this.position - 1);
                AppMethodBeat.o(206694);
                return substring;
            }
            AppMethodBeat.o(206694);
            return null;
        }

        /* access modifiers changed from: package-private */
        public final String rF() {
            AppMethodBeat.i(206695);
            if (empty()) {
                AppMethodBeat.o(206695);
                return null;
            }
            int i2 = this.position;
            this.position = this.aWz;
            String substring = this.aWy.substring(i2);
            AppMethodBeat.o(206695);
            return substring;
        }
    }

    private static void a(h.al alVar, Attributes attributes) {
        AppMethodBeat.i(206761);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String qName = attributes.getQName(i2);
            if (qName.equals("id") || qName.equals("xml:id")) {
                alVar.id = attributes.getValue(i2).trim();
                AppMethodBeat.o(206761);
                return;
            } else if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i2).trim();
                if (BuildConfig.KINDA_DEFAULT.equals(trim)) {
                    alVar.aSL = Boolean.FALSE;
                    AppMethodBeat.o(206761);
                    return;
                } else if ("preserve".equals(trim)) {
                    alVar.aSL = Boolean.TRUE;
                    AppMethodBeat.o(206761);
                    return;
                } else {
                    k kVar = new k("Invalid value for \"xml:space\" attribute: ".concat(String.valueOf(trim)));
                    AppMethodBeat.o(206761);
                    throw kVar;
                }
            }
        }
        AppMethodBeat.o(206761);
    }

    private static void b(h.al alVar, Attributes attributes) {
        AppMethodBeat.i(206762);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (trim.length() != 0) {
                switch (f.aM(attributes.getLocalName(i2))) {
                    case style:
                        a(alVar, trim);
                        continue;
                    case CLASS:
                        alVar.aSN = b.X(trim);
                        continue;
                    default:
                        if (alVar.aSM == null) {
                            alVar.aSM = new h.ae();
                        }
                        a(alVar.aSM, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                        continue;
                }
            }
        }
        AppMethodBeat.o(206762);
    }

    private static void a(h.al alVar, String str) {
        AppMethodBeat.i(206763);
        b.c cVar = new b.c(str.replaceAll("/\\*.*?\\*/", ""));
        while (!cVar.empty()) {
            cVar.rs();
            String qA = cVar.qA();
            cVar.rs();
            if (!cVar.b(';')) {
                if (!cVar.b(':')) {
                    break;
                }
                cVar.rs();
                String qD = cVar.qD();
                if (qD != null) {
                    cVar.rs();
                    if (cVar.empty() || cVar.b(';')) {
                        if (alVar.aPk == null) {
                            alVar.aPk = new h.ae();
                        }
                        a(alVar.aPk, qA, qD);
                        cVar.rs();
                    }
                }
            }
        }
        AppMethodBeat.o(206763);
    }

    static void a(h.ae aeVar, String str, String str2) {
        AppMethodBeat.i(206764);
        if (str2.length() == 0) {
            AppMethodBeat.o(206764);
        } else if (str2.equals("inherit")) {
            AppMethodBeat.o(206764);
        } else {
            switch (AnonymousClass1.aTW[f.aM(str).ordinal()]) {
                case 47:
                    aeVar.aRk = al(str2);
                    if (aeVar.aRk != null) {
                        aeVar.aRj |= 1;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    aeVar.aRl = au(str2);
                    if (aeVar.aRl != null) {
                        aeVar.aRj |= 2;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 49:
                    aeVar.aRm = ai(str2);
                    if (aeVar.aRm != null) {
                        aeVar.aRj |= 4;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 50:
                    aeVar.aRn = al(str2);
                    if (aeVar.aRn != null) {
                        aeVar.aRj |= 8;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 51:
                    aeVar.aRo = ai(str2);
                    if (aeVar.aRo != null) {
                        aeVar.aRj |= 16;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 52:
                    try {
                        aeVar.aRp = ag(str2);
                        aeVar.aRj |= 32;
                        AppMethodBeat.o(206764);
                        return;
                    } catch (k e2) {
                        AppMethodBeat.o(206764);
                        return;
                    }
                case 53:
                    aeVar.aRq = av(str2);
                    if (aeVar.aRq != null) {
                        aeVar.aRj |= 64;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 54:
                    aeVar.aRr = aw(str2);
                    if (aeVar.aRr != null) {
                        aeVar.aRj |= 128;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 55:
                    try {
                        aeVar.aRs = Float.valueOf(parseFloat(str2));
                        aeVar.aRj |= 256;
                        AppMethodBeat.o(206764);
                        return;
                    } catch (k e3) {
                        AppMethodBeat.o(206764);
                        return;
                    }
                case 56:
                    if ("none".equals(str2)) {
                        aeVar.aRt = null;
                        aeVar.aRj |= 512;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    aeVar.aRt = ax(str2);
                    if (aeVar.aRt != null) {
                        aeVar.aRj |= 512;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                    try {
                        aeVar.aRu = ag(str2);
                        aeVar.aRj |= 1024;
                        AppMethodBeat.o(206764);
                        return;
                    } catch (k e4) {
                        AppMethodBeat.o(206764);
                        return;
                    }
                case 58:
                    aeVar.aRv = ai(str2);
                    aeVar.aRj |= 2048;
                    AppMethodBeat.o(206764);
                    return;
                case bv.CTRL_INDEX /*{ENCODED_INT: 59}*/:
                    try {
                        aeVar.aRw = an(str2);
                        aeVar.aRj |= 4096;
                        AppMethodBeat.o(206764);
                        return;
                    } catch (k e5) {
                        AppMethodBeat.o(206764);
                        return;
                    }
                case 60:
                    a(aeVar, str2);
                    AppMethodBeat.o(206764);
                    return;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    aeVar.aRx = ap(str2);
                    if (aeVar.aRx != null) {
                        aeVar.aRj |= 8192;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 62:
                    aeVar.aRy = aq(str2);
                    if (aeVar.aRy != null) {
                        aeVar.aRj |= 16384;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 63:
                    aeVar.aRz = d.aK(str2);
                    if (aeVar.aRz != null) {
                        aeVar.aRj |= 32768;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 64:
                    aeVar.aRA = ar(str2);
                    if (aeVar.aRA != null) {
                        aeVar.aRj |= 65536;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 65:
                    aeVar.aRB = as(str2);
                    if (aeVar.aRB != null) {
                        aeVar.aRj |= 131072;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 66:
                    aeVar.aRC = at(str2);
                    if (aeVar.aRC != null) {
                        aeVar.aRj |= 68719476736L;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 67:
                    aeVar.aRD = ay(str2);
                    if (aeVar.aRD != null) {
                        aeVar.aRj |= 262144;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 68:
                    aeVar.aRE = az(str2);
                    if (aeVar.aRE != null) {
                        aeVar.aRj |= com.tencent.mm.hardcoder.g.ACTION_MINI_PROGRAM_LAUNCH;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case 69:
                    aeVar.aRG = aH(str2);
                    aeVar.aRH = aeVar.aRG;
                    aeVar.aRI = aeVar.aRG;
                    aeVar.aRj |= 14680064;
                    AppMethodBeat.o(206764);
                    return;
                case 70:
                    aeVar.aRG = aH(str2);
                    aeVar.aRj |= 2097152;
                    AppMethodBeat.o(206764);
                    return;
                case 71:
                    aeVar.aRH = aH(str2);
                    aeVar.aRj |= 4194304;
                    AppMethodBeat.o(206764);
                    return;
                case 72:
                    aeVar.aRI = aH(str2);
                    aeVar.aRj |= 8388608;
                    AppMethodBeat.o(206764);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX /*{ENCODED_INT: 73}*/:
                    if (str2.indexOf(124) < 0 && "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + str2 + '|')) {
                        aeVar.aRJ = Boolean.valueOf(!str2.equals("none"));
                        aeVar.aRj |= 16777216;
                        AppMethodBeat.o(206764);
                        return;
                    }
                case 74:
                    if (str2.indexOf(124) < 0 && "|visible|hidden|collapse|".contains("|" + str2 + '|')) {
                        aeVar.aRK = Boolean.valueOf(str2.equals("visible"));
                        aeVar.aRj |= 33554432;
                        AppMethodBeat.o(206764);
                        return;
                    }
                case 75:
                    if (str2.equals("currentColor")) {
                        aeVar.aRL = h.g.qT();
                    } else {
                        try {
                            aeVar.aRL = an(str2);
                        } catch (k e6) {
                            e6.getMessage();
                            AppMethodBeat.o(206764);
                            return;
                        }
                    }
                    aeVar.aRj |= 67108864;
                    AppMethodBeat.o(206764);
                    return;
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO /*{ENCODED_INT: 76}*/:
                    aeVar.aRM = ai(str2);
                    aeVar.aRj |= 134217728;
                    AppMethodBeat.o(206764);
                    return;
                case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                    aeVar.aRF = aA(str2);
                    if (aeVar.aRF != null) {
                        aeVar.aRj |= 1048576;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case h.a.CTRL_INDEX /*{ENCODED_INT: 78}*/:
                    aeVar.aRN = aH(str2);
                    aeVar.aRj |= 268435456;
                    AppMethodBeat.o(206764);
                    return;
                case 79:
                    aeVar.aRO = au(str2);
                    aeVar.aRj |= TPAudioFrame.TP_CH_STEREO_LEFT;
                    AppMethodBeat.o(206764);
                    return;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    aeVar.aRP = aH(str2);
                    aeVar.aRj |= TPAudioFrame.TP_CH_STEREO_RIGHT;
                    AppMethodBeat.o(206764);
                    return;
                case 81:
                    if (str2.equals("currentColor")) {
                        aeVar.aRQ = h.g.qT();
                    } else {
                        try {
                            aeVar.aRQ = an(str2);
                        } catch (k e7) {
                            e7.getMessage();
                            AppMethodBeat.o(206764);
                            return;
                        }
                    }
                    aeVar.aRj |= 2147483648L;
                    AppMethodBeat.o(206764);
                    return;
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                    aeVar.aRR = ai(str2);
                    aeVar.aRj |= 4294967296L;
                    AppMethodBeat.o(206764);
                    return;
                case 83:
                    if (str2.equals("currentColor")) {
                        aeVar.aRS = h.g.qT();
                    } else {
                        try {
                            aeVar.aRS = an(str2);
                        } catch (k e8) {
                            e8.getMessage();
                            AppMethodBeat.o(206764);
                            return;
                        }
                    }
                    aeVar.aRj |= 8589934592L;
                    AppMethodBeat.o(206764);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX /*{ENCODED_INT: 84}*/:
                    aeVar.aRT = ai(str2);
                    aeVar.aRj |= 17179869184L;
                    AppMethodBeat.o(206764);
                    return;
                case s.CTRL_INDEX /*{ENCODED_INT: 85}*/:
                    aeVar.aRU = aB(str2);
                    if (aeVar.aRU != null) {
                        aeVar.aRj |= 34359738368L;
                        AppMethodBeat.o(206764);
                        return;
                    }
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX /*{ENCODED_INT: 86}*/:
                    aeVar.aRV = aC(str2);
                    if (aeVar.aRV != null) {
                        aeVar.aRj |= 137438953472L;
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(206764);
        }
    }

    private static void a(h.ar arVar, Attributes attributes) {
        AppMethodBeat.i(206765);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.aM(attributes.getLocalName(i2))) {
                case preserveAspectRatio:
                    a((h.ap) arVar, trim);
                    break;
                case viewBox:
                    arVar.aQb = aj(trim);
                    break;
            }
        }
        AppMethodBeat.o(206765);
    }

    private static void a(h.n nVar, Attributes attributes) {
        AppMethodBeat.i(206766);
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (f.aM(attributes.getLocalName(i2)) == f.transform) {
                nVar.setTransform(af(attributes.getValue(i2)));
            }
        }
        AppMethodBeat.o(206766);
    }

    private static Matrix af(String str) {
        AppMethodBeat.i(206767);
        Matrix matrix = new Matrix();
        h hVar = new h(str);
        hVar.rs();
        while (!hVar.empty()) {
            String rA = hVar.rA();
            if (rA == null) {
                k kVar = new k("Bad transform function encountered in transform list: ".concat(String.valueOf(str)));
                AppMethodBeat.o(206767);
                throw kVar;
            }
            char c2 = 65535;
            switch (rA.hashCode()) {
                case -1081239615:
                    if (rA.equals("matrix")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -925180581:
                    if (rA.equals(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 109250890:
                    if (rA.equals("scale")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 109493390:
                    if (rA.equals("skewX")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 109493391:
                    if (rA.equals("skewY")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1052832078:
                    if (rA.equals("translate")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    hVar.rs();
                    float nextFloat = hVar.nextFloat();
                    hVar.rt();
                    float nextFloat2 = hVar.nextFloat();
                    hVar.rt();
                    float nextFloat3 = hVar.nextFloat();
                    hVar.rt();
                    float nextFloat4 = hVar.nextFloat();
                    hVar.rt();
                    float nextFloat5 = hVar.nextFloat();
                    hVar.rt();
                    float nextFloat6 = hVar.nextFloat();
                    hVar.rs();
                    if (!Float.isNaN(nextFloat6) && hVar.b(')')) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                        matrix.preConcat(matrix2);
                        break;
                    } else {
                        k kVar2 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar2;
                    }
                case 1:
                    hVar.rs();
                    float nextFloat7 = hVar.nextFloat();
                    float ru = hVar.ru();
                    hVar.rs();
                    if (!Float.isNaN(nextFloat7) && hVar.b(')')) {
                        if (!Float.isNaN(ru)) {
                            matrix.preTranslate(nextFloat7, ru);
                            break;
                        } else {
                            matrix.preTranslate(nextFloat7, 0.0f);
                            break;
                        }
                    } else {
                        k kVar3 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar3;
                    }
                    break;
                case 2:
                    hVar.rs();
                    float nextFloat8 = hVar.nextFloat();
                    float ru2 = hVar.ru();
                    hVar.rs();
                    if (!Float.isNaN(nextFloat8) && hVar.b(')')) {
                        if (!Float.isNaN(ru2)) {
                            matrix.preScale(nextFloat8, ru2);
                            break;
                        } else {
                            matrix.preScale(nextFloat8, nextFloat8);
                            break;
                        }
                    } else {
                        k kVar4 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar4;
                    }
                    break;
                case 3:
                    hVar.rs();
                    float nextFloat9 = hVar.nextFloat();
                    float ru3 = hVar.ru();
                    float ru4 = hVar.ru();
                    hVar.rs();
                    if (Float.isNaN(nextFloat9) || !hVar.b(')')) {
                        k kVar5 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar5;
                    } else if (Float.isNaN(ru3)) {
                        matrix.preRotate(nextFloat9);
                        break;
                    } else if (!Float.isNaN(ru4)) {
                        matrix.preRotate(nextFloat9, ru3, ru4);
                        break;
                    } else {
                        k kVar6 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar6;
                    }
                    break;
                case 4:
                    hVar.rs();
                    float nextFloat10 = hVar.nextFloat();
                    hVar.rs();
                    if (!Float.isNaN(nextFloat10) && hVar.b(')')) {
                        matrix.preSkew((float) Math.tan(Math.toRadians((double) nextFloat10)), 0.0f);
                        break;
                    } else {
                        k kVar7 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar7;
                    }
                case 5:
                    hVar.rs();
                    float nextFloat11 = hVar.nextFloat();
                    hVar.rs();
                    if (!Float.isNaN(nextFloat11) && hVar.b(')')) {
                        matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians((double) nextFloat11)));
                        break;
                    } else {
                        k kVar8 = new k("Invalid transform list: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206767);
                        throw kVar8;
                    }
                default:
                    k kVar9 = new k("Invalid transform list fn: " + rA + ")");
                    AppMethodBeat.o(206767);
                    throw kVar9;
            }
            if (!hVar.empty()) {
                hVar.rt();
            } else {
                AppMethodBeat.o(206767);
                return matrix;
            }
        }
        AppMethodBeat.o(206767);
        return matrix;
    }

    private static h.p ag(String str) {
        AppMethodBeat.i(206768);
        if (str.length() == 0) {
            k kVar = new k("Invalid length value (empty string)");
            AppMethodBeat.o(206768);
            throw kVar;
        }
        int length = str.length();
        h.bd bdVar = h.bd.px;
        char charAt = str.charAt(length - 1);
        if (charAt == '%') {
            length--;
            bdVar = h.bd.percent;
        } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                bdVar = h.bd.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException e2) {
                k kVar2 = new k("Invalid length unit specifier: ".concat(String.valueOf(str)));
                AppMethodBeat.o(206768);
                throw kVar2;
            }
        }
        try {
            h.p pVar = new h.p(g(str, length), bdVar);
            AppMethodBeat.o(206768);
            return pVar;
        } catch (NumberFormatException e3) {
            k kVar3 = new k("Invalid length value: ".concat(String.valueOf(str)), e3);
            AppMethodBeat.o(206768);
            throw kVar3;
        }
    }

    private static List<h.p> ah(String str) {
        AppMethodBeat.i(206769);
        if (str.length() == 0) {
            k kVar = new k("Invalid length list (empty string)");
            AppMethodBeat.o(206769);
            throw kVar;
        }
        ArrayList arrayList = new ArrayList(1);
        h hVar = new h(str);
        hVar.rs();
        while (!hVar.empty()) {
            float nextFloat = hVar.nextFloat();
            if (Float.isNaN(nextFloat)) {
                k kVar2 = new k("Invalid length list value: " + hVar.rB());
                AppMethodBeat.o(206769);
                throw kVar2;
            }
            h.bd rC = hVar.rC();
            if (rC == null) {
                rC = h.bd.px;
            }
            arrayList.add(new h.p(nextFloat, rC));
            hVar.rt();
        }
        AppMethodBeat.o(206769);
        return arrayList;
    }

    private static float parseFloat(String str) {
        AppMethodBeat.i(206770);
        int length = str.length();
        if (length == 0) {
            k kVar = new k("Invalid float value (empty string)");
            AppMethodBeat.o(206770);
            throw kVar;
        }
        float g2 = g(str, length);
        AppMethodBeat.o(206770);
        return g2;
    }

    private static float g(String str, int i2) {
        AppMethodBeat.i(206771);
        float f2 = new e().f(str, 0, i2);
        if (!Float.isNaN(f2)) {
            AppMethodBeat.o(206771);
            return f2;
        }
        k kVar = new k("Invalid float value: ".concat(String.valueOf(str)));
        AppMethodBeat.o(206771);
        throw kVar;
    }

    private static Float ai(String str) {
        float f2 = 0.0f;
        AppMethodBeat.i(206772);
        try {
            float parseFloat = parseFloat(str);
            if (parseFloat >= 0.0f) {
                f2 = parseFloat > 1.0f ? 1.0f : parseFloat;
            }
            Float valueOf = Float.valueOf(f2);
            AppMethodBeat.o(206772);
            return valueOf;
        } catch (k e2) {
            AppMethodBeat.o(206772);
            return null;
        }
    }

    private static h.b aj(String str) {
        AppMethodBeat.i(206773);
        h hVar = new h(str);
        hVar.rs();
        float nextFloat = hVar.nextFloat();
        hVar.rt();
        float nextFloat2 = hVar.nextFloat();
        hVar.rt();
        float nextFloat3 = hVar.nextFloat();
        hVar.rt();
        float nextFloat4 = hVar.nextFloat();
        if (Float.isNaN(nextFloat) || Float.isNaN(nextFloat2) || Float.isNaN(nextFloat3) || Float.isNaN(nextFloat4)) {
            k kVar = new k("Invalid viewBox definition - should have four numbers");
            AppMethodBeat.o(206773);
            throw kVar;
        } else if (nextFloat3 < 0.0f) {
            k kVar2 = new k("Invalid viewBox. width cannot be negative");
            AppMethodBeat.o(206773);
            throw kVar2;
        } else if (nextFloat4 < 0.0f) {
            k kVar3 = new k("Invalid viewBox. height cannot be negative");
            AppMethodBeat.o(206773);
            throw kVar3;
        } else {
            h.b bVar = new h.b(nextFloat, nextFloat2, nextFloat3, nextFloat4);
            AppMethodBeat.o(206773);
            return bVar;
        }
    }

    private static void a(h.ap apVar, String str) {
        AppMethodBeat.i(206774);
        apVar.aPZ = ak(str);
        AppMethodBeat.o(206774);
    }

    private static f ak(String str) {
        AppMethodBeat.i(206775);
        h hVar = new h(str);
        hVar.rs();
        String a2 = hVar.a(' ', false);
        if ("defer".equals(a2)) {
            hVar.rs();
            a2 = hVar.a(' ', false);
        }
        f.a aJ = a.aJ(a2);
        f.b bVar = null;
        hVar.rs();
        if (!hVar.empty()) {
            String a3 = hVar.a(' ', false);
            char c2 = 65535;
            switch (a3.hashCode()) {
                case 3347527:
                    if (a3.equals("meet")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 109526418:
                    if (a3.equals("slice")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    bVar = f.b.meet;
                    break;
                case 1:
                    bVar = f.b.slice;
                    break;
                default:
                    k kVar = new k("Invalid preserveAspectRatio definition: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(206775);
                    throw kVar;
            }
        }
        f fVar = new f(aJ, bVar);
        AppMethodBeat.o(206775);
        return fVar;
    }

    private static h.ao al(String str) {
        h.ao aoVar = null;
        AppMethodBeat.i(206776);
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim2.length() > 0) {
                    aoVar = am(trim2);
                }
                h.u uVar = new h.u(trim, aoVar);
                AppMethodBeat.o(206776);
                return uVar;
            }
            h.u uVar2 = new h.u(str.substring(4).trim(), null);
            AppMethodBeat.o(206776);
            return uVar2;
        }
        h.ao am = am(str);
        AppMethodBeat.o(206776);
        return am;
    }

    private static h.ao am(String str) {
        AppMethodBeat.i(206777);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3387192:
                if (str.equals("none")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1442907498:
                if (str.equals("currentColor")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.f fVar = h.f.aQv;
                AppMethodBeat.o(206777);
                return fVar;
            case 1:
                h.g qT = h.g.qT();
                AppMethodBeat.o(206777);
                return qT;
            default:
                try {
                    h.f an = an(str);
                    AppMethodBeat.o(206777);
                    return an;
                } catch (k e2) {
                    AppMethodBeat.o(206777);
                    return null;
                }
        }
    }

    private static h.f an(String str) {
        float f2;
        AppMethodBeat.i(206778);
        if (str.charAt(0) == '#') {
            d f3 = d.f(str, str.length());
            if (f3 == null) {
                k kVar = new k("Bad hex colour value: ".concat(String.valueOf(str)));
                AppMethodBeat.o(206778);
                throw kVar;
            }
            switch (f3.pos) {
                case 4:
                    int i2 = (int) f3.value;
                    int i3 = i2 & 3840;
                    int i4 = i2 & 240;
                    int i5 = i2 & 15;
                    h.f fVar = new h.f((i3 << 8) | (i3 << 12) | WebView.NIGHT_MODE_COLOR | (i4 << 8) | (i4 << 4) | (i5 << 4) | i5);
                    AppMethodBeat.o(206778);
                    return fVar;
                case 5:
                    int i6 = (int) f3.value;
                    int i7 = 61440 & i6;
                    int i8 = i6 & 3840;
                    int i9 = i6 & 240;
                    int i10 = i6 & 15;
                    h.f fVar2 = new h.f((i7 << 4) | (i10 << 24) | (i10 << 28) | (i7 << 8) | (i8 << 4) | i8 | i9 | (i9 >> 4));
                    AppMethodBeat.o(206778);
                    return fVar2;
                case 6:
                case 8:
                default:
                    k kVar2 = new k("Bad hex colour value: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(206778);
                    throw kVar2;
                case 7:
                    h.f fVar3 = new h.f(((int) f3.value) | WebView.NIGHT_MODE_COLOR);
                    AppMethodBeat.o(206778);
                    return fVar3;
                case 9:
                    h.f fVar4 = new h.f((((int) f3.value) >>> 8) | (((int) f3.value) << 24));
                    AppMethodBeat.o(206778);
                    return fVar4;
            }
        } else {
            String lowerCase = str.toLowerCase(Locale.US);
            boolean startsWith = lowerCase.startsWith("rgba(");
            if (startsWith || lowerCase.startsWith("rgb(")) {
                h hVar = new h(str.substring(startsWith ? 5 : 4));
                hVar.rs();
                float nextFloat = hVar.nextFloat();
                if (!Float.isNaN(nextFloat) && hVar.b('%')) {
                    nextFloat = (nextFloat * 256.0f) / 100.0f;
                }
                float U = hVar.U(nextFloat);
                if (!Float.isNaN(U) && hVar.b('%')) {
                    U = (U * 256.0f) / 100.0f;
                }
                float U2 = hVar.U(U);
                if (Float.isNaN(U2) || !hVar.b('%')) {
                    f2 = U2;
                } else {
                    f2 = (U2 * 256.0f) / 100.0f;
                }
                if (startsWith) {
                    float U3 = hVar.U(f2);
                    hVar.rs();
                    if (Float.isNaN(U3) || !hVar.b(')')) {
                        k kVar3 = new k("Bad rgba() colour value: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206778);
                        throw kVar3;
                    }
                    h.f fVar5 = new h.f((T(nextFloat) << 16) | (T(U3 * 256.0f) << 24) | (T(U) << 8) | T(f2));
                    AppMethodBeat.o(206778);
                    return fVar5;
                }
                hVar.rs();
                if (Float.isNaN(f2) || !hVar.b(')')) {
                    k kVar4 = new k("Bad rgb() colour value: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(206778);
                    throw kVar4;
                }
                h.f fVar6 = new h.f((T(nextFloat) << 16) | WebView.NIGHT_MODE_COLOR | (T(U) << 8) | T(f2));
                AppMethodBeat.o(206778);
                return fVar6;
            }
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (startsWith2 || lowerCase.startsWith("hsl(")) {
                h hVar2 = new h(str.substring(startsWith2 ? 5 : 4));
                hVar2.rs();
                float nextFloat2 = hVar2.nextFloat();
                float U4 = hVar2.U(nextFloat2);
                if (!Float.isNaN(U4)) {
                    hVar2.b('%');
                }
                float U5 = hVar2.U(U4);
                if (!Float.isNaN(U5)) {
                    hVar2.b('%');
                }
                if (startsWith2) {
                    float U6 = hVar2.U(U5);
                    hVar2.rs();
                    if (Float.isNaN(U6) || !hVar2.b(')')) {
                        k kVar5 = new k("Bad hsla() colour value: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(206778);
                        throw kVar5;
                    }
                    h.f fVar7 = new h.f((T(U6 * 256.0f) << 24) | h(nextFloat2, U4, U5));
                    AppMethodBeat.o(206778);
                    return fVar7;
                }
                hVar2.rs();
                if (Float.isNaN(U5) || !hVar2.b(')')) {
                    k kVar6 = new k("Bad hsl() colour value: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(206778);
                    throw kVar6;
                }
                h.f fVar8 = new h.f(h(nextFloat2, U4, U5) | WebView.NIGHT_MODE_COLOR);
                AppMethodBeat.o(206778);
                return fVar8;
            }
            h.f ao = ao(lowerCase);
            AppMethodBeat.o(206778);
            return ao;
        }
    }

    private static int T(float f2) {
        AppMethodBeat.i(206779);
        if (f2 < 0.0f) {
            AppMethodBeat.o(206779);
            return 0;
        } else if (f2 > 255.0f) {
            AppMethodBeat.o(206779);
            return 255;
        } else {
            int round = Math.round(f2);
            AppMethodBeat.o(206779);
            return round;
        }
    }

    private static int h(float f2, float f3, float f4) {
        float f5;
        AppMethodBeat.i(206780);
        float f6 = (f2 >= 0.0f ? f2 % 360.0f : (f2 % 360.0f) + 360.0f) / 60.0f;
        float f7 = f3 / 100.0f;
        float f8 = f4 / 100.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (f8 < 0.0f) {
            f8 = 0.0f;
        } else if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        if (f8 <= 0.5f) {
            f5 = (f7 + 1.0f) * f8;
        } else {
            f5 = (f8 + f7) - (f8 * f7);
        }
        float f9 = (f8 * 2.0f) - f5;
        int T = T(i(f9, f5, f6 - 2.0f) * 256.0f) | (T(i(f9, f5, f6 + 2.0f) * 256.0f) << 16) | (T(i(f9, f5, f6) * 256.0f) << 8);
        AppMethodBeat.o(206780);
        return T;
    }

    private static float i(float f2, float f3, float f4) {
        float f5;
        if (f4 < 0.0f) {
            f5 = f4 + 6.0f;
        } else {
            f5 = f4;
        }
        if (f5 >= 6.0f) {
            f5 -= 6.0f;
        }
        if (f5 < 1.0f) {
            return (f5 * (f3 - f2)) + f2;
        }
        if (f5 < 3.0f) {
            return f3;
        }
        if (f5 >= 4.0f) {
            return f2;
        }
        return ((4.0f - f5) * (f3 - f2)) + f2;
    }

    private static h.f ao(String str) {
        AppMethodBeat.i(206781);
        Integer aK = b.aK(str);
        if (aK == null) {
            k kVar = new k("Invalid colour keyword: ".concat(String.valueOf(str)));
            AppMethodBeat.o(206781);
            throw kVar;
        }
        h.f fVar = new h.f(aK.intValue());
        AppMethodBeat.o(206781);
        return fVar;
    }

    private static void a(h.ae aeVar, String str) {
        String c2;
        AppMethodBeat.i(206782);
        if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains("|" + str + '|')) {
            AppMethodBeat.o(206782);
            return;
        }
        h hVar = new h(str);
        String str2 = null;
        h.ae.b bVar = null;
        Integer num = null;
        while (true) {
            c2 = hVar.c('/');
            hVar.rs();
            if (c2 != null) {
                if (num == null || bVar == null) {
                    if (!c2.equals("normal") && ((num != null || (num = d.aK(c2)) == null) && (bVar != null || (bVar = ar(c2)) == null))) {
                        if (str2 != null || !c2.equals("small-caps")) {
                            break;
                        }
                        str2 = c2;
                    }
                } else {
                    break;
                }
            } else {
                AppMethodBeat.o(206782);
                return;
            }
        }
        h.p aq = aq(c2);
        if (hVar.b('/')) {
            hVar.rs();
            String nextToken = hVar.nextToken();
            if (nextToken != null) {
                try {
                    ag(nextToken);
                } catch (k e2) {
                    AppMethodBeat.o(206782);
                    return;
                }
            }
            hVar.rs();
        }
        aeVar.aRx = ap(hVar.rF());
        aeVar.aRy = aq;
        aeVar.aRz = Integer.valueOf(num == null ? 400 : num.intValue());
        if (bVar == null) {
            bVar = h.ae.b.Normal;
        }
        aeVar.aRA = bVar;
        aeVar.aRj |= 122880;
        AppMethodBeat.o(206782);
    }

    private static List<String> ap(String str) {
        AppMethodBeat.i(206783);
        ArrayList arrayList = null;
        h hVar = new h(str);
        do {
            String rE = hVar.rE();
            if (rE == null) {
                rE = hVar.a(',', true);
            }
            if (rE == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(rE);
            hVar.rt();
        } while (!hVar.empty());
        AppMethodBeat.o(206783);
        return arrayList;
    }

    private static h.p aq(String str) {
        AppMethodBeat.i(206784);
        try {
            h.p aL = c.aL(str);
            if (aL == null) {
                aL = ag(str);
            }
            AppMethodBeat.o(206784);
            return aL;
        } catch (k e2) {
            AppMethodBeat.o(206784);
            return null;
        }
    }

    private static h.ae.b ar(String str) {
        AppMethodBeat.i(206785);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.ae.b bVar = h.ae.b.Italic;
                AppMethodBeat.o(206785);
                return bVar;
            case 1:
                h.ae.b bVar2 = h.ae.b.Normal;
                AppMethodBeat.o(206785);
                return bVar2;
            case 2:
                h.ae.b bVar3 = h.ae.b.Oblique;
                AppMethodBeat.o(206785);
                return bVar3;
            default:
                AppMethodBeat.o(206785);
                return null;
        }
    }

    private static h.ae.g as(String str) {
        AppMethodBeat.i(206786);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c2 = 0;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c2 = 4;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.ae.g gVar = h.ae.g.None;
                AppMethodBeat.o(206786);
                return gVar;
            case 1:
                h.ae.g gVar2 = h.ae.g.Underline;
                AppMethodBeat.o(206786);
                return gVar2;
            case 2:
                h.ae.g gVar3 = h.ae.g.Overline;
                AppMethodBeat.o(206786);
                return gVar3;
            case 3:
                h.ae.g gVar4 = h.ae.g.LineThrough;
                AppMethodBeat.o(206786);
                return gVar4;
            case 4:
                h.ae.g gVar5 = h.ae.g.Blink;
                AppMethodBeat.o(206786);
                return gVar5;
            default:
                AppMethodBeat.o(206786);
                return null;
        }
    }

    private static h.ae.EnumC0057h at(String str) {
        AppMethodBeat.i(206787);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 107498:
                if (str.equals("ltr")) {
                    c2 = 0;
                    break;
                }
                break;
            case 113258:
                if (str.equals("rtl")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.ae.EnumC0057h hVar = h.ae.EnumC0057h.LTR;
                AppMethodBeat.o(206787);
                return hVar;
            case 1:
                h.ae.EnumC0057h hVar2 = h.ae.EnumC0057h.RTL;
                AppMethodBeat.o(206787);
                return hVar2;
            default:
                AppMethodBeat.o(206787);
                return null;
        }
    }

    private static h.ae.a au(String str) {
        AppMethodBeat.i(206788);
        if ("nonzero".equals(str)) {
            h.ae.a aVar = h.ae.a.NonZero;
            AppMethodBeat.o(206788);
            return aVar;
        } else if ("evenodd".equals(str)) {
            h.ae.a aVar2 = h.ae.a.EvenOdd;
            AppMethodBeat.o(206788);
            return aVar2;
        } else {
            AppMethodBeat.o(206788);
            return null;
        }
    }

    private static h.ae.c av(String str) {
        AppMethodBeat.i(206789);
        if ("butt".equals(str)) {
            h.ae.c cVar = h.ae.c.Butt;
            AppMethodBeat.o(206789);
            return cVar;
        } else if ("round".equals(str)) {
            h.ae.c cVar2 = h.ae.c.Round;
            AppMethodBeat.o(206789);
            return cVar2;
        } else if (MessengerShareContentUtility.IMAGE_RATIO_SQUARE.equals(str)) {
            h.ae.c cVar3 = h.ae.c.Square;
            AppMethodBeat.o(206789);
            return cVar3;
        } else {
            AppMethodBeat.o(206789);
            return null;
        }
    }

    private static h.ae.d aw(String str) {
        AppMethodBeat.i(206790);
        if ("miter".equals(str)) {
            h.ae.d dVar = h.ae.d.Miter;
            AppMethodBeat.o(206790);
            return dVar;
        } else if ("round".equals(str)) {
            h.ae.d dVar2 = h.ae.d.Round;
            AppMethodBeat.o(206790);
            return dVar2;
        } else if ("bevel".equals(str)) {
            h.ae.d dVar3 = h.ae.d.Bevel;
            AppMethodBeat.o(206790);
            return dVar3;
        } else {
            AppMethodBeat.o(206790);
            return null;
        }
    }

    private static h.p[] ax(String str) {
        AppMethodBeat.i(206791);
        h hVar = new h(str);
        hVar.rs();
        if (hVar.empty()) {
            AppMethodBeat.o(206791);
            return null;
        }
        h.p rw = hVar.rw();
        if (rw == null) {
            AppMethodBeat.o(206791);
            return null;
        } else if (rw.isNegative()) {
            AppMethodBeat.o(206791);
            return null;
        } else {
            float f2 = rw.value;
            ArrayList arrayList = new ArrayList();
            arrayList.add(rw);
            while (!hVar.empty()) {
                hVar.rt();
                h.p rw2 = hVar.rw();
                if (rw2 == null) {
                    AppMethodBeat.o(206791);
                    return null;
                } else if (rw2.isNegative()) {
                    AppMethodBeat.o(206791);
                    return null;
                } else {
                    arrayList.add(rw2);
                    f2 += rw2.value;
                }
            }
            if (f2 == 0.0f) {
                AppMethodBeat.o(206791);
                return null;
            }
            h.p[] pVarArr = (h.p[]) arrayList.toArray(new h.p[arrayList.size()]);
            AppMethodBeat.o(206791);
            return pVarArr;
        }
    }

    private static h.ae.f ay(String str) {
        AppMethodBeat.i(206792);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.ae.f fVar = h.ae.f.Start;
                AppMethodBeat.o(206792);
                return fVar;
            case 1:
                h.ae.f fVar2 = h.ae.f.Middle;
                AppMethodBeat.o(206792);
                return fVar2;
            case 2:
                h.ae.f fVar3 = h.ae.f.End;
                AppMethodBeat.o(206792);
                return fVar3;
            default:
                AppMethodBeat.o(206792);
                return null;
        }
    }

    private static Boolean az(String str) {
        AppMethodBeat.i(206793);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c2 = 2;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 1;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(206793);
                return bool;
            case 2:
            case 3:
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(206793);
                return bool2;
            default:
                AppMethodBeat.o(206793);
                return null;
        }
    }

    private static h.c aA(String str) {
        AppMethodBeat.i(206794);
        if ("auto".equals(str)) {
            AppMethodBeat.o(206794);
            return null;
        } else if (!str.startsWith("rect(")) {
            AppMethodBeat.o(206794);
            return null;
        } else {
            h hVar = new h(str.substring(5));
            hVar.rs();
            h.p b2 = b(hVar);
            hVar.rt();
            h.p b3 = b(hVar);
            hVar.rt();
            h.p b4 = b(hVar);
            hVar.rt();
            h.p b5 = b(hVar);
            hVar.rs();
            if (hVar.b(')') || hVar.empty()) {
                h.c cVar = new h.c(b2, b3, b4, b5);
                AppMethodBeat.o(206794);
                return cVar;
            }
            AppMethodBeat.o(206794);
            return null;
        }
    }

    private static h.p b(h hVar) {
        AppMethodBeat.i(206795);
        if (hVar.aO("auto")) {
            h.p pVar = new h.p(0.0f);
            AppMethodBeat.o(206795);
            return pVar;
        }
        h.p rw = hVar.rw();
        AppMethodBeat.o(206795);
        return rw;
    }

    private static h.ae.i aB(String str) {
        AppMethodBeat.i(206796);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3387192:
                if (str.equals("none")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1629199934:
                if (str.equals("non-scaling-stroke")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.ae.i iVar = h.ae.i.None;
                AppMethodBeat.o(206796);
                return iVar;
            case 1:
                h.ae.i iVar2 = h.ae.i.NonScalingStroke;
                AppMethodBeat.o(206796);
                return iVar2;
            default:
                AppMethodBeat.o(206796);
                return null;
        }
    }

    private static h.ae.e aC(String str) {
        AppMethodBeat.i(206797);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 0;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                h.ae.e eVar = h.ae.e.auto;
                AppMethodBeat.o(206797);
                return eVar;
            case 1:
                h.ae.e eVar2 = h.ae.e.optimizeQuality;
                AppMethodBeat.o(206797);
                return eVar2;
            case 2:
                h.ae.e eVar3 = h.ae.e.optimizeSpeed;
                AppMethodBeat.o(206797);
                return eVar3;
            default:
                AppMethodBeat.o(206797);
                return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 218
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    private static com.a.a.h.w aD(java.lang.String r16) {
        /*
        // Method dump skipped, instructions count: 888
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.l.aD(java.lang.String):com.a.a.h$w");
    }

    private static Set<String> aE(String str) {
        AppMethodBeat.i(206799);
        h hVar = new h(str);
        HashSet hashSet = new HashSet();
        while (!hVar.empty()) {
            String nextToken = hVar.nextToken();
            if (nextToken.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(nextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            hVar.rs();
        }
        AppMethodBeat.o(206799);
        return hashSet;
    }

    private static Set<String> aF(String str) {
        AppMethodBeat.i(206800);
        h hVar = new h(str);
        HashSet hashSet = new HashSet();
        while (!hVar.empty()) {
            String nextToken = hVar.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            hVar.rs();
        }
        AppMethodBeat.o(206800);
        return hashSet;
    }

    private static Set<String> aG(String str) {
        AppMethodBeat.i(206801);
        h hVar = new h(str);
        HashSet hashSet = new HashSet();
        while (!hVar.empty()) {
            hashSet.add(hVar.nextToken());
            hVar.rs();
        }
        AppMethodBeat.o(206801);
        return hashSet;
    }

    private static String aH(String str) {
        AppMethodBeat.i(206802);
        if (str.equals("none")) {
            AppMethodBeat.o(206802);
            return null;
        } else if (!str.startsWith("url(")) {
            AppMethodBeat.o(206802);
            return null;
        } else if (str.endsWith(")")) {
            String trim = str.substring(4, str.length() - 1).trim();
            AppMethodBeat.o(206802);
            return trim;
        } else {
            String trim2 = str.substring(4).trim();
            AppMethodBeat.o(206802);
            return trim2;
        }
    }

    private void C(Attributes attributes) {
        AppMethodBeat.i(206803);
        if (this.aTN == null) {
            k kVar = new k("Invalid document. Root element must be <svg>");
            AppMethodBeat.o(206803);
            throw kVar;
        }
        String str = "all";
        boolean z = true;
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.aTW[f.aM(attributes.getLocalName(i2)).ordinal()]) {
                case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                    z = trim.equals("text/css");
                    break;
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                    str = trim;
                    break;
            }
        }
        if (!z || !b.a(str, b.e.screen)) {
            this.aTO = true;
            this.aTP = 1;
            AppMethodBeat.o(206803);
            return;
        }
        this.aTT = true;
        AppMethodBeat.o(206803);
    }

    private void aI(String str) {
        AppMethodBeat.i(206804);
        this.aTM.b(new b(b.e.screen, b.t.Document).W(str));
        AppMethodBeat.o(206804);
    }
}
