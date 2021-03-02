package com.tencent.magicbrush.handler.glfont;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.glfont.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* access modifiers changed from: package-private */
@SuppressLint({"LongLogTag"})
public final class g {
    h cNb;
    private HashMap<String, k> cNc;
    a cNd;
    private FloatBuffer cNe;
    private List<k> cNf;
    private j cNg;
    private StringBuilder cNh = new StringBuilder();

    g(e eVar, c cVar) {
        AppMethodBeat.i(206812);
        this.cNb = new h(eVar, this);
        this.cNb.cNo = cVar;
        this.cNc = new HashMap<>();
        this.cNd = new a();
        this.cNf = new ArrayList();
        AppMethodBeat.o(206812);
    }

    /* access modifiers changed from: package-private */
    public final FloatBuffer eb(String str) {
        AppMethodBeat.i(140022);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140022);
            return null;
        }
        List<k> ec = ec(str);
        if (ec == null || ec.size() == 0) {
            AppMethodBeat.o(140022);
            return null;
        }
        int max = (Math.max(str.length(), 10) * 40) + 16;
        if (this.cNe == null || this.cNe.capacity() * 4 < max) {
            this.cNe = ByteBuffer.allocateDirect(max).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.cNe.clear();
        FloatBuffer floatBuffer = this.cNe;
        float I = h.I(ec);
        Paint.FontMetrics fontMetrics = this.cNb.cNr;
        floatBuffer.put(I).put(fontMetrics.ascent).put(fontMetrics.bottom).put(fontMetrics.bottom - fontMetrics.ascent);
        k.a(floatBuffer, ec);
        floatBuffer.flip();
        this.cNf.clear();
        AppMethodBeat.o(140022);
        return floatBuffer;
    }

    private List<k> ec(String str) {
        k s;
        AppMethodBeat.i(140023);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140023);
            return null;
        }
        this.cNf.clear();
        int i2 = 0;
        while (i2 < str.length()) {
            int s2 = s(str, i2);
            if (s2 > 0) {
                s = i(str, i2, s2);
                i2 += s2;
            } else {
                s = s(str.charAt(i2));
                i2++;
            }
            if (s == null) {
                this.cNf.clear();
                AppMethodBeat.o(140023);
                return null;
            }
            this.cNf.add(s);
        }
        List<k> list = this.cNf;
        AppMethodBeat.o(140023);
        return list;
    }

    private k s(char c2) {
        AppMethodBeat.i(140024);
        if (this.cNg == null) {
            AppMethodBeat.o(140024);
            return null;
        }
        String t = t(c2);
        k kVar = this.cNc.get(t);
        if (kVar != null) {
            AppMethodBeat.o(140024);
            return kVar;
        }
        k u = this.cNb.u(c2);
        if (u == null) {
            c.C0193c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + c2 + "]", new Object[0]);
            AppMethodBeat.o(140024);
            return null;
        }
        this.cNc.put(t, u);
        AppMethodBeat.o(140024);
        return u;
    }

    private k i(String str, int i2, int i3) {
        AppMethodBeat.i(140025);
        String j2 = j(str, i2, i3);
        k kVar = this.cNc.get(j2);
        if (kVar != null) {
            AppMethodBeat.o(140025);
            return kVar;
        } else if (com.tencent.magicbrush.a.a.Rt() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("FontDrawableProvider must support");
            AppMethodBeat.o(140025);
            throw illegalStateException;
        } else {
            Drawable r = com.tencent.magicbrush.a.a.Rt().r(str, i2);
            if (r == null) {
                AppMethodBeat.o(140025);
                return null;
            }
            int i4 = (int) this.cNg.fontSize;
            int i5 = (int) this.cNg.fontSize;
            if (i4 <= 0 || i5 <= 0) {
                AppMethodBeat.o(140025);
                return null;
            }
            k a2 = this.cNb.a(r, i4, i5);
            if (a2 == null) {
                c.C0193c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
                AppMethodBeat.o(140025);
                return null;
            }
            a2.cNN = i3;
            this.cNc.put(j2, a2);
            AppMethodBeat.o(140025);
            return a2;
        }
    }

    private static int s(String str, int i2) {
        AppMethodBeat.i(140026);
        if (com.tencent.magicbrush.a.a.Rt() == null) {
            AppMethodBeat.o(140026);
            return 0;
        }
        int q = com.tencent.magicbrush.a.a.Rt().q(str, i2);
        AppMethodBeat.o(140026);
        return q;
    }

    private String j(String str, int i2, int i3) {
        AppMethodBeat.i(140027);
        if (i3 <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException("There is no font drawable");
            AppMethodBeat.o(140027);
            throw illegalStateException;
        }
        this.cNh.setLength(0);
        while (i3 > 0) {
            this.cNh.append(str.charAt(i2));
            i2++;
            i3--;
        }
        this.cNh.append("|").append(this.cNg.fontSize);
        String sb = this.cNh.toString();
        AppMethodBeat.o(140027);
        return sb;
    }

    private String t(char c2) {
        AppMethodBeat.i(140028);
        if (this.cNg == null) {
            AppMethodBeat.o(140028);
            return null;
        }
        this.cNh.setLength(0);
        StringBuilder append = this.cNh.append(c2).append("|").append(this.cNg.fontSize).append("|").append(this.cNg.sB == null ? BuildConfig.COMMAND : Integer.valueOf(this.cNg.sB.hashCode()));
        if (this.cNg.cNx) {
            append.append("|").append(this.cNg.strokeWidth);
        }
        if (this.cNg.cNy != null) {
            append.append("|").append(this.cNg.cNy.cND);
        }
        String sb = append.toString();
        AppMethodBeat.o(140028);
        return sb;
    }

    /* access modifiers changed from: package-private */
    public final void a(j jVar) {
        AppMethodBeat.i(140029);
        this.cNg = jVar;
        h hVar = this.cNb;
        hVar.cNm = jVar;
        hVar.cNn.setTypeface(jVar.sB);
        hVar.cNn.setTextSize(jVar.fontSize);
        if (jVar.cNx) {
            hVar.cNn.setStyle(Paint.Style.STROKE);
            hVar.cNn.setStrokeWidth(jVar.strokeWidth);
        } else {
            hVar.cNn.setStyle(Paint.Style.FILL);
        }
        hVar.cNn.setTextSkewX(0.0f);
        hVar.cNn.setFakeBoldText(false);
        if (jVar.cNy != null) {
            if (jVar.sB == null || jVar.sB.getStyle() != jVar.cNy.cND) {
                if (jVar.cNy == j.a.ITALIC || jVar.cNy == j.a.BOLD_ITALIC) {
                    hVar.cNn.setTextSkewX(-0.25f);
                }
                if (jVar.cNy == j.a.BOLD || jVar.cNy == j.a.BOLD_ITALIC) {
                    hVar.cNn.setFakeBoldText(true);
                }
            }
            if (jVar.cNy.isBold()) {
                hVar.cNn.setFakeBoldText(true);
            }
        }
        if (hVar.cNo != null) {
            hVar.cNo.a(hVar.cNn, jVar.cNw, jVar.fontSize);
        }
        hVar.cNn.getFontMetrics(hVar.cNr);
        AppMethodBeat.o(140029);
    }

    /* access modifiers changed from: package-private */
    public final float ed(String str) {
        AppMethodBeat.i(140030);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140030);
            return 0.0f;
        }
        List<k> ec = ec(str);
        if (ec == null || ec.size() == 0) {
            AppMethodBeat.o(140030);
            return -1.0f;
        }
        float I = h.I(ec);
        AppMethodBeat.o(140030);
        return I;
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        AppMethodBeat.i(140031);
        if (this.cNc != null) {
            for (k kVar : this.cNc.values()) {
                a aVar = this.cNd;
                if (kVar != null) {
                    kVar.setEmpty();
                    aVar.cNi.offer(kVar);
                }
            }
            this.cNc.clear();
        }
        AppMethodBeat.o(140031);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        Queue<k> cNi = new LinkedList();

        a() {
            AppMethodBeat.i(140019);
            AppMethodBeat.o(140019);
        }

        /* access modifiers changed from: package-private */
        public final k Rz() {
            AppMethodBeat.i(140020);
            k poll = this.cNi.poll();
            if (poll == null) {
                k kVar = new k();
                AppMethodBeat.o(140020);
                return kVar;
            }
            AppMethodBeat.o(140020);
            return poll;
        }
    }
}
