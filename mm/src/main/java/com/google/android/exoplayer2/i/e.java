package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    private static final Pattern bGW = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern bGX = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern bGY = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> bGZ;

    static {
        AppMethodBeat.i(93132);
        HashMap hashMap = new HashMap();
        bGZ = hashMap;
        hashMap.put("aliceblue", -984833);
        bGZ.put("antiquewhite", -332841);
        bGZ.put("aqua", -16711681);
        bGZ.put("aquamarine", -8388652);
        bGZ.put("azure", -983041);
        bGZ.put("beige", -657956);
        bGZ.put("bisque", -6972);
        bGZ.put("black", Integer.valueOf((int) WebView.NIGHT_MODE_COLOR));
        bGZ.put("blanchedalmond", -5171);
        bGZ.put("blue", -16776961);
        bGZ.put("blueviolet", -7722014);
        bGZ.put("brown", -5952982);
        bGZ.put("burlywood", -2180985);
        bGZ.put("cadetblue", -10510688);
        bGZ.put("chartreuse", -8388864);
        bGZ.put("chocolate", -2987746);
        bGZ.put("coral", -32944);
        bGZ.put("cornflowerblue", -10185235);
        bGZ.put("cornsilk", -1828);
        bGZ.put("crimson", -2354116);
        bGZ.put("cyan", -16711681);
        bGZ.put("darkblue", -16777077);
        bGZ.put("darkcyan", -16741493);
        bGZ.put("darkgoldenrod", -4684277);
        bGZ.put("darkgray", -5658199);
        bGZ.put("darkgreen", -16751616);
        bGZ.put("darkgrey", -5658199);
        bGZ.put("darkkhaki", -4343957);
        bGZ.put("darkmagenta", -7667573);
        bGZ.put("darkolivegreen", -11179217);
        bGZ.put("darkorange", -29696);
        bGZ.put("darkorchid", -6737204);
        bGZ.put("darkred", -7667712);
        bGZ.put("darksalmon", -1468806);
        bGZ.put("darkseagreen", -7357297);
        bGZ.put("darkslateblue", -12042869);
        bGZ.put("darkslategray", -13676721);
        bGZ.put("darkslategrey", -13676721);
        bGZ.put("darkturquoise", -16724271);
        bGZ.put("darkviolet", -7077677);
        bGZ.put("deeppink", -60269);
        bGZ.put("deepskyblue", -16728065);
        bGZ.put("dimgray", -9868951);
        bGZ.put("dimgrey", -9868951);
        bGZ.put("dodgerblue", -14774017);
        bGZ.put("firebrick", -5103070);
        bGZ.put("floralwhite", -1296);
        bGZ.put("forestgreen", -14513374);
        bGZ.put("fuchsia", -65281);
        bGZ.put("gainsboro", -2302756);
        bGZ.put("ghostwhite", -460545);
        bGZ.put("gold", -10496);
        bGZ.put("goldenrod", -2448096);
        bGZ.put("gray", -8355712);
        bGZ.put("green", -16744448);
        bGZ.put("greenyellow", -5374161);
        bGZ.put("grey", -8355712);
        bGZ.put("honeydew", -983056);
        bGZ.put("hotpink", -38476);
        bGZ.put("indianred", -3318692);
        bGZ.put("indigo", -11861886);
        bGZ.put("ivory", -16);
        bGZ.put("khaki", -989556);
        bGZ.put("lavender", -1644806);
        bGZ.put("lavenderblush", -3851);
        bGZ.put("lawngreen", -8586240);
        bGZ.put("lemonchiffon", -1331);
        bGZ.put("lightblue", -5383962);
        bGZ.put("lightcoral", -1015680);
        bGZ.put("lightcyan", -2031617);
        bGZ.put("lightgoldenrodyellow", -329006);
        bGZ.put("lightgray", -2894893);
        bGZ.put("lightgreen", -7278960);
        bGZ.put("lightgrey", -2894893);
        bGZ.put("lightpink", -18751);
        bGZ.put("lightsalmon", -24454);
        bGZ.put("lightseagreen", -14634326);
        bGZ.put("lightskyblue", -7876870);
        bGZ.put("lightslategray", -8943463);
        bGZ.put("lightslategrey", -8943463);
        bGZ.put("lightsteelblue", -5192482);
        bGZ.put("lightyellow", -32);
        bGZ.put("lime", -16711936);
        bGZ.put("limegreen", -13447886);
        bGZ.put("linen", -331546);
        bGZ.put("magenta", -65281);
        bGZ.put("maroon", -8388608);
        bGZ.put("mediumaquamarine", -10039894);
        bGZ.put("mediumblue", -16777011);
        bGZ.put("mediumorchid", -4565549);
        bGZ.put("mediumpurple", -7114533);
        bGZ.put("mediumseagreen", -12799119);
        bGZ.put("mediumslateblue", -8689426);
        bGZ.put("mediumspringgreen", -16713062);
        bGZ.put("mediumturquoise", -12004916);
        bGZ.put("mediumvioletred", -3730043);
        bGZ.put("midnightblue", -15132304);
        bGZ.put("mintcream", -655366);
        bGZ.put("mistyrose", -6943);
        bGZ.put("moccasin", -6987);
        bGZ.put("navajowhite", -8531);
        bGZ.put("navy", -16777088);
        bGZ.put("oldlace", -133658);
        bGZ.put("olive", -8355840);
        bGZ.put("olivedrab", -9728477);
        bGZ.put("orange", -23296);
        bGZ.put("orangered", -47872);
        bGZ.put("orchid", -2461482);
        bGZ.put("palegoldenrod", -1120086);
        bGZ.put("palegreen", -6751336);
        bGZ.put("paleturquoise", -5247250);
        bGZ.put("palevioletred", -2396013);
        bGZ.put("papayawhip", -4139);
        bGZ.put("peachpuff", -9543);
        bGZ.put("peru", -3308225);
        bGZ.put("pink", -16181);
        bGZ.put("plum", -2252579);
        bGZ.put("powderblue", -5185306);
        bGZ.put("purple", -8388480);
        bGZ.put("rebeccapurple", -10079335);
        bGZ.put("red", -65536);
        bGZ.put("rosybrown", -4419697);
        bGZ.put("royalblue", -12490271);
        bGZ.put("saddlebrown", -7650029);
        bGZ.put("salmon", -360334);
        bGZ.put("sandybrown", -744352);
        bGZ.put("seagreen", -13726889);
        bGZ.put("seashell", -2578);
        bGZ.put("sienna", -6270419);
        bGZ.put("silver", -4144960);
        bGZ.put("skyblue", -7876885);
        bGZ.put("slateblue", -9807155);
        bGZ.put("slategray", -9404272);
        bGZ.put("slategrey", -9404272);
        bGZ.put("snow", -1286);
        bGZ.put("springgreen", -16711809);
        bGZ.put("steelblue", -12156236);
        bGZ.put("tan", -2968436);
        bGZ.put("teal", -16744320);
        bGZ.put("thistle", -2572328);
        bGZ.put("tomato", -40121);
        bGZ.put("transparent", 0);
        bGZ.put("turquoise", -12525360);
        bGZ.put("violet", -1146130);
        bGZ.put("wheat", -663885);
        bGZ.put("white", -1);
        bGZ.put("whitesmoke", -657931);
        bGZ.put("yellow", -256);
        bGZ.put("yellowgreen", -6632142);
        AppMethodBeat.o(93132);
    }

    public static int bv(String str) {
        AppMethodBeat.i(93128);
        int f2 = f(str, false);
        AppMethodBeat.o(93128);
        return f2;
    }

    public static int bw(String str) {
        AppMethodBeat.i(93129);
        int f2 = f(str, true);
        AppMethodBeat.o(93129);
        return f2;
    }

    private static int f(String str, boolean z) {
        int parseInt;
        int i2;
        AppMethodBeat.i(93130);
        a.checkArgument(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                i2 = parseLong | WebView.NIGHT_MODE_COLOR;
            } else if (replace.length() == 9) {
                i2 = (parseLong >>> 8) | ((parseLong & 255) << 24);
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.o(93130);
                throw illegalArgumentException;
            }
            AppMethodBeat.o(93130);
            return i2;
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? bGY : bGX).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                int argb = argb(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                AppMethodBeat.o(93130);
                return argb;
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = bGW.matcher(replace);
            if (matcher2.matches()) {
                int rgb = rgb(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                AppMethodBeat.o(93130);
                return rgb;
            }
        } else {
            Integer num = bGZ.get(x.bH(replace));
            if (num != null) {
                int intValue = num.intValue();
                AppMethodBeat.o(93130);
                return intValue;
            }
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException();
        AppMethodBeat.o(93130);
        throw illegalArgumentException2;
    }

    private static int argb(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    private static int rgb(int i2, int i3, int i4) {
        AppMethodBeat.i(93131);
        int argb = argb(255, i2, i3, i4);
        AppMethodBeat.o(93131);
        return argb;
    }
}
