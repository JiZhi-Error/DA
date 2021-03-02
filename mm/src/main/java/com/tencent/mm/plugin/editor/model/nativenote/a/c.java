package com.tencent.mm.plugin.editor.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.o;
import com.tencent.mm.plugin.editor.model.nativenote.spans.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c implements Html.TagHandler {
    private static final Pattern bCJ = Pattern.compile("\\d+");
    private static final Pattern qQe = Pattern.compile("#[a-f0-9]+");
    private static HashMap<String, Integer> qQf;
    private Stack<com.tencent.mm.plugin.editor.model.nativenote.spans.a> qQc = new Stack<>();
    final HashMap<String, String> qQd = new HashMap<>();

    public c() {
        AppMethodBeat.i(181704);
        AppMethodBeat.o(181704);
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        int alT;
        int alT2;
        Object dVar;
        String str2;
        String str3;
        int i2;
        Object fVar;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(181705);
        this.qQd.clear();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("data");
            declaredField3.setAccessible(true);
            String[] strArr = (String[]) declaredField3.get(obj2);
            Field declaredField4 = obj2.getClass().getDeclaredField("length");
            declaredField4.setAccessible(true);
            int intValue = ((Integer) declaredField4.get(obj2)).intValue();
            for (int i3 = 0; i3 < intValue; i3++) {
                this.qQd.put(strArr[(i3 * 5) + 1], strArr[(i3 * 5) + 4]);
            }
        } catch (Exception e2) {
        }
        if (!z) {
            if (str.equalsIgnoreCase("wx-ul")) {
                lg(false);
            } else if (str.equalsIgnoreCase("wx-ol")) {
                lg(true);
            } else if (str.equalsIgnoreCase("wn-todo")) {
                AbstractC0949c cVar = (AbstractC0949c) a(editable, (Class<? extends Object>) AbstractC0949c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != '\n') {
                        editable.append('\n');
                    }
                    int spanStart = editable.getSpanStart(cVar);
                    int length = editable.length();
                    if (!cVar.qQk) {
                        editable.setSpan(new s(((e) cVar).oD, com.tencent.mm.plugin.editor.model.nativenote.manager.f.cDE(), spanStart == length, false, false), spanStart, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-li")) {
                AbstractC0949c cVar2 = (AbstractC0949c) a(editable, (Class<? extends Object>) AbstractC0949c.class);
                if (cVar2 != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != '\n') {
                        editable.append('\n');
                    }
                    int spanStart2 = editable.getSpanStart(cVar2);
                    int length2 = editable.length();
                    if (!cVar2.qQk) {
                        int cDE = com.tencent.mm.plugin.editor.model.nativenote.manager.f.cDE();
                        if (cVar2 instanceof d) {
                            dVar = new k(1, cDE, spanStart2 == length2, false, false);
                        } else {
                            if (spanStart2 != length2) {
                                z2 = false;
                            }
                            dVar = new com.tencent.mm.plugin.editor.model.nativenote.spans.d(cDE, z2, false, false);
                        }
                        editable.setSpan(dVar, spanStart2, length2, 33);
                    }
                    editable.removeSpan(cVar2);
                }
            } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
                int length3 = editable.length();
                Object a2 = a(editable, (Class<? extends Object>) b.class);
                if (a2 != null) {
                    int spanStart3 = editable.getSpanStart(a2);
                    editable.removeSpan(a2);
                    if (spanStart3 != length3) {
                        b bVar = (b) a2;
                        if (!TextUtils.isEmpty(bVar.qQi)) {
                            editable.setSpan(new TypefaceSpan(bVar.qQi), spanStart3, length3, 33);
                        }
                        if (bVar.mSize > 0) {
                            editable.setSpan(new AbsoluteSizeSpan(com.tencent.mm.plugin.editor.model.nativenote.manager.f.Fz(bVar.mSize)), spanStart3, length3, 33);
                        }
                        if ((!TextUtils.isEmpty(bVar.qQg)) && (alT2 = alT(bVar.qQg)) != -1) {
                            editable.setSpan(new ForegroundColorSpan(alT2 | WebView.NIGHT_MODE_COLOR), spanStart3, length3, 33);
                        }
                        if (TextUtils.isEmpty(bVar.qQh)) {
                            z2 = false;
                        }
                        if (z2 && (alT = alT(bVar.qQh)) != -1) {
                            editable.setSpan(new BackgroundColorSpan(alT | WebView.NIGHT_MODE_COLOR), spanStart3, length3, 33);
                        }
                    }
                }
            } else if (str.equalsIgnoreCase("wx-b")) {
                Object boldSpan = new BoldSpan();
                int length4 = editable.length();
                Object a3 = a(editable, (Class<? extends Object>) a.class);
                int spanStart4 = editable.getSpanStart(a3);
                editable.removeSpan(a3);
                if (spanStart4 != length4) {
                    editable.setSpan(boldSpan, spanStart4, length4, 33);
                }
            } else if (str.equalsIgnoreCase("wx-p")) {
                d(editable);
            } else {
                str.equalsIgnoreCase("wx-div");
            }
            this.qQd.clear();
        } else if (str.equalsIgnoreCase("wx-ul")) {
            a(false, o.NOTEUL);
        } else if (str.equalsIgnoreCase("wx-ol")) {
            a(true, o.NOTEOL);
        } else if (str.equalsIgnoreCase("wn-todo")) {
            this.qQc.push(new com.tencent.mm.plugin.editor.model.nativenote.spans.a(o.NOTETODO, 1, 1));
            String str4 = this.qQd.get("checked");
            if (!Util.isNullOrNil(str4) && str4.equals("1")) {
                z3 = true;
            }
            a(editable, new e(this.qQc.peek().qSZ, z3));
        } else if (str.equalsIgnoreCase("wx-li")) {
            String str5 = this.qQd.get("done");
            if (Util.isNullOrNil(str5) || !str5.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                z2 = false;
            }
            if (!this.qQc.isEmpty()) {
                com.tencent.mm.plugin.editor.model.nativenote.spans.a peek = this.qQc.peek();
                o oVar = peek.qSY;
                int i4 = peek.qSZ;
                if (oVar.cEx()) {
                    fVar = new d(i4);
                } else if (oVar.cEw()) {
                    fVar = new f(i4);
                } else if (oVar.cEy()) {
                    fVar = new e(i4, z2);
                } else {
                    fVar = null;
                }
            } else {
                fVar = new f(0);
            }
            if (fVar != null) {
                a(editable, fVar);
            }
        } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
            int i5 = Integer.MIN_VALUE;
            String str6 = this.qQd.get(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            if (str6 != null) {
                String[] split = str6.toLowerCase(Locale.ENGLISH).split(";");
                int length5 = split.length;
                int i6 = 0;
                String str7 = null;
                str3 = null;
                while (i6 < length5) {
                    String str8 = split[i6];
                    if (str8.startsWith("font-size")) {
                        Matcher matcher = bCJ.matcher(str8);
                        if (matcher.find(0)) {
                            try {
                                i2 = Integer.parseInt(str8.substring(matcher.start(), matcher.end()));
                            } catch (NumberFormatException e3) {
                            }
                        }
                        i2 = i5;
                    } else if (str8.startsWith("color")) {
                        Matcher matcher2 = qQe.matcher(str8);
                        if (matcher2.find(0)) {
                            str3 = str8.substring(matcher2.start(), matcher2.end());
                        }
                        i2 = i5;
                    } else {
                        if (str8.startsWith("background-color")) {
                            Matcher matcher3 = qQe.matcher(str8);
                            if (matcher3.find(0)) {
                                str7 = str8.substring(matcher3.start(), matcher3.end());
                                i2 = i5;
                            }
                        }
                        i2 = i5;
                    }
                    i6++;
                    i5 = i2;
                }
                str2 = str7;
            } else {
                str2 = null;
                str3 = null;
            }
            int length6 = editable.length();
            b bVar2 = new b((byte) 0);
            bVar2.mSize = i5;
            bVar2.qQg = str3;
            bVar2.qQh = str2;
            editable.setSpan(bVar2.qQi = this.qQd.get("face"), length6, length6, 17);
        } else if (str.equalsIgnoreCase("wx-b")) {
            a(editable, new a((byte) 0));
        } else if (str.equalsIgnoreCase("wx-p")) {
            d(editable);
        } else if (str.equalsIgnoreCase("wx-div")) {
            d(editable);
        }
        a.qQa = editable;
        AppMethodBeat.o(181705);
    }

    private static void d(Editable editable) {
        AppMethodBeat.i(181706);
        int length = editable.length();
        if (length <= 0 || editable.charAt(length - 1) != '\n') {
            if (length != 0) {
                editable.append("\n");
            }
            AppMethodBeat.o(181706);
            return;
        }
        AppMethodBeat.o(181706);
    }

    private void a(boolean z, o oVar) {
        com.tencent.mm.plugin.editor.model.nativenote.spans.a peek;
        AppMethodBeat.i(181707);
        if (z) {
            oVar = o.NOTEOL;
        }
        if (this.qQc.isEmpty()) {
            peek = null;
        } else {
            peek = this.qQc.peek();
        }
        if (peek == null) {
            this.qQc.push(new com.tencent.mm.plugin.editor.model.nativenote.spans.a(oVar, 1, 1));
            AppMethodBeat.o(181707);
        } else if (peek.qSY == oVar) {
            peek.qSZ++;
            peek.qTa++;
            AppMethodBeat.o(181707);
        } else {
            this.qQc.push(new com.tencent.mm.plugin.editor.model.nativenote.spans.a(oVar, peek.qSZ + 1, 1));
            AppMethodBeat.o(181707);
        }
    }

    private void lg(boolean z) {
        AppMethodBeat.i(181708);
        while (!this.qQc.isEmpty()) {
            com.tencent.mm.plugin.editor.model.nativenote.spans.a peek = this.qQc.peek();
            o oVar = peek.qSY;
            if ((!z || !oVar.cEx()) && ((z || !oVar.cEw()) && (z || !oVar.cEy()))) {
                this.qQc.pop();
            } else {
                int i2 = peek.qTa;
                if (i2 > 1) {
                    peek.qTa = i2 - 1;
                    peek.qSZ--;
                    AppMethodBeat.o(181708);
                    return;
                }
                this.qQc.pop();
                AppMethodBeat.o(181708);
                return;
            }
        }
        AppMethodBeat.o(181708);
    }

    private static Object a(Editable editable, Class<? extends Object> cls) {
        AppMethodBeat.i(181709);
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            AppMethodBeat.o(181709);
            return null;
        }
        Object obj = spans[spans.length - 1];
        AppMethodBeat.o(181709);
        return obj;
    }

    private static void a(Editable editable, Object obj) {
        AppMethodBeat.i(181710);
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
        AppMethodBeat.o(181710);
    }

    static {
        AppMethodBeat.i(181712);
        HashMap<String, Integer> hashMap = new HashMap<>();
        qQf = hashMap;
        hashMap.put("aqua", 65535);
        qQf.put("black", 0);
        qQf.put("blue", 255);
        qQf.put("fuchsia", 16711935);
        qQf.put("green", 32768);
        qQf.put("grey", 8421504);
        qQf.put("lime", 65280);
        qQf.put("maroon", Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCHighTierLevel61));
        qQf.put("navy", 128);
        qQf.put("olive", 8421376);
        qQf.put("purple", 8388736);
        qQf.put("red", 16711680);
        qQf.put("silver", 12632256);
        qQf.put("teal", 32896);
        qQf.put("white", 16777215);
        qQf.put("yellow", 16776960);
        AppMethodBeat.o(181712);
    }

    static class a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.editor.model.nativenote.a.c$c  reason: collision with other inner class name */
    static abstract class AbstractC0949c {
        int qQj;
        boolean qQk = false;

        AbstractC0949c(int i2) {
            this.qQj = i2;
        }
    }

    static class f extends AbstractC0949c {
        f(int i2) {
            super(i2);
        }
    }

    static class d extends AbstractC0949c {
        d(int i2) {
            super(i2);
        }
    }

    static class e extends AbstractC0949c {
        boolean oD = false;

        e(int i2, boolean z) {
            super(i2);
            this.oD = z;
        }
    }

    static class b {
        int mSize;
        String qQg;
        String qQh;
        String qQi;

        private b() {
            this.mSize = Integer.MIN_VALUE;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static int alT(String str) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(181711);
        Integer num = qQf.get(str.toLowerCase());
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(181711);
            return intValue;
        } else if (str == null) {
            try {
                AppMethodBeat.o(181711);
                return -1;
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(181711);
                return -1;
            }
        } else {
            String charSequence = str.toString();
            int length = charSequence.length();
            int i5 = 10;
            if ('-' == charSequence.charAt(0)) {
                i2 = 1;
                i3 = -1;
            } else {
                i2 = 0;
                i3 = 1;
            }
            if ('0' == charSequence.charAt(i2)) {
                if (i2 == length - 1) {
                    AppMethodBeat.o(181711);
                    return 0;
                }
                char charAt = charSequence.charAt(i2 + 1);
                if ('x' == charAt || 'X' == charAt) {
                    i4 = i2 + 2;
                    i5 = 16;
                } else {
                    i4 = i2 + 1;
                    i5 = 8;
                }
            } else if ('#' == charSequence.charAt(i2)) {
                i4 = i2 + 1;
                i5 = 16;
            } else {
                i4 = i2;
            }
            int parseInt = Integer.parseInt(charSequence.substring(i4), i5) * i3;
            AppMethodBeat.o(181711);
            return parseInt;
        }
    }
}
