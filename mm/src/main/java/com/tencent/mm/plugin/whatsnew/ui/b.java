package com.tencent.mm.plugin.whatsnew.ui;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 92\u00020\u0001:\u00019B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00107\u001a\u00020\u0003H\u0016J\b\u00108\u001a\u00020\u0011H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001a¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "", "initCount", "", "inScreenCount", "minRadius", "maxRadius", "blurRadius", "alpha", "", "distance", "minSpeed", "maxSpeed", "minAngle", "maxAngle", "colors", "", "", "bgColors", "(IIIIIDIIIII[Ljava/lang/String;[Ljava/lang/String;)V", "getAlpha", "()D", "getBgColors", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getBlurRadius", "()I", "getColors", "getDistance", "getInScreenCount", "getInitCount", "getMaxAngle", "getMaxRadius", "getMaxSpeed", "getMinAngle", "getMinRadius", "getMinSpeed", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIIDIIIII[Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "Companion", "app_release"})
public final class b {
    private static b JOS = new b();
    public static final a JOT = new a((byte) 0);
    final int JOI;
    final int JOJ;
    final int JOK;
    final double JOL;
    final int JOM;
    final int JON;
    final int JOO;
    final int JOP;
    final String[] JOQ;
    final String[] JOR;
    final int initCount;
    final int jbm;
    final int vPo;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    /* renamed from: com.tencent.mm.plugin.whatsnew.ui.b$b  reason: collision with other inner class name */
    static final class C2010b extends q implements kotlin.g.a.b<String, String> {
        public static final C2010b JOU = new C2010b();

        static {
            AppMethodBeat.i(230951);
            AppMethodBeat.o(230951);
        }

        C2010b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(230950);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            String str3 = "\"" + str2 + '\"';
            AppMethodBeat.o(230950);
            return str3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class c extends q implements kotlin.g.a.b<String, String> {
        public static final c JOV = new c();

        static {
            AppMethodBeat.i(230953);
            AppMethodBeat.o(230953);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(230952);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            String str3 = "\"" + str2 + '\"';
            AppMethodBeat.o(230952);
            return str3;
        }
    }

    public b(int i2, int i3, int i4, int i5, int i6, double d2, int i7, int i8, int i9, int i10, int i11, String[] strArr, String[] strArr2) {
        p.h(strArr, "colors");
        p.h(strArr2, "bgColors");
        AppMethodBeat.i(230957);
        this.initCount = i2;
        this.JOI = i3;
        this.JOJ = i4;
        this.JOK = i5;
        this.jbm = i6;
        this.JOL = d2;
        this.vPo = i7;
        this.JOM = i8;
        this.JON = i9;
        this.JOO = i10;
        this.JOP = i11;
        this.JOQ = strArr;
        this.JOR = strArr2;
        AppMethodBeat.o(230957);
    }

    private /* synthetic */ b() {
        this(9, 9, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 287, 199, 0.46d, 50, 58, 102, 0, 90, new String[]{"#6b81e8", "#3f89be", "#15c2da"}, new String[]{"#EFB3B2", "#3ed4c2"});
        AppMethodBeat.i(230958);
        AppMethodBeat.o(230958);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(230954);
        if (this == obj) {
            AppMethodBeat.o(230954);
            return true;
        }
        if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
            AppMethodBeat.o(230954);
            return false;
        } else if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.whatsnew.ui.Config");
            AppMethodBeat.o(230954);
            throw tVar;
        } else if (this.initCount != ((b) obj).initCount) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOI != ((b) obj).JOI) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOJ != ((b) obj).JOJ) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOK != ((b) obj).JOK) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.jbm != ((b) obj).jbm) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOL != ((b) obj).JOL) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.vPo != ((b) obj).vPo) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOM != ((b) obj).JOM) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JON != ((b) obj).JON) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOO != ((b) obj).JOO) {
            AppMethodBeat.o(230954);
            return false;
        } else if (this.JOP != ((b) obj).JOP) {
            AppMethodBeat.o(230954);
            return false;
        } else if (!Arrays.equals(this.JOQ, ((b) obj).JOQ)) {
            AppMethodBeat.o(230954);
            return false;
        } else if (!Arrays.equals(this.JOR, ((b) obj).JOR)) {
            AppMethodBeat.o(230954);
            return false;
        } else {
            AppMethodBeat.o(230954);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(230955);
        int hashCode = (((((((((((((((((((((((this.initCount * 31) + this.JOI) * 31) + this.JOJ) * 31) + this.JOK) * 31) + this.jbm) * 31) + Double.valueOf(this.JOL).hashCode()) * 31) + this.vPo) * 31) + this.JOM) * 31) + this.JON) * 31) + this.JOO) * 31) + this.JOP) * 31) + Arrays.hashCode(this.JOQ)) * 31) + Arrays.hashCode(this.JOR);
        AppMethodBeat.o(230955);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(230956);
        String str = "Config(\n    initCount = " + this.initCount + ",\n    inScreenCount = " + this.JOI + ",\n    minRadius = " + this.JOJ + ",\n    maxRadius = " + this.JOK + ",\n    blurRadius = " + this.jbm + ",\n    alpha = " + this.JOL + ",\n    distance = " + this.vPo + ",\n    minSpeed = " + this.JOM + ",\n    maxSpeed = " + this.JON + ",\n    minAngle = " + this.JOO + ",\n    maxAngle = " + this.JOP + ",\n    colors = arrayOf(" + e.a(this.JOQ, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C2010b.JOU, 31) + "),\n    bgColors = arrayOf(" + e.a(this.JOR, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, c.JOV, 31) + ")\n)";
        AppMethodBeat.o(230956);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/Config$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "getInstance", "()Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "setInstance", "(Lcom/tencent/mm/plugin/whatsnew/ui/Config;)V", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(230959);
        AppMethodBeat.o(230959);
    }
}
