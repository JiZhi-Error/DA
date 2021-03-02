package com.tencent.mm.ab;

import com.eclipsesource.a.a;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class l implements c {
    private e hpD;

    public l() {
        AppMethodBeat.i(158673);
        this.hpD = new e();
        AppMethodBeat.o(158673);
    }

    l(e eVar) {
        AppMethodBeat.i(158674);
        this.hpD = eVar == null ? new e() : eVar;
        AppMethodBeat.o(158674);
    }

    public l(Map map) {
        AppMethodBeat.i(158675);
        this.hpD = j.w(map);
        AppMethodBeat.o(158675);
    }

    public l(String str) {
        AppMethodBeat.i(158676);
        this.hpD = a.aR(str).si();
        AppMethodBeat.o(158676);
    }

    @Override // com.tencent.mm.ab.c
    public final int length() {
        AppMethodBeat.i(158677);
        int size = this.hpD.aZK.size();
        AppMethodBeat.o(158677);
        return size;
    }

    @Override // com.tencent.mm.ab.c
    public final c v(String str, boolean z) {
        AppMethodBeat.i(158678);
        this.hpD.a(str, a.aL(z));
        AppMethodBeat.o(158678);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final c b(String str, double d2) {
        AppMethodBeat.i(158679);
        this.hpD.a(str, a.d(d2));
        AppMethodBeat.o(158679);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final c T(String str, int i2) {
        AppMethodBeat.i(158680);
        this.hpD.a(str, a.dA(i2));
        AppMethodBeat.o(158680);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final c u(String str, long j2) {
        AppMethodBeat.i(158681);
        this.hpD.a(str, a.s(j2));
        AppMethodBeat.o(158681);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final c f(String str, Object obj) {
        AppMethodBeat.i(158682);
        j.a(this.hpD, str, obj);
        AppMethodBeat.o(158682);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final c g(String str, Object obj) {
        AppMethodBeat.i(158683);
        j.a(this.hpD, str, obj);
        AppMethodBeat.o(158683);
        return this;
    }

    @Override // com.tencent.mm.ab.c
    public final String Fz(String str) {
        AppMethodBeat.i(158684);
        if (str == null) {
            g gVar = new g("Names must be non-null");
            AppMethodBeat.o(158684);
            throw gVar;
        }
        AppMethodBeat.o(158684);
        return str;
    }

    @Override // com.tencent.mm.ab.c
    public final Object remove(String str) {
        AppMethodBeat.i(158685);
        e eVar = this.hpD;
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(158685);
            throw nullPointerException;
        }
        int indexOf = eVar.indexOf(str);
        if (indexOf != -1) {
            eVar.aZL.remove(indexOf);
            eVar.aZK.remove(indexOf);
            eVar.aIq.remove(indexOf);
        }
        if (eVar.isNumber()) {
            String hVar = eVar.toString();
            AppMethodBeat.o(158685);
            return hVar;
        } else if (eVar.isBoolean()) {
            Boolean valueOf = Boolean.valueOf(eVar.se());
            AppMethodBeat.o(158685);
            return valueOf;
        } else if (eVar.isArray()) {
            k kVar = new k(eVar.sd());
            AppMethodBeat.o(158685);
            return kVar;
        } else if (eVar.isObject()) {
            l lVar = new l(eVar.si());
            AppMethodBeat.o(158685);
            return lVar;
        } else if (eVar.isString()) {
            String sG = eVar.sG();
            AppMethodBeat.o(158685);
            return sG;
        } else {
            AppMethodBeat.o(158685);
            return null;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final boolean isNull(String str) {
        AppMethodBeat.i(158686);
        if (this.hpD.aU(str) == null) {
            AppMethodBeat.o(158686);
            return true;
        }
        AppMethodBeat.o(158686);
        return false;
    }

    @Override // com.tencent.mm.ab.c
    public final boolean has(String str) {
        AppMethodBeat.i(158687);
        if (this.hpD.aU(str) != null) {
            AppMethodBeat.o(158687);
            return true;
        }
        AppMethodBeat.o(158687);
        return false;
    }

    @Override // com.tencent.mm.ab.c
    public final Object get(String str) {
        AppMethodBeat.i(158688);
        Object opt = opt(str);
        AppMethodBeat.o(158688);
        return opt;
    }

    @Override // com.tencent.mm.ab.c
    public final Object opt(String str) {
        AppMethodBeat.i(158689);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158689);
            return null;
        } else if (aU.isNumber()) {
            String hVar = aU.toString();
            AppMethodBeat.o(158689);
            return hVar;
        } else if (aU.isBoolean()) {
            Boolean valueOf = Boolean.valueOf(aU.se());
            AppMethodBeat.o(158689);
            return valueOf;
        } else if (aU.isArray()) {
            k kVar = new k(aU.sd());
            AppMethodBeat.o(158689);
            return kVar;
        } else if (aU.isObject()) {
            l lVar = new l(aU.si());
            AppMethodBeat.o(158689);
            return lVar;
        } else if (aU.isString()) {
            String sG = aU.sG();
            AppMethodBeat.o(158689);
            return sG;
        } else {
            AppMethodBeat.o(158689);
            return null;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final boolean getBoolean(String str) {
        AppMethodBeat.i(158690);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158690);
            throw gVar;
        } else if (aU.isBoolean()) {
            boolean se = aU.se();
            AppMethodBeat.o(158690);
            return se;
        } else {
            if (aU.isString()) {
                String hVar = aU.toString();
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(hVar)) {
                    AppMethodBeat.o(158690);
                    return true;
                } else if ("false".equals(hVar)) {
                    AppMethodBeat.o(158690);
                    return false;
                }
            }
            g gVar2 = new g(String.format("getBoolean by key : %s error, value : %s", str, aU));
            AppMethodBeat.o(158690);
            throw gVar2;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.i(158691);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158691);
            return z;
        } else if (aU.isBoolean()) {
            boolean se = aU.se();
            AppMethodBeat.o(158691);
            return se;
        } else {
            if (aU.isString()) {
                String hVar = aU.toString();
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(hVar)) {
                    AppMethodBeat.o(158691);
                    return true;
                } else if ("false".equals(hVar)) {
                    AppMethodBeat.o(158691);
                    return false;
                }
            }
            AppMethodBeat.o(158691);
            return z;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final double getDouble(String str) {
        AppMethodBeat.i(158692);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158692);
            throw gVar;
        }
        try {
            if (aU.isNumber()) {
                double sh = aU.sh();
                AppMethodBeat.o(158692);
                return sh;
            }
            if (aU.isString()) {
                double parseDouble = Double.parseDouble(aU.toString());
                AppMethodBeat.o(158692);
                return parseDouble;
            }
            g gVar2 = new g(String.format("getDouble by key : %s error, value : %s", str, aU));
            AppMethodBeat.o(158692);
            throw gVar2;
        } catch (Exception e2) {
        }
    }

    @Override // com.tencent.mm.ab.c
    public final double optDouble(String str, double d2) {
        AppMethodBeat.i(158693);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158693);
            return d2;
        }
        try {
            if (aU.isNumber()) {
                double sh = aU.sh();
                AppMethodBeat.o(158693);
                return sh;
            }
            if (aU.isString()) {
                double parseDouble = Double.parseDouble(aU.toString());
                AppMethodBeat.o(158693);
                return parseDouble;
            }
            AppMethodBeat.o(158693);
            return d2;
        } catch (Exception e2) {
        }
    }

    @Override // com.tencent.mm.ab.c
    public final int getInt(String str) {
        AppMethodBeat.i(158694);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158694);
            throw gVar;
        }
        try {
            if (aU.isNumber()) {
                try {
                    int sf = aU.sf();
                    AppMethodBeat.o(158694);
                    return sf;
                } catch (Exception e2) {
                    int sh = (int) aU.sh();
                    AppMethodBeat.o(158694);
                    return sh;
                }
            } else {
                if (aU.isString()) {
                    int parseDouble = (int) Double.parseDouble(aU.toString());
                    AppMethodBeat.o(158694);
                    return parseDouble;
                }
                g gVar2 = new g(String.format("getInt by key : %s error, value : %s", str, aU));
                AppMethodBeat.o(158694);
                throw gVar2;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.c
    public final int optInt(String str, int i2) {
        AppMethodBeat.i(158695);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158695);
            return i2;
        }
        try {
            if (aU.isNumber()) {
                try {
                    int sf = aU.sf();
                    AppMethodBeat.o(158695);
                    return sf;
                } catch (Exception e2) {
                    int sh = (int) aU.sh();
                    AppMethodBeat.o(158695);
                    return sh;
                }
            } else {
                if (aU.isString()) {
                    int parseDouble = (int) Double.parseDouble(aU.toString());
                    AppMethodBeat.o(158695);
                    return parseDouble;
                }
                AppMethodBeat.o(158695);
                return i2;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.c
    public final long getLong(String str) {
        AppMethodBeat.i(158696);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158696);
            throw gVar;
        }
        try {
            if (aU.isNumber()) {
                try {
                    long sg = aU.sg();
                    AppMethodBeat.o(158696);
                    return sg;
                } catch (Exception e2) {
                    long sh = (long) aU.sh();
                    AppMethodBeat.o(158696);
                    return sh;
                }
            } else {
                if (aU.isString()) {
                    long parseDouble = (long) Double.parseDouble(aU.toString());
                    AppMethodBeat.o(158696);
                    return parseDouble;
                }
                g gVar2 = new g(String.format("getLong by key : %s error, value : %s", str, aU));
                AppMethodBeat.o(158696);
                throw gVar2;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.c
    public final long optLong(String str, long j2) {
        AppMethodBeat.i(158697);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158697);
            return j2;
        }
        try {
            if (aU.isNumber()) {
                try {
                    long sg = aU.sg();
                    AppMethodBeat.o(158697);
                    return sg;
                } catch (Exception e2) {
                    long sh = (long) aU.sh();
                    AppMethodBeat.o(158697);
                    return sh;
                }
            } else {
                if (aU.isString()) {
                    long parseDouble = (long) Double.parseDouble(aU.toString());
                    AppMethodBeat.o(158697);
                    return parseDouble;
                }
                AppMethodBeat.o(158697);
                return j2;
            }
        } catch (Exception e3) {
        }
    }

    @Override // com.tencent.mm.ab.c
    public final String getString(String str) {
        AppMethodBeat.i(158698);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158698);
            throw gVar;
        } else if (aU.isString()) {
            String sG = aU.sG();
            AppMethodBeat.o(158698);
            return sG;
        } else {
            String hVar = aU.toString();
            AppMethodBeat.o(158698);
            return hVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final String optString(String str) {
        AppMethodBeat.i(158699);
        String optString = optString(str, null);
        AppMethodBeat.o(158699);
        return optString;
    }

    @Override // com.tencent.mm.ab.c
    public final String optString(String str, String str2) {
        AppMethodBeat.i(158700);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158700);
            return null;
        } else if (aU.isString()) {
            String sG = aU.sG();
            AppMethodBeat.o(158700);
            return sG;
        } else {
            String hVar = aU.toString();
            AppMethodBeat.o(158700);
            return hVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final a FA(String str) {
        AppMethodBeat.i(158701);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158701);
            throw gVar;
        }
        k kVar = new k(aU.sd());
        AppMethodBeat.o(158701);
        return kVar;
    }

    @Override // com.tencent.mm.ab.c
    public final a FB(String str) {
        AppMethodBeat.i(158702);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158702);
            return null;
        }
        k kVar = new k(aU.sd());
        AppMethodBeat.o(158702);
        return kVar;
    }

    @Override // com.tencent.mm.ab.c
    public final c FC(String str) {
        AppMethodBeat.i(158703);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            g gVar = new g(String.format("key %s do not exist.", str));
            AppMethodBeat.o(158703);
            throw gVar;
        }
        l lVar = new l(aU.si());
        AppMethodBeat.o(158703);
        return lVar;
    }

    @Override // com.tencent.mm.ab.c
    public final c FD(String str) {
        AppMethodBeat.i(158704);
        h aU = this.hpD.aU(str);
        if (aU == null) {
            AppMethodBeat.o(158704);
            return null;
        }
        l lVar = new l(aU.si());
        AppMethodBeat.o(158704);
        return lVar;
    }

    @Override // com.tencent.mm.ab.c
    public final Iterator<String> keys() {
        AppMethodBeat.i(158705);
        Iterator<String> it = Collections.unmodifiableList(this.hpD.aZK).iterator();
        AppMethodBeat.o(158705);
        return it;
    }

    public final String toString() {
        AppMethodBeat.i(158706);
        String eVar = this.hpD.toString();
        AppMethodBeat.o(158706);
        return eVar;
    }
}
