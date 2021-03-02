package com.tencent.mm.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends JSONObject implements c {
    private final c hpB;

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ a FA(String str) {
        AppMethodBeat.i(158622);
        f FH = FH(str);
        AppMethodBeat.o(158622);
        return FH;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ a FB(String str) {
        AppMethodBeat.i(158621);
        f FI = FI(str);
        AppMethodBeat.o(158621);
        return FI;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c FC(String str) {
        AppMethodBeat.i(158620);
        i FJ = FJ(str);
        AppMethodBeat.o(158620);
        return FJ;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c FD(String str) {
        AppMethodBeat.i(158619);
        i FK = FK(str);
        AppMethodBeat.o(158619);
        return FK;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c T(String str, int i2) {
        AppMethodBeat.i(158626);
        i U = U(str, i2);
        AppMethodBeat.o(158626);
        return U;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c b(String str, double d2) {
        AppMethodBeat.i(158627);
        i c2 = c(str, d2);
        AppMethodBeat.o(158627);
        return c2;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c f(String str, Object obj) {
        AppMethodBeat.i(158624);
        i h2 = h(str, obj);
        AppMethodBeat.o(158624);
        return h2;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c g(String str, Object obj) {
        AppMethodBeat.i(158623);
        i i2 = i(str, obj);
        AppMethodBeat.o(158623);
        return i2;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONArray getJSONArray(String str) {
        AppMethodBeat.i(158612);
        f FH = FH(str);
        AppMethodBeat.o(158612);
        return FH;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject getJSONObject(String str) {
        AppMethodBeat.i(158610);
        i FJ = FJ(str);
        AppMethodBeat.o(158610);
        return FJ;
    }

    public final /* synthetic */ JSONArray optJSONArray(String str) {
        AppMethodBeat.i(158611);
        f FI = FI(str);
        AppMethodBeat.o(158611);
        return FI;
    }

    public final /* synthetic */ JSONObject optJSONObject(String str) {
        AppMethodBeat.i(158609);
        i FK = FK(str);
        AppMethodBeat.o(158609);
        return FK;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject put(String str, double d2) {
        AppMethodBeat.i(158617);
        i c2 = c(str, d2);
        AppMethodBeat.o(158617);
        return c2;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject put(String str, int i2) {
        AppMethodBeat.i(158616);
        i U = U(str, i2);
        AppMethodBeat.o(158616);
        return U;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject put(String str, long j2) {
        AppMethodBeat.i(158615);
        i v = v(str, j2);
        AppMethodBeat.o(158615);
        return v;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject put(String str, Object obj) {
        AppMethodBeat.i(158614);
        i h2 = h(str, obj);
        AppMethodBeat.o(158614);
        return h2;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject put(String str, boolean z) {
        AppMethodBeat.i(158618);
        i w = w(str, z);
        AppMethodBeat.o(158618);
        return w;
    }

    @Override // org.json.JSONObject
    public final /* synthetic */ JSONObject putOpt(String str, Object obj) {
        AppMethodBeat.i(158613);
        i i2 = i(str, obj);
        AppMethodBeat.o(158613);
        return i2;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c u(String str, long j2) {
        AppMethodBeat.i(158625);
        i v = v(str, j2);
        AppMethodBeat.o(158625);
        return v;
    }

    @Override // com.tencent.mm.ab.c
    public final /* synthetic */ c v(String str, boolean z) {
        AppMethodBeat.i(158628);
        i w = w(str, z);
        AppMethodBeat.o(158628);
        return w;
    }

    public i() {
        AppMethodBeat.i(158571);
        this.hpB = h.ayS();
        AppMethodBeat.o(158571);
    }

    public i(c cVar) {
        AppMethodBeat.i(158572);
        Assert.assertNotNull(cVar);
        this.hpB = cVar;
        AppMethodBeat.o(158572);
    }

    public i(Map map) {
        AppMethodBeat.i(158573);
        this.hpB = h.v(map);
        AppMethodBeat.o(158573);
    }

    public i(String str) {
        AppMethodBeat.i(158574);
        this.hpB = h.FF(str);
        AppMethodBeat.o(158574);
    }

    @Override // com.tencent.mm.ab.c
    public final int length() {
        AppMethodBeat.i(158575);
        int length = this.hpB.length();
        AppMethodBeat.o(158575);
        return length;
    }

    public final i w(String str, boolean z) {
        AppMethodBeat.i(158576);
        this.hpB.v(str, z);
        AppMethodBeat.o(158576);
        return this;
    }

    private i c(String str, double d2) {
        AppMethodBeat.i(158577);
        this.hpB.b(Fz(str), d2);
        AppMethodBeat.o(158577);
        return this;
    }

    public final i U(String str, int i2) {
        AppMethodBeat.i(158578);
        this.hpB.T(Fz(str), i2);
        AppMethodBeat.o(158578);
        return this;
    }

    public final i v(String str, long j2) {
        AppMethodBeat.i(158579);
        this.hpB.u(Fz(str), j2);
        AppMethodBeat.o(158579);
        return this;
    }

    public final i h(String str, Object obj) {
        AppMethodBeat.i(158580);
        Object obj2 = obj;
        while (obj2 instanceof i) {
            obj2 = ((i) obj2).hpB;
        }
        this.hpB.f(str, obj2);
        AppMethodBeat.o(158580);
        return this;
    }

    public final i i(String str, Object obj) {
        AppMethodBeat.i(158581);
        this.hpB.g(str, obj);
        AppMethodBeat.o(158581);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final String Fz(String str) {
        AppMethodBeat.i(158582);
        String Fz = this.hpB.Fz(str);
        AppMethodBeat.o(158582);
        return Fz;
    }

    @Override // com.tencent.mm.ab.c
    public final Object remove(String str) {
        AppMethodBeat.i(158583);
        Object remove = this.hpB.remove(str);
        AppMethodBeat.o(158583);
        return remove;
    }

    @Override // com.tencent.mm.ab.c
    public final boolean isNull(String str) {
        AppMethodBeat.i(158584);
        boolean isNull = this.hpB.isNull(str);
        AppMethodBeat.o(158584);
        return isNull;
    }

    @Override // com.tencent.mm.ab.c
    public final boolean has(String str) {
        AppMethodBeat.i(158585);
        boolean has = this.hpB.has(str);
        AppMethodBeat.o(158585);
        return has;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final Object get(String str) {
        AppMethodBeat.i(158586);
        Object obj = this.hpB.get(str);
        AppMethodBeat.o(158586);
        return obj;
    }

    @Override // com.tencent.mm.ab.c
    public final Object opt(String str) {
        AppMethodBeat.i(158587);
        Object opt = this.hpB.opt(str);
        AppMethodBeat.o(158587);
        return opt;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final boolean getBoolean(String str) {
        AppMethodBeat.i(158588);
        boolean z = this.hpB.getBoolean(str);
        AppMethodBeat.o(158588);
        return z;
    }

    public final boolean optBoolean(String str) {
        AppMethodBeat.i(158589);
        boolean optBoolean = this.hpB.optBoolean(str, false);
        AppMethodBeat.o(158589);
        return optBoolean;
    }

    @Override // com.tencent.mm.ab.c
    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.i(158590);
        boolean optBoolean = this.hpB.optBoolean(str, z);
        AppMethodBeat.o(158590);
        return optBoolean;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final double getDouble(String str) {
        AppMethodBeat.i(158591);
        double d2 = this.hpB.getDouble(str);
        AppMethodBeat.o(158591);
        return d2;
    }

    public final double optDouble(String str) {
        AppMethodBeat.i(158592);
        double optDouble = this.hpB.optDouble(str, Double.NaN);
        AppMethodBeat.o(158592);
        return optDouble;
    }

    @Override // com.tencent.mm.ab.c
    public final double optDouble(String str, double d2) {
        AppMethodBeat.i(158593);
        double optDouble = this.hpB.optDouble(str, d2);
        AppMethodBeat.o(158593);
        return optDouble;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final int getInt(String str) {
        AppMethodBeat.i(158594);
        int i2 = this.hpB.getInt(str);
        AppMethodBeat.o(158594);
        return i2;
    }

    public final int optInt(String str) {
        AppMethodBeat.i(158595);
        int optInt = this.hpB.optInt(str, 0);
        AppMethodBeat.o(158595);
        return optInt;
    }

    @Override // com.tencent.mm.ab.c
    public final int optInt(String str, int i2) {
        AppMethodBeat.i(158596);
        int optInt = this.hpB.optInt(str, i2);
        AppMethodBeat.o(158596);
        return optInt;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final long getLong(String str) {
        AppMethodBeat.i(158597);
        long j2 = this.hpB.getLong(str);
        AppMethodBeat.o(158597);
        return j2;
    }

    public final long optLong(String str) {
        AppMethodBeat.i(158598);
        long optLong = this.hpB.optLong(str, 0);
        AppMethodBeat.o(158598);
        return optLong;
    }

    @Override // com.tencent.mm.ab.c
    public final long optLong(String str, long j2) {
        AppMethodBeat.i(158599);
        long optLong = this.hpB.optLong(str, j2);
        AppMethodBeat.o(158599);
        return optLong;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final String getString(String str) {
        AppMethodBeat.i(158600);
        String string = this.hpB.getString(str);
        AppMethodBeat.o(158600);
        return string;
    }

    @Override // com.tencent.mm.ab.c
    public final String optString(String str) {
        AppMethodBeat.i(158601);
        String optString = this.hpB.optString(str, "");
        AppMethodBeat.o(158601);
        return optString;
    }

    @Override // com.tencent.mm.ab.c
    public final String optString(String str, String str2) {
        AppMethodBeat.i(158602);
        String optString = this.hpB.optString(str, str2);
        AppMethodBeat.o(158602);
        return optString;
    }

    public final f FH(String str) {
        AppMethodBeat.i(158603);
        a FA = this.hpB.FA(str);
        if (FA == null) {
            AppMethodBeat.o(158603);
            return null;
        }
        f fVar = new f(FA);
        AppMethodBeat.o(158603);
        return fVar;
    }

    public final f FI(String str) {
        AppMethodBeat.i(158604);
        a FB = this.hpB.FB(str);
        if (FB == null) {
            AppMethodBeat.o(158604);
            return null;
        }
        f fVar = new f(FB);
        AppMethodBeat.o(158604);
        return fVar;
    }

    public final i FJ(String str) {
        AppMethodBeat.i(158605);
        c FC = this.hpB.FC(str);
        if (FC == null) {
            AppMethodBeat.o(158605);
            return null;
        }
        i iVar = new i(FC);
        AppMethodBeat.o(158605);
        return iVar;
    }

    public final i FK(String str) {
        AppMethodBeat.i(158606);
        c FD = this.hpB.FD(str);
        if (FD == null) {
            AppMethodBeat.o(158606);
            return null;
        }
        i iVar = new i(FD);
        AppMethodBeat.o(158606);
        return iVar;
    }

    @Override // org.json.JSONObject, com.tencent.mm.ab.c
    public final Iterator<String> keys() {
        AppMethodBeat.i(158607);
        Iterator<String> keys = this.hpB.keys();
        AppMethodBeat.o(158607);
        return keys;
    }

    public final String toString() {
        AppMethodBeat.i(158608);
        String obj = this.hpB.toString();
        AppMethodBeat.o(158608);
        return obj;
    }
}
