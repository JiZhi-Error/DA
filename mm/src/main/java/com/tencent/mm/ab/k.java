package com.tencent.mm.ab;

import com.eclipsesource.a.a;
import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class k implements a {
    private b hpC;

    public k() {
        AppMethodBeat.i(158634);
        this.hpC = new b();
        AppMethodBeat.o(158634);
    }

    public k(String str) {
        AppMethodBeat.i(158635);
        this.hpC = a.aR(str).sd();
        if (this.hpC == null) {
            g gVar = new g(String.format("JSONArray string(%s) parse error.", str));
            AppMethodBeat.o(158635);
            throw gVar;
        }
        AppMethodBeat.o(158635);
    }

    k(b bVar) {
        AppMethodBeat.i(158636);
        Assert.assertNotNull(bVar);
        this.hpC = bVar;
        AppMethodBeat.o(158636);
    }

    @Override // com.tencent.mm.ab.a
    public final int length() {
        AppMethodBeat.i(158637);
        int size = this.hpC.aIq.size();
        AppMethodBeat.o(158637);
        return size;
    }

    @Override // com.tencent.mm.ab.a
    public final a ep(boolean z) {
        AppMethodBeat.i(158638);
        this.hpC.aM(z);
        AppMethodBeat.o(158638);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a k(double d2) {
        AppMethodBeat.i(158639);
        this.hpC.e(d2);
        AppMethodBeat.o(158639);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a pQ(int i2) {
        AppMethodBeat.i(158640);
        this.hpC.dB(i2);
        AppMethodBeat.o(158640);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a zp(long j2) {
        AppMethodBeat.i(158641);
        this.hpC.t(j2);
        AppMethodBeat.o(158641);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a bu(Object obj) {
        AppMethodBeat.i(158642);
        j.a(this.hpC, obj);
        AppMethodBeat.o(158642);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a C(int i2, boolean z) {
        AppMethodBeat.i(158643);
        try {
            this.hpC.n(i2, z);
            AppMethodBeat.o(158643);
            return this;
        } catch (Exception e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158643);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a c(int i2, double d2) {
        AppMethodBeat.i(158644);
        try {
            this.hpC.a(i2, d2);
            AppMethodBeat.o(158644);
            return this;
        } catch (Exception e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158644);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a cS(int i2, int i3) {
        AppMethodBeat.i(158645);
        try {
            this.hpC.aV(i2, i3);
            AppMethodBeat.o(158645);
            return this;
        } catch (Exception e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158645);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a v(int i2, long j2) {
        AppMethodBeat.i(158646);
        try {
            this.hpC.f(i2, j2);
            AppMethodBeat.o(158646);
            return this;
        } catch (Exception e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158646);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a g(int i2, Object obj) {
        AppMethodBeat.i(158647);
        try {
            b bVar = this.hpC;
            if (obj instanceof c) {
                bVar.a(i2, j.a((c) obj));
            } else if (obj instanceof a) {
                bVar.a(i2, j.a((a) obj));
            } else if (obj instanceof Integer) {
                bVar.aV(i2, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                bVar.aIq.set(i2, a.aQ((String) obj));
            } else if (obj instanceof Boolean) {
                bVar.n(i2, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                bVar.f(i2, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                bVar.aIq.set(i2, a.ab(((Float) obj).floatValue()));
            } else if (obj instanceof Integer) {
                bVar.aV(i2, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bVar.a(i2, ((Double) obj).doubleValue());
            } else if (obj instanceof h) {
                bVar.a(i2, (h) obj);
            }
            AppMethodBeat.o(158647);
            return this;
        } catch (Exception e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158647);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final boolean isNull(int i2) {
        AppMethodBeat.i(158648);
        if (i2 < 0 || i2 >= length() || this.hpC.dC(i2) == null) {
            AppMethodBeat.o(158648);
            return true;
        }
        AppMethodBeat.o(158648);
        return false;
    }

    @Override // com.tencent.mm.ab.a
    public final Object get(int i2) {
        AppMethodBeat.i(158649);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158649);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158649);
            return null;
        } else if (dC.isNumber()) {
            String hVar = dC.toString();
            AppMethodBeat.o(158649);
            return hVar;
        } else if (dC.isBoolean()) {
            Boolean valueOf = Boolean.valueOf(dC.se());
            AppMethodBeat.o(158649);
            return valueOf;
        } else if (dC.isArray()) {
            k kVar = new k(dC.sd());
            AppMethodBeat.o(158649);
            return kVar;
        } else if (dC.isObject()) {
            l lVar = new l(dC.si());
            AppMethodBeat.o(158649);
            return lVar;
        } else if (dC.isString()) {
            String sG = dC.sG();
            AppMethodBeat.o(158649);
            return sG;
        } else {
            AppMethodBeat.o(158649);
            return null;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final Object opt(int i2) {
        AppMethodBeat.i(158650);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158650);
            return null;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158650);
            return null;
        } else if (dC.isNumber()) {
            String hVar = dC.toString();
            AppMethodBeat.o(158650);
            return hVar;
        } else if (dC.isBoolean()) {
            Boolean valueOf = Boolean.valueOf(dC.se());
            AppMethodBeat.o(158650);
            return valueOf;
        } else if (dC.isArray()) {
            k kVar = new k(dC.sd());
            AppMethodBeat.o(158650);
            return kVar;
        } else if (dC.isObject()) {
            l lVar = new l(dC.si());
            AppMethodBeat.o(158650);
            return lVar;
        } else if (dC.isString()) {
            String sG = dC.sG();
            AppMethodBeat.o(158650);
            return sG;
        } else {
            AppMethodBeat.o(158650);
            return null;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final Object remove(int i2) {
        AppMethodBeat.i(158651);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158651);
            return null;
        }
        b bVar = this.hpC;
        bVar.aIq.remove(i2);
        if (bVar.isNumber()) {
            String hVar = bVar.toString();
            AppMethodBeat.o(158651);
            return hVar;
        } else if (bVar.isBoolean()) {
            Boolean valueOf = Boolean.valueOf(bVar.se());
            AppMethodBeat.o(158651);
            return valueOf;
        } else if (bVar.isArray()) {
            k kVar = new k(bVar.sd());
            AppMethodBeat.o(158651);
            return kVar;
        } else if (bVar.isObject()) {
            l lVar = new l(bVar.si());
            AppMethodBeat.o(158651);
            return lVar;
        } else if (bVar.isString()) {
            String sG = bVar.sG();
            AppMethodBeat.o(158651);
            return sG;
        } else {
            AppMethodBeat.o(158651);
            return null;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final boolean getBoolean(int i2) {
        AppMethodBeat.i(158652);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158652);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getBoolean(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158652);
            throw gVar2;
        } else if (dC.isBoolean()) {
            boolean se = dC.se();
            AppMethodBeat.o(158652);
            return se;
        } else {
            if (dC.isString()) {
                String sG = dC.sG();
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(sG)) {
                    AppMethodBeat.o(158652);
                    return true;
                } else if ("false".equals(sG)) {
                    AppMethodBeat.o(158652);
                    return false;
                }
            }
            g gVar3 = new g(String.format("getBoolean(%d) error, value : %s.", Integer.valueOf(i2), dC));
            AppMethodBeat.o(158652);
            throw gVar3;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final boolean optBoolean(int i2) {
        AppMethodBeat.i(158653);
        boolean optBoolean = optBoolean(i2, false);
        AppMethodBeat.o(158653);
        return optBoolean;
    }

    @Override // com.tencent.mm.ab.a
    public final boolean optBoolean(int i2, boolean z) {
        AppMethodBeat.i(158654);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158654);
            return z;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158654);
            return z;
        } else if (dC.isBoolean()) {
            boolean se = dC.se();
            AppMethodBeat.o(158654);
            return se;
        } else {
            if (dC.isString()) {
                String sG = dC.sG();
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(sG)) {
                    AppMethodBeat.o(158654);
                    return true;
                } else if ("false".equals(sG)) {
                    AppMethodBeat.o(158654);
                    return false;
                }
            }
            AppMethodBeat.o(158654);
            return z;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final double getDouble(int i2) {
        AppMethodBeat.i(158655);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158655);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getDouble(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158655);
            throw gVar2;
        }
        try {
            if (dC.isNumber()) {
                double sh = dC.sh();
                AppMethodBeat.o(158655);
                return sh;
            }
            if (dC.isString()) {
                double parseDouble = Double.parseDouble(dC.sG());
                AppMethodBeat.o(158655);
                return parseDouble;
            }
            g gVar3 = new g(String.format("getDouble(%d) error, value : %s.", Integer.valueOf(i2), dC));
            AppMethodBeat.o(158655);
            throw gVar3;
        } catch (Exception e2) {
        }
    }

    @Override // com.tencent.mm.ab.a
    public final double optDouble(int i2) {
        AppMethodBeat.i(158656);
        double optDouble = optDouble(i2, 0.0d);
        AppMethodBeat.o(158656);
        return optDouble;
    }

    @Override // com.tencent.mm.ab.a
    public final double optDouble(int i2, double d2) {
        AppMethodBeat.i(158657);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158657);
            return d2;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158657);
            return d2;
        }
        try {
            if (dC.isNumber()) {
                double sh = dC.sh();
                AppMethodBeat.o(158657);
                return sh;
            }
            if (dC.isString()) {
                double parseDouble = Double.parseDouble(dC.sG());
                AppMethodBeat.o(158657);
                return parseDouble;
            }
            AppMethodBeat.o(158657);
            return d2;
        } catch (Exception e2) {
        }
    }

    @Override // com.tencent.mm.ab.a
    public final int getInt(int i2) {
        AppMethodBeat.i(158658);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158658);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getInteger(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158658);
            throw gVar2;
        }
        try {
            if (dC.isNumber()) {
                try {
                    int sf = dC.sf();
                    AppMethodBeat.o(158658);
                    return sf;
                } catch (Exception e2) {
                    int sh = (int) dC.sh();
                    AppMethodBeat.o(158658);
                    return sh;
                }
            } else {
                if (dC.isString()) {
                    int parseDouble = (int) Double.parseDouble(dC.sG());
                    AppMethodBeat.o(158658);
                    return parseDouble;
                }
                g gVar3 = new g(String.format("getInt(%d) error, value : %s.", Integer.valueOf(i2), dC));
                AppMethodBeat.o(158658);
                throw gVar3;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.a
    public final int optInt(int i2) {
        AppMethodBeat.i(158659);
        int optInt = optInt(i2, 0);
        AppMethodBeat.o(158659);
        return optInt;
    }

    @Override // com.tencent.mm.ab.a
    public final int optInt(int i2, int i3) {
        AppMethodBeat.i(158660);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158660);
            return i3;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158660);
            return i3;
        }
        try {
            if (dC.isNumber()) {
                try {
                    int sf = dC.sf();
                    AppMethodBeat.o(158660);
                    return sf;
                } catch (Exception e2) {
                    int sh = (int) dC.sh();
                    AppMethodBeat.o(158660);
                    return sh;
                }
            } else {
                if (dC.isString()) {
                    int parseDouble = (int) Double.parseDouble(dC.sG());
                    AppMethodBeat.o(158660);
                    return parseDouble;
                }
                AppMethodBeat.o(158660);
                return i3;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.a
    public final long getLong(int i2) {
        AppMethodBeat.i(158661);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158661);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getLong(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158661);
            throw gVar2;
        }
        try {
            if (dC.isNumber()) {
                try {
                    long sg = dC.sg();
                    AppMethodBeat.o(158661);
                    return sg;
                } catch (Exception e2) {
                    long sh = (long) dC.sh();
                    AppMethodBeat.o(158661);
                    return sh;
                }
            } else {
                if (dC.isString()) {
                    long parseDouble = (long) Double.parseDouble(dC.sG());
                    AppMethodBeat.o(158661);
                    return parseDouble;
                }
                g gVar3 = new g(String.format("getLong(%d) error, value : %s.", Integer.valueOf(i2), dC));
                AppMethodBeat.o(158661);
                throw gVar3;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.a
    public final long optLong(int i2) {
        AppMethodBeat.i(158662);
        long optLong = optLong(i2, 0);
        AppMethodBeat.o(158662);
        return optLong;
    }

    @Override // com.tencent.mm.ab.a
    public final long optLong(int i2, long j2) {
        AppMethodBeat.i(158663);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158663);
            return j2;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158663);
            return j2;
        }
        try {
            if (dC.isNumber()) {
                try {
                    long sg = dC.sg();
                    AppMethodBeat.o(158663);
                    return sg;
                } catch (Exception e2) {
                    long sh = (long) dC.sh();
                    AppMethodBeat.o(158663);
                    return sh;
                }
            } else {
                if (dC.isString()) {
                    long parseDouble = (long) Double.parseDouble(dC.sG());
                    AppMethodBeat.o(158663);
                    return parseDouble;
                }
                AppMethodBeat.o(158663);
                return j2;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.a
    public final String getString(int i2) {
        AppMethodBeat.i(158664);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158664);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getString(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158664);
            throw gVar2;
        } else if (dC.isString()) {
            String sG = dC.sG();
            AppMethodBeat.o(158664);
            return sG;
        } else {
            String hVar = dC.toString();
            AppMethodBeat.o(158664);
            return hVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final String optString(int i2) {
        AppMethodBeat.i(158665);
        String optString = optString(i2, null);
        AppMethodBeat.o(158665);
        return optString;
    }

    @Override // com.tencent.mm.ab.a
    public final String optString(int i2, String str) {
        AppMethodBeat.i(158666);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158666);
            return str;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158666);
            return str;
        } else if (dC.isString()) {
            String sG = dC.sG();
            AppMethodBeat.o(158666);
            return sG;
        } else {
            String hVar = dC.toString();
            AppMethodBeat.o(158666);
            return hVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a pR(int i2) {
        AppMethodBeat.i(158667);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158667);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getJSONArray(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158667);
            throw gVar2;
        }
        k kVar = new k(dC.sd());
        AppMethodBeat.o(158667);
        return kVar;
    }

    @Override // com.tencent.mm.ab.a
    public final a pS(int i2) {
        AppMethodBeat.i(158668);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158668);
            return null;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158668);
            return null;
        }
        k kVar = new k(dC.sd());
        AppMethodBeat.o(158668);
        return kVar;
    }

    @Override // com.tencent.mm.ab.a
    public final c pT(int i2) {
        AppMethodBeat.i(158669);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", Integer.valueOf(i2), Integer.valueOf(length)));
            AppMethodBeat.o(158669);
            throw gVar;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            g gVar2 = new g(String.format("getJSONObject(%d) return null.", Integer.valueOf(i2)));
            AppMethodBeat.o(158669);
            throw gVar2;
        }
        l lVar = new l(dC.si());
        AppMethodBeat.o(158669);
        return lVar;
    }

    @Override // com.tencent.mm.ab.a
    public final c pU(int i2) {
        AppMethodBeat.i(158670);
        int length = length();
        if (i2 < 0 || i2 >= length) {
            AppMethodBeat.o(158670);
            return null;
        }
        h dC = this.hpC.dC(i2);
        if (dC == null) {
            AppMethodBeat.o(158670);
            return null;
        }
        l lVar = new l(dC.si());
        AppMethodBeat.o(158670);
        return lVar;
    }

    @Override // com.tencent.mm.ab.a
    public final String toString() {
        AppMethodBeat.i(158671);
        String bVar = this.hpC.toString();
        AppMethodBeat.o(158671);
        return bVar;
    }

    @Override // com.tencent.mm.ab.a
    public final String toString(int i2) {
        AppMethodBeat.i(158672);
        try {
            String a2 = this.hpC.a(com.eclipsesource.a.k.dD(i2));
            AppMethodBeat.o(158672);
            return a2;
        } catch (Throwable th) {
            g gVar = new g(th);
            AppMethodBeat.o(158672);
            throw gVar;
        }
    }
}
