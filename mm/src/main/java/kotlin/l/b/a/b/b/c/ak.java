package kotlin.l.b.a.b.b.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;

public abstract class ak extends k implements ax {
    static final /* synthetic */ boolean $assertionsDisabled = (!ak.class.desiredAssertionStatus());
    protected ab TmB;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ak(l lVar, g gVar, f fVar, ab abVar, an anVar) {
        super(lVar, gVar, fVar, anVar);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (anVar == null) {
            atM(3);
        }
        this.TmB = abVar;
    }

    @Override // kotlin.l.b.a.b.b.au
    public final ab hBy() {
        ab abVar = this.TmB;
        if (abVar == null) {
            atM(4);
        }
        return abVar;
    }

    public final void M(ab abVar) {
        if ($assertionsDisabled || this.TmB == null) {
            this.TmB = abVar;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: hCq */
    public ax hBT() {
        ax axVar = (ax) super.hAE();
        if (axVar == null) {
            atM(5);
        }
        return axVar;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<av> hAw() {
        List<av> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(6);
        }
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public boolean hAx() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a
    public Collection<? extends a> hAy() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            atM(7);
        }
        return emptySet;
    }

    @Override // kotlin.l.b.a.b.b.a
    public List<as> hAt() {
        List<as> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(8);
        }
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public kotlin.l.b.a.b.b.ak hAr() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.a
    public kotlin.l.b.a.b.b.ak hAs() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.a
    public ab hAu() {
        ab hBy = hBy();
        if (hBy == null) {
            atM(9);
        }
        return hBy;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public boolean hBH() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a
    public <V> V a(a.AbstractC2276a<V> aVar) {
        return null;
    }
}
