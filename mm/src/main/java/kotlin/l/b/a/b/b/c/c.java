package kotlin.l.b.a.b.b.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.a.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.bh;

public abstract class c extends j implements ak {
    private static final f TjZ = f.bua("<this>");

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.j
    public final /* bridge */ /* synthetic */ l hAE() {
        return this;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final /* bridge */ /* synthetic */ a hAv() {
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(g gVar) {
        super(gVar, TjZ);
        if (gVar == null) {
            atM(0);
        }
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        return nVar.a(this, d2);
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ak hAr() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ak hAs() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<as> hAt() {
        List<as> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(2);
        }
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ab hAu() {
        return hBy();
    }

    @Override // kotlin.l.b.a.b.b.au
    public final ab hBy() {
        ab hBy = hBt().hBy();
        if (hBy == null) {
            atM(3);
        }
        return hBy;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<av> hAw() {
        List<av> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(4);
        }
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final boolean hAx() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final Collection<? extends a> hAy() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            atM(5);
        }
        return emptySet;
    }

    @Override // kotlin.l.b.a.b.b.p
    public final ba hzE() {
        ba baVar = az.ThV;
        if (baVar == null) {
            atM(6);
        }
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.o
    public final an hzM() {
        an anVar = an.ThK;
        if (anVar == null) {
            atM(8);
        }
        return anVar;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final <V> V a(a.AbstractC2276a<V> aVar) {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.ak
    /* renamed from: e */
    public final ak f(kotlin.l.b.a.b.m.ba baVar) {
        ab c2;
        if (baVar == null) {
            atM(1);
        }
        if (baVar.Tlg.isEmpty()) {
            return this;
        }
        if (hzx() instanceof e) {
            c2 = baVar.c(hBy(), bh.OUT_VARIANCE);
        } else {
            c2 = baVar.c(hBy(), bh.INVARIANT);
        }
        if (c2 == null) {
            return null;
        }
        return c2 != hBy() ? new ad(hzx(), new h(c2), hzL()) : this;
    }
}
