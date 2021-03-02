package com.tencent.mm.live.core.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005HÆ\u0003J3\u0010\u001e\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005HÆ\u0001J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020 J\u0013\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R1\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001c\u0010\u001a\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\r¨\u0006*"}, hxF = {"Lcom/tencent/mm/live/core/render/BeautyConfig;", "", "configMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "getConfigMap", "()Ljava/util/HashMap;", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "rosy", "getRosy", "setRosy", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "component1", "copy", "enable", "", "enableBright", "enableRosy", "enableShape", "enableSkin", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-core_release"})
public final class a {
    private int hDb;
    private int hDc;
    private int hDd;
    private int hDe;
    private int hDf;
    private int hDg;
    public final HashMap<Integer, Integer> hDh;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(196611);
        if (this == obj || ((obj instanceof a) && p.j(this.hDh, ((a) obj).hDh))) {
            AppMethodBeat.o(196611);
            return true;
        }
        AppMethodBeat.o(196611);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(196610);
        HashMap<Integer, Integer> hashMap = this.hDh;
        if (hashMap != null) {
            int hashCode = hashMap.hashCode();
            AppMethodBeat.o(196610);
            return hashCode;
        }
        AppMethodBeat.o(196610);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(196609);
        String str = "BeautyConfig(configMap=" + this.hDh + ")";
        AppMethodBeat.o(196609);
        return str;
    }

    public /* synthetic */ a() {
        this(new HashMap());
        AppMethodBeat.i(196608);
        AppMethodBeat.o(196608);
    }

    private a(HashMap<Integer, Integer> hashMap) {
        p.h(hashMap, "configMap");
        AppMethodBeat.i(196607);
        this.hDh = hashMap;
        this.hDb = -1;
        this.hDc = -1;
        this.hDd = -1;
        this.hDe = -1;
        this.hDf = -1;
        this.hDg = -1;
        AppMethodBeat.o(196607);
    }

    public final int aEl() {
        AppMethodBeat.i(196597);
        HashMap<Integer, Integer> hashMap = this.hDh;
        e.c cVar = e.c.hxm;
        Integer num = hashMap.get(Integer.valueOf(e.c.aCh()));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(196597);
            return intValue;
        }
        AppMethodBeat.o(196597);
        return -1;
    }

    public final int aEm() {
        AppMethodBeat.i(196598);
        HashMap<Integer, Integer> hashMap = this.hDh;
        e.c cVar = e.c.hxm;
        Integer num = hashMap.get(Integer.valueOf(e.c.aCl()));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(196598);
            return intValue;
        }
        AppMethodBeat.o(196598);
        return -1;
    }

    public final int aEn() {
        AppMethodBeat.i(196599);
        HashMap<Integer, Integer> hashMap = this.hDh;
        e.c cVar = e.c.hxm;
        Integer num = hashMap.get(Integer.valueOf(e.c.aCi()));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(196599);
            return intValue;
        }
        AppMethodBeat.o(196599);
        return -1;
    }

    public final int aEo() {
        AppMethodBeat.i(196600);
        HashMap<Integer, Integer> hashMap = this.hDh;
        e.c cVar = e.c.hxm;
        Integer num = hashMap.get(Integer.valueOf(e.c.aCj()));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(196600);
            return intValue;
        }
        AppMethodBeat.o(196600);
        return -1;
    }

    public final int aEp() {
        AppMethodBeat.i(196601);
        HashMap<Integer, Integer> hashMap = this.hDh;
        e.c cVar = e.c.hxm;
        Integer num = hashMap.get(Integer.valueOf(e.c.aCm()));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(196601);
            return intValue;
        }
        AppMethodBeat.o(196601);
        return -1;
    }

    public final int aEq() {
        AppMethodBeat.i(196602);
        HashMap<Integer, Integer> hashMap = this.hDh;
        e.c cVar = e.c.hxm;
        Integer num = hashMap.get(Integer.valueOf(e.c.aCk()));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(196602);
            return intValue;
        }
        AppMethodBeat.o(196602);
        return -1;
    }

    public final boolean aEr() {
        AppMethodBeat.i(196603);
        if (aEl() >= 0) {
            AppMethodBeat.o(196603);
            return true;
        }
        AppMethodBeat.o(196603);
        return false;
    }

    public final boolean aEs() {
        AppMethodBeat.i(196604);
        if (aEm() >= 0 || aEn() >= 0) {
            AppMethodBeat.o(196604);
            return true;
        }
        AppMethodBeat.o(196604);
        return false;
    }

    public final boolean aEt() {
        AppMethodBeat.i(196605);
        if (aEo() >= 0 || aEp() >= 0) {
            AppMethodBeat.o(196605);
            return true;
        }
        AppMethodBeat.o(196605);
        return false;
    }

    public final boolean aEu() {
        AppMethodBeat.i(196606);
        if (aEq() >= 0) {
            AppMethodBeat.o(196606);
            return true;
        }
        AppMethodBeat.o(196606);
        return false;
    }
}
