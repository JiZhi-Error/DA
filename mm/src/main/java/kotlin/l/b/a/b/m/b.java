package kotlin.l.b.a.b.m;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.j;

public abstract class b extends h implements at {
    private int aHK;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 1:
            case 3:
            case 4:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 2:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
            case 4:
                i3 = 2;
                break;
            case 2:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
                break;
            case 2:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "getBuiltIns";
                break;
            case 2:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
                break;
            case 3:
            case 4:
                objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
            case 4:
                break;
            case 2:
                objArr[2] = "hasMeaningfulFqName";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 3:
            case 4:
                throw new IllegalStateException(format);
            case 2:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* renamed from: hzT */
    public abstract e hzS();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(j jVar) {
        super(jVar);
        if (jVar == null) {
            atM(0);
        }
        this.aHK = 0;
    }

    public final int hashCode() {
        int i2 = this.aHK;
        if (i2 == 0) {
            e hzT = hzS();
            if (d(hzT)) {
                i2 = c.n(hzT).hashCode();
            } else {
                i2 = System.identityHashCode(this);
            }
            this.aHK = i2;
        }
        return i2;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final g hBh() {
        g G = a.G(hzS());
        if (G == null) {
            atM(1);
        }
        return G;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof at)) {
            return false;
        }
        if (obj.hashCode() != hashCode()) {
            return false;
        }
        if (((at) obj).getParameters().size() != getParameters().size()) {
            return false;
        }
        e hzT = hzS();
        h hzS = ((at) obj).hzS();
        if (!d(hzT) || (hzS != null && !d(hzS))) {
            return false;
        }
        if (!(hzS instanceof e)) {
            return false;
        }
        e eVar = hzT;
        e eVar2 = (e) hzS;
        if (!eVar.hAH().equals(eVar2.hAH())) {
            return false;
        }
        l hzx = eVar.hzx();
        l hzx2 = eVar2.hzx();
        while (true) {
            if (hzx == null || hzx2 == null) {
                break;
            } else if (hzx instanceof y) {
                return hzx2 instanceof y;
            } else {
                if (hzx2 instanceof y) {
                    return false;
                }
                if (hzx instanceof ab) {
                    if (!(hzx2 instanceof ab) || !((ab) hzx).hBk().equals(((ab) hzx2).hBk())) {
                        return false;
                    }
                } else if (hzx2 instanceof ab) {
                    return false;
                } else {
                    if (!hzx.hAH().equals(hzx2.hAH())) {
                        return false;
                    }
                    hzx = hzx.hzx();
                    hzx2 = hzx2.hzx();
                }
            }
        }
        return true;
    }

    private static boolean d(h hVar) {
        if (hVar == null) {
            atM(2);
        }
        return !u.L(hVar) && !c.m(hVar);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.h
    public final Collection<ab> EU(boolean z) {
        l hzx = hzS().hzx();
        if (!(hzx instanceof e)) {
            List emptyList = Collections.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            atM(3);
            return emptyList;
        }
        kotlin.l.b.a.b.o.h hVar = new kotlin.l.b.a.b.o.h();
        e eVar = (e) hzx;
        hVar.add(eVar.hAG());
        e hzA = eVar.hzA();
        if (z && hzA != null) {
            hVar.add(hzA.hAG());
        }
        return hVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.h
    public final ab hBX() {
        if (g.e(hzS())) {
            return null;
        }
        return hBh().hzi();
    }
}
