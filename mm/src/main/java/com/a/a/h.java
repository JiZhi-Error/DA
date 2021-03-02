package com.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h {
    private static j aQd = null;
    private static boolean aQe = true;
    af aQf = null;
    private float aQg = 96.0f;
    b.q aQh = new b.q();
    private Map<String, al> aQi = new HashMap();
    String desc = "";
    String title = "";

    interface ag {
        void ab(String str);

        void b(Set<String> set);

        void c(Set<String> set);

        void d(Set<String> set);

        void e(Set<String> set);

        Set<String> qV();

        String qW();

        Set<String> qX();

        Set<String> qY();

        Set<String> qZ();
    }

    /* access modifiers changed from: package-private */
    public interface aj {
        void a(an anVar);

        List<an> getChildren();
    }

    interface ax {
        bb ra();
    }

    interface bb {
    }

    interface n {
        void setTransform(Matrix matrix);
    }

    interface t {
    }

    /* access modifiers changed from: package-private */
    public interface x {
        void a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6);

        void close();

        void cubicTo(float f2, float f3, float f4, float f5, float f6, float f7);

        void lineTo(float f2, float f3);

        void moveTo(float f2, float f3);

        void quadTo(float f2, float f3, float f4, float f5);
    }

    /* access modifiers changed from: package-private */
    public enum bd {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent;

        public static bd valueOf(String str) {
            AppMethodBeat.i(206536);
            bd bdVar = (bd) Enum.valueOf(bd.class, str);
            AppMethodBeat.o(206536);
            return bdVar;
        }

        static {
            AppMethodBeat.i(206537);
            AppMethodBeat.o(206537);
        }
    }

    enum k {
        pad,
        reflect,
        repeat;

        public static k valueOf(String str) {
            AppMethodBeat.i(206483);
            k kVar = (k) Enum.valueOf(k.class, str);
            AppMethodBeat.o(206483);
            return kVar;
        }

        static {
            AppMethodBeat.i(206484);
            AppMethodBeat.o(206484);
        }
    }

    h() {
        AppMethodBeat.i(206538);
        AppMethodBeat.o(206538);
    }

    public static h f(InputStream inputStream) {
        AppMethodBeat.i(206539);
        h a2 = new l().a(inputStream, aQe);
        AppMethodBeat.o(206539);
        return a2;
    }

    private Picture aU(int i2, int i3) {
        AppMethodBeat.i(206541);
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i2, i3);
        g gVar = new g();
        gVar.p((float) i2, (float) i3);
        new i(beginRecording, this.aQg).a(this, gVar);
        picture.endRecording();
        AppMethodBeat.o(206541);
        return picture;
    }

    public final float qM() {
        AppMethodBeat.i(206542);
        if (this.aQf == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SVG document is empty");
            AppMethodBeat.o(206542);
            throw illegalArgumentException;
        }
        float f2 = R(this.aQg).width;
        AppMethodBeat.o(206542);
        return f2;
    }

    public final float qN() {
        AppMethodBeat.i(206543);
        if (this.aQf == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SVG document is empty");
            AppMethodBeat.o(206543);
            throw illegalArgumentException;
        }
        float f2 = R(this.aQg).height;
        AppMethodBeat.o(206543);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final an Z(String str) {
        AppMethodBeat.i(206544);
        if (str == null) {
            AppMethodBeat.o(206544);
            return null;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        String replace = str.replace("\\\n", "").replace("\\A", "\n");
        if (replace.length() <= 1 || !replace.startsWith("#")) {
            AppMethodBeat.o(206544);
            return null;
        }
        al aa2 = aa(replace.substring(1));
        AppMethodBeat.o(206544);
        return aa2;
    }

    private b R(float f2) {
        float f3;
        AppMethodBeat.i(206545);
        p pVar = this.aQf.aQJ;
        p pVar2 = this.aQf.aQK;
        if (pVar == null || pVar.isZero() || pVar.aQL == bd.percent || pVar.aQL == bd.em || pVar.aQL == bd.ex) {
            b bVar = new b(-1.0f, -1.0f, -1.0f, -1.0f);
            AppMethodBeat.o(206545);
            return bVar;
        }
        float S = pVar.S(f2);
        if (pVar2 == null) {
            f3 = this.aQf.aQb != null ? (this.aQf.aQb.height * S) / this.aQf.aQb.width : S;
        } else if (pVar2.isZero() || pVar2.aQL == bd.percent || pVar2.aQL == bd.em || pVar2.aQL == bd.ex) {
            b bVar2 = new b(-1.0f, -1.0f, -1.0f, -1.0f);
            AppMethodBeat.o(206545);
            return bVar2;
        } else {
            f3 = pVar2.S(f2);
        }
        b bVar3 = new b(0.0f, 0.0f, S, f3);
        AppMethodBeat.o(206545);
        return bVar3;
    }

    /* access modifiers changed from: package-private */
    public final void b(b.q qVar) {
        AppMethodBeat.i(206546);
        this.aQh.a(qVar);
        AppMethodBeat.o(206546);
    }

    /* access modifiers changed from: package-private */
    public final boolean qO() {
        boolean z2;
        AppMethodBeat.i(206547);
        b.q qVar = this.aQh;
        if (qVar.aPm == null || qVar.aPm.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            AppMethodBeat.o(206547);
            return true;
        }
        AppMethodBeat.o(206547);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void qP() {
        AppMethodBeat.i(206548);
        b.q qVar = this.aQh;
        b.t tVar = b.t.RenderOptions;
        if (qVar.aPm != null) {
            Iterator<b.o> it = qVar.aPm.iterator();
            while (it.hasNext()) {
                if (it.next().aOe == tVar) {
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(206548);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        float height;
        float minX;
        float minY;
        float width;

        b(float f2, float f3, float f4, float f5) {
            this.minX = f2;
            this.minY = f3;
            this.width = f4;
            this.height = f5;
        }

        b(b bVar) {
            this.minX = bVar.minX;
            this.minY = bVar.minY;
            this.width = bVar.width;
            this.height = bVar.height;
        }

        static b i(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(206476);
            b bVar = new b(f2, f3, f4 - f2, f5 - f3);
            AppMethodBeat.o(206476);
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public final float qR() {
            return this.minX + this.width;
        }

        /* access modifiers changed from: package-private */
        public final float qS() {
            return this.minY + this.height;
        }

        /* access modifiers changed from: package-private */
        public final void a(b bVar) {
            AppMethodBeat.i(206477);
            if (bVar.minX < this.minX) {
                this.minX = bVar.minX;
            }
            if (bVar.minY < this.minY) {
                this.minY = bVar.minY;
            }
            if (bVar.qR() > qR()) {
                this.width = bVar.qR() - this.minX;
            }
            if (bVar.qS() > qS()) {
                this.height = bVar.qS() - this.minY;
            }
            AppMethodBeat.o(206477);
        }

        public final String toString() {
            AppMethodBeat.i(206478);
            String str = "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
            AppMethodBeat.o(206478);
            return str;
        }
    }

    static class ae implements Cloneable {
        b aRA;
        g aRB;
        EnumC0057h aRC;
        f aRD;
        Boolean aRE;
        c aRF;
        String aRG;
        String aRH;
        String aRI;
        Boolean aRJ;
        Boolean aRK;
        ao aRL;
        Float aRM;
        String aRN;
        a aRO;
        String aRP;
        ao aRQ;
        Float aRR;
        ao aRS;
        Float aRT;
        i aRU;
        e aRV;
        long aRj = 0;
        ao aRk;
        a aRl;
        Float aRm;
        ao aRn;
        Float aRo;
        p aRp;
        c aRq;
        d aRr;
        Float aRs;
        p[] aRt;
        p aRu;
        Float aRv;
        f aRw;
        List<String> aRx;
        p aRy;
        Integer aRz;

        ae() {
        }

        public enum a {
            NonZero,
            EvenOdd;

            public static a valueOf(String str) {
                AppMethodBeat.i(206505);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(206505);
                return aVar;
            }

            static {
                AppMethodBeat.i(206506);
                AppMethodBeat.o(206506);
            }
        }

        public enum c {
            Butt,
            Round,
            Square;

            public static c valueOf(String str) {
                AppMethodBeat.i(206511);
                c cVar = (c) Enum.valueOf(c.class, str);
                AppMethodBeat.o(206511);
                return cVar;
            }

            static {
                AppMethodBeat.i(206512);
                AppMethodBeat.o(206512);
            }
        }

        public enum d {
            Miter,
            Round,
            Bevel;

            public static d valueOf(String str) {
                AppMethodBeat.i(206514);
                d dVar = (d) Enum.valueOf(d.class, str);
                AppMethodBeat.o(206514);
                return dVar;
            }

            static {
                AppMethodBeat.i(206515);
                AppMethodBeat.o(206515);
            }
        }

        public enum b {
            Normal,
            Italic,
            Oblique;

            public static b valueOf(String str) {
                AppMethodBeat.i(206508);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(206508);
                return bVar;
            }

            static {
                AppMethodBeat.i(206509);
                AppMethodBeat.o(206509);
            }
        }

        public enum f {
            Start,
            Middle,
            End;

            public static f valueOf(String str) {
                AppMethodBeat.i(206520);
                f fVar = (f) Enum.valueOf(f.class, str);
                AppMethodBeat.o(206520);
                return fVar;
            }

            static {
                AppMethodBeat.i(206521);
                AppMethodBeat.o(206521);
            }
        }

        public enum g {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink;

            public static g valueOf(String str) {
                AppMethodBeat.i(206523);
                g gVar = (g) Enum.valueOf(g.class, str);
                AppMethodBeat.o(206523);
                return gVar;
            }

            static {
                AppMethodBeat.i(206524);
                AppMethodBeat.o(206524);
            }
        }

        /* renamed from: com.a.a.h$ae$h  reason: collision with other inner class name */
        public enum EnumC0057h {
            LTR,
            RTL;

            public static EnumC0057h valueOf(String str) {
                AppMethodBeat.i(206526);
                EnumC0057h hVar = (EnumC0057h) Enum.valueOf(EnumC0057h.class, str);
                AppMethodBeat.o(206526);
                return hVar;
            }

            static {
                AppMethodBeat.i(206527);
                AppMethodBeat.o(206527);
            }
        }

        public enum i {
            None,
            NonScalingStroke;

            public static i valueOf(String str) {
                AppMethodBeat.i(206529);
                i iVar = (i) Enum.valueOf(i.class, str);
                AppMethodBeat.o(206529);
                return iVar;
            }

            static {
                AppMethodBeat.i(206530);
                AppMethodBeat.o(206530);
            }
        }

        public enum e {
            auto,
            optimizeQuality,
            optimizeSpeed;

            public static e valueOf(String str) {
                AppMethodBeat.i(206517);
                e eVar = (e) Enum.valueOf(e.class, str);
                AppMethodBeat.o(206517);
                return eVar;
            }

            static {
                AppMethodBeat.i(206518);
                AppMethodBeat.o(206518);
            }
        }

        static ae qU() {
            AppMethodBeat.i(206531);
            ae aeVar = new ae();
            aeVar.aRj = -1;
            aeVar.aRk = f.aQu;
            aeVar.aRl = a.NonZero;
            aeVar.aRm = Float.valueOf(1.0f);
            aeVar.aRn = null;
            aeVar.aRo = Float.valueOf(1.0f);
            aeVar.aRp = new p(1.0f);
            aeVar.aRq = c.Butt;
            aeVar.aRr = d.Miter;
            aeVar.aRs = Float.valueOf(4.0f);
            aeVar.aRt = null;
            aeVar.aRu = new p(0.0f);
            aeVar.aRv = Float.valueOf(1.0f);
            aeVar.aRw = f.aQu;
            aeVar.aRx = null;
            aeVar.aRy = new p(12.0f, bd.pt);
            aeVar.aRz = 400;
            aeVar.aRA = b.Normal;
            aeVar.aRB = g.None;
            aeVar.aRC = EnumC0057h.LTR;
            aeVar.aRD = f.Start;
            aeVar.aRE = Boolean.TRUE;
            aeVar.aRF = null;
            aeVar.aRG = null;
            aeVar.aRH = null;
            aeVar.aRI = null;
            aeVar.aRJ = Boolean.TRUE;
            aeVar.aRK = Boolean.TRUE;
            aeVar.aRL = f.aQu;
            aeVar.aRM = Float.valueOf(1.0f);
            aeVar.aRN = null;
            aeVar.aRO = a.NonZero;
            aeVar.aRP = null;
            aeVar.aRQ = null;
            aeVar.aRR = Float.valueOf(1.0f);
            aeVar.aRS = null;
            aeVar.aRT = Float.valueOf(1.0f);
            aeVar.aRU = i.None;
            aeVar.aRV = e.auto;
            AppMethodBeat.o(206531);
            return aeVar;
        }

        /* access modifiers changed from: package-private */
        public final void aI(boolean z) {
            AppMethodBeat.i(206532);
            this.aRJ = Boolean.TRUE;
            this.aRE = z ? Boolean.TRUE : Boolean.FALSE;
            this.aRF = null;
            this.aRN = null;
            this.aRv = Float.valueOf(1.0f);
            this.aRL = f.aQu;
            this.aRM = Float.valueOf(1.0f);
            this.aRP = null;
            this.aRQ = null;
            this.aRR = Float.valueOf(1.0f);
            this.aRS = null;
            this.aRT = Float.valueOf(1.0f);
            this.aRU = i.None;
            AppMethodBeat.o(206532);
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public final Object clone() {
            AppMethodBeat.i(206533);
            ae aeVar = (ae) super.clone();
            if (this.aRt != null) {
                aeVar.aRt = (p[]) this.aRt.clone();
            }
            AppMethodBeat.o(206533);
            return aeVar;
        }
    }

    static abstract class ao implements Cloneable {
        ao() {
        }
    }

    static class f extends ao {
        static final f aQu = new f(WebView.NIGHT_MODE_COLOR);
        static final f aQv = new f(0);
        int aQt;

        static {
            AppMethodBeat.i(206480);
            AppMethodBeat.o(206480);
        }

        f(int i2) {
            this.aQt = i2;
        }

        public final String toString() {
            AppMethodBeat.i(206479);
            String format = String.format("#%08x", Integer.valueOf(this.aQt));
            AppMethodBeat.o(206479);
            return format;
        }
    }

    static class g extends ao {
        private static g aQw = new g();

        static {
            AppMethodBeat.i(206481);
            AppMethodBeat.o(206481);
        }

        private g() {
        }

        static g qT() {
            return aQw;
        }
    }

    static class u extends ao {
        ao aQY;
        String aQk;

        u(String str, ao aoVar) {
            this.aQk = str;
            this.aQY = aoVar;
        }

        public final String toString() {
            AppMethodBeat.i(206491);
            String str = this.aQk + " " + this.aQY;
            AppMethodBeat.o(206491);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class p implements Cloneable {
        bd aQL;
        float value;

        p(float f2, bd bdVar) {
            this.value = f2;
            this.aQL = bdVar;
        }

        p(float f2) {
            this.value = f2;
            this.aQL = bd.px;
        }

        /* access modifiers changed from: package-private */
        public final float a(i iVar) {
            AppMethodBeat.i(206485);
            switch (this.aQL) {
                case px:
                    float f2 = this.value;
                    AppMethodBeat.o(206485);
                    return f2;
                case em:
                    float rc = this.value * iVar.rc();
                    AppMethodBeat.o(206485);
                    return rc;
                case ex:
                    float textSize = this.value * (iVar.aTk.aTI.getTextSize() / 2.0f);
                    AppMethodBeat.o(206485);
                    return textSize;
                case in:
                    float f3 = this.value * iVar.aTj;
                    AppMethodBeat.o(206485);
                    return f3;
                case cm:
                    float f4 = (this.value * iVar.aTj) / 2.54f;
                    AppMethodBeat.o(206485);
                    return f4;
                case mm:
                    float f5 = (this.value * iVar.aTj) / 25.4f;
                    AppMethodBeat.o(206485);
                    return f5;
                case pt:
                    float f6 = (this.value * iVar.aTj) / 72.0f;
                    AppMethodBeat.o(206485);
                    return f6;
                case pc:
                    float f7 = (this.value * iVar.aTj) / 6.0f;
                    AppMethodBeat.o(206485);
                    return f7;
                case percent:
                    b rd = iVar.rd();
                    if (rd == null) {
                        float f8 = this.value;
                        AppMethodBeat.o(206485);
                        return f8;
                    }
                    float f9 = (rd.width * this.value) / 100.0f;
                    AppMethodBeat.o(206485);
                    return f9;
                default:
                    float f10 = this.value;
                    AppMethodBeat.o(206485);
                    return f10;
            }
        }

        /* access modifiers changed from: package-private */
        public final float b(i iVar) {
            AppMethodBeat.i(206486);
            if (this.aQL == bd.percent) {
                b rd = iVar.rd();
                if (rd == null) {
                    float f2 = this.value;
                    AppMethodBeat.o(206486);
                    return f2;
                }
                float f3 = (rd.height * this.value) / 100.0f;
                AppMethodBeat.o(206486);
                return f3;
            }
            float a2 = a(iVar);
            AppMethodBeat.o(206486);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final float c(i iVar) {
            AppMethodBeat.i(206487);
            if (this.aQL == bd.percent) {
                b rd = iVar.rd();
                if (rd == null) {
                    float f2 = this.value;
                    AppMethodBeat.o(206487);
                    return f2;
                }
                float f3 = rd.width;
                float f4 = rd.height;
                if (f3 == f4) {
                    float f5 = (this.value * f3) / 100.0f;
                    AppMethodBeat.o(206487);
                    return f5;
                }
                float sqrt = (((float) (Math.sqrt((double) ((f4 * f4) + (f3 * f3))) / 1.414213562373095d)) * this.value) / 100.0f;
                AppMethodBeat.o(206487);
                return sqrt;
            }
            float a2 = a(iVar);
            AppMethodBeat.o(206487);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final float a(i iVar, float f2) {
            AppMethodBeat.i(206488);
            if (this.aQL == bd.percent) {
                float f3 = (this.value * f2) / 100.0f;
                AppMethodBeat.o(206488);
                return f3;
            }
            float a2 = a(iVar);
            AppMethodBeat.o(206488);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final float S(float f2) {
            AppMethodBeat.i(206489);
            switch (this.aQL) {
                case px:
                    float f3 = this.value;
                    AppMethodBeat.o(206489);
                    return f3;
                case em:
                case ex:
                default:
                    float f4 = this.value;
                    AppMethodBeat.o(206489);
                    return f4;
                case in:
                    float f5 = this.value * f2;
                    AppMethodBeat.o(206489);
                    return f5;
                case cm:
                    float f6 = (this.value * f2) / 2.54f;
                    AppMethodBeat.o(206489);
                    return f6;
                case mm:
                    float f7 = (this.value * f2) / 25.4f;
                    AppMethodBeat.o(206489);
                    return f7;
                case pt:
                    float f8 = (this.value * f2) / 72.0f;
                    AppMethodBeat.o(206489);
                    return f8;
                case pc:
                    float f9 = (this.value * f2) / 6.0f;
                    AppMethodBeat.o(206489);
                    return f9;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean isZero() {
            return this.value == 0.0f;
        }

        /* access modifiers changed from: package-private */
        public final boolean isNegative() {
            return this.value < 0.0f;
        }

        public final String toString() {
            AppMethodBeat.i(206490);
            String str = String.valueOf(this.value) + this.aQL;
            AppMethodBeat.o(206490);
            return str;
        }
    }

    static class c {
        p aQl;
        p aQm;
        p aQn;
        p aQo;

        c(p pVar, p pVar2, p pVar3, p pVar4) {
            this.aQl = pVar;
            this.aQm = pVar2;
            this.aQn = pVar3;
            this.aQo = pVar4;
        }
    }

    /* access modifiers changed from: package-private */
    public static class an {
        h aSO;
        aj aSP;

        an() {
        }

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class al extends an {
        ae aPk = null;
        Boolean aSL = null;
        ae aSM = null;
        List<String> aSN = null;
        String id = null;

        al() {
        }

        public String toString() {
            return getNodeName();
        }
    }

    static abstract class ak extends al {
        b aSK = null;

        ak() {
        }
    }

    static abstract class ai extends ak implements ag {
        Set<String> aSF = null;
        String aSG = null;
        Set<String> aSH = null;
        Set<String> aSI = null;
        Set<String> aSJ = null;

        ai() {
        }

        @Override // com.a.a.h.ag
        public final void b(Set<String> set) {
            this.aSF = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qV() {
            return this.aSF;
        }

        @Override // com.a.a.h.ag
        public final void ab(String str) {
            this.aSG = str;
        }

        @Override // com.a.a.h.ag
        public final String qW() {
            return this.aSG;
        }

        @Override // com.a.a.h.ag
        public final void c(Set<String> set) {
            this.aSH = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qX() {
            return this.aSH;
        }

        @Override // com.a.a.h.ag
        public final void d(Set<String> set) {
            this.aSI = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qY() {
            return this.aSI;
        }

        @Override // com.a.a.h.ag
        public final void e(Set<String> set) {
            this.aSJ = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qZ() {
            return this.aSJ;
        }
    }

    static abstract class ah extends ak implements ag, aj {
        List<an> aQz = new ArrayList();
        Set<String> aSF = null;
        String aSG = null;
        Set<String> aSH = null;
        Set<String> aSI = null;
        Set<String> aSJ = null;

        ah() {
        }

        @Override // com.a.a.h.aj
        public final List<an> getChildren() {
            return this.aQz;
        }

        @Override // com.a.a.h.aj
        public void a(an anVar) {
            this.aQz.add(anVar);
        }

        @Override // com.a.a.h.ag
        public final void b(Set<String> set) {
            this.aSF = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qV() {
            return this.aSF;
        }

        @Override // com.a.a.h.ag
        public final void ab(String str) {
            this.aSG = str;
        }

        @Override // com.a.a.h.ag
        public final String qW() {
            return this.aSG;
        }

        @Override // com.a.a.h.ag
        public final void c(Set<String> set) {
            this.aSH = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qX() {
            return null;
        }

        @Override // com.a.a.h.ag
        public final void d(Set<String> set) {
            this.aSI = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qY() {
            return this.aSI;
        }

        @Override // com.a.a.h.ag
        public final void e(Set<String> set) {
            this.aSJ = set;
        }

        @Override // com.a.a.h.ag
        public final Set<String> qZ() {
            return this.aSJ;
        }
    }

    static abstract class ap extends ah {
        f aPZ = null;

        ap() {
        }
    }

    static abstract class ar extends ap {
        b aQb;

        ar() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class af extends ar {
        p aQH;
        p aQI;
        p aQJ;
        p aQK;
        public String version;

        af() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "svg";
        }
    }

    static class m extends ah implements n {
        Matrix transform;

        m() {
        }

        @Override // com.a.a.h.n
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public String getNodeName() {
            return "group";
        }
    }

    /* renamed from: com.a.a.h$h  reason: collision with other inner class name */
    static class C0058h extends m implements t {
        C0058h() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.m, com.a.a.h.an
        public final String getNodeName() {
            return "defs";
        }
    }

    static abstract class l extends ai implements n {
        Matrix transform;

        l() {
        }

        @Override // com.a.a.h.n
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    static class a extends m {
        String aQk;

        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.m, com.a.a.h.an
        public final String getNodeName() {
            return "a";
        }
    }

    static class be extends m {
        p aQH;
        p aQI;
        p aQJ;
        p aQK;
        String aQk;

        be() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.m, com.a.a.h.an
        public final String getNodeName() {
            return "use";
        }
    }

    static class v extends l {
        w aQZ;
        Float aRa;

        v() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "path";
        }
    }

    static class ab extends l {
        p aQH;
        p aQI;
        p aQJ;
        p aQK;
        p aQx;
        p aQy;

        ab() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "rect";
        }
    }

    static class d extends l {
        p aQp;
        p aQq;
        p aQr;

        d() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "circle";
        }
    }

    static class i extends l {
        p aQp;
        p aQq;
        p aQx;
        p aQy;

        i() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "ellipse";
        }
    }

    static class q extends l {
        p aQM;
        p aQN;
        p aQO;
        p aQP;

        q() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "line";
        }
    }

    static class z extends l {
        float[] points;

        z() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public String getNodeName() {
            return "polyline";
        }
    }

    static class aa extends z {
        aa() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.z, com.a.a.h.an
        public final String getNodeName() {
            return "polygon";
        }
    }

    static abstract class ay extends ah {
        ay() {
        }

        @Override // com.a.a.h.aj, com.a.a.h.ah
        public final void a(an anVar) {
            if (anVar instanceof ax) {
                this.aQz.add(anVar);
                return;
            }
            throw new k("Text content elements cannot contain " + anVar + " elements.");
        }
    }

    static abstract class ba extends ay {
        List<p> aSU;
        List<p> aSV;
        List<p> aSW;
        List<p> aSX;

        ba() {
        }
    }

    static class aw extends ba implements bb, n {
        Matrix transform;

        aw() {
        }

        @Override // com.a.a.h.n
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "text";
        }
    }

    static class av extends ba implements ax {
        bb aSS;

        av() {
        }

        @Override // com.a.a.h.ax
        public final bb ra() {
            return this.aSS;
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "tspan";
        }
    }

    static class bc extends an implements ax {
        private bb aSS;
        String text;

        bc(String str) {
            this.text = str;
        }

        public final String toString() {
            AppMethodBeat.i(206534);
            String str = "TextChild: '" + this.text + "'";
            AppMethodBeat.o(206534);
            return str;
        }

        @Override // com.a.a.h.ax
        public final bb ra() {
            return this.aSS;
        }
    }

    static class au extends ay implements ax {
        String aQk;
        bb aSS;

        au() {
        }

        @Override // com.a.a.h.ax
        public final bb ra() {
            return this.aSS;
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "tref";
        }
    }

    static class az extends ay implements ax {
        String aQk;
        bb aSS;
        p aST;

        az() {
        }

        @Override // com.a.a.h.ax
        public final bb ra() {
            return this.aSS;
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "textPath";
        }
    }

    static class as extends m {
        as() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.m, com.a.a.h.an
        public final String getNodeName() {
            return "switch";
        }
    }

    static class at extends ar implements t {
        at() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "symbol";
        }
    }

    static class r extends ar implements t {
        boolean aQQ;
        p aQR;
        p aQS;
        p aQT;
        p aQU;
        Float aQV;

        r() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "marker";
        }
    }

    static abstract class j extends al implements aj {
        Boolean aQA;
        Matrix aQB;
        k aQC;
        String aQk;
        List<an> aQz = new ArrayList();

        j() {
        }

        @Override // com.a.a.h.aj
        public final List<an> getChildren() {
            return this.aQz;
        }

        @Override // com.a.a.h.aj
        public final void a(an anVar) {
            if (anVar instanceof ad) {
                this.aQz.add(anVar);
                return;
            }
            throw new k("Gradient elements cannot contain " + anVar + " elements.");
        }
    }

    static class ad extends al implements aj {
        Float aRi;

        ad() {
        }

        @Override // com.a.a.h.aj
        public final List<an> getChildren() {
            AppMethodBeat.i(206503);
            List<an> emptyList = Collections.emptyList();
            AppMethodBeat.o(206503);
            return emptyList;
        }

        @Override // com.a.a.h.aj
        public final void a(an anVar) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "stop";
        }
    }

    static class am extends j {
        p aQM;
        p aQN;
        p aQO;
        p aQP;

        am() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "linearGradient";
        }
    }

    static class aq extends j {
        p aQp;
        p aQq;
        p aQr;
        p aSQ;
        p aSR;

        aq() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "radialGradient";
        }
    }

    static class e extends m implements t {
        Boolean aQs;

        e() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.m, com.a.a.h.an
        public final String getNodeName() {
            return "clipPath";
        }
    }

    static class y extends ar implements t {
        p aQH;
        p aQI;
        p aQJ;
        p aQK;
        String aQk;
        Boolean aRf;
        Boolean aRg;
        Matrix aRh;

        y() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "pattern";
        }
    }

    static class o extends ap implements n {
        p aQH;
        p aQI;
        p aQJ;
        p aQK;
        String aQk;
        Matrix transform;

        o() {
        }

        @Override // com.a.a.h.n
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "image";
        }
    }

    /* access modifiers changed from: package-private */
    public static class bf extends ar implements t {
        bf() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "view";
        }
    }

    static class s extends ah implements t {
        p aQH;
        p aQI;
        p aQJ;
        p aQK;
        Boolean aQW;
        Boolean aQX;

        s() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "mask";
        }
    }

    static class ac extends al implements aj {
        ac() {
        }

        @Override // com.a.a.h.aj
        public final List<an> getChildren() {
            AppMethodBeat.i(206502);
            List<an> emptyList = Collections.emptyList();
            AppMethodBeat.o(206502);
            return emptyList;
        }

        @Override // com.a.a.h.aj
        public final void a(an anVar) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.a.a.h.an
        public final String getNodeName() {
            return "solidColor";
        }
    }

    static j qQ() {
        return aQd;
    }

    static class w implements x {
        private byte[] aRb = new byte[8];
        private int aRc = 0;
        private float[] aRd = new float[16];
        private int aRe = 0;

        w() {
            AppMethodBeat.i(206492);
            AppMethodBeat.o(206492);
        }

        /* access modifiers changed from: package-private */
        public final boolean isEmpty() {
            return this.aRc == 0;
        }

        /* access modifiers changed from: package-private */
        public final void a(byte b2) {
            AppMethodBeat.i(206493);
            if (this.aRc == this.aRb.length) {
                byte[] bArr = new byte[(this.aRb.length * 2)];
                System.arraycopy(this.aRb, 0, bArr, 0, this.aRb.length);
                this.aRb = bArr;
            }
            byte[] bArr2 = this.aRb;
            int i2 = this.aRc;
            this.aRc = i2 + 1;
            bArr2[i2] = b2;
            AppMethodBeat.o(206493);
        }

        private void dv(int i2) {
            AppMethodBeat.i(206494);
            if (this.aRd.length < this.aRe + i2) {
                float[] fArr = new float[(this.aRd.length * 2)];
                System.arraycopy(this.aRd, 0, fArr, 0, this.aRd.length);
                this.aRd = fArr;
            }
            AppMethodBeat.o(206494);
        }

        @Override // com.a.a.h.x
        public final void moveTo(float f2, float f3) {
            AppMethodBeat.i(206495);
            a((byte) 0);
            dv(2);
            float[] fArr = this.aRd;
            int i2 = this.aRe;
            this.aRe = i2 + 1;
            fArr[i2] = f2;
            float[] fArr2 = this.aRd;
            int i3 = this.aRe;
            this.aRe = i3 + 1;
            fArr2[i3] = f3;
            AppMethodBeat.o(206495);
        }

        @Override // com.a.a.h.x
        public final void lineTo(float f2, float f3) {
            AppMethodBeat.i(206496);
            a((byte) 1);
            dv(2);
            float[] fArr = this.aRd;
            int i2 = this.aRe;
            this.aRe = i2 + 1;
            fArr[i2] = f2;
            float[] fArr2 = this.aRd;
            int i3 = this.aRe;
            this.aRe = i3 + 1;
            fArr2[i3] = f3;
            AppMethodBeat.o(206496);
        }

        @Override // com.a.a.h.x
        public final void cubicTo(float f2, float f3, float f4, float f5, float f6, float f7) {
            AppMethodBeat.i(206497);
            a((byte) 2);
            dv(6);
            float[] fArr = this.aRd;
            int i2 = this.aRe;
            this.aRe = i2 + 1;
            fArr[i2] = f2;
            float[] fArr2 = this.aRd;
            int i3 = this.aRe;
            this.aRe = i3 + 1;
            fArr2[i3] = f3;
            float[] fArr3 = this.aRd;
            int i4 = this.aRe;
            this.aRe = i4 + 1;
            fArr3[i4] = f4;
            float[] fArr4 = this.aRd;
            int i5 = this.aRe;
            this.aRe = i5 + 1;
            fArr4[i5] = f5;
            float[] fArr5 = this.aRd;
            int i6 = this.aRe;
            this.aRe = i6 + 1;
            fArr5[i6] = f6;
            float[] fArr6 = this.aRd;
            int i7 = this.aRe;
            this.aRe = i7 + 1;
            fArr6[i7] = f7;
            AppMethodBeat.o(206497);
        }

        @Override // com.a.a.h.x
        public final void quadTo(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(206498);
            a((byte) 3);
            dv(4);
            float[] fArr = this.aRd;
            int i2 = this.aRe;
            this.aRe = i2 + 1;
            fArr[i2] = f2;
            float[] fArr2 = this.aRd;
            int i3 = this.aRe;
            this.aRe = i3 + 1;
            fArr2[i3] = f3;
            float[] fArr3 = this.aRd;
            int i4 = this.aRe;
            this.aRe = i4 + 1;
            fArr3[i4] = f4;
            float[] fArr4 = this.aRd;
            int i5 = this.aRe;
            this.aRe = i5 + 1;
            fArr4[i5] = f5;
            AppMethodBeat.o(206498);
        }

        @Override // com.a.a.h.x
        public final void a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            int i2 = 0;
            AppMethodBeat.i(206499);
            int i3 = (z ? 2 : 0) | 4;
            if (z2) {
                i2 = 1;
            }
            a((byte) (i2 | i3));
            dv(5);
            float[] fArr = this.aRd;
            int i4 = this.aRe;
            this.aRe = i4 + 1;
            fArr[i4] = f2;
            float[] fArr2 = this.aRd;
            int i5 = this.aRe;
            this.aRe = i5 + 1;
            fArr2[i5] = f3;
            float[] fArr3 = this.aRd;
            int i6 = this.aRe;
            this.aRe = i6 + 1;
            fArr3[i6] = f4;
            float[] fArr4 = this.aRd;
            int i7 = this.aRe;
            this.aRe = i7 + 1;
            fArr4[i7] = f5;
            float[] fArr5 = this.aRd;
            int i8 = this.aRe;
            this.aRe = i8 + 1;
            fArr5[i8] = f6;
            AppMethodBeat.o(206499);
        }

        @Override // com.a.a.h.x
        public final void close() {
            AppMethodBeat.i(206500);
            a((byte) 8);
            AppMethodBeat.o(206500);
        }

        /* access modifiers changed from: package-private */
        public final void a(x xVar) {
            AppMethodBeat.i(206501);
            int i2 = 0;
            for (int i3 = 0; i3 < this.aRc; i3++) {
                byte b2 = this.aRb[i3];
                switch (b2) {
                    case 0:
                        int i4 = i2 + 1;
                        float f2 = this.aRd[i2];
                        i2 = i4 + 1;
                        xVar.moveTo(f2, this.aRd[i4]);
                        break;
                    case 1:
                        int i5 = i2 + 1;
                        float f3 = this.aRd[i2];
                        i2 = i5 + 1;
                        xVar.lineTo(f3, this.aRd[i5]);
                        break;
                    case 2:
                        int i6 = i2 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        xVar.cubicTo(this.aRd[i2], this.aRd[i6], this.aRd[i7], this.aRd[i8], this.aRd[i9], this.aRd[i10]);
                        i2 = i10 + 1;
                        break;
                    case 3:
                        int i11 = i2 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i2 = i13 + 1;
                        xVar.quadTo(this.aRd[i2], this.aRd[i11], this.aRd[i12], this.aRd[i13]);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        int i14 = i2 + 1;
                        int i15 = i14 + 1;
                        int i16 = i15 + 1;
                        int i17 = i16 + 1;
                        xVar.a(this.aRd[i2], this.aRd[i14], this.aRd[i15], (b2 & 2) != 0, (b2 & 1) != 0, this.aRd[i16], this.aRd[i17]);
                        i2 = i17 + 1;
                        break;
                    case 8:
                        xVar.close();
                        break;
                }
            }
            AppMethodBeat.o(206501);
        }
    }

    /* access modifiers changed from: package-private */
    public final al aa(String str) {
        AppMethodBeat.i(206549);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(206549);
            return null;
        } else if (str.equals(this.aQf.id)) {
            af afVar = this.aQf;
            AppMethodBeat.o(206549);
            return afVar;
        } else if (this.aQi.containsKey(str)) {
            al alVar = this.aQi.get(str);
            AppMethodBeat.o(206549);
            return alVar;
        } else {
            al a2 = a(this.aQf, str);
            this.aQi.put(str, a2);
            AppMethodBeat.o(206549);
            return a2;
        }
    }

    private al a(aj ajVar, String str) {
        al a2;
        AppMethodBeat.i(206550);
        al alVar = (al) ajVar;
        if (str.equals(alVar.id)) {
            AppMethodBeat.o(206550);
            return alVar;
        }
        for (an anVar : ajVar.getChildren()) {
            if (anVar instanceof al) {
                al alVar2 = (al) anVar;
                if (str.equals(alVar2.id)) {
                    AppMethodBeat.o(206550);
                    return alVar2;
                } else if ((anVar instanceof aj) && (a2 = a((aj) anVar, str)) != null) {
                    AppMethodBeat.o(206550);
                    return a2;
                }
            }
        }
        AppMethodBeat.o(206550);
        return null;
    }

    public final Picture qL() {
        AppMethodBeat.i(206540);
        b bVar = this.aQf.aQb;
        if (this.aQf.aQJ != null && this.aQf.aQJ.aQL != bd.percent && this.aQf.aQK != null && this.aQf.aQK.aQL != bd.percent) {
            Picture aU = aU((int) Math.ceil((double) this.aQf.aQJ.S(this.aQg)), (int) Math.ceil((double) this.aQf.aQK.S(this.aQg)));
            AppMethodBeat.o(206540);
            return aU;
        } else if (this.aQf.aQJ != null && bVar != null) {
            float S = this.aQf.aQJ.S(this.aQg);
            Picture aU2 = aU((int) Math.ceil((double) S), (int) Math.ceil((double) ((bVar.height * S) / bVar.width)));
            AppMethodBeat.o(206540);
            return aU2;
        } else if (this.aQf.aQK == null || bVar == null) {
            Picture aU3 = aU(512, 512);
            AppMethodBeat.o(206540);
            return aU3;
        } else {
            float S2 = this.aQf.aQK.S(this.aQg);
            Picture aU4 = aU((int) Math.ceil((double) ((bVar.width * S2) / bVar.height)), (int) Math.ceil((double) S2));
            AppMethodBeat.o(206540);
            return aU4;
        }
    }
}
